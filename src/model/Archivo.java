package model;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.json.JSONArray;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Archivo {

	private File arch;
	private FileInputStream fInput;
	private FileOutputStream fOutput;
	private DataInputStream dInput;
	private DataOutputStream dOutput;
	private ObjectInputStream objInput;
	private ObjectOutputStream objOutput;

	/**public Archivo(File arch, FileInputStream fInput, FileOutputStream fOutput, DataInputStream dInput,
			DataOutputStream dOutput, ObjectInputStream objInput, ObjectOutputStream objOutput) {
		super();
		this.arch = arch;
		this.fInput = fInput;
		this.fOutput = fOutput;
		this.dInput = dInput;
		this.dOutput = dOutput;
		this.objInput = objInput;
		this.objOutput = objOutput;
	}*/
	public void crearFichero(String nombre) {
		File arch= new File(nombre);
	}	
	public Archivo(String ruta) {
		this.arch = new File(ruta);
		try {
			this.fInput =new FileInputStream(arch);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.fOutput= new FileOutputStream(arch);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.dInput= new DataInputStream(fInput);
		this.dOutput= new DataOutputStream(fOutput);
		try {
			this.objInput= new ObjectInputStream(objInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.objOutput=new ObjectOutputStream(objOutput);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	public void grabarEnArchivo(Cliente cliente) {
		try {
			objOutput.writeObject(cliente);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void grabarJSONEnArchivo(JSONArray stock) {
		try {
			objOutput.writeObject(stock);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void cerrarStream(Archivo archivo) throws IOException {
		archivo.objOutput.close();
	}

	public Object cargarListaArchivo(Archivo archivo) throws ClassNotFoundException {
	try {	
		return objInput.readObject();
	}catch (IOException e) {
		e.printStackTrace();
	}
	return null;
	}
}