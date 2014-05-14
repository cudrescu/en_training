import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class SecondEncription implements Encription{

	private ArrayList<LetterMapping> letterMappingArray;
	private HashMap<String, Integer> letterMappingHash;
	
	SecondEncription(ArrayList<LetterMapping> letterMappingArray, HashMap<String, Integer> letterMappingHash){
		this.letterMappingArray = letterMappingArray;
		this.letterMappingHash = letterMappingHash;
	}
	
	
	@Override
	public String encript(String toCript, int key) {
		
		String cripted = "";
		char[] toCriptArray = toCript.toCharArray();
		int length = toCriptArray.length;
		
		switch(key){
			
			case 0:
				for(int i = 0; i<length; i++){
					if((toCriptArray[i] >= 'a' && toCriptArray[i] <= 'z') || (toCriptArray[i] >= 'A' && toCriptArray[i] <= 'Z')){
						cripted += getMappedValue(toCriptArray[i]) + 10;
					}
				}
				break;
			case 1:
				for(int i = 0; i<length; i++){
					if((toCriptArray[i] >= 'a' && toCriptArray[i] <= 'z') || (toCriptArray[i] >= 'A' && toCriptArray[i] <= 'Z')){
						cripted += letterMappingHash.get(String.valueOf(toCriptArray[i])) + 10;
					}
				}
				break;
			default:
				System.out.println("Wrong type argument! Expected 0/1");
				break;
		}
		
		return cripted;
	}

	private int getMappedValue(char letter) {
		
		for(int i = 0; i<letterMappingArray.size(); i++){
			if(letterMappingArray.get(i).getLetter().equals(""+letter)){
				return letterMappingArray.get(i).getValue();
			}
		}
		
		return -1;
	}

	@Override
	public String decript(String toDecript, int key) {
		
		String decripted = "";	
		char[] toDecriptArray = toDecript.toCharArray();
		int length = toDecriptArray.length;
		
		switch(key){
			
			case 0:
				for(int i = 0; i<length; i+=2){
					decripted += getMappedLetter(Integer.parseInt(""+toDecriptArray[i] + toDecriptArray[i+1]) - 10, 0);
				}
				break;
			case 1:
				for(int i = 0; i<length; i+=2){
					decripted += getMappedLetter(Integer.parseInt(""+toDecriptArray[i] + toDecriptArray[i+1]) - 10, 1);
				}
				break;
			default:
				System.out.println("Wrong type argument! Expected 0/1");
				break;
		}
		
		
		return decripted;
	}


	private String getMappedLetter(int value, int sourceType) {

		String returnLetter = "";

		switch(sourceType){
		
		case 0:
			for(int i = 0; i<letterMappingArray.size(); i++){
				if(letterMappingArray.get(i).getValue() == value)
					returnLetter =  letterMappingArray.get(i).getLetter();
			}
			return returnLetter;
		case 1:
			for(Entry<String, Integer> entry : letterMappingHash.entrySet()){
				if(entry.getValue() == value)
					returnLetter = entry.getKey();
			}
			return returnLetter;
			
		default:
			return returnLetter;
		}
	}

}
