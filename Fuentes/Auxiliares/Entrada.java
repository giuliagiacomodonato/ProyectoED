package Auxiliares;

/**
 * Modela un par clave-valor
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 * @param <K> Tipo de las claves.
 * @param <V> Tipo de los valores.
 */
public class Entrada<K, V> implements Entry<K, V> {
	private K clave;
	private V valor;

	/**
	 * Crea una entrada (k,v).
	 * @param k Clave de la entrada.
	 * @param v Valor de la entrada.
	 */
	public Entrada(K k, V v) {
		clave = k;
		valor = v;
	}
	
	/**
	 * Consulta la clave de una entrada.
	 * @return Clave de la entry que recibe el mensaje.
	 */

	public K getKey() {
		return clave;
	}
	
	/**
	 * Consulta la clave de una entrada.
	 * @return Clave de la entry que recibe el mensaje.
	 */
	public V getValue() {
		return valor;
	}

	/**
	 * Modifica la clave de la entrada que recibe el mensaje.
	 * @param k Clave.
	 */
	public void setKey(K k) {
		clave = k;
	}

	/**
	 * Modifica el valor de la entrada que recibe el mensaje.
	 * @param v Valor.
	 */
	public void setValue(V v) {
		valor = v;
	}

	/**
	 * Devuelve la entrada en forma de string (k,v).
	 * @return La entrada en forma de string (k,v).
	 */
	public String toString() {
		return "(" + getKey() + "," + getValue() + ")" ;
	}
}