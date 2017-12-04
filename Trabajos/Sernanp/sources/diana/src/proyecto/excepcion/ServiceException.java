package proyecto.excepcion;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(Exception e){
		super("Error en Service: " + e);
	}


	public ServiceException(String message)
    {
            super(message);
    }
    
    public ServiceException(Throwable cause)
    {
            super(cause);
    }
    
    public ServiceException(String message, Throwable cause)
    {
            super(message, cause);
    }
	
}
