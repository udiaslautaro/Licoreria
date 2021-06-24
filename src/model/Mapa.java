package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Mapa<T, E> {
	
	HashMap<T,E> mapaUsuarios;


	public Mapa() 
	{
		this.mapaUsuarios= new HashMap<T, E>();
	}
	
	public void ingresarDato(T key, E value)
	{
		mapaUsuarios.put(key, value);
	}
	public E retornarDato() 
	{
		return mapaUsuarios.get(mapaUsuarios);
	}
	public int sizeMapa() 
	{
		return mapaUsuarios.size();
	}
/*	public boolean buscarDato(T dato) 
	{
		boolean bool=false;
		Iterator<T> it = (Iterator<T>) mapaUsuarios.keySet().iterator();
		while (it.hasNext())
		{
			if mapaUsuarios.get(mapaUsuarios)
		}
		return bool;
	}*/
}

	