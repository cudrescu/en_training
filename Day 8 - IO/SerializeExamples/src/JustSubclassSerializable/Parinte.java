package JustSubclassSerializable;

public class Parinte{

	protected String name;
	
	public Parinte(){
		this.name = "";
	}
	
	public Parinte(String name){
		this.name = name;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return "" + this.name +"\n";
	}
}
