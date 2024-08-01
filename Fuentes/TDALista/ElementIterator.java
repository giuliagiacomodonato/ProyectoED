package TDALista;
import Excepciones.*;
import Auxiliares.Position;
import java.util.*;
/**
 * 
 * Iterador de elementos
 * @param <E> Tipo de los elementos a iterar.
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class ElementIterator<E> implements Iterator <E> {
	protected PositionList<E> list;
	protected Position<E> cursor; 
	
	/**
	 * Crea un nuevo iterador.
	 * @param l Lista de los elementos a iterar.
	 */
	public ElementIterator (PositionList <E> l ) {
		try {
			list = l; 
			if (list.isEmpty()) {
				cursor = null;
			}
			else {
				cursor = list.first();
			}
		}
		catch(EmptyListException e) {
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * Consulta si el iterador tiene siguiente.
	 * @return Verdadero si tiene seguiente, falso en caso contrario.
	 */
	public boolean hasNext() { 
			return cursor != null; 
	}
	
	/**
	 * Consulta por el elemento a iterar y avanza al siguiente elemento.
	 * @return Elemento corriente.
	 */
	public E next ()  {
		E toReturn = null;
		try {
			if ( cursor != null ){
				toReturn = cursor.element(); 
				cursor = (cursor == list.last()) ? null : list.next(cursor); 
			}
		}
		catch(EmptyListException | BoundaryViolationException | InvalidPositionException e) {
			System.out.print(e.getMessage());
		}
		return toReturn; 
	} 
}