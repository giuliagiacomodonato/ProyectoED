package Modelo;
/**
 * Comparador de enteros de menor a mayor 
 * @param <Integer>
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class MinComparator<Integer> implements java.util.Comparator<Integer> {


	/**
	 * Compara dos enteros según su relación de orden.
	 * Devuelve cero si los elementos son iguales, un número positivo si el primer elemento es mayor al segundo
	 * y un número negativo en caso contrario.
	 * @param o1 Primer elemento  a comparar.
	 * @param o2 Segundo elemento a comparar.
	 * @return Devuelve cero si los elementos son iguales, un número positivo si el priemr elemento es mayor al segundo
	 *  y un número negativo en caso contrario.
	 */
	public int compare(Integer o1, Integer o2) {
		return (int)o1 - (int)o2;
	}
	
}
   