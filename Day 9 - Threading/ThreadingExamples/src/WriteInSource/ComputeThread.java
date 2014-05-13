package WriteInSource;
import java.util.ArrayList;

public class ComputeThread extends Thread{

	private ArrayList<Integer> elemente;
	private ArrayList<Integer> result;
	
	public ComputeThread(ArrayList<Integer> elemente){
		this.elemente = elemente;
		this.result = new ArrayList<Integer>();
	}
	
	private boolean isPrime(int element){
		
		int maxValue = (int)Math.sqrt(element);
		for(int i = 2; i<=maxValue; i++)
			if(element%i == 0)
				return false;
		
		return true;
	}
	
	public void run(){
		
		while(true){
			synchronized(elemente){
				
				if(elemente.isEmpty())
					break;
				
				int elementPrelucrat = elemente.remove(0);
				if(isPrime(elementPrelucrat)){
						result.add(elementPrelucrat);
				}
			}
		}
		
		synchronized(elemente){
			elemente.addAll(result);
		}
	}
}
