package proyecto.excepcion;

public class LoginException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4301569969108281052L;

	public LoginException(){
		super("Usuario y/o clave incorrectos");
	}

	
	public LoginException(String message)
    {
            super(message);
    }
    
    public LoginException(Throwable cause)
    {
            super(cause);
    }
    
    public LoginException(String message, Throwable cause)
    {
            super(message, cause);
    }
	
}

