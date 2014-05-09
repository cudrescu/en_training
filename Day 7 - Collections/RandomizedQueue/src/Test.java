import java.util.Iterator;


public class Test {

	public static void main(String[] args) {
		
		
		RandomizedQueue<Integer> testQueue = new RandomizedQueue<Integer>();
		
		//testare functionalitati
		System.out.println("Testare functionalitati: ");
		//enqueue
		for(int i = 0; i<10; i++){
			try{
				testQueue.enqueue(i);
			} catch(NullPointerException e){
				System.out.println("Exceptie la adaugarea elementului! Elementul este null !");
			}
		}
		
		//dequeue - sample
		try{	
			System.out.println("Dequeue: " +testQueue.dequeue());
			System.out.println("Sample: " +testQueue.sample());
		} catch(java.util.NoSuchElementException e){
			System.out.println("Exeption ! Queue is empty !");
		}
		
		//size
		System.out.println("Size: " +testQueue.size());
		System.out.println("isEmpty: " +testQueue.isEmpty());
		
		//iterator
		System.out.println("First Iterator: ");
		Iterator<Integer> firstIterator = testQueue.iterator();
		while(firstIterator.hasNext()){
			try{
				System.out.print(firstIterator.next() + " ");
			} catch(java.util.NoSuchElementException e){
				System.out.println("Exception ! No more elements !");
			}
		}
		
		System.out.println("\nSecond Iterator:");
		Iterator<Integer> secondIterator = testQueue.iterator();
		while(secondIterator.hasNext()){
			try{
				System.out.print(secondIterator.next() + " ");
			} catch(java.util.NoSuchElementException e){
				System.out.println("Exception ! No more elements !");
			}
		}
		
		//Testare exceptii
		System.out.println("\n\nTestare exceptii: ");
		RandomizedQueue<String> testStringsQueue = new RandomizedQueue<String>();
		
		//enqueue
		try{
			testStringsQueue.enqueue(null);
		} catch(NullPointerException e){
			System.out.println("Exeption ! Queue is empty !");
		}
		
		//dequeue - sample
		try{
			testStringsQueue.dequeue();
			testStringsQueue.sample();
		} catch(java.util.NoSuchElementException e){
			System.out.println("Exeption ! Queue is empty !");
		}
		
		//iterator next - remove
		Iterator<String >stringIterator = testStringsQueue.iterator();
		try{
			System.out.print(stringIterator.next() + " ");
		} catch(java.util.NoSuchElementException e){
			System.out.println("Exception ! No more elements !");
		}
		
		try{
			stringIterator.remove();
		} catch(UnsupportedOperationException e){
			System.out.println("Exception! Unsuported operation! Queue is empty !");
		}
	}

}
