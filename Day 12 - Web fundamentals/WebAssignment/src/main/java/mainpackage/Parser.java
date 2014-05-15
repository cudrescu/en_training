package mainpackage;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Parser {
	
	Parser(){
		
	}
	
	public ParsedObjectFormat parse(String toParse){
		
		ParsedObjectFormat parsedObject = null;
		
		ObjectMapper mapper = new ObjectMapper();

		try {
			parsedObject = mapper.readValue(toParse, ParsedObjectFormat.class);
			System.out.println(parsedObject);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		return parsedObject;
	}
}
