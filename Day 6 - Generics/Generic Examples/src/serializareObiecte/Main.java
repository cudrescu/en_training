package serializareObiecte;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<AggregationExceptions> g = new ArrayList<AggregationExceptions>();
		g.add(new AggregationExceptions());
		g.add(new AggregationExceptions());
		
		ObjectOutputStream os = null;
        try {
                os = new ObjectOutputStream(new FileOutputStream("input.txt"));
                os.writeObject(g);
        }
        catch (IOException e) {
                e.printStackTrace();
        }
        finally {
                if (os != null)
                        try {
                                os.close();
                        }
                        catch (IOException e) {}
        }
		
		
		SerialListOldFashion slof = new SerialListOldFashion();
		
		ArrayList<AggregationExceptions> aggregationExceptions = slof.readAggregationExceptionsFromFile("", "input.txt");
		
		System.out.println("The end " +aggregationExceptions.size());

	}

}
