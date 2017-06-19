package main.services;

import main.BeanFileSystem;

public class FileSystem implements IFileSystem{

	@Override
	public BeanFileSystem execCommand(String[] args) {
		BeanFileSystem bean = new BeanFileSystem();
		
		try{
		//Llamar al comando del jar
			
			bean.setMensaje("Éxito.");
			bean.setStatus(true);
		}catch(Exception e){
			bean.setMensaje(e.getMessage());
			bean.setStatus(false);
		}
		
		return bean;
	}

}
