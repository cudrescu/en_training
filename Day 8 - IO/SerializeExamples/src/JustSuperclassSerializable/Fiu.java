package JustSuperclassSerializable;

public class Fiu extends Parinte{

	private int age;
	
	public Fiu(String name, int age){
		
		super(name);
		this.age = age;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setAge(int newAge){
		this.age = newAge;
	}
	
	public String toString(){
		return this.getName() +" " +this.age + "\n";
	}
}
