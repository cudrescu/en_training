package colections.exercises;

import java.util.HashSet;
import java.util.Set;

/**
 * Is the result correct?
 * @author gtrandafir
 *
 *Rezultatul nu este corect - trebuie suprascrisa metoda hashCode
 */
public class Ex2 {
	public static void main(String[] args) {
		Set<Circle> circleList = new HashSet<Circle>();
		circleList.add(new Circle(10, 20, 5));
		System.out.println(circleList.contains(new Circle(10, 20, 5)));
	}
}

class Circle {
	private int xPos, yPos, radius;

	public Circle(int x, int y, int r) {
		xPos = x;
		yPos = y;
		radius = r;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;		
		}
		if (getClass() != obj.getClass()){
			return false;
		}
			
		Circle other = (Circle) obj;
		if (this.radius != other.radius)
			return false;
		if (this.xPos != other.xPos)
			return false;
		if (this.yPos != other.yPos)
			return false;
		
		return true;
	}
	
	
	/**
	 * Metoda hashCode trebuia suprascrisa intrucat contains din hashSet face compararea dupa aceasta
	 * nu e cea mai fericita suprascriere dar functioneaza pentru a evidentia functionalitatea din exemplu 
	 */
	public int hashCode(){
		
		return this.xPos + this.yPos +this.radius;
	}

}