package main.services;

import java.util.Scanner;

import main.BeanFileSystem;

public class FileSystem implements IFileSystem{

	@Override
	public BeanFileSystem execCommand(String[] args) {
		BeanFileSystem bean = new BeanFileSystem();
		
		try{
		//Llamar al comando del jar
			//System.out.println("TEST");
			Scanner scan = new Scanner(System.in);
			for(int i=0; i<5; i++){
				System.out.println("fuck");
				scan.nextLine();
			}
			
			bean.setMensaje("");
			bean.setStatus(true);
		}catch(Exception e){
			bean.setMensaje(e.getMessage());
			bean.setStatus(false);
		}
		
		return bean;
	}

}
