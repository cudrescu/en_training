package colections.exercises;

import java.util.Map;
import java.util.TreeMap;

/**
 * Compile and run. What's the problem?
 * 
 * @author George Trandafir
 * 
 * Square trebuie sa implementeze comparable pentru a fi folosita intrun TreeMap intrucat TreeMap tine elementele ordonate
 */
public class Ex4 {
	public static void main(String[] args) {
		House house1 = new House(1);
		House house2 = new House(50);
		Square square1 = new Square(20, 22);
		Square square2 = new Square(21, 23);
		Map<Square,House> map = new TreeMap<Square, House>();
		
		map.put(square1, house1);
		map.put(square2, house2);
		System.out.println(map.containsKey(square1));
		for (Square index : map.keySet()) {
			System.out.println(map.get(index));
		}
	}
}
/**
 * Am implementat comparable si am definit metoda compareTo pentru a ordona crescator elementele
 */
class Square implements Comparable<Square>{
	private int xPos, yPos;

	public Square(int x, int y) {
		xPos = x;
		yPos = y;
	}

	@Override
	public int compareTo(Square o) {
		if(this.xPos > o.xPos)
			return 1;
		else
			if(this.xPos < o.xPos)
				return -1;
			else
				if(this.yPos > o.yPos)
					return 1;
				else
					if(this.yPos < o.yPos)
						return -1;
					else
						return 0;
	}

}


class House {
	private Integer age;

	public House(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "House [age=" + age + "]";
	}
}
