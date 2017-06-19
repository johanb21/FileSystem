package Model;

public abstract class CommandAbstract {

	public abstract String exec(String[] args);
	
	public FileSystem getFileSystem(String pID){
		return FileSystem.getInstance();
	}
}
