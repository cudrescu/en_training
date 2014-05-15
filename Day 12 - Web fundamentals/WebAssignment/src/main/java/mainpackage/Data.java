package mainpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class Data
{
	HttpClient client;
	HttpGet request;
	HttpResponse response;
	
	public Data(String address){
		client = new DefaultHttpClient();
		request = new HttpGet(address);
		try {
			response = client.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Get the response
	public String getResponse(){
		String inputData = "";
		
		BufferedReader rd = null;
		try {
			rd = new BufferedReader
			  (new InputStreamReader(response.getEntity().getContent()));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		    
		String line = "";
		try {
			while ((line = rd.readLine()) != null) {
			  inputData += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	return inputData;
	}
}
