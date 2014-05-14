import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

	public static void mapLettersToArray(ArrayList<LetterMapping> letterMappingArray){
		for(char letter = 'a'; letter < 'z'; letter++){
			letterMappingArray.add(new LetterMapping(""+letter, (letter - 'a')+10));
		}
		for(char letter = 'A'; letter < 'Z'; letter++){
			letterMappingArray.add(new LetterMapping(""+letter, (letter-'A')+36));
		}
	}
	
	public static void mapLettersToHash(HashMap<String, Integer> letterMappingHash){
		for(char letter = 'a'; letter < 'z'; letter++){
			letterMappingHash.put(""+letter, (letter - 'a')+10);
		}
		for(char letter = 'A'; letter < 'Z'; letter++){
			letterMappingHash.put(""+letter, (letter - 'A')+36);
		}

	}
	
	public static String generateTest(){
		
		String testString = "";
		char[] letters = new char[50];
		for(char letter = 'a'; letter<'z'; letter ++)
			letters[letter-'a'] = letter;
		
		for(char letter = 'A'; letter<'Z'; letter ++)
			letters[letter-'A' +25] = letter;

				
		Random generator = new Random();
		
		for(int i = 0; i<1000; i++){
			for(int j = 0; j<80; j++){
				testString += letters[generator.nextInt(50)];
			}
			testString += "\n";
		}
		return testString;
	}
	
	public static void main(String[] args) {
		
		ArrayList<LetterMapping> letterMappingArray = new ArrayList<LetterMapping>();
		HashMap<String, Integer> letterMappingHash = new HashMap<String, Integer>();
		
		mapLettersToArray(letterMappingArray);
		mapLettersToHash(letterMappingHash);
		
		EncriptionFactory factory = EncriptionFactory.getInstance();
		Encription encription = factory.encriptionFactory(EncriptionFactory.EncriptionType.FirstEncription, letterMappingArray, letterMappingHash);
		
		String testString = generateTest();
		
		long start2 = System.currentTimeMillis();
		String crypted2 = encription.encript(testString, 1);
		String decrypted2 = encription.decript(crypted2, 1);
		long end2 = System.currentTimeMillis();
		
		long start1 = System.currentTimeMillis();
		String crypted1 = encription.encript(testString , 0);
		String decrypted1 = encription.decript(crypted1, 0);
		long end1 = System.currentTimeMillis();
		
		System.out.println("Array time: " +(end1 - start1));
		System.out.println("Hash time: " +(end2 - start2));
		
		System.out.println("Compare crypted results: " +crypted1.equals(crypted2));
		System.out.println("Compare decrypted results: " +decrypted1.equals(decrypted2));
	}

}
