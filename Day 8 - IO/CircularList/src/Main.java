import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {

	public static final int listSize = 5;
	
	public static void main(String[] args){
		
		CircularList<String> circularList = new CircularList<String>();
		
		for(int i = 0; i<listSize; i++)
			circularList.add("This is element: " +i);
		
		 // Serializare.
        ObjectOutputStream objectOutputStream = null;
        try {
        	objectOutputStream = new ObjectOutputStream(new FileOutputStream("out.bin"));
        	objectOutputStream.writeObject(circularList);
        }
        catch (IOException e) {
                e.printStackTrace();
        }
        finally {
	        if (objectOutputStream != null){
	            try {
	            	objectOutputStream.close();
	            }
	            catch (IOException e) {}
	        }
        }
        
        // Deserializare.
        ObjectInputStream objectInputstream = null;
        CircularList<String> readCircularList = null;
        
        try {
        	objectInputstream = new ObjectInputStream(new FileInputStream("out.bin"));
        	readCircularList = ((CircularList<String>)objectInputstream.readObject());
        }
        catch (IOException e) {
                e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
                e.printStackTrace();
        }
        finally {
        	if (objectInputstream != null){
	            try {
	            	objectInputstream.close();
	            }
	            catch (IOException e) {}
        	}
        }

        System.out.println("Initial list: \n" + circularList);
        System.out.println("Deserialized: \n" + readCircularList);
        
	}
	
}
