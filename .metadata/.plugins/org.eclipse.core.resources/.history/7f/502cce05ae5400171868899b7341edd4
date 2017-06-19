package Model;

public class FileSystem {
	private String uID;
	private FileComponent root;
	private FileComponent currentFile;
	private Disk disk;
	private String userID;
	
	public FileSystem(String pUID){
		uID = pUID;
		/*root = new Directory("FS001","MyComputer", null);
		currentFile = null;
		disk = new Disk("C", 15, 10);
		userID = "USERID01";*/
	}
	
	public void execCommand(Command command, String[] args){
		CommandFactory cmdFactory = new CommandFactory();
		cmdFactory.getCommand(command, args);
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
