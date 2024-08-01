
package Modelo;

/**
 * Modela un par de elementos (k,v)
 * @param <K> Tipo del primer elemento.
 * @param <V> Tipo del segundo elemento.
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class Pair <K,V>{
	protected K obj1;
	protected V obj2;
	
	/**
	 * Crea un par 
	 * @param obj1, primer elemento del par.
	 * @param obj2, segundo elemento del par. 
	 */
	
	public Pair(K obj1,V obj2) {
		this.obj1=obj1;
		this.obj2=obj2;
	}
	
	/**
	 * Consulta por el primer elemento del par.
	 * @return Primer elemento del par.
	 */
	public K getK() {
		return obj1;
	}
	
	/**
	 * Consulta por el segundo elemento del par.
	 * @return Segundo elemento del par.
	 */
	public V getV() {
		return obj2;
	}
}