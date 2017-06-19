package Commands;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.CommandAbstract;
import Model.Directory;
import Model.File;
import Model.FileComponent;
import Model.FileSystem;

public class VIEW extends CommandAbstract{

	@Override
	public String exec(String[] args) {
		if(args.length < 2) throw new IllegalArgumentException("Cantidad insuficientes de argumentos");
		
		String fsID = args[0];
		String fileName = args[1];
		
		try{
			FileSystem fs = getFileSystem(fsID);
			Directory currentDir = (Directory) fs.getCurrentFile();
			ArrayList<FileComponent> elements = currentDir.getChildren();
			String resultado = "";
			for(FileComponent element : elements){
				if(element.isFile() && element.getName().equals(fileName)){
					File file = (File) element;
					resultado = file.getContent();
					return resultado;
				}
			}
		}catch(Exception e){
			
		}
		
		return "Error al abrir archivo";
		
		
		
	}

}
