package Modelo;
/**
 * Comparador de enteros de mayor a menor
 * @param <Integer> 
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class MaxComparator<Integer> implements java.util.Comparator<Integer> {
	
	/**
	 * Compara dos enteros según su relación de orden.
	 * Devuelve cero si los elementos son iguales, un número positivo si el segundo elemento es mayor al primero
	 * y un número negativo en caso contrario.
	 * @param o1 Primer elemento  a comparar.
	 * @param o2 Segundo elemento a comparar.
	 * @return Devuelve cero si los elementos son iguales, un número positivo si el segundo elemento es mayor al primero
	 *  y un número negativo en caso contrario.
	 */
	public int compare(Integer o1, Integer o2) {
		return (int)o2 - (int)o1;
	}
}