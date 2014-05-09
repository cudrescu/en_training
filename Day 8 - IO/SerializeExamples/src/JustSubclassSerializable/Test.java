package JustSubclassSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.WriteAbortedException;

public class Test {

	public static void main(String[] args) {
		
		Parinte parinte = new Parinte("Zeus");
		Parinte fiu = new Fiu("Hercule", 10);
		
		// Serializare parinte
        ObjectOutputStream objectOutputStream = null;
        try {
        	objectOutputStream = new ObjectOutputStream(new FileOutputStream("SubclassSerializableParinte.bin"));
        	objectOutputStream.writeObject(parinte);
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
        
        // Serializare fiu
        try {
        	objectOutputStream = new ObjectOutputStream(new FileOutputStream("SubclassSerializableFiu.bin"));
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
        
        // Deserializare parinte.
        ObjectInputStream objectInputstream = null;
        Parinte parinteDeserializat = null;
		Parinte fiuDeserializat = null;
        
        try {
        	objectInputstream = new ObjectInputStream(new FileInputStream("SubclassSerializableParinte.bin"));
        	parinteDeserializat = (Parinte)objectInputstream.readObject();
        }
        catch(WriteAbortedException e){
        	System.out.println("Exceptie la citirea obiectului serializat! ");
        }
        catch(NotSerializableException e){
        	System.out.println("Obiectul nu este serializabil!");
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
        
        
        // Deserializare fiu.
        try {
        	objectInputstream = new ObjectInputStream(new FileInputStream("SubclassSerializableFiu.bin"));
        	fiuDeserializat = (Fiu)objectInputstream.readObject();
        }
        catch(WriteAbortedException e){
        	System.out.println("Exceptie la citirea obiectului serializat! ");
        }
        catch(NotSerializableException e){
        	System.out.println("Obiectul nu este serializabil!");
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
