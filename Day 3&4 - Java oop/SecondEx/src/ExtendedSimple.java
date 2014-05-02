
public class ExtendedSimple extends Simple{

	
	/* lipsea constructorul implicit din clasa parinte
	 * Fixed & working !
	 */
	ExtendedSimple(){
		System.out.println("Hello from a 0-arg constructor");
	}
	
	ExtendedSimple(int i){
		System.out.println("Hello from a 1-arg constructor");
	}
	
	ExtendedSimple(int i, int j){
		System.out.println("Hello from a 2-arg constructor");
	}
}
