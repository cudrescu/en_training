
public class BusinessException extends Exception{

	/**
	 * Definirea exceptiei BusinessException
	 */
	private static final long serialVersionUID = -6699610325684126828L;

	BusinessException(Exception ex){
		super(ex);
	}
}
