package game;
/**
 * 
 * @author Martin Fernandez
 * This is our own exception, which it's used in case the life will be negative
 *
 */

public class NegativeLifeException  extends Exception{
	public NegativeLifeException() {
		super();
	}
	
	public NegativeLifeException(String mensaje) {
		super(mensaje);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Se ha producido un error";
	}
}
