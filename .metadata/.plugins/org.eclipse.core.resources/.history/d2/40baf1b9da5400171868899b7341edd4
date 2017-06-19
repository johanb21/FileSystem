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
	public void exec(String[] args) {
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
					JOptionPane.showMessageDialog(null, "Archivo modificado!");
					break;
				}
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
