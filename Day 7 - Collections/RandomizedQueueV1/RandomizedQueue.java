package RandomizedQueueV1;
import java.util.Iterator;
import java.util.Random;

/**
 * Clasa ce contine implementarea unei cozi randomizate
 * RandomQueue<Item> este o interfata pe care am definito pentru aceasta coada;
 * @param <Item>
 */
public class RandomizedQueue <Item> implements Iterable<Item>, RandomQueue<Item>{

	private int size;
	private Node<Item> start;
	private Node<Item> end;
	Random generator;
	
	/**
	 *  construct an empty randomized queue
	 */
	public RandomizedQueue(){
		
		this.start = null;
		this.end = null;
		this.size = 0;
		this.generator = new Random();
	}
	
	/**
	 * implementarea unei celule din coada
	 * @param <T>
	 */
	 private class Node <T>{
		
		private T value;
		private Node<T> next;
		
		Node(T value, Node<T> next){	
			this.value = value;
			this.next = next;
		}
		
		@SuppressWarnings("unused")
		void setValue(T newValue){
			this.value = newValue;
		}
		
		T getValue(){
			return this.value;
		}
		
		void setNextNode(Node<T> newNextNode){
			this.next = newNextNode;
		}
		
		Node<T> getNextNode(){
			return this.next;
		}
	}

	/**
	 *  is the queue empty?
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 *  return the number of items on the queue
	 */
	public int size(){
		return size;
	}
	
	/**
	 *  add the item
	 */
	public void enqueue(Item item){
		
		if(item == null){
			throw new NullPointerException();
		}
		
		if(start == null){	
			start = new Node<Item>(item, null);
			end = start;
		}
		else{		
			Node<Item> addNode = new Node<Item>(item, null);
			end.setNextNode(addNode);
			end = addNode;
		}
		
		size ++;
	}

	/**
	 *  delete and return a random item
	 */
	public Item dequeue(){
		
		if(this.isEmpty()){
			throw new java.util.NoSuchElementException();
		}
		
		Item returnValue = null;
		int position = generator.nextInt(size);
		int index = 0;
		
		if(position == 0){
			returnValue = start.getValue();
			this.start = this.start.getNextNode();
			
			size --;
		}
		else{
			for(Node<Item> node = this.start; node != null; node=node.getNextNode(), index++){
				if(index+1 == position){
					returnValue = node.getNextNode().getValue();
					if(position != size-1)
						node.setNextNode(node.getNextNode().getNextNode());
					else
						node.setNextNode(null);
					
					size --;
					break;
				}
			}
		}
		
		return returnValue;
	}
	
	/**
	 *  return (but do not delete) a random item
	 */
	public Item sample(){
		
		if(this.isEmpty()){
			throw new java.util.NoSuchElementException();
		}
		
		Item returnValue = null;
		int position = generator.nextInt(size);
		int index = 0;
		
		for(Node<Item> node = this.start; node != null; node=node.getNextNode(), index++){
			if(index == position){
				returnValue = node.getValue();
				break;
			}
		}
		
		return returnValue;
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
	
	/**
	 * intoarce elementul de la pozitia primita ca parametru
	 *
	 */
	private Item getItemByIndex(int position) {
		
		int index = 0;
		Item returnValue = null;
		for(Node<Item> node = this.start; node != null; node=node.getNextNode(), index++){
			if(index == position){
				returnValue = node.getValue();
				break;
			}
		}
		
		return returnValue;
	}
	
	/**
	 *  return an independent iterator over items in random order
	 */
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
				return getItemByIndex(indexes[listedCount ++]);
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
