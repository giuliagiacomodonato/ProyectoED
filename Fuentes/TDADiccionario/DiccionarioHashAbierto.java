package TDADiccionario;
import Auxiliares.*;
import Excepciones.InvalidKeyException;
import Excepciones.InvalidPositionException;
import Excepciones.InvalidEntryException;
import TDALista.*;

//Java program to implement in-built pair classes
import java.util.Iterator;
/**
 * Diccionario modelado con Hash Abierto
 * @param <K> Tipo de las claves.
 * @param <V> Tipo de los valores.
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */
public class DiccionarioHashAbierto<K, V> implements Dictionary<K, V> {

	protected PositionList<Entrada<K, V>> A[];
	protected int n;
	protected int N = 13;
	protected final double fc = 0.5;

	/**
	 * Crea un nuevo diccionario con Hash abierto.
	 */
	public DiccionarioHashAbierto() {
		A = (ListaDE<Entrada<K, V>>[]) new ListaDE[N];
		n = 0;
		for (int i = 0; i < A.length; i++) {
			A[i] = new ListaDE<Entrada<K, V>>();
		}
	}

	/**
	 * Función de compresión para calcular el número de bucket.
	 * @param key Clave del elemento a guardar.
	 * @return Número de bucket para la clave k.
	 */
	private int H(K key) {
		return key.hashCode() % N;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public Entry<K, V> find(K key) throws InvalidKeyException {
		checkKey(key);
		Entry<K, V> ret = null;
		int clave = H(key);
		Iterator<Entrada<K, V>> it = A[clave].iterator();
		boolean esta = false;

		Entrada<K, V> act = it.hasNext() ? it.next() : null;
		while (!esta && act != null) {
			if (key.equals(act.getKey())) {
				esta = true;
				ret = act;
			} else {
				act = it.hasNext() ? it.next() : null;
			}
		}
		return ret;
	}

	public Iterable<Entry<K, V>> findAll(K key) throws InvalidKeyException {
		checkKey(key);
		PositionList<Entry<K, V>> lista = new ListaDE<Entry<K, V>>();
		int clave = H(key);

		for (Entry<K, V> elem : A[clave]) {
			if (key.equals(elem.getKey())) {
				lista.addLast(elem);
			}
		}
		return lista;
	}

	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		checkKey(key);

		if (n / N >= fc)
			rehash();
		int clave = H(key);
		PositionList<Entrada<K, V>> l = A[clave];
		Entrada<K, V> nueva = new Entrada<K, V>(key, value);
		A[clave].addLast(nueva);
		n++;
		return nueva;
	}

	public Entry<K, V> remove(Entry<K, V> e) throws InvalidEntryException {
		if (e == null)
			throw new InvalidEntryException("Entrada Invalida");
		int clave = H(e.getKey());
		PositionList<Entrada<K, V>> l = A[clave];
		Position<Entrada<K, V>> cursor = null;
		Iterator<Position<Entrada<K, V>>> it = l.positions().iterator();
		Entry<K, V> salida = null;
		while (it.hasNext() && salida == null) {
			cursor = it.next();
			if (cursor.element() == e) {
				salida = cursor.element();
				try {
					l.remove(cursor);
				} catch (InvalidPositionException ex) {
					ex.getMessage();
				}
				n--;
			}
		}
		if (salida == null)
			throw new InvalidEntryException("La entrada no se encuentra en el diccionario");

		return salida;
	}

	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K, V>> lista = new ListaDE<Entry<K, V>>();
		for (int i = 0; i < N; i++) {
			for (Entry<K, V> en : A[i]) {
				lista.addLast(en);
			}
		}
		return lista;
	}

	/**
	 * Verifica que la clave sea válida.
	 * @param key Clave.
	 * @throws InvalidKeyException si la clave es inválida.
	 */
	private void checkKey(K key) throws InvalidKeyException {
		if (key == null)
			throw new InvalidKeyException("Clave invalida");
	}

	/**
	 * Cambia el tamaño del arreglo al próximo primo y redistribuye las claves uniformemente.
	 */
	private void rehash() {
		Iterable<Entry<K, V>> entradas = entries();
		N = proximo_primo(N * 2);
		A = (PositionList<Entrada<K, V>>[]) new ListaDE[N];
		n = 0;
		for (int i = 0; i < N; i++)
			A[i] = new ListaDE<Entrada<K, V>>();
		for (Entry<K, V> e : entradas)
			try {
				insert(e.getKey(), e.getValue());
			} catch (InvalidKeyException ex) {
				ex.getMessage();
			}

	}

	/**
	 * Calcula el número primo más cercano a n.
	 * @param n Numero para buscar el primo siguiente.
	 * @return El primo siguiente a n.
	 */
	private int proximo_primo(int n) {
		boolean es = false;
		n++;
		while (!es) {
			if (esPrimo(n))
				es = true;
			else
				n++;

		}
		return n;
	}

	/**
	 * Consulta si un número es primo.
	 * @param n Numero que se desea saber si es primo.
	 * @return Verdadero si n es primo, falso en caso contrario.
	 */
	private boolean esPrimo(int n) {
		boolean es = false;
		int divisor = 2;
		while (divisor < n && !es) {
			if (n % divisor == 0)
				es = true;
			else
				divisor++;

		}

		return es;
	}

	



}