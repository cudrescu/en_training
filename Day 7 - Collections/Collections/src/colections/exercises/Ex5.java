package colections.exercises;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Run the example? What happens? Why?
 * @author gtrandafir
 *
 * Eroarea provine din faptul ca MyInteger nu implementeaza comparable pentru a putea fi folosita de PriorityQueue
 */
public class Ex5 {
	public static void main(String[] args){
		Queue<MyInteger> queue = new PriorityQueue<>();
		queue.add(new MyInteger(1));
		queue.add(new MyInteger(2));
		for (MyInteger myInteger : queue) {
			System.out.println(myInteger);
		}
		
	}
}

/**
 * Am implementat Comparable si metoda compareTo
 */
class MyInteger implements Comparable<MyInteger>{
	private int value; 
	
	public MyInteger(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "MyInteger [value=" + value + "]";
	}

	@Override
	public int compareTo(MyInteger o) {
		return this.value - o.value;
	}
}
