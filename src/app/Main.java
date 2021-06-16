package app;
import java.util.Scanner;
import model.Cerveza;
import model.Cliente;
import model.HistorialPedidos;
import model.InventarioBebidas;
import model.Licor;
import model.ListaClientes;
import model.Pedido;
import model.Vino;

public class Main {

	public static Scanner scan = new Scanner(System.in);


	public static void main(String[] args) {
		HistorialPedidos listaPedidos = new HistorialPedidos();
		InventarioBebidas listaBebidas = new InventarioBebidas();
		menu(listaBebidas);
		scan.close();
	}


	public static void menu(InventarioBebidas listaBebidas) {

		System.out.println("Bienvenido");
		System.out.println("1- Ingresar como Administrador");
		System.out.println("2- Ingresar como Cliente");
		System.out.println("3- Salir");
		int opcion;
		opcion = scan.nextInt();
		if (opcion == 1 || opcion == 2 || opcion == 3) {
			switch (opcion) {
			case 1: 
				scan.nextLine();	
				System.out.println("Ingrese Contraseña de administrador: ");
				int contraseña;
				contraseña=scan.nextInt();
				if (contraseña == 1234){
					menuAdmin(listaBebidas);
				}else System.out.println("Contraseña incorrecta");
				break;
			case 2:
				ListaClientes listaClientes = new ListaClientes();
				System.out.println("1 - Registrarse como cliente");
				System.out.println("2 - Iniciar sesión");
				int operacion = scan.nextInt();
				switch (operacion) {
				case 1:
					Cliente cliente = new Cliente();
					System.out.println("Ingrese su nombre:");
					cliente.setNombre(scan.nextLine());
					System.out.println("Ingrese su apellido:");
					cliente.setApellido(scan.nextLine());
					System.out.println("Ingrese su número de DNI:");
					cliente.setDni(scan.nextLine());
					System.out.println("Ingrese su fecha de nacimiento:");
					cliente.setNacimiento(scan.nextLine());
					System.out.println("Ingrese una contraseña:");
					cliente.setContraseña(scan.nextLine());
					listaClientes.agregarCliente(cliente);
					System.out.println("Su nombre de usuario será: "+cliente.getNombreUsuario());
					break;
				case 2:
					System.out.println("Ingrese su nombre de usuario");
					String nombreUsuario = scan.next(); 
					System.out.println("Ingrese contraseña");
					String password = scan.nextLine();
					menuCliente();
					break;
				case 3 :
					System.out.println("Adios!");
					scan.next();
					
					break;
				}

			}
		}else {
			System.out.println("Opcion invalida!");
			scan.next();
			menu(listaBebidas);
		}
	}


