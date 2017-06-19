package Model;

public class FileSystem {
	public static FileSystem instance;
	
	public static int fileCounter = 0;
	public static int dirCounter = 0;
	
	private String uID;
	private FileComponent root;
	private FileComponent currentFile;
	public Disk disk;
	private String userID;
	
	public static FileSystem getInstance(){
		if(instance != null)
			return instance;
		return new FileSystem("");
	}
	
	public FileSystem(String pUID){
		uID = pUID;
		instance = this;
	}
	
	public String waitCommand(String command, String[]args){
		switch(command.toUpperCase()){
			case "CRT":
				return execCommand(Command.CRT, args);

			case "FLE":
				return execCommand(Command.FLE, args);

			case "MKDIR":
				return execCommand(Command.MKDIR, args);

			case "CHDIR":
				return execCommand(Command.CHDIR, args);

			case "LDIR":
				return execCommand(Command.LDIR, args);

			case "MFLE":
				return execCommand(Command.MFLE, args);

			case "PPT":
				return execCommand(Command.PPT, args);

			case "VIEW":
				return execCommand(Command.VIEW, args);

			case "CPY":
				return execCommand(Command.CPY, args);

			case "MOV":
				return execCommand(Command.MOV, args);

			case "REM":
				return execCommand(Command.REM, args);

			case "TREE":
				return execCommand(Command.TREE, args);

			default:
				throw new IllegalArgumentException("No existe ningún comando válido para " + command);
		}
	}
	
	public String execCommand(Command pCommand, String[] args){
		CommandFactory cmdFactory = new CommandFactory();
		CommandAbstract com = cmdFactory.getCommand(pCommand, args);
		return com.exec(args);
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public FileComponent getRoot() {
		return root;
	}

	public void setRoot(FileComponent root) {
		this.root = root;
	}

	public FileComponent getCurrentFile() {
		return currentFile;
	}

	public void setCurrentFile(FileComponent currentFile) {
		this.currentFile = currentFile;
	}

	public Disk getDisk() {
		return disk;
	}

	public void setDisk(Disk disk) {
		this.disk = disk;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
