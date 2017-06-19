package Commands;

import javax.swing.JOptionPane;

import Model.CommandAbstract;
import Model.Directory;
import Model.FileComponent;
import Model.FileSystem;

public class MKDIR extends CommandAbstract{

	@Override
	public void exec(String[] args) {
		String fsID = args[0];
		String dirName = args[1];
		
		FileSystem fs = getFileSystem(fsID);
		FileComponent currentDir = fs.getCurrentFile();
		FileComponent dir = new Directory(""+FileSystem.dirCounter+1, dirName, currentDir);
		currentDir.add(dir);
		FileSystem.dirCounter++;
		JOptionPane.showMessageDialog(null, "Directorio creado", "ak7", JOptionPane.INFORMATION_MESSAGE);
	}

}
