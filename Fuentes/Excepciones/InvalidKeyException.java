package Excepciones;

/**
 * Excepción que se lanza cuando una entrada es inválida
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class InvalidKeyException extends Exception {
	/**
	 * Crea una nueva InvalidKeyException.
	 * @param msg Mensaje que se muestra cuando se lanza la excepción.
	 */
	public InvalidKeyException(String msg){
		super(msg);
	}
}