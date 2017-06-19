package Model;

public abstract class CommandAbstract {

	public abstract void exec(String[] args);
	
	public FileSystem getFileSystem(String pID){
		FileSystem fs = null;
		for(int i=0; i<Main.fs.size(); i++){
			if(Main.fs.get(i).getuID().equals(pID)){
				fs = Main.fs.get(i);
			}
		}
		return fs;
	}
}
