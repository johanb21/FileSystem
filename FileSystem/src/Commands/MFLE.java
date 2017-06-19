package Commands;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.CommandAbstract;
import Model.Directory;
import Model.File;
import Model.FileComponent;
import Model.FileSystem;

public class MFLE extends CommandAbstract{

	@Override
	public String exec(String[] args) {
		String fsID = args[0];
		String fileName = args[1];
		String fileNewContent = args[2];
		
		try{
			FileSystem fs = getFileSystem(fsID);
			Directory currentDir = (Directory) fs.getCurrentFile();
			ArrayList<FileComponent> elements = currentDir.getChildren();
			for(FileComponent element : elements){
				if(element.getName().equals(fileName)){
					File file = (File) element;
					file.setContent(fileNewContent);
					file.updateSizes(file.getSize(), fileNewContent.length());
					
					return "Archivo modificado con éxito";
				}
			}
		}catch(Exception e){
			return "Error al modificar archivo";
		}
		
		return "Error al modificar archivo";
	}

}
