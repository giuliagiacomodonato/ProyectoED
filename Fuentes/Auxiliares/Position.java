package Auxiliares;

/**
 * Interface Position
 * @param <E> Tipo de las posiciones.
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public interface Position<E> {
	
	/**
	 * Consulta el elemento guardado en la posición que recibe el mensaje.
	 * @return Elemento guardado en la posición que recibe el mensaje.
	 */
	public E element();
}
