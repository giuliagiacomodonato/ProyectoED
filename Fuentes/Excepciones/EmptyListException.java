package Excepciones;
/**
 * Excepción que se lanza cuando la lista está vacía
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class EmptyListException extends Exception {
		
	/**
	 * Crea una nueva EmptyListException.
	 * @param msg Mensaje que se muestra cuando se lanza la excepción.
	 */
	public EmptyListException (String msg){
			super(msg);
		}
	

}
