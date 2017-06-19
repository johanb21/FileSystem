package Commands;

import javax.swing.JOptionPane;

import Model.CommandAbstract;
import Model.Directory;
import Model.FileComponent;
import Model.FileSystem;

public class MKDIR extends CommandAbstract{

	@Override
	public String exec(String[] args) {
		
		if(args.length < 2) throw new IllegalArgumentException("Cantidad insuficientes de argumentos");
		
		String fsID = args[0];
		String dirName = args[1];
		
		FileSystem fs = getFileSystem(fsID);
		FileComponent currentDir = fs.getCurrentFile();
		FileComponent dir = new Directory(""+FileSystem.dirCounter+1, dirName, currentDir);
		currentDir.add(dir);
		FileSystem.dirCounter++;
		
		return "Directorio creado con éxito";
	}

}
