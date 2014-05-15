package mainpackage;

public class Main {
	
	public static final String address = "http://petstore.swagger.wordnik.com/api/api-docs";

	public static void main(String[] args) {
		Data data = new Data(address);
		String response = data.getResponse();
		
		Parser parser = new Parser();
		ParsedObjectFormat parsedObject = parser.parse(response);
		
		WriteToFile printer = new WriteToFile();
		printer.write(parsedObject, "example.html");
		
	}

}
