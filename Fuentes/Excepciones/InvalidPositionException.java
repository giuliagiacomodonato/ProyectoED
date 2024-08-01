package Excepciones;
/**
 * Excepión que se lanza cuando una posición es inválida
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class InvalidPositionException extends Exception {
	
	/**
	 * Crea una nueva InvalidPositionException.
	 * @param msg Mensaje que se muestra cuando se lanza la excepción.
	 */
	public InvalidPositionException(String msg){
		super(msg);
	}
	
}
