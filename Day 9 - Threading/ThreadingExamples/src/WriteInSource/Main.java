package WriteInSource;

import java.util.ArrayList;

public class Main {


	public static final int testSize = 100000;
	public static final int noThreads = 5;
	
	public static ArrayList<Integer> init(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 2; i<testSize+2; i++)
			list.add(i);
		return list;
	}
	
	public static void main(String[] args){
		
		ArrayList<Integer> initialList = init();
		
		ComputeThread computeThreads[] = new ComputeThread[noThreads];
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i<noThreads; i++){
			computeThreads[i] = new ComputeThread(initialList);
			computeThreads[i].start();
		}
		
		for(int i = 0; i<noThreads; i++){
			try {
				computeThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Number of elements in result list: " +initialList.size());
		System.out.println("Execution time: " +(end-start));
		
	}
}
