package Serial;
import java.util.ArrayList;

public class Serial {

	public static final int testSize = 100000;
	
	
	private static boolean isPrime(int element){
		
		int maxValue = (int)Math.sqrt(element);
		for(int i = 2; i<=maxValue; i++)
			if(element%i == 0)
				return false;
		
		return true;
	}
	
	public static ArrayList<Integer> init(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 2; i<testSize+2; i++)
			list.add(i);
		return list;
	}
	
	public static void main(String[] args){
		
		ArrayList<Integer> initialList = init();
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i<testSize; i++){
			if(isPrime(initialList.get(i))){
				resultList.add(initialList.get(i));
			}
		}
				
		System.out.println("Number of elements in result list: " +resultList.size());
		long end = System.currentTimeMillis();
		
		System.out.println("Execution time: " +(end-start));
	}

}
