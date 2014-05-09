package colections.exercises;

import java.util.Set;
import java.util.TreeSet;

/**
 * Compile and run. What's the problem?
 * 
 * @author George Trandafir
 * 
 * problema este cauzata de clasa Graduate care nu implementa Comparable
 */
public class Ex1 {
	public static void main(String[] args) {
		Graduate graduate1 = new Graduate(1);
		Graduate graduate2 = new Graduate(2);
		Set<Graduate> set = new TreeSet<Graduate>();
		set.add(graduate1);
		set.add(graduate2);
		for (Graduate graduate : set) {
			System.out.println(graduate);
		}
	}
}

/** 
 * Graduate trebuie sa implementeza Comparable
 * Am definit metoda compareTo
 */
class Graduate implements Comparable<Graduate>{
	private Integer age;

	public Graduate(Integer age) {
		this.age = age;
	}
	
	public Integer getAge(){
		return this.age;
	}

	@Override
	public String toString() {
		return "Graduate [age=" + age + "]";
	}

	@Override
	public int compareTo(Graduate o) {		
		return this.age - o.getAge();
	}
}
