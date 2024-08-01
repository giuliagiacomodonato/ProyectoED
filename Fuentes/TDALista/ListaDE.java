package TDALista;
import Auxiliares.*;
import Excepciones.*;



import java.util.Iterator;

/**
 * Lista modelada con una estructura doblemente enlazada
 * @param <E> Tipo de los elementos.
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class ListaDE<E> implements PositionList<E> {

	protected int size;
	protected DNodo<E> header, trailer;
/**
 * Crea una Lista Doblemente Enlazada.
 */
	public ListaDE() {
		size = 0;
		header = new DNodo<E>(null, null, null);
		trailer = new DNodo<E>(header, null, null);
		header.setNext(trailer);
	}
/**
 * Verifica que la posicion sea válida.
 * @param p Posicion a validar.
 * @return DNodo de la posicion.
 * @throws InvalidPositionException si la posición es inválida.
 */
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException {
		if (p == null || p == header || p == trailer)
			throw new InvalidPositionException("Se ha pasado una posicion nula");
		try {
			DNodo<E> temp = (DNodo<E>) p;
			if ((temp.getPrev() == null) || (temp.getNext() == null))
				throw new InvalidPositionException("La posicion no pertenece a una lista valida");
			return temp;
		} catch (ClassCastException e) {
			throw new InvalidPositionException("La posicion es de un tipo incorrecto para esta lista");
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public Position<E> first() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("La lista esta vacia");
		return header.getNext();
	}

	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> n = checkPosition(p);
		DNodo<E> prev = n.getPrev();
		if (prev == header)
			throw new BoundaryViolationException("No se puede retornar el elemento anterior al primero");
		return prev;
	}

	public void addBefore(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> n = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E>(n.getPrev(), n, element);
		n.getPrev().setNext(nuevo);
		n.setPrev(nuevo);
		size++;
	}

	public void addFirst(E element) {
		DNodo<E> nuevo = new DNodo<E>(header, header.getNext(), element);
		header.getNext().setPrev(nuevo);
		header.setNext(nuevo);
		size++;
	}

	public E remove(Position<E> p) throws InvalidPositionException {
		DNodo<E> n = checkPosition(p);
		size--;
		DNodo<E> ant = n.getPrev();
		DNodo<E> sig = n.getNext();
		ant.setNext(sig);
		sig.setPrev(ant);
		E elemento = n.element();
		n.setNext(null);
		n.setPrev(null);
		n.setElemento(null);
		return elemento;
	}

	public E set(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> n = checkPosition(p);
		E elemento = n.element();
		n.setElemento(element);

		return elemento;
	}

	public void addLast(E e) {
		DNodo<E> nuevo = new DNodo<E>(trailer.getPrev(), trailer, e);
		trailer.getPrev().setNext(nuevo);
		trailer.setPrev(nuevo);
		size++;

	}

	public Position<E> last() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("La lista esta vacia");
		return trailer.getPrev();
	}

	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> n = checkPosition(p);
		DNodo<E> next = n.getNext();
		if (next == trailer)
			throw new BoundaryViolationException("No se puede retornar la posicion siguiente a la ultima");

		return next;
	}

	public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		DNodo<E> n = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E>(n, n.getNext(), e);
		n.getNext().setPrev(nuevo);
		n.setNext(nuevo);
		size++;
	}

	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}

	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> LP = new ListaDE<Position<E>>();
		if (!isEmpty()) {
			try {
				Position<E> pos = first();
				boolean seguir = true;
				while (seguir) {
					LP.addLast(pos);
					if (pos == last())
						seguir = false;
					else
						pos = next(pos);
				}
			} catch (EmptyListException | BoundaryViolationException | InvalidPositionException e) {
			}
		}
		return LP;
	}

}
