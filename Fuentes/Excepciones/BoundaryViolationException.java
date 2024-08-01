package Excepciones;
/**
 * 
 * Excepción que se lanza cuando se violan de los límites
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class BoundaryViolationException extends Exception {
	/**
	 * Crea una nueva BoundaryViolationException.
	 * @param msg Mensaje que se muestra cuando se lanza la excepción.
	 */
	public BoundaryViolationException(String msg){
		super(msg);
	}
	
}
