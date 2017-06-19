package Commands;

import Model.CommandAbstract;
import Model.Directory;
import Model.Main;
import Model.FileSystem;
import Model.Disk;
import Model.FileComponent;

public class CRT extends CommandAbstract{

	@Override
	public String exec(String[] args) {
		if(args.length < 4) throw new IllegalArgumentException("Cantidad insuficientes de argumentos");
		
		String fsID = args[0];
		int sectors = Integer.parseInt(args[1]);
		int sectorSize = Integer.parseInt(args[2]);
		
		String rootName = args[3];
		FileSystem fs =getFileSystem(fsID);
		FileComponent root = new Directory(""+FileSystem.dirCounter+1, rootName, null);
		fs.setRoot(root);
		FileSystem.dirCounter++;
		fs.setCurrentFile(root);
		fs.disk = new Disk("C", sectors, sectorSize);
		fs.disk.initDisk();
		
		return "Unidad virtual creada con éxito";
	}
	
}
