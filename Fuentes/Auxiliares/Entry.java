package Auxiliares;
/**
 * Interface Entry
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 * @param <K> Tipo de las claves
 * @param <V> Tipo de los valores
 */
public interface Entry<K,V> {
	
	/**
	 * Consulta la clave de una entry.
	 * @return Clave de la entry que recibe el mensaje.
	 */
	public K getKey();
	
	/**
	 * Consulta el valor de una entry.
	 * @return Valor de la entry que recibe el mensaje.
	 */
	public V getValue();

}
