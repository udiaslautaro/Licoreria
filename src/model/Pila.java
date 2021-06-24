package model;

import java.util.Stack;

public class Pila<T> {
	Stack<T> pila;



	/**
	 * apila un dato T
	 * @param dato dato generico T
	 */
	public void apilar(T dato) {
		pila.push(dato);
	}
	/**
	 * desapila 
	 */
	public void desapilar() {
		if (!pila.empty()) {
			pila.pop();
		}	
	}
	/**
	 * 
	 * @return ultimo elemento de la pila
	 */
	public T verUltima() {
		if (!pila.empty()) {
			return pila.peek();
		}
		return null;
		}
	/**
	 * busca elemento en la pila
	 * @param dato
	 */
	public void buscar(T dato) {
		if (!pila.empty()) {
			pila.search(dato);
		}
	}
	/**
	 * 
	 * @return true si la pila está vacía
	 */
	public boolean pilaVacia() {
		return pila.empty();
	}
}

