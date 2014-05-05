
public class FinallyDemo {
	
	static int method1(){
		
		try{
			return 2;
		}
		finally{
			System.out.println("Executing finally block in method1()");
		}
	}
	
	static void method2(){
		
		try{
			throw new RuntimeException("Unchecked error");
		}
		finally {
			System.out.println("Executing finally block in method2()");
		}
	}
	
	/**
	 * in main se apeleaza cele 2 metode statice definite mai sus ce pun in evidenta executia blocului finally;
	 * @param args
	 */
	public static void main(String[] args){
		
		method1();
		method2();
	}
	
}
