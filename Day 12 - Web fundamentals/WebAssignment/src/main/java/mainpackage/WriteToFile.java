package mainpackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	
	public void write(ParsedObjectFormat parsedObject, String filename){
		
		BufferedWriter out = null;
		
		try {
			out = new BufferedWriter(new FileWriter(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			out.write("<html>\n");
				out.write("<head>\n");
					out.write("<title>"+parsedObject.getInfo().getTitle()+"</title>\n");
				out.write("</head>\n");
				
				out.write("<body>\n");
					out.write("<p>" +parsedObject.getInfo().getDescription() + "</p>\n");
					out.write("<p>" +parsedObject.getInfo().getContact() + "</p>\n");
					out.write("<p>" +parsedObject.getInfo().getLicense() + "</p>\n");
					out.write("<p>" +parsedObject.getInfo().getLicenseUrl() + "</p>\n");
				out.write("</body>\n");
				
			out.write("</html>\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	

		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
