package colections.exercises;

import java.util.ArrayList;

/**
 * Lets make our own iterable collection. We want to be able to write a
 * "foreach" on our collection. Solution?
 * 
 * @author George Trandafir
 * 
 * 
 */

/**
 * Am declarat o colectie (ArrayList) pe care se poate itera cu foreach
 */
public class Ex3 {
	public static void main(String[] args) {
		ArrayList<Town<String>> myTown = new ArrayList<Town<String>>();
		
		myTown.add(new Town<String>("exemplu"));
		myTown.add(new Town<String>("simplu"));
		
		for (Town<String> town : myTown) {
			System.out.println("Job done ! " +town);	
		}
	}
}

class Town<T>{
	private T type;
	
	Town(T type){
		this.type = type;
	}
	
	public String toString(){
		return "" + type;
	}
}