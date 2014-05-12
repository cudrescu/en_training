package RandomizedQueueV2;

import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements RandomQueue<Item>, Iterable<Item>{

	private int size;
	private int allocatedSize;
	Random generator;
	private Item[] listOfElements;
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue(){
		this.size = 0;
		this.allocatedSize = 1;
		this.listOfElements = (Item[])new Object[1];
		this.generator = new Random();
	}
	
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void enqueue(Item item) {
		
		if(item == null){
			throw new NullPointerException();
		}
		
		if(size == allocatedSize){
			resizeDouble();
		}
		
		listOfElements[size] = item;
		size ++;
	}

	@SuppressWarnings("unchecked")
	private void resizeDouble() {
		
		allocatedSize *= 2;
		Item[] newListOfElements = (Item[])new Object[allocatedSize];
		
		for(int i = 0; i<size; i++){
			newListOfElements[i] = listOfElements[i];
		}
		
		listOfElements = newListOfElements;
	}


	@Override
	public Item dequeue() {
		if(this.isEmpty()){
			throw new java.util.NoSuchElementException();
		}
		
		Item returnValue = null;
		int position = generator.nextInt(size);
		returnValue = listOfElements[position];
		
		for(int i = position; i<size-1; i++){
			listOfElements[i] = listOfElements[i+1];
		}
		
		size --;
		if(size < allocatedSize/4){
			resizeHalf();
		}	
		
		return returnValue;
	}

	@SuppressWarnings("unchecked")
	private void resizeHalf() {
		allocatedSize /= 2;
		Item[] newListOfElements = (Item[])new Object[allocatedSize];
		
		for(int i = 0; i<size; i++){
			newListOfElements[i] = listOfElements[i];
		}
		
		listOfElements = newListOfElements;	
	}


	@Override
	public Item sample() {
		
		if(this.isEmpty()){
			throw new java.util.NoSuchElementException();
		}
		
		int position = generator.nextInt(size);
		return listOfElements[position];
	}

	/** rearanjare random a indecsilor dupa care se va face iterarea
	 * in acest mod 2 iteratori vor afisa elementele in ordine diferita
	 * @param array
	 */
	private void shuffleArray(int[] array)
	{
	    int index, temp;
	    for (int i = array.length - 1; i > 0; i--)
	    {
	        index = generator.nextInt(i + 1);
	        temp = array[index];
	        array[index] = array[i];
	        array[i] = temp;
	    }
	}
	
	
	/**
	 * metoda ce returneaza un array de intregi cuprinsi intre [0-size] intr-o ordine aleatoare
	 */
	private int[] initIndexes(){
		
		int[] indexes = new int[size];
		
		for(int i = 0; i<size; i++)
			indexes[i] = i;
		
		 shuffleArray(indexes);
		 
		 return indexes;
	}
	
	@Override
	public Iterator<Item> iterator() {
		
	Iterator<Item> it = new Iterator<Item>() {
			
			private int listedCount = 0;
			private int[] indexes = initIndexes();	
			
			
			@Override
			public boolean hasNext() {
				return listedCount < size;
			}

			@Override
			public Item next() {
				
				if(!hasNext()){
					throw new java.util.NoSuchElementException();
				}
				return listOfElements[indexes[listedCount ++]];
			}

			@Override
			public void remove() {
				if(isEmpty()){
					throw new UnsupportedOperationException();
				}
			}
			
		};
		
		return it;
	}
}
