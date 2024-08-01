package TDALista;
import Auxiliares.Position;

/**
 * Nodo utilizado para representar estructuras enlazadas dobles
 * @param <E> Tipo del nodo.
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */

public class DNodo<E> implements Position<E> {

	private E elem;
	private DNodo<E> next, prev;
	
/**
 * Crea un nuevo DNodo.
 * @param p Previo al nodo.
 * @param n Siguiente al nodo.
 * @param e Elemento del nodo.
 */
	public DNodo(DNodo<E> p, DNodo<E> n, E e) {
		prev = p;
		next = n;
		elem = e;
	}

	/**
	 * Crea un nuevo DNodo.
	 * @param e Elemento del nodo.
	 */
	public DNodo(E e) {
		this(null, null, e);
	}

	/**
	 * Consulta por el elemento guardado en el DNodo que recibe el mensaje.
	 * @return Elemento del nodo.
	 */
	public E element() {
		return elem;
	}

	/**
	 * Consulta por el DNodo anterior del DNodo que recibe el mensaje.
	 * @return DNodo previo al nodo.
	 */
	public DNodo<E> getPrev() {
		return prev;
	}

	/**
	 * Consulta por el DNodo siguiente del DNodo que recibe el mensaje.
	 * @return DNodo siguiente al nodo.
	 */
	public DNodo<E> getNext() {
		return next;
	}
/**
 * Modifica el elemento del DNodo que recibe el mensaje.
 * @param e Elemento del nodo.
 */
	public void setElemento(E e) {
		elem = e;
	}
/**
 * Modifica el DNodo siguiente del DNodo que recibe el mensaje. 
 * @param n DNodo siguiente.
 */
	public void setNext(DNodo<E> n) {
		next = n;
	}
/**
 * Modifica el DNodo previo del DNodo que recibe el mensaje.
 * @param p DNodo previo.
 */
	public void setPrev(DNodo<E> p) {
		prev = p;
	}

}