package RandomizedQueueV2;

public interface RandomQueue<Item> {

	// is the queue empty?
	public boolean isEmpty();
	
	// return the number of items on the queue
	public int size();
	
	// add the item
	public void enqueue(Item item);

	// delete and return a random item
	public Item dequeue();
	
	// return (but do not delete) a random item
	public Item sample();
			
}
