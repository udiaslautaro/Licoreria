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

	public static void main(String[] args) {
		HistorialPedidos listaPedidos = new HistorialPedidos();
		menu();

	}

	
	public static void menu() {
		
		System.out.println("Bienvenido");
		System.out.println("1- Ingresar como Administrador");
		System.out.println("2- Ingresar como Cliente");
		Scanner scan = new Scanner(System.in);
		int opcion;
		opcion = scan.nextInt();
		switch (opcion) {
		case 1: 
			scan.nextLine();	
			System.out.println("Ingrese Contraseña de administrador: ");
				int contraseña;
				contraseña=scan.nextInt();
				if (contraseña == 1234){
					menuAdmin();
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
				System.out.println("Su nombre de usuario será: "+cliente.getNombreUsuario());
				break;
			case 2:
				System.out.println("Ingrese su nombre de usuario");
				String nombreUsuario = scan.next(); 
				System.out.println("Ingrese contraseña");
				String password = scan.next();
				menuCliente();
			}

		}
	
		scan.close();
	}


	private static void menuAdmin() {
		
		InventarioBebidas listaBebidas = new InventarioBebidas();
		System.out.println("1- Ingresar nueva Bebida");
		System.out.println("2- Agregar Bebidas al Stock");
		System.out.println("3- Modificar precio de las Bebidas");
		System.out.println("4- Mostrar todo el inventario de Bebidas");
		System.out.println("5- Buscar bebida por código");
		System.out.println("6- Eliminar bebida del inventario");
		int opcion;
		Scanner scan = new Scanner(System.in);
		opcion = scan.nextInt();
		switch (opcion) {
		case 1: 
			System.out.println("1- Vino");
			System.out.println("2- Cerveza");
			System.out.println("3- Licor");
			scan.next();
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
				String codigo="aca va un codigo generado secuencialmente cuando se mete el objeto al array de stock";
				/*Vino vino1 = new Vino(graduacion, marca, capacidad, nombre, stock, origen,
						 codigo,precio , tipo, bodega, año);*/
				//agrega un nuevo vino al inventario
				listaBebidas.agregarBebida(new Vino(graduacion, marca, capacidad, nombre, stock, origen,
						 codigo,precio , tipo, bodega, año));
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
				String codigoCerveza = "aca va el codigo";
				//Cerveza cerveza1 = new Cerveza(graduacionCerveza, marcaCerveza, capacidadCerveza, nombreCerveza, stockCerveza, origenCerveza, codigoCerveza, precioCerveza, variedad);
				//agrega al inventario un nuevo tipo de cerveza
				listaBebidas.agregarBebida(new Cerveza(graduacionCerveza, marcaCerveza, capacidadCerveza, nombreCerveza, stockCerveza, origenCerveza, codigoCerveza, precioCerveza, variedad));
				break;
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
				String codigoLicor= "aca va el codigo";
				listaBebidas.agregarBebida(new Licor(graduacionLicor, marcaLicor, capacidadLicor,nombreLicor, stockLicor, origenLicor, codigoLicor, precioLicor, tipoLicor ));
				break;
			}
			scan.close();
		case 2:
				System.out.println("Ingrese el codigo de la bebida:");
				String codigoBebida = scan.next();
				if (listaBebidas.codigoExiste(codigoBebida)== true){
					System.out.println("Ingrese stock a agregar: ");
					int stockBebida = scan.nextInt();
					listaBebidas.modificarStock(codigoBebida, stockBebida);
				}else System.out.println("El codigo ingresado no es valido");
				
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		}		
		scan.close();
		}
	
	private static void menuCliente() {
		
		System.out.println("Ingrese que operación desea realizar:");
		System.out.println("1 - Realizar pedido.");
		System.out.println("2 - Consultar pedidos anteriores.");
		System.out.println("3 - Imprimir factura.");
		int opcion;
		Scanner scan = new Scanner(System.in);
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
		scan.close();
	}
}
