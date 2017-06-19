package Commands;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.CommandAbstract;
import Model.Directory;
import Model.FileComponent;
import Model.FileSystem;

public class PPT extends CommandAbstract{

	@Override
	public String exec(String[] args) {
		
		if(args.length < 2) throw new IllegalArgumentException("Cantidad insuficientes de argumentos");
		
		String fsID = args[0];
		String fileName = args[1];
		
		try{
			FileSystem fs = getFileSystem(fsID);
			Directory currentDir = (Directory) fs.getCurrentFile();
			ArrayList<FileComponent> elements = currentDir.getChildren();
			String resultado = "Propiedades de "+fileName+":\n\n";
			for(FileComponent element : elements){
				if(element.getName().equals(fileName)){
					resultado += element.toString();
					return resultado;
				}
				if(currentDir.getName().equals(fileName)){
					resultado = currentDir.toString();
					return resultado;
				}
			}
		}catch(Exception e){
			return "Error al abrir archivo";
		}
		return "Error al abrir archivo";
		
	}

}
