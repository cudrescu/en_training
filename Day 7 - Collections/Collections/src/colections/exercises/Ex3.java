package colections.exercises;

import java.util.Iterator;

/**
 * Lets make our own iterable collection. We want to be able to write a
 * "foreach" on our collection. Solution?
 * 
 * @author George Trandafir
 * 
 */
public class Ex3 {
	public static void main(String[] args) {
		Town<String> myTown = new Town<>();
		for (Town town : myTown) {

		}
	}
}

class Town<T>{
	private T type;
}