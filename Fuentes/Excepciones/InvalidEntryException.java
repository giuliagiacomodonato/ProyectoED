package Excepciones;
/**
 * Excepción que se lanza cuando una entrada es inválida
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class InvalidEntryException extends Exception{
	/**
	 * Crea una nueva InvalidEntryException.
	 * @param msg Mensaje que se muestra cuando se lanza la excepción.
	 */
	public InvalidEntryException(String msg){
		super(msg);
	}
}
