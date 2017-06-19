package Commands;

import javax.swing.JOptionPane;

import Model.CommandAbstract;
import Model.File;
import Model.FileComponent;
import Model.FileSystem;

public class FLE extends CommandAbstract{

	@Override
	public void exec(String[] args) {
		String fsID = args[0];
		String fileName = args[1];
		String fileExt = args[2];
		String fileContent = args[3];
		
		FileSystem fs = getFileSystem(fsID);
		FileComponent file = new File(""+FileSystem.fileCounter+1, fileName, fileExt, fileContent, fs.getCurrentFile());
		FileComponent dir = fs.getCurrentFile();
		boolean getsIn = fs.disk.bestFit(file);
		if(getsIn){
			dir.add(file);
			FileSystem.fileCounter++;
			JOptionPane.showMessageDialog(null, "Archivo", "LINDAA", JOptionPane.INFORMATION_MESSAGE);
		}else JOptionPane.showMessageDialog(null, "Archivo alv :(", "Error", JOptionPane.ERROR_MESSAGE);
	}

}
