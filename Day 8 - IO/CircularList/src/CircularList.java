import java.io.Serializable;

/**
 * clasa in care am definit o celula din lista 
 */
class Node <T> implements Serializable{
	
	private static final long serialVersionUID = -3825931614408133369L;
	private T value;
	private Node<T> next;
	
	Node(T value, Node<T> next){	
		this.value = value;
		this.next = next;
	}
	
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
 * clasa in care am definit o lista circulara 
 * @param <T>
 */
public class CircularList<T> implements Serializable{

	private static final long serialVersionUID = -3153585385271963379L;
	Node<T> end;
	Node<T> start;
	
	public CircularList(){
	
		this.end = null;
		this.start = null;
	}
	
	public CircularList(CircularList<T> list){
		
		for(Node<T> node = list.start; node.equals(end) == false; node = node.getNextNode()){
			this.add(node.getValue());
		}
	}
	
	void add(T value){
		
		if(start == null){
			
			start = new Node<T>(value, null);
			end = start;
		}
		else{
			
			Node<T> addNode = new Node<T>(value, start);
			end.setNextNode(addNode);
			end = addNode;
		}
	}
	
	void remove(int index){
		
		if(index == 0){
			this.end.setNextNode(this.start.getNextNode());
			this.start = this.end.getNextNode();
			return;
		}
		
		int count = 0;
		for(Node<T> node = this.start; node.equals(end) == false; node=node.getNextNode(), count++){
			if(index == count+1){
				node.setNextNode(node.getNextNode().getNextNode());
				return;
			}
		}
	}
	
	public String toString(){
		
		String output = "";
		
		for(Node<T> node = this.start; node.equals(end) == false; node=node.getNextNode())
				output += node.getValue() +"\n";
		
		return output;
	}
	
}
