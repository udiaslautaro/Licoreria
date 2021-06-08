package app;
import java.util.Scanner;

import model.Vino;

public class Main {

	public static void main(String[] args) {
		
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
				
		}
	
		scan.close();
	}


	private static void menuAdmin() {
		System.out.println("1- Ingresar nueva Bebida");
		System.out.println("2- Agregar Bebidas al Stock");
		System.out.println("3- Modificar precio de las Bebidas");
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
				String codigo="aca va un codigo generado secuencialmente cuando se mete el objeto al array de stock";
				Vino vino1 = new Vino(graduacion, marca, capacidad, nombre, stock, origen,
						 codigo, tipo, bodega, año);
			}
			
			
		}
		
		
		scan.close();
		}
}
