package Excepciones;
/**
 * Excepción que se lanza cuando la cola con prioridad está vacía
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class EmptyPriorityQueueException extends Exception {

	/**
	 * Crea una nueva EmptyPriorityQueueException.
	 * @param msg Mensaje que se muestra cuando se lanza la excepción.
	 */
	 public EmptyPriorityQueueException(String msg) {
		 
		 super(msg);
	 }
	}
