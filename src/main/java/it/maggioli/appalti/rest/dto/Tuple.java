package it.maggioli.appalti.rest.dto;

/**
 * Classe che rappresenta una tupla (vedi linguaggio Scala)
 * @author gabriele.nencini
 *
 * @param <T> classe del primo parametro
 * @param <U> classe del secondo parametro
 */
public class Tuple<T,U> {
	private T first;
	private U second;
	
	/**
	 * 
	 * @param first
	 * @param second
	 */
	public Tuple(T first,U second){
		this.first = first;
		this.second = second;
	}
	
	/**
	 * Metodo che ricalca Scala per la restituzione del primo parametro
	 * @return
	 */
	public T _1(){
		return first;
	}
	/**
	 * Metodo che ricalca Scala per la restituzione del secondo parametro
	 * @return
	 */
	public U _2(){
		return second;
	}

}
