package JustSuperclassSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class Test {

	public static void main(String[] args) {
		
		Parinte parinte = new Parinte("Zeus");
		Parinte fiu = new Fiu("Hercule", 10);
		
		// Serializare parinte.
        ObjectOutputStream objectOutputStream = null;
        try {
        	objectOutputStream = new ObjectOutputStream(new FileOutputStream("SuperclassSerializableParinte.bin"));
        	objectOutputStream.writeObject(parinte);
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
        
        // Serializare fiu.
        try {
        	objectOutputStream = new ObjectOutputStream(new FileOutputStream("SuperclassSerializableFiu.bin"));
        	objectOutputStream.writeObject(fiu);	
        } 
        catch(NotSerializableException e){
        	System.out.println("Obiectul nu poate fi serializat!");
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
        
        // Deserializare parinte
        ObjectInputStream objectInputstream = null;
        Parinte parinteDeserializat = null;
		Parinte fiuDeserializat = null;
        
        try {
        	objectInputstream = new ObjectInputStream(new FileInputStream("SuperclassSerializableParinte.bin"));
        	parinteDeserializat = (Parinte)objectInputstream.readObject();
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

        // Deserializare fiu
        try {
        	objectInputstream = new ObjectInputStream(new FileInputStream("SuperclassSerializableFiu.bin"));
        	fiuDeserializat = (Fiu)objectInputstream.readObject();
        }
        catch(StreamCorruptedException e){
        	System.out.println("Obiectul nu a putut fi deserializat !");
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
        System.out.println("\nInainte de serializare: \n" +parinte +fiu);
        System.out.println("Dupa deserializare: \n" +parinteDeserializat +fiuDeserializat);

	}

}
