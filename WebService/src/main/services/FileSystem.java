package main.services;

import java.util.ArrayList;
import java.util.List;

import main.BeanFileSystem;

public class FileSystem implements IFileSystem{

	public static int fsCounter = 0;
	public static List<Model.FileSystem> fs = new ArrayList<>();

	@Override
	public BeanFileSystem build() {
		BeanFileSystem bean = new BeanFileSystem();
		
		if(fs == null) fs = new ArrayList<>();
		
		try {
			Model.FileSystem file = addFileSystem();
			
			bean.setUid(file.getuID());
			bean.setMensaje("");
			bean.setStatus(true);
		} catch (Exception e) {
			bean.setMensaje(e.getMessage());
			bean.setStatus(false);
		}
		
		return bean;
	}
	
	@Override
	public BeanFileSystem execCommand(String uid, String[] args) {
		BeanFileSystem bean = new BeanFileSystem();

		try{
			
			if(args.length < 1) throw new Exception("Cantidad insuficiente de parámetros.");
			
			String respuesta = getFileSystem(uid).waitCommand(args[0], args);

			bean.setMensaje(respuesta);
			bean.setStatus(true);
		}catch(Exception e){
			bean.setMensaje(e.getMessage());
			bean.setStatus(false);
		}

		return bean;
	}

	private Model.FileSystem addFileSystem(){
		String id = "FS"+(++fsCounter);
		Model.FileSystem flSys = new Model.FileSystem(id);
		fs.add(flSys);
		return flSys;
	}

	
	private Model.FileSystem getFileSystem(String pID){
		for(Model.FileSystem filesystem : FileSystem.fs ){
			if(filesystem.getuID().equals(pID))
				return filesystem;
		}
		return null;
	}

}
