package Model;

import Commands.CHDIR;
import Commands.CPY;
import Commands.CRT;
import Commands.FLE;
import Commands.LDIR;
import Commands.MFLE;
import Commands.MKDIR;
import Commands.MOV;
import Commands.PPT;
import Commands.REM;
import Commands.TREE;
import Commands.VIEW;

public class FileSystem {
	public static int fileCounter = 0;
	public static int dirCounter = 0;
	
	private String uID;
	private FileComponent root;
	private FileComponent currentFile;
	public Disk disk;
	private String userID;
	
	public FileSystem(String pUID){
		uID = pUID;
		/*root = new Directory("FS001","MyComputer", null);
		currentFile = null;
		disk = new Disk("C", 15, 10);
		userID = "USERID01";*/
	}
	
	public void waitCommand(String command, String[]args){
		switch(command.toUpperCase()){
			case "CRT":
				execCommand(Command.CRT, args);
				break;
			case "FLE":
				execCommand(Command.FLE, args);
				break;
			case "MKDIR":
				execCommand(Command.MKDIR, args);
				break;
			case "CHDIR":
				execCommand(Command.CHDIR, args);
				break;
			case "LDIR":
				execCommand(Command.LDIR, args);
				break;
			case "MFLE":
				execCommand(Command.MFLE, args);
				break;
			case "PPT":
				execCommand(Command.PPT, args);
				break;
			case "VIEW":
				execCommand(Command.VIEW, args);
				break;
			case "CPY":
				execCommand(Command.CPY, args);
				break;
			case "MOV":
				execCommand(Command.MOV, args);
				break;
			case "REM":
				execCommand(Command.REM, args);
				break;
			case "TREE":
				execCommand(Command.TREE, args);
				break;
			default:
				break;
		}
	}
	
	public void execCommand(Command pCommand, String[] args){
		CommandFactory cmdFactory = new CommandFactory();
		CommandAbstract com = cmdFactory.getCommand(pCommand, args);
		com.exec(args);
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
