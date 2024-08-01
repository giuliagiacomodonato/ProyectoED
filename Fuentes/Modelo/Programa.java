
package Modelo;

import Auxiliares.*;
import Excepciones.*;



import TDALista.*;
import TDAColaCP.*;
import TDADiccionario.*;
import java.util.Iterator;


/**
 * Funcionalidades
 * @author BAUSER ANA PAZ Y GIACOMODONATO GIULIA 
 */

public class Programa {
	private String materia;
	private ListaDE<Pair<Integer,Integer>> lista; 

	/**
	 * Crea una nueva materia.
	 * @param m Nombre de la materia.
	 */
	public Programa(String m){
		materia = m;
		lista = new ListaDE<Pair<Integer,Integer>>();
	}
	
	/**
	 * Consulta el nombre de la materia. 
	 * @return Nombre de la materia.
	 */
	public String getMateria() {
		return materia;
	}
	
	/**
	 * Agrega un alumno y su nota al registro.
	 * @param lu Numero de lu del almuno a agregar.
	 * @param nota Nota del alumno en la materia.
	 * @return Verdadero si lo pudo agregar, falso si el alumno ya existía y no lo agregó.
	 */
	public boolean agregarAlumno(Integer lu, Integer nota) {
		Pair<Integer,Integer> par = new Pair<Integer,Integer>(lu,nota);
		boolean esta = false;
		try {
			if(!lista.isEmpty()) {
				esta = estaAlumno(par.getK());
			}
		}
		catch (EmptyListException e) {	
		}
		if(!esta) {
			lista.addLast(par);
		}
		return !(esta);
	}
	
	/**
	 * Consulta si el alumno está en el registro.
	 * @param lu Número de lu del alumno a consultar.
	 * @return Verdadero si está, falso en caso contrario.
	 * @throws EmptyListException si la lista estaba vacía al momento de buscar un alumno.
	 */
	private boolean estaAlumno(Integer lu) throws EmptyListException {
		Iterator<Pair<Integer, Integer>> it = lista.iterator();
		boolean encontre = false;
			while(it.hasNext() && !encontre) {
				if(it.next().getK().equals(lu)) {
					encontre = true;
				}
			}
		return encontre;
	}
	
	/**
	 * Consulta la nota de un alumno.
	 * @param lu Numero de lu del almuno a consultar.
	 * @return Nota del alumno si existe, null en caso contrario.
	 */
	public Integer verNotaAlumno(Integer lu) {
		Iterator<Pair<Integer, Integer>> it = lista.iterator();
		boolean encontre = false;
		Integer nota = null;
				while(it.hasNext() && !encontre) {
						Pair<Integer, Integer> elemento =  it.next();
						if(elemento.getK().equals(lu)) {
							encontre = true;
							nota = elemento.getV();
							encontre = true;
						}
					}
		return nota;
	}
	
	/**
	 * Elimina un alumno y su nota del registro.
	 * @param lu Numero de lu del almuno a eliminar.
	 * @return Verdadero si lo pudo eliminar, falso si el alumno no existía.
	 */
	
	public boolean eliminarAlumno(Integer lu) {
		Iterator<Position<Pair<Integer,Integer>>> it = lista.positions().iterator();
		boolean encontre = false;
		try {
			while(it.hasNext() && !encontre) {
				Position<Pair<Integer, Integer>> pos = it.next();
				if((pos.element()).getK().equals(lu)) {
					lista.remove(pos);
					encontre = true;
				}
			}
		}
		catch(InvalidPositionException e) {
		}
		return encontre;
	}
	
	/**
	 * Consulta todos los alumnos y sus notas en el registro.
	 * @return Lista iterable de pares de lu de alumnos y notas.
	 */
	public Iterable<Pair<Integer,Integer>> alumnosYNotas(){
		return lista;
	}
	
	/**
	 * Consulta el promedio de notas entre todos los alumnos en el registro. 
	 * @return Promedio de notas entre todos los alumnos en el registro
	 */
	
	public float promedioNotas() {
		float promedio = 0;
			for(Pair<Integer,Integer> elemento : lista) {
				promedio += elemento.getV();
			}
			promedio = promedio / lista.size();
		return promedio;
	}
	
	/**
	 * Consulta la nota mínima entre los alumnos del registro.
	 * @return Nota mínima entre los alumnos del registro, null si no hay alumnos.
	 */
	public Integer notaMinima() {
		Integer nota = null;
		PriorityQueue<Integer,Integer> cola = new HeapPQueue<Integer,Integer>(new MinComparator<Integer>());
		if(!lista.isEmpty()) {
			try {
				for(Pair<Integer,Integer> elemento : lista) {
						cola.insert(elemento.getV(), elemento.getK());
				}
				nota = cola.min().getKey();
			} catch (EmptyPriorityQueueException | InvalidKeyException e) { 			
			} 
		}
		return nota;
	}
	
	/**
	 * Devuelve las notas ordenadas de mayor a menor.
	 * @return Lista iterable con pares de alumnos y notas.
	 */
	public  Iterable<Pair<Integer,Integer>>  notasMayorAMenor(){
		PositionList<Pair<Integer,Integer>> l = new ListaDE<Pair<Integer, Integer>>();
		PriorityQueue<Integer,Integer> cola = new HeapPQueue<Integer,Integer>(new MaxComparator<Integer>());
		if(!lista.isEmpty()) {
			try {
				for(Pair<Integer,Integer> elemento : lista) {
					cola.insert(elemento.getV(), elemento.getK());
					
				}
				while(!cola.isEmpty()) {
					Entry<Integer,Integer> elemento = cola.removeMin();
					l.addLast(new Pair<Integer,Integer>(elemento.getValue(), elemento.getKey()));
				}
			} catch (EmptyPriorityQueueException  | InvalidKeyException e) { 			
			} 
		}
		return l;
	}
	
	/**
	 * Consulta todos los alumnos que tienen una misma nota en el registro.
	 * @param nota Nota que se desea buscar.
	 * @return Lista iterable de alumnos que tienen esa nota.
	 */
	public  PositionList<Integer> alumnosConMismaNota(Integer nota) {
		Dictionary<Integer, Integer> diccionario = new DiccionarioHashAbierto<Integer, Integer>();
		PositionList<Integer> listaAlumnos = new ListaDE<Integer>();
		try {
			for(Pair<Integer,Integer> elemento : lista) {
				diccionario.insert(elemento.getV(), elemento.getK());
			}
			for(Entry<Integer,Integer> entrada : diccionario.findAll(nota)) {
				listaAlumnos.addLast(entrada.getValue());
			}		
		}
		catch(InvalidKeyException e) {
			
		}
		return listaAlumnos;
		
	}

	/**
	 * Consulta los aprobados  del registro.
	 * @return Lista iterable con los alumnos aprobados. 
	 */
	public Iterable<Integer> aprobados() {
		PositionList<Integer> lAprobados = new ListaDE<Integer>();
			for(Pair<Integer,Integer> elemento : lista) {
				if(elemento.getV() >= 6) {
					lAprobados.addLast(elemento.getK());
				}
			}
		return lAprobados;
		
	}
	
	/**
	 * Consulta los desaprobados  del registro.
	 * @return Lista iterable con los alumnos desaprobados. 
	 */
	public Iterable<Integer> desaprobados() {
		PositionList<Integer> lDesaprobados = new ListaDE<Integer>();
			for(Pair<Integer,Integer> elemento : lista) {
				if(elemento.getV() < 6) {
					lDesaprobados.addLast(elemento.getK());
				}
			}
		return lDesaprobados;
		
	}
	
}

