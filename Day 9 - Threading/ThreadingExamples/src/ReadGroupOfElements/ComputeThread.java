package ReadGroupOfElements;

import java.util.ArrayList;

public class ComputeThread extends Thread{

	ArrayList<Integer> elemente;
	ArrayList<Integer> result;
	
	public ComputeThread(ArrayList<Integer> elemente, ArrayList<Integer> result, int nrElemPerThread){
		
		synchronized(elemente){
			if(elemente.size()/nrElemPerThread < 2){
				this.elemente = new ArrayList<Integer>(elemente);
			}
			else{
				this.elemente = new ArrayList<Integer>();
				for(int i = 0; i<nrElemPerThread; i++)
					this.elemente.add(elemente.remove(i));
			}
		}
		this.result = result;
	}
	
	private boolean isPrime(int element){
		
		int maxValue = (int)Math.sqrt(element);
		for(int i = 2; i<=maxValue; i++)
			if(element%i == 0)
				return false;
		
		return true;
	}
	
	public void run(){
		
		for(int i = 0; i<elemente.size(); i++){
			if(isPrime(elemente.get(i))){
				synchronized(result){
					result.add(elemente.get(i));
				}
			}
		}
		
	}
	
}
