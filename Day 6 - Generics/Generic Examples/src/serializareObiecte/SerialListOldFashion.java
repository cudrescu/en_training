package serializareObiecte;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SerialListOldFashion {

	@SuppressWarnings("finally")
	public ArrayList<AggregationExceptions> readAggregationExceptionsFromFile(String path, String filename){
		
		ArrayList<AggregationExceptions> aggregationExceptions = null;
		
		BufferedReader input = null;
		
		try {
			input = new BufferedReader(new FileReader("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Type listType = new TypeToken<ArrayList<AggregationExceptions>>(){
						}.getType();
		
		try {
			aggregationExceptions = new Gson().fromJson(input.readLine(), listType);
		} catch (JsonSyntaxException | IOException e) {
			e.printStackTrace();
		}
		
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			return aggregationExceptions;
		}
		
	}
}
