package main.client;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Scanner;

import main.BeanFileSystem;
import main.services.FileSystem;
import main.services.FileSystemProxy;

public class Main {

	public static void main(String[] args) {
		FileSystem filesystem = new FileSystemProxy("http://localhost:8080/FileSystemWS/services/FileSystem");

		boolean exit = false;
		Scanner scanner = new Scanner(System.in);

		BeanFileSystem obj;
		
		printWelcome();

		while(!exit){
			
			System.out.print("> ");
			String newCommand = scanner.nextLine();
			
			if(newCommand.equals("exit")){
				exit = true;
				break;
			}
			
			try {
				obj = filesystem.execCommand(string2Array(newCommand));
				
				if(obj.getStatus()){
					System.out.println(obj.getMensaje());
				} else {
					System.out.println(obj.getMensaje());
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
		printBye();
		scanner.close();

	}

	private static String[] string2Array(String args){
		return args.split(" ");
	}
	
	private static void printWelcome(){
		System.out.println("TEC/Ing. Computación");
		System.out.println("Sistemas Operativos SI.2017");
		System.out.println();
		System.out.println("Bienvenido a Debiantec!");
		System.out.println(" * Documentación: https://github.com/johanb21/FileSystem");
		System.out.println();
		System.out.println("Hoy es " + new Date().toString());
		System.out.println();
		System.out.println("Ha ingresado como un usuario anónimo. Para iniciar debe crear una unidad virtual con el comando:");
		System.out.println("CRT <cantidad de sectores> <tamaño del sector> <nombre de la raiz>");
		System.out.println();
	}

	private static void printBye(){
		System.out.println("Adiós!");
	}
}
