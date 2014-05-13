package SplitByChunks;
import java.util.ArrayList;

public class ComputeThread extends Thread{

	private ArrayList<Integer> list;
	private ArrayList<Integer> result;
	private int start;
	private int end;
	
	ComputeThread(ArrayList<Integer> list, ArrayList<Integer> result, int start, int end){
		this.list = list;
		this.result = result;
		this.start = start;
		this.end = end;
	}

	private boolean isPrime(int element){
		
		int maxValue = (int)Math.sqrt(element);
		for(int i = 2; i<=maxValue; i++)
			if(element%i == 0)
				return false;
		
		return true;
	}
	
	public void run(){		
		for(int i = start; i<end; i++){	
			if(isPrime(list.get(i))){
				synchronized(result){
					result.add(list.get(i));
				}
			}
		}
	}
}
