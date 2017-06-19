package Commands;

import java.util.ArrayList;

import Model.CommandAbstract;
import Model.Directory;
import Model.FileComponent;
import Model.FileSystem;

public class MOV extends CommandAbstract{

	@Override
	public String exec(String[] args) {
		
		if(args.length < 2) throw new IllegalArgumentException("Cantidad insuficientes de argumentos");
		
		//String file = args[1];
		String[] dirFile = args[1].split("/");
		String file = dirFile[dirFile.length - 1];
		
		String dir = args[2];
		String[] dirDestino = file.split("/");
		
		FileSystem fs = getFileSystem("");
		Directory currentDir = (Directory) fs.getRoot();
		 
		
		ArrayList<FileComponent> elements = currentDir.getChildren();
		
		
		return "Archivo movido con éxito";
	}

}
