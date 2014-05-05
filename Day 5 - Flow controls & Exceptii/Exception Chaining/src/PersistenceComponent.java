
public class PersistenceComponent {
	
	/**
	 * metoda persist arunca o exceptie PersistenceException
	 * @param arg
	 * @throws PersistenceException
	 */
	void persist(Object arg) throws PersistenceException{
			throw new PersistenceException("Cannot persist object " +arg.toString());
	}
}
