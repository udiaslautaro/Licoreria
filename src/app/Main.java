package app;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import model.Cerveza;
import model.Cliente;
import model.Factura;
import model.HistorialPedidos;
import model.InventarioBebidas;
import model.Licor;
import model.ListaClientes;
import model.Pedido;
import model.Pila;
import model.Vino;

public class Main {

	public static Scanner scan = new Scanner(System.in);
	public static File archClientes=new File("Clientes.dat");
	public static File archStock=new File ("Stock.txt");
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		HistorialPedidos listaPedidos = new HistorialPedidos();
		InventarioBebidas listaBebidas = new InventarioBebidas();
		ListaClientes listaClientes = new ListaClientes();
		//cargarListas(listaClientes, listaBebidas);
		menu(listaBebidas, listaPedidos, listaClientes);
		scan.close();
	}

	
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
				adminLogin(listaBebidas, listaPedidos);
				break;
			case 2:
				System.out.println("1 - Registrarse como cliente");
				System.out.println("2 - Iniciar sesión");
				int operacion = scan.nextInt();
				switch (operacion) {
				case 1:
					crearCliente(listaClientes);
					break;
				case 2:
					iniciarSesion(listaClientes, listaBebidas, listaPedidos);
					break;
				}
			case 3 :
				try {
					salvandoDatos(listaClientes, listaBebidas);
				} catch (IOException e) {
					e.printStackTrace();
				}
				scan.next();
				break;
			}

		}else {
			System.out.println("Opcion invalida!");
			scan.next();
			menu(listaBebidas, listaPedidos, listaClientes);
		}
	}
	private static void adminLogin(InventarioBebidas listaBebidas,HistorialPedidos listaPedidos) {
		scan.nextLine();	
		System.out.println("Ingrese Contraseña de administrador: ");
		int contraseña;
		contraseña=scan.nextInt();
		if (contraseña == 1234){
			menuAdmin(listaBebidas, listaPedidos);
		}else System.out.println("Contraseña incorrecta");
	}

	private static void salvandoDatos(ListaClientes listaClientes, InventarioBebidas listaBebidas) throws IOException {
		FileOutputStream fOutput= new FileOutputStream(archClientes);
		FileOutputStream fOutputStock= new FileOutputStream(archStock);
		ObjectOutputStream objOutput = new ObjectOutputStream(fOutput);
		ObjectOutputStream objOutputStock= new ObjectOutputStream(fOutputStock);
		for(int i=0; i< listaClientes.totalClientes(); i++) {
			objOutput.writeObject(listaClientes.devolverCliente(i));
		}
		try {
			objOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
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
	private static void cargarListas(ListaClientes listaClientes, InventarioBebidas listaBebidas) throws ClassNotFoundException, IOException {
		FileInputStream fInput = new FileInputStream(archClientes);
		try (ObjectInputStream objInput = new ObjectInputStream(fInput)) {
			do {
				listaClientes.agregarCliente((Cliente)objInput.readObject());
			}while (objInput.read()!= -1);
		}
		
		
		}
	

	private static void menuAdmin(InventarioBebidas listaBebidas, HistorialPedidos listaPedidos) {
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
				menuIngreso(listaBebidas, listaPedidos);
				break;
			case 2:
				menuStock(listaBebidas, listaPedidos);
				break;
			case 3:
				menuPrecio(listaBebidas, listaPedidos);
				break;
			case 4:
				mostrarInventario(listaBebidas);
				break;
			case 5:
				eliminarBebida(listaBebidas, listaPedidos);
				break;
			case 6:
				menu(listaBebidas, listaPedidos, null);
				break;
			default:
				System.out.println("Opción inválida. Intente nuevamente.");
				menu(listaBebidas, listaPedidos, null);

			}		
		}
	}
	private static void eliminarBebida(InventarioBebidas listaBebidas, HistorialPedidos listaPedidos) {
		String confirm;
		int codigo;
		System.out.println("Ingrese el codigo de la bebida a eliminar");
		codigo =scan.nextInt();
		if (listaBebidas.codigoExiste(codigo)) {
			System.out.println("Esta a punto de eliminar "+ listaBebidas.buscarPorCodigo(codigo) + "Para confirmar ingrese Si");
			confirm=scan.nextLine();
			if (confirm== "Si") {
				listaBebidas.eliminarBebidaPorCodigo(codigo);
				System.out.println("Bebida eliminada, desea eliminar otra bebida? Si o cualquier tecla para salir");
				confirm=scan.nextLine();
				if(confirm == "Si") {
					eliminarBebida(listaBebidas, listaPedidos);
				}else {
					menuAdmin(listaBebidas, listaPedidos);
				}

			}
		}else {
			System.out.println("Codigo ingresado invalido desea volver a intentarlo? Si o cualquier tecla para salir");
			scan.next();
			confirm=scan.nextLine();
			if (confirm == "Si") {
				eliminarBebida(listaBebidas, listaPedidos);
			}else {
				menuAdmin(listaBebidas, listaPedidos);
			}
		}
	}

	private static void mostrarInventario(InventarioBebidas listaBebidas) {
		listaBebidas.mostrarTodoInventario();

	}
	private static void menuPrecio(InventarioBebidas listaBebidas, HistorialPedidos listaPedidos) {
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
				menuPrecio(listaBebidas, listaPedidos);
			}else {
				menuAdmin(listaBebidas, listaPedidos);
			}

		}
	}
	private static void menuCliente(Cliente cliente, InventarioBebidas listaBebidas, HistorialPedidos listaPedidos) {

		System.out.println("Ingrese que operación desea realizar:");
		System.out.println("1 - Realizar pedido.");
		System.out.println("2 - Consultar pedidos anteriores.");
		System.out.println("3 - Mostrar ultimo pedido.");
		System.out.println("4 - Cerrar Sesión.");
		int opcion;
		opcion = scan.nextInt();
		switch (opcion) {
		case 1:
			Pedido pedido = new Pedido(cliente);
			nuevoPedido(pedido, listaBebidas, listaPedidos, cliente);
			break;
		case 2:
			mostrarPedidosCliente(cliente);
			break;
		case 3: verUltimaFactura(cliente);
		break;
		case 4: 
			menu(listaBebidas, listaPedidos, null);
		default:
			System.out.println("Opción inválida. Intente nuevamente.");
			menuCliente(cliente, listaBebidas, listaPedidos);
		}
	}

	private static void menuIngreso(InventarioBebidas listaBebidas, HistorialPedidos listaPedidos) {
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
			int año = scan.nextInt();
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
					 codigo,precio , tipo, bodega, año);*/
			//agrega un nuevo vino al inventario
			listaBebidas.agregarBebida(new Vino(graduacion, marca, capacidad, nombre, stock, origen,
					codigo,precio , tipo, bodega, año));
			System.out.println("Desea agregar otra bebida? S/N");
			op=scan.next().charAt(op);
			switch (op) {
			case 's': menuIngreso(listaBebidas, listaPedidos);
			break;
			case 'n':		
				menuAdmin(listaBebidas, listaPedidos);
				break;
			default: 
				System.out.println("Opcion Incorrecta volviendo al menu principal");
				menuAdmin(listaBebidas, listaPedidos);
				break;
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
				case 's': menuIngreso(listaBebidas, listaPedidos);
				break;
				case 'n':		
					menuAdmin(listaBebidas, listaPedidos);
					break;
				default: 
					System.out.println("Opcion Incorrecta volviendo al menu principal");
					menuAdmin(listaBebidas, listaPedidos);
					break;
				}
			case 3:
				System.out.println("Ingrese marca:");
				String marcaLicor= scan.next();
				System.out.println("Ingrese nombre:");
				String nombreLicor= scan.next();
				System.out.println("Ingrse tipo de licor: ");
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
				case 's': menuIngreso(listaBebidas, listaPedidos);
				break;
				case 'n':		
					menuAdmin(listaBebidas, listaPedidos);
					break;
				default: 
					System.out.println("Opcion Incorrecta volviendo al menu principal");
					menuAdmin(listaBebidas, listaPedidos);
					break;
				}
			}
		}	

	}
	private static void menuStock(InventarioBebidas listaBebidas, HistorialPedidos listaPedidos) {
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
			menuAdmin(listaBebidas, listaPedidos);
		}else menuStock(listaBebidas, listaPedidos);
		}
	}

	private static void mostrarPedidosCliente(Cliente cliente) {
		System.out.println("Listado de sus pedidos anteriores: \n");
		Pila<Factura> aux =new Pila<Factura>();
		while (!cliente.factura.pilaVacia()) {
			aux.apilar(cliente.factura.verUltima());
			cliente.factura.toString();
			cliente.factura.desapilar();
		}
		while(!aux.pilaVacia()) {
			cliente.factura.apilar(aux.verUltima());
			aux.desapilar();
		}
		//String codigo = cliente.getCodigo();
		//listaPedidos.mostrarPedidosCliente(codigo);
	}
	private static void verUltimaFactura(Cliente cliente) {
		System.out.println("\nSu ultima factura es: \n" + cliente.factura.verUltima().toString());
	}

	private static void imprimirFactura(float montoPedido, Pedido pedido, Cliente cliente) {
		Date fecha = new Date();
		System.out.println("¿Cómo desea abonar su pedido? \n1-Tarjeta \2-Efectivo");
		int medioDePago = scan.nextInt();
		Factura factura = new Factura(montoPedido,fecha, medioDePago, pedido);
		factura.toString();
		cliente.factura.apilar(factura);
	}

	private static void crearCliente(ListaClientes listaClientes) {
		Cliente cliente = new Cliente();
		System.out.println("Ingrese su nombre:");
		cliente.setNombre(scan.next());
		System.out.println("Ingrese su apellido:");
		cliente.setApellido(scan.next());
		System.out.println("Ingrese su número de DNI:");
		cliente.setDni(scan.next());
		System.out.println("Ingrese su fecha de nacimiento:");
		cliente.setNacimiento(scan.next());
		System.out.println("Ingrese una contraseña:");
		cliente.setContraseña(scan.next());
		listaClientes.agregarCliente(cliente);
		System.out.println("Su nombre de usuario será: " +cliente.getNombreUsuario());
	}

	private static void iniciarSesion(ListaClientes listaClientes, InventarioBebidas listaBebidas, HistorialPedidos listaPedidos) {
		System.out.println("Ingrese su nombre de usuario");
		String nombreUsuario = scan.next(); 
		System.out.println("Ingrese contraseña");
		String password = scan.next();
		if (listaClientes.estaCliente(nombreUsuario, password)){
			int i = listaClientes.devolverPosicion(nombreUsuario);
			menuCliente(listaClientes.devolverCliente(i), listaBebidas, listaPedidos);
		}
		else {
			System.out.println("Nombre de usuario o contraseña no válidos, intente nuevamente");
			iniciarSesion(listaClientes, listaBebidas, listaPedidos);
		}
	}
	private static void nuevoPedido(Pedido pedido, InventarioBebidas listaBebidas, HistorialPedidos listaPedidos, Cliente cliente) {
		char continuar = 'S';
		float montoPedido = 0;
		while (continuar == 'S') {
			listaBebidas.mostrarInfoBebidas();
			System.out.println("Ingrese el código de la bebida que desea agregar al pedido: ");
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
			scan.next().charAt(continuar);
		}
		System.out.println("El monto total del pedido es: $"+montoPedido);
		listaPedidos.agregarPedido(pedido);
		System.out.println("¿Cómo desea continuar? \n");
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
				jsonObject.put("Contraseña", listaClientes.devolverCliente(i).getContraseña());

				jsonArray.put(jsonObject);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return jsonArray;	
	}*/
	private static JSONArray inventarioToJSON (InventarioBebidas listaBebidas) {
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
					jsonObject.put("Año", ((Vino) listaBebidas.devolverPorPosicion(i)).getAño());
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
	}
}
