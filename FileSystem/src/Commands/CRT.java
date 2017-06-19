package Commands;

import Model.CommandAbstract;
import Model.Directory;
import Model.Main;
import Model.FileSystem;
import Model.Disk;
import Model.FileComponent;

public class CRT extends CommandAbstract{

	@Override
	public void exec(String[] args) {
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
	}
	
	/*public FileSystem getFileSystem(String pID){
		FileSystem fs = null;
		for(int i=0; i<Main.fs.size(); i++){
			if(Main.fs.get(i).getuID().equals(pID)){
				fs = Main.fs.get(i);
			}
		}
		return fs;
	}*/
}
