package Commands;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.CommandAbstract;
import Model.Directory;
import Model.FileComponent;
import Model.FileSystem;

public class PPT extends CommandAbstract{

	@Override
	public void exec(String[] args) {
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
					JOptionPane.showMessageDialog(null, resultado, "Info de objeto", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				if(currentDir.getName().equals(fileName)){
					resultado = currentDir.toString();
					JOptionPane.showMessageDialog(null, resultado, "Info de objeto", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
