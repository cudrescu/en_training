
public class ChainedExceptionsDemo {
	
	/** 
	 * Metoda main in care se creaza 2 obiecte persistenceComponent si businessComponent
	 * si se apeleaza metoda doWork pentru a evidentia ExceptionChaining
	 * @param args
	 */
	public static void main(String[] args) {
		
		PersistenceComponent persistenceComponent = new PersistenceComponent();
		BusinessComponent businessComponent = new BusinessComponent();
		businessComponent.setPersistenceComponent(persistenceComponent);
		
		try{
			businessComponent.doWork(new Object());
		}
		catch (BusinessException ex){
			
			Throwable cause = ex.getCause(); 
			
			if(cause instanceof PersistenceException){
				PersistenceException pex = (PersistenceException)cause;
				System.out.println("PersistenceException caught:" + pex.getMessage());
			}	
		}
	}
}
