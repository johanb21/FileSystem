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
	public void exec(String[] args) {
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
					JOptionPane.showMessageDialog(null, resultado, fileName, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
