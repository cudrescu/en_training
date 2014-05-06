
class Util{
	
	public static <K, V> boolean compare(K o1, V o2){
		return o1.equals(o2);
	}
}


public class Example1 {
	
	public static void main(String[] args){
		
		Integer p1 = 1;
		String p2 = "are";
		
		boolean same = Util.compare(p1, p2);
		System.out.println("Compare result: " +same);
		
		same = Util.<Integer, String>compare(p1, p2);
		System.out.println("Compare result: " +same);
	}
}
