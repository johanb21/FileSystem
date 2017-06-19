package Commands;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.CommandAbstract;
import Model.Directory;
import Model.FileComponent;
import Model.FileSystem;

public class LDIR extends CommandAbstract{

	@Override
	public String exec(String[] args) {
		String fsID = args[0];
		FileSystem fs = getFileSystem(fsID);
		FileComponent currentDir = fs.getCurrentFile();
		
		String resultado = "Contenido de "+currentDir.getName()+":\n\n";
		if(currentDir.isDir()){
			Directory dir = (Directory) currentDir;
			ArrayList<FileComponent> elements = dir.getChildren();
			resultado += "Archivos:\n";
			for(FileComponent element : elements){
				if(element.isFile()) resultado+=element.getName()+"\n";
			}
			resultado+="\nDirectorios:\n";
			for(FileComponent element : elements){
				if(element.isDir()) resultado+=element.getName()+"\n";
			}
		}
		
		return resultado;
	}

}
