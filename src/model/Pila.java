package model;

import java.util.Stack;

public class Pila<T> {
	Stack<T> pila;




	public void apilar(T dato) {
		pila.push(dato);
	}
	public void desapilar() {
		if (!pila.empty()) {
			pila.pop();
		}	
	}
	public T verUltima() {
		if (!pila.empty()) {
			return pila.peek();
		}
		return null;
		}
	public void buscar(T dato) {
		if (!pila.empty()) {
			pila.search(dato);
		}
	}
	
	public boolean pilaVacia() {
		return pila.empty();
	}
}

