package JustSuperclassSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) {
		
		Parinte parinte = new Parinte("Zeus");
		Parinte fiu = new Fiu("Hercule", 10);
		
		// Serializare.
        ObjectOutputStream objectOutputStream = null;
        try {
        	objectOutputStream = new ObjectOutputStream(new FileOutputStream("SuperclassSerializable.bin"));
        	objectOutputStream.writeObject(parinte);
        	objectOutputStream.writeObject(fiu);	
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
        Parinte parinteDeserializat = null;
		Parinte fiuDeserializat = null;
        
        try {
        	objectInputstream = new ObjectInputStream(new FileInputStream("SuperclassSerializable.bin"));
        	parinteDeserializat = (Parinte)objectInputstream.readObject();
        	fiuDeserializat = (Fiu)objectInputstream.readObject();
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
        
        // Afisare rezultate
        System.out.println("Inainte de serializare: \n" +parinte +fiu);
        System.out.println("Dupa deserializare: \n" +parinteDeserializat +fiuDeserializat);

	}

}
