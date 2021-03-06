package app;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import model.Bebida;
import model.Cerveza;
import model.Cliente;
import model.Factura;
import model.HistorialPedidos;
import model.InventarioBebidas;
import model.Licor;
import model.ListaClientes;
import model.Pedido;
import model.Vino;

public class Main {

	public static Scanner scan = new Scanner(System.in);
	public static File archPedidos=new File("Pedidos.dat");
	public static File archClientes=new File("Clientes.dat");
	public static File archStock=new File ("Stock.txt");
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		HistorialPedidos listaPedidos = new HistorialPedidos();
		InventarioBebidas listaBebidas = new InventarioBebidas();
		ListaClientes listaClientes = new ListaClientes();
		cargarListaClientes(listaClientes);
		cargarListaPedidos(listaPedidos);
		cargarListaBebidas(listaBebidas);
		menu(listaBebidas, listaPedidos, listaClientes);
		scan.close();
	}

	/**
	 * Menu: ingresar 1 para ingresar como administrador o 2 como cliente
	 * @param listaBebidas
	 * @param listaPedidos
	 * @param listaClientes
	 */
	public static void menu(InventarioBebidas listaBebidas, HistorialPedidos listaPedidos, ListaClientes listaClientes) {

		System.out.println("Bienvenido");
		System.out.println("1- Ingresar como Administrador");
		System.out.println("2- Ingresar como Cliente");
		System.out.println("3- Salir");
		int opcion;
		opcion = scan.nextInt();
		if (opcion == 1 || opcion == 2 || opcion == 3) {
			switch (opcion) {
			case 1: 
				adminLogin(listaBebidas, listaPedidos, listaClientes);
				break;
			case 2:
				System.out.println("1 - Registrarse como cliente");
				System.out.println("2 - Iniciar sesi?n");
				int operacion = scan.nextInt();
				switch (operacion) {
				case 1:
					crearCliente(listaClientes);
					menu(listaBebidas, listaPedidos,listaClientes);
					break;
				case 2:
					iniciarSesion(listaClientes, listaBebidas, listaPedidos);
					break;
				}
			case 3 :
				try {
					salvandoDatos(listaClientes, listaBebidas, listaPedidos);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Adios!");
				break;
			}

		}else {
			System.out.println("Opcion invalida!");
			scan.next();
			menu(listaBebidas, listaPedidos, listaClientes);
		}
	}
	/**
	 * verifica contrase?a del administrador
	 * @param listaBebidas
	 * @param listaPedidos
	 * @param listaClientes
	 */
	private static void adminLogin(InventarioBebidas listaBebidas,HistorialPedidos listaPedidos, ListaClientes listaClientes) {
		scan.nextLine();	
		System.out.println("Ingrese Contrase?a de administrador: ");
		int contrase?a;
		contrase?a=scan.nextInt();
		if (contrase?a == 1234){
			menuAdmin(listaBebidas, listaPedidos, listaClientes);
		}else System.out.println("Contrase?a incorrecta");
	}
	/**
	 * graba lista de clientes, de bebidas y pedidos en sus respectivos archivos
	 * @param listaClientes
	 * @param listaBebidas
	 * @param listaPedidos
	 * @throws IOException
	 */
	private static void salvandoDatos(ListaClientes listaClientes, InventarioBebidas listaBebidas, HistorialPedidos listaPedidos) throws IOException {
		try {
			FileOutputStream fOutputPedido= new FileOutputStream(archPedidos);
			FileOutputStream fOutput= new FileOutputStream(archClientes);
			FileOutputStream fOutputStock= new FileOutputStream(archStock);
			ObjectOutputStream objOutputPedido = new ObjectOutputStream(fOutputPedido);
			ObjectOutputStream objOutput = new ObjectOutputStream(fOutput);
			ObjectOutputStream objOutputStock= new ObjectOutputStream(fOutputStock);
			for(int i=0; i< listaClientes.totalClientes(); i++) {
				objOutput.writeObject(listaClientes.devolverCliente(i));
			}

			for (int i=0; i<listaBebidas.totalBebidas();i++) {
				objOutputStock.writeObject(listaBebidas.devolverPorPosicion(i));
			}

			for (int i=0; i<listaPedidos.tama?oListaPedidos(); i++) {
				objOutputPedido.writeObject(listaPedidos.devolverPorPosicion(i));
			}
			objOutput.close();
			objOutputPedido.close();
			objOutputStock.close();
		} catch (IOException e) 
		{
			System.out.println("Ha habido un problema guardando los archivos");
		}
	}
	/*try {

            FileWriter fileStock=new FileWriter(archStock);
            fileStock.write(inventarioToJSON(listaBebidas).toString());
            fileStock.flush();
            fileStock.close();

        } catch (IOException e) {
            e.getStackTrace();
        }
        try {
            JSONArray stock = new JSONArray(inventarioToJSON(listaBebidas));
            objOutputStock.writeObject(stock);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            objOutputStock.close();
        }catch(IOException e) {
            e.printStackTrace();
        }

    }
	/*private static void cargarListas(ListaClientes listaClientes, InventarioBebidas listaBebidas) throws ClassNotFoundException, IOException {
		FileInputStream fInput = new FileInputStream(archClientes);
		try (ObjectInputStream objInput = new ObjectInputStream(fInput)) {
			do {
				listaClientes.agregarCliente((Cliente)objInput.readObject());
			}while (objInput.read()!= -1);
		}
		}*/ 
	/**
	 * muestra lista clientes
	 * @param listaClientes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private static void cargarListaClientes(ListaClientes listaClientes) throws ClassNotFoundException, IOException {
		try {
			FileInputStream fInput = new FileInputStream(archClientes);
			ObjectInputStream objInput = new ObjectInputStream(fInput);
			/* if (objInput.read()!=-1) {
                do {
                	Cliente cliente =(Cliente) objInput.readObject();
                    listaClientes.agregarCliente(cliente);
                }while (objInput.read()!= -1);
            }*/
			Cliente cliente;
			while ((cliente = (Cliente)objInput.readObject())!= null) 
			{
				listaClientes.agregarCliente(cliente);
			}
			objInput.close();
		}
		catch (IOException e) {
			e.getStackTrace();
		}
	}
	/**
	 * muestra lista pedidos
	 * @param listaPedidos
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private static void cargarListaPedidos(HistorialPedidos listaPedidos) throws ClassNotFoundException, IOException {
		try {
			FileInputStream fInput = new FileInputStream(archPedidos);
			ObjectInputStream objInput = new ObjectInputStream(fInput);
			/* if (objInput.read()!=-1) {
	                do {
	                	Cliente cliente =(Cliente) objInput.readObject();
	                    listaClientes.agregarCliente(cliente);
	                }while (objInput.read()!= -1);
	            }*/
			Pedido pedido;
			while ((pedido = ( (Pedido)objInput.readObject())) != null) 
			{
				listaPedidos.agregarPedido(pedido);
			}
			objInput.close();
		}
		catch (IOException e) {
			e.getStackTrace();
		}

	}
	/**
	 * muestra lista de bebidas
	 * @param listaBebidas
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private static void cargarListaBebidas(InventarioBebidas listaBebidas) throws ClassNotFoundException, IOException {
		try {
			FileInputStream fInput = new FileInputStream(archStock);
			ObjectInputStream objInput = new ObjectInputStream(fInput);
			/* if (objInput.read()!=-1) {
	                do {
	                	Cliente cliente =(Cliente) objInput.readObject();
	                    listaClientes.agregarCliente(cliente);
	                }while (objInput.read()!= -1);
	            }*/
			Bebida bebida;
			while ((bebida = (Bebida)objInput.readObject())!= null) 
			{
				listaBebidas.agregarBebida(bebida);
			}
			objInput.close();
		}
		catch (IOException e) {
			e.getStackTrace();
		}

	}
	/**
	 * Opciones para realizar como administrador: 1-Ingresar bebida, 2-Agregar al stock, 3-modificar un precio
	 * 4-mostrar inventario bebidas, 5- eliminar bebida, 6-vovler al menu principal
	 * @param listaBebidas
	 * @param listaPedidos
	 * @param listaClientes
	 */
	private static void menuAdmin(InventarioBebidas listaBebidas, HistorialPedidos listaPedidos, ListaClientes listaClientes) {
		int opcion=0;

		while (opcion != 6) { 
			System.out.println("1- Ingresar nueva Bebida");
			System.out.println("2- Agregar Bebidas al Stock");
			System.out.println("3- Modificar precio de las Bebidas");
			System.out.println("4- Mostrar todo el inventario de Bebidas");
			System.out.println("5- Eliminar bebida del inventario");
			System.out.println("6- Salir al menu principal");
			opcion = scan.nextInt();
			switch (opcion) {
			case 1: 
				menuIngreso(listaBebidas, listaPedidos, listaClientes);
				break;
			case 2:
				menuStock(listaBebidas, listaPedidos, listaClientes);
				break;
			case 3:
				menuPrecio(listaBebidas, listaPedidos, listaClientes);
				break;
			case 4:
				mostrarInventario(listaBebidas);
				break;
			case 5:
				eliminarBebida(listaBebidas, listaPedidos, listaClientes);
				break;
			case 6:
				menu(listaBebidas, listaPedidos, listaClientes);
				break;
			default:
				System.out.println("Opci?n inv?lida. Intente nuevamente.");
				menu(listaBebidas, listaPedidos, listaClientes);

			}		
		}
	}
	/**
	 * elimina bebida del inventario
	 * @param listaBebidas
	 * @param listaPedidos
	 * @param listaClientes
	 */
	private static void eliminarBebida(InventarioBebidas listaBebidas, HistorialPedidos listaPedidos, ListaClientes listaClientes) {
		String confirm;
		int codigo;
		System.out.println("Ingrese el codigo de la bebida a eliminar");
		codigo =scan.nextInt();
		if (listaBebidas.codigoExiste(codigo)) {
			System.out.println("Esta a punto de eliminar "+ listaBebidas.buscarPorCodigo(codigo) + "Para confirmar ingrese Si");
			confirm=scan.next();
			if (confirm== "Si") {
				listaBebidas.eliminarBebidaPorCodigo(codigo);
				System.out.println("Bebida eliminada, desea eliminar otra bebida? Si o cualquier tecla para salir");
				confirm=scan.nextLine();
				if(confirm == "Si") {
					eliminarBebida(listaBebidas, listaPedidos, listaClientes);
				}else {
					menuAdmin(listaBebidas, listaPedidos, listaClientes);
				}

			}
		}else {
			System.out.println("Codigo ingresado invalido desea volver a intentarlo? Si o cualquier tecla para salir");
			scan.next();
			confirm=scan.nextLine();
			if (confirm == "Si") {
				eliminarBebida(listaBebidas, listaPedidos, listaClientes);
			}else {
				menuAdmin(listaBebidas, listaPedidos, listaClientes);
			}
		}
	}
	/**
	 * muestra inventario de bebidas
	 * @param listaBebidas
	 */
	private static void mostrarInventario(InventarioBebidas listaBebidas) {
		System.out.println(listaBebidas.mostrarTodoInventario());

	}
	/**
	 * modifica precio de la bebida
	 * @param listaBebidas
	 * @param listaPedidos
	 * @param listaClientes
	 */
	private static void menuPrecio(InventarioBebidas listaBebidas, HistorialPedidos listaPedidos, ListaClientes listaClientes) {
		String opcion;
		float precio;
		System.out.println("Ingrese el codigo de la bebida a la que desea modificarle el precio: ");
		int codigo = scan.nextInt();
		if(listaBebidas.codigoExiste(codigo)) {
			int i= listaBebidas.devolverPosicion(codigo);
			System.out.println("Ingrese nuevo precio");
			precio=scan.nextFloat();
			listaBebidas.modificarPrecio(precio, i);
		}else {
			System.out.println("El codigo ingresado es invalido, Si para volver a ingresar cualquier otra tecla para salir");
			scan.next();
			opcion= scan.nextLine();
			if (opcion== "Si") {
				menuPrecio(listaBebidas, listaPedidos, listaClientes);
			}else {
				menuAdmin(listaBebidas, listaPedidos, listaClientes);
			}

		}
	}
	/**
	 * Permite realizar acciones como cliente: 1- registrarse, 2-iniciar sesion, 3-salir
	 * @param cliente
	 * @param listaBebidas
	 * @param listaPedidos
	 * @param listaClientes
	 */
	private static void menuCliente(Cliente cliente, InventarioBebidas listaBebidas, HistorialPedidos listaPedidos, ListaClientes listaClientes) {

		System.out.println("Ingrese que operaci?n desea realizar:");
		System.out.println("1 - Realizar pedido.");
		System.out.println("2 - Consultar pedidos anteriores.");
		System.out.println("3 - Cerrar Sesi?n.");
		int opcion;
		opcion = scan.nextInt();
		switch (opcion) {
		case 1:
			Pedido pedido = new Pedido(cliente);
			nuevoPedido(pedido, listaBebidas, listaPedidos, cliente);
			menuCliente(cliente, listaBebidas, listaPedidos, listaClientes);
			break;
		case 2:
			mostrarPedidosCliente(cliente, listaPedidos);
			menuCliente(cliente, listaBebidas, listaPedidos, listaClientes);
			break;
		case 3: 
			menu(listaBebidas, listaPedidos,listaClientes);
		default:
			System.out.println("Opci?n inv?lida. Intente nuevamente.");
			menuCliente(cliente, listaBebidas, listaPedidos, listaClientes);
		}
	}
	/**
	 * ingresa bebidas al sistema
	 * @param listaBebidas
	 * @param listaPedidos
	 * @param listaClientes
	 */
	private static void menuIngreso(InventarioBebidas listaBebidas, HistorialPedidos listaPedidos, ListaClientes listaClientes) {
		int opcion;
		char op = 0;
		System.out.println("1- Vino");
		System.out.println("2- Cerveza");
		System.out.println("3- Licor");
		opcion = scan.nextInt();
		switch (opcion) {
		case 1: 
			System.out.println("Ingrese marca:");
			String marca= scan.next();
			System.out.println("Ingrese nombre: ");
			String nombre=scan.next();
			System.out.println("Ingrese origen:");
			String origen=scan.next();
			System.out.println("Ingrese bodega:");
			String bodega=scan.next();
			System.out.println("Ingrese la variedad de vino:");
			String tipo=scan.next();
			System.out.println("Ingrese cosecha:");
			int a?o = scan.nextInt();
			System.out.println("Ingrese graduacion alcoholica:");
			String graduacion=scan.next();
			System.out.println("Ingrese capacidad:");
			float capacidad= scan.nextFloat();
			System.out.println("Ingrese cantidad de stock inicial:");
			int stock= scan.nextInt();
			System.out.println("Ingrese el precio por unidad:");
			double precio=scan.nextDouble();
			int codigo=1;
			while (listaBebidas.codigoExiste(codigo)) {
				codigo++;
			}
			/*Vino vino1 = new Vino(graduacion, marca, capacidad, nombre, stock, origen,
					 codigo,precio , tipo, bodega, a?o);*/
			//agrega un nuevo vino al inventario
			listaBebidas.agregarBebida(new Vino(graduacion, marca, capacidad, nombre, stock, origen,
					codigo,precio , tipo, bodega, a?o));
			System.out.println("Desea agregar otra bebida? S/N");
			op=scan.next().charAt(op);
			switch (op) {
			case 'S': menuIngreso(listaBebidas, listaPedidos, listaClientes);
			break;
			case 'N':		
				menuAdmin(listaBebidas, listaPedidos, listaClientes);
				break;
			default: 
				System.out.println("Opcion Incorrecta volviendo al menu principal");
				menuAdmin(listaBebidas, listaPedidos, listaClientes);
				break;
			}
		case 2:
			System.out.println("Ingrese marca:");
			String marcaCerveza= scan.next();
			System.out.println("Ingrese nombre: ");
			String nombreCerveza=scan.next();
			System.out.println("Ingrese que variedad de cerveza es:");
			String variedad=scan.next();
			System.out.println("Ingrese origen:");
			String origenCerveza=scan.next();
			System.out.println("Ingrese graduacion alcoholica:");
			String graduacionCerveza=scan.next();
			System.out.println("Ingrese capacidad:");
			float capacidadCerveza= scan.nextFloat();
			System.out.println("Ingrese cantidad de stock inicial:");
			int stockCerveza= scan.nextInt();
			System.out.println("Ingrese el precio por unidad:");
			double precioCerveza=scan.nextDouble();
			int codigoCerveza=1;
			while (listaBebidas.codigoExiste(codigoCerveza)) {
				codigoCerveza++;
			}
			//Cerveza cerveza1 = new Cerveza(graduacionCerveza, marcaCerveza, capacidadCerveza, nombreCerveza, stockCerveza, origenCerveza, codigoCerveza, precioCerveza, variedad);
			//agrega al inventario un nuevo tipo de cerveza
			listaBebidas.agregarBebida(new Cerveza(graduacionCerveza, marcaCerveza, capacidadCerveza, nombreCerveza, stockCerveza, origenCerveza, codigoCerveza, precioCerveza, variedad));

			System.out.println("Desea agregar otra bebida? S/N");
			op=scan.next().charAt(op);
			switch (op) {
			case 'S': menuIngreso(listaBebidas, listaPedidos, listaClientes);
			break;
			case 'N':		
				menuAdmin(listaBebidas, listaPedidos, listaClientes);
				break;
			default: 
				System.out.println("Opcion Incorrecta volviendo al menu principal");
				menuAdmin(listaBebidas, listaPedidos, listaClientes);
				break;
			}
		case 3:
			System.out.println("Ingrese marca:");
			String marcaLicor= scan.next();
			System.out.println("Ingrese nombre:");
			String nombreLicor= scan.next();
			System.out.println("Ingrese tipo de licor: ");
			String tipoLicor= scan.next();
			System.out.println("Ingrese origen: ");
			String origenLicor= scan.next();
			System.out.println("Ingrese graduacion alcoholica: ");
			String graduacionLicor= scan.next();
			System.out.println("Ingrese capacidad: ");
			float capacidadLicor = scan.nextFloat();
			System.out.println("Ingrese cantidad de stock inicial: ");
			int stockLicor= scan.nextInt();
			System.out.println("Ingrese el precio por unidad: ");
			double precioLicor = scan.nextDouble();
			int codigoLicor=1;
			while (listaBebidas.codigoExiste(codigoLicor)) {
				codigoLicor++;
			}
			listaBebidas.agregarBebida(new Licor(graduacionLicor, marcaLicor, capacidadLicor,nombreLicor, stockLicor, origenLicor, codigoLicor, precioLicor, tipoLicor ));
			System.out.println("Desea agregar otra bebida? S/N");
			op=scan.next().charAt(op);
			switch (op) {
			case 'S': menuIngreso(listaBebidas, listaPedidos, listaClientes);
			break;
			case 'N':		
				menuAdmin(listaBebidas, listaPedidos, listaClientes);
				break;
			default: 
				System.out.println("Opcion Incorrecta volviendo al menu principal");
				menuAdmin(listaBebidas, listaPedidos, listaClientes);
				break;
			}
		}	

	}
	/**
	 * modifica stock de una bebida
	 * @param listaBebidas
	 * @param listaPedidos
	 * @param listaClientes
	 */
	private static void menuStock(InventarioBebidas listaBebidas, HistorialPedidos listaPedidos, ListaClientes listaClientes) {
		int opcion;
		System.out.println("Ingrese el codigo de la bebida:");
		int codigoBebida = scan.nextInt();
		if (listaBebidas.codigoExiste(codigoBebida)== true){
			System.out.println("Ingrese stock a agregar: ");
			int stockBebida = scan.nextInt();
			listaBebidas.modificarStock(codigoBebida, stockBebida);
		}else {System.out.println("El codigo ingresado no es valido");
		scan.next();
		System.out.println("Presione 1 para salir o cualquier otra tecla para reintentar");
		opcion =scan.nextInt();
		if (opcion == 1) {
			menuAdmin(listaBebidas, listaPedidos, listaClientes);
		}else menuStock(listaBebidas, listaPedidos, listaClientes);
		}
	}
	/**
	 * muestra todos los pedidos de un cliente
	 * @param cliente
	 * @param listaPedidos
	 */
	private static void mostrarPedidosCliente(Cliente cliente, HistorialPedidos listaPedidos) {
		System.out.println("Listado de sus pedidos anteriores: \n");
		String codigo = cliente.getCodigo();
		System.out.println(listaPedidos.mostrarPedidosCliente(codigo));
	}

	/**
	 * imprime factura de un pedido
	 * @param montoPedido
	 * @param pedido
	 * @param cliente
	 */
	private static void imprimirFactura(float montoPedido, Pedido pedido, Cliente cliente) {
		Date fecha = new Date();
		System.out.println("?C?mo desea abonar su pedido? \n1-Tarjeta \2-Efectivo");
		int medioDePago = scan.nextInt();
		Factura factura = new Factura(montoPedido,fecha, medioDePago,pedido);
		System.out.println(factura.toString());	
	}
	/**
	 * da de alta un cliente, recibe sus datos y le crea un nombre de usuario
	 * @param listaClientes
	 */
	private static void crearCliente(ListaClientes listaClientes) {
		Cliente cliente = new Cliente();
		System.out.println("Ingrese su nombre:");
		cliente.setNombre(scan.next());
		System.out.println("Ingrese su apellido:");
		cliente.setApellido(scan.next());
		System.out.println("Ingrese su n?mero de DNI:");
		cliente.setDni(scan.next());
		System.out.println("Ingrese su fecha de nacimiento:");
		cliente.setNacimiento(scan.next());
		System.out.println("Ingrese una contrase?a:");
		cliente.setContrase?a(scan.next());
		listaClientes.agregarCliente(cliente);
		System.out.println("Su nombre de usuario ser?: " +cliente.getNombreUsuario());
	}
	/**
	 * valida el inicio de sesion
	 * @param listaClientes
	 * @param listaBebidas
	 * @param listaPedidos
	 */
	private static void iniciarSesion(ListaClientes listaClientes, InventarioBebidas listaBebidas, HistorialPedidos listaPedidos) {
		System.out.println("Ingrese su nombre de usuario");
		String nombreUsuario = scan.next(); 
		System.out.println("Ingrese contrase?a");
		String password = scan.next();
		if (listaClientes.estaCliente(nombreUsuario, password)){
			int i = listaClientes.devolverPosicion(nombreUsuario);
			menuCliente(listaClientes.devolverCliente(i), listaBebidas, listaPedidos, listaClientes);
		}
		else {
			System.out.println("Nombre de usuario o contrase?a no v?lidos, intente nuevamente");
			iniciarSesion(listaClientes, listaBebidas, listaPedidos);
		}
	}
	/**
	 * permite al cliente realizar nuevo pedido
	 * @param pedido
	 * @param listaBebidas
	 * @param listaPedidos
	 * @param cliente
	 */
	private static void nuevoPedido(Pedido pedido, InventarioBebidas listaBebidas, HistorialPedidos listaPedidos, Cliente cliente) {
		char continuar = 'S';
		float montoPedido = 0;
		while (continuar == 'S') {
			System.out.println(listaBebidas.mostrarInfoBebidas());
			System.out.println("Ingrese el c?digo de la bebida que desea agregar al pedido: ");
			int codigo = scan.nextInt();
			//Busca la bebida en el inventario y si tiene el stock que se busca,la agrega
			if (listaBebidas.codigoExiste(codigo)) {
				System.out.println("Ingrese cantidad de unidades: ");
				int cantidad = scan.nextInt();
				int i = listaBebidas.devolverPosicion(codigo);
				if( listaBebidas.devolverPorPosicion(i).getStock() > cantidad) {
					listaBebidas.devolverPorPosicion(i).setCantidad(cantidad);
					pedido.agregarAlPedido(listaBebidas.devolverPorPosicion(i), cantidad);
					montoPedido += listaBebidas.devolverPorPosicion(i).precioPorCantidad(cantidad);
				}
				else {
					System.out.println("Lo sentimos, no tenemos stock suficiente de ese producto.");
				}
			}
			System.out.println("Desea agregar otra bebida al pedido? S/N");
			continuar = scan.next().charAt(0);
		}
		System.out.println("El monto total del pedido es: $"+montoPedido);
		listaPedidos.agregarPedido(pedido);
		System.out.println("?C?mo desea continuar? \n");
		System.out.println("1 - Imprimir Factura.");
		System.out.println("2 - Cancelar Pedido");
		int opcionSeguir = scan.nextInt();
		switch (opcionSeguir) {
		case 1:
			imprimirFactura(montoPedido, pedido, cliente);
			break;
		case 2:
			listaPedidos.eliminarPedido(pedido);
			break;
		}
	}

	/*private static JSONArray ClientesToJSON(ListaClientes listaClientes) {
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < listaClientes.totalClientes(); i++) {
			JSONObject jsonObject = new JSONObject();
			try {
				jsonObject.put("Codigo", listaClientes.devolverCliente(i).getCodigo());
				jsonObject.put("Nombre", listaClientes.devolverCliente(i).getNombre());
				jsonObject.put("Apellido", listaClientes.devolverCliente(i).getApellido());
				jsonObject.put("DNI", listaClientes.devolverCliente(i).getDni());
				jsonObject.put("Nacimiento", listaClientes.devolverCliente(i).getNacimiento());
				jsonObject.put("Nombre de Usuario", listaClientes.devolverCliente(i).getNombreUsuario());
				jsonObject.put("Contrase?a", listaClientes.devolverCliente(i).getContrase?a());

				jsonArray.put(jsonObject);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return jsonArray;	
	}*/
	/*private static JSONArray inventarioToJSON (InventarioBebidas listaBebidas) {
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < listaBebidas.totalBebidas(); i++) {
			JSONObject jsonObject = new JSONObject();
			try {
				jsonObject.put("Codigo", listaBebidas.devolverPorPosicion(i).getCodigo());
				jsonObject.put("Nombre", listaBebidas.devolverPorPosicion(i).getNombre());
				jsonObject.put("Marca", listaBebidas.devolverPorPosicion(i).getMarca());
				jsonObject.put("Capacidad", listaBebidas.devolverPorPosicion(i).getCapacidad());
				jsonObject.put("Graduacion", listaBebidas.devolverPorPosicion(i).getGraduacion());
				jsonObject.put("Stock", listaBebidas.devolverPorPosicion(i).getStock());
				jsonObject.put("Origen", listaBebidas.devolverPorPosicion(i).getOrigen());
				jsonObject.put("Precio", listaBebidas.devolverPorPosicion(i).getPrecio());

				if(listaBebidas.devolverPorPosicion(i) instanceof Vino) {
					jsonObject.put("A?o", ((Vino) listaBebidas.devolverPorPosicion(i)).getA?o());
					jsonObject.put("Bodega", ((Vino) listaBebidas.devolverPorPosicion(i)).getBodega());
					jsonObject.put("Tipo", ((Vino) listaBebidas.devolverPorPosicion(i)).getTipo());
				}
				else {
					if(listaBebidas.devolverPorPosicion(i) instanceof Cerveza) {
						jsonObject.put("Variedad", ((Cerveza) listaBebidas.devolverPorPosicion(i)).getVariedad());
					}
					else {
						jsonObject.put("Tipo", ((Licor) listaBebidas.devolverPorPosicion(i)).getTipo());
					}
				}
				jsonArray.put(jsonObject);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return jsonArray;
	}*/

}
