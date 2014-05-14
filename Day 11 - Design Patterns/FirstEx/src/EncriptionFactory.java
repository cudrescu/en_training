import java.util.ArrayList;
import java.util.HashMap;


public class EncriptionFactory {

	private static final EncriptionFactory instance = new EncriptionFactory();
	
	private EncriptionFactory(){
	}
	
	public static EncriptionFactory getInstance(){
		return instance;
	}
	
	public enum EncriptionType{
		FirstEncription, SecondEncription
	}
	
	public Encription encriptionFactory(EncriptionType encriptionType, ArrayList<LetterMapping> letterMappingArray, HashMap<String, Integer> letterMappingHash){
		
		switch(encriptionType){
		
			case FirstEncription:
				return new FirstEncription(letterMappingArray, letterMappingHash);
			case SecondEncription:
				return new SecondEncription(letterMappingArray, letterMappingHash);		
		}
		
		throw new IllegalArgumentException("The encription type " +encriptionType + " is not recognized");
		
	}
}