	private static void menuAdmin(InventarioBebidas listaBebidas) {
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
				menuIngreso(listaBebidas);
				break;
			case 2:
				menuStock(listaBebidas);
				break;
			case 3:
				menuPrecio(listaBebidas);
				break;
			case 4:
				mostrarInventario(listaBebidas);
				break;
			case 5:
				eliminarBebida(listaBebidas);
				break;
			case 6:
				menu(listaBebidas);
				break;

			}		
		}
	}
	private static void eliminarBebida(InventarioBebidas listaBebidas) {
		String confirm, codigo;
		System.out.println("Ingrese el codigo de la bebida a eliminar");
		codigo =scan.nextLine();
		if (listaBebidas.codigoExiste(codigo)) {
			System.out.println("Esta a punto de eliminar "+ listaBebidas.buscarPorCodigo(codigo) + "Para confirmar ingrese Si");
			confirm=scan.nextLine();
			if (confirm== "Si") {
				listaBebidas.eliminarBebidaPorCodigo(codigo);
				System.out.println("Bebida eliminada, desea eliminar otra bebida? Si o cualquier tecla para salir");
				confirm=scan.nextLine();
				if(confirm == "Si") {
					eliminarBebida(listaBebidas);
				}else {
					menuAdmin(listaBebidas);
				}

			}
		}else {
			System.out.println("Codigo ingresado invalido desea volver a intentarlo? Si o cualquier tecla para salir");
			scan.next();
			confirm=scan.nextLine();
			if (confirm == "Si") {
				eliminarBebida(listaBebidas);
			}else {
				menuAdmin(listaBebidas);
			}
		}
	}

	private static void mostrarInventario(InventarioBebidas listaBebidas) {
		listaBebidas.mostrarTodoInventario();

	}
	private static void menuPrecio(InventarioBebidas listaBebidas) {
		String codigo, opcion;
		float precio;
		System.out.println("Ingrese el codigo de la bebida a la que desea modificarle el precio: ");
		codigo = scan.nextLine();
		if(listaBebidas.codigoExiste(codigo)) {
			int i= listaBebidas.posicionPorCodigo(codigo);
			System.out.println("Ingrese nuevo precio");
			precio=scan.nextFloat();
			listaBebidas.modificarPrecio(precio, i);
		}else {
			System.out.println("El codigo ingresado es invalido, Si para volver a ingresar cualquier otra tecla para salir");
			scan.next();
			opcion= scan.nextLine();
			if (opcion== "Si") {
				menuPrecio(listaBebidas);
			}else {
				menuAdmin(listaBebidas);
			}
			
		}
	}
	private static void menuCliente() {

		System.out.println("Ingrese que operación desea realizar:");
		System.out.println("1 - Realizar pedido.");
		System.out.println("2 - Consultar pedidos anteriores.");
		System.out.println("3 - Imprimir factura.");
		int opcion;
		opcion = scan.nextInt();
		switch (opcion) {
		case 1:

			char continuar = 'S';
			while (continuar == 'S') {

				//agregar bebidas al pedido

				System.out.println("Desea agregar otra bebida al pedido? S/N");
				scan.next().charAt(continuar);
			}
			break;
		case 2:
			break;
		case 3:
			break;
		}
	}

	private static void menuIngreso(InventarioBebidas listaBebidas) {
		int opcion;
		String op;
		System.out.println("1- Vino");
		System.out.println("2- Cerveza");
		System.out.println("3- Licor");
		opcion = scan.nextInt();
		switch (opcion) {
		case 1: 
			System.out.println("Ingrese marca:");
			String marca= scan.nextLine();
			System.out.println("Ingrese nombre: ");
			String nombre=scan.nextLine();
			System.out.println("Ingrese origen:");
			String origen=scan.nextLine();
			System.out.println("Ingrese bodega:");
			String bodega=scan.nextLine();
			System.out.println("Ingrese la variedad de vino:");
			String tipo=scan.nextLine();
			System.out.println("Ingrese cosecha:");
			int año = scan.nextInt();
			System.out.println("Ingrese graduacion alcoholica:");
			String graduacion=scan.nextLine();
			System.out.println("Ingrese capacidad:");
			float capacidad= scan.nextFloat();
			System.out.println("Ingrese cantidad de stock inicial:");
			int stock= scan.nextInt();
			System.out.println("Ingrese el precio por unidad:");
			double precio=scan.nextDouble();
			String codigo="aca va un codigo generado secuencialmente cuando se mete el objeto al array de stock";
			/*Vino vino1 = new Vino(graduacion, marca, capacidad, nombre, stock, origen,
					 codigo,precio , tipo, bodega, año);*/
			//agrega un nuevo vino al inventario
			listaBebidas.agregarBebida(new Vino(graduacion, marca, capacidad, nombre, stock, origen,
					codigo,precio , tipo, bodega, año));
			System.out.println("Desea agregar otra bebida? escriba Si o cualquier tecla para volver al menu");
			op=scan.nextLine();
			if (op== "Si") {
				menuIngreso(listaBebidas);
			}
			menuAdmin(listaBebidas);
			break;
		case 2:
			System.out.println("Ingrese marca:");
			String marcaCerveza= scan.nextLine();
			System.out.println("Ingrese nombre: ");
			String nombreCerveza=scan.nextLine();
			System.out.println("Ingrese que variedad de cerveza es:");
			String variedad=scan.nextLine();
			System.out.println("Ingrese origen:");
			String origenCerveza=scan.nextLine();
			System.out.println("Ingrese graduacion alcoholica:");
			String graduacionCerveza=scan.nextLine();
			System.out.println("Ingrese capacidad:");
			float capacidadCerveza= scan.nextFloat();
			System.out.println("Ingrese cantidad de stock inicial:");
			int stockCerveza= scan.nextInt();
			System.out.println("Ingrese el precio por unidad:");
			double precioCerveza=scan.nextDouble();
			String codigoCerveza = "aca va el codigo";
			//Cerveza cerveza1 = new Cerveza(graduacionCerveza, marcaCerveza, capacidadCerveza, nombreCerveza, stockCerveza, origenCerveza, codigoCerveza, precioCerveza, variedad);
			//agrega al inventario un nuevo tipo de cerveza
			listaBebidas.agregarBebida(new Cerveza(graduacionCerveza, marcaCerveza, capacidadCerveza, nombreCerveza, stockCerveza, origenCerveza, codigoCerveza, precioCerveza, variedad));
			System.out.println("Desea agregar otra bebida? escriba Si o cualquier tecla para volver al menu");
			op=scan.nextLine();
			if (op== "Si") {
				menuIngreso(listaBebidas);
			}
			menuAdmin(listaBebidas);
			break;
		case 3:
			System.out.println("Ingrese marca:");
			String marcaLicor= scan.nextLine();
			System.out.println("Ingrese nombre:");
			String nombreLicor= scan.nextLine();
			System.out.println("Ingrse tipo de licor: ");
			String tipoLicor= scan.nextLine();
			System.out.println("Ingrese origen: ");
			String origenLicor= scan.nextLine();
			System.out.println("Ingrese graduacion alcoholica: ");
			String graduacionLicor= scan.nextLine();
			System.out.println("Ingrese capacidad: ");
			float capacidadLicor = scan.nextFloat();
			System.out.println("Ingrese cantidad de stock inicial: ");
			int stockLicor= scan.nextInt();
			System.out.println("Ingrese el precio por unidad: ");
			double precioLicor = scan.nextDouble();
			String codigoLicor= "aca va el codigo";
			listaBebidas.agregarBebida(new Licor(graduacionLicor, marcaLicor, capacidadLicor,nombreLicor, stockLicor, origenLicor, codigoLicor, precioLicor, tipoLicor ));
			System.out.println("Desea agregar otra bebida? escriba Si o cualquier tecla para volver al menu");
			op=scan.next();
			if (op== "Si") {

				menuIngreso(listaBebidas);
			}
			menuAdmin(listaBebidas);
			break;
		}	
	}
	private static void menuStock(InventarioBebidas listaBebidas) {
		int opcion;
		System.out.println("Ingrese el codigo de la bebida:");
		String codigoBebida = scan.nextLine();
		if (listaBebidas.codigoExiste(codigoBebida)== true){
			System.out.println("Ingrese stock a agregar: ");
			int stockBebida = scan.nextInt();
			listaBebidas.modificarStock(codigoBebida, stockBebida);
		}else {System.out.println("El codigo ingresado no es valido");
		scan.next();
		System.out.println("Presione 1 para salir o cualquier otra tecla para reintentar");
		opcion =scan.nextInt();
		if (opcion == 1) {
			menuAdmin(listaBebidas);
		}else menuStock(listaBebidas);
		}
	}

}
