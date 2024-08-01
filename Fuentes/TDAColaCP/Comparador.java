package TDAColaCP;
/**
 * Compara dos elementos de forma genérica
 * @param <E> Tipo de los elementos que se comparan
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class Comparador<E> implements java.util.Comparator<E> {

	/**
	 * Compara dos elementos según su relacíon de orden.
	 * @return Devuelve cero si los elementos son iguales, un número positivo si el primer elemento es mayor al segundo
	 * y un número negativo en caso contrario.
	 */
	public int compare(E a, E b) throws ClassCastException {
		return ((Comparable<E>) a).compareTo(b);
	}
}
