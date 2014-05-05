
public class BusinessComponent {

	private PersistenceComponent persistenceComponent;
	
	/**
	 * constructorul clasei
	 * @param persistenceComponent
	 */
	public void setPersistenceComponent(PersistenceComponent persistenceComponent){
		this.persistenceComponent = persistenceComponent;
	}
	
	/**
	 * metoda in care se apeleaza metoda persist din persistenceComponent si se arunca o exceptie  BusinessException
	 * daca in metoda apelata se genereaza o exceptie PersistenceException
	 * @param o
	 * @throws BusinessException
	 */
	public void doWork(Object o) throws BusinessException{
		
		try{
			persistenceComponent.persist(o);
		} catch (PersistenceException ex){
				throw new BusinessException(ex);
		}
		
	}
	
}

