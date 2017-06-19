package Model;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Main {

	public static int fsCounter = 0;
	public static ArrayList<FileSystem> fs;
	
	public static void main(String[] args) {
		fs = new ArrayList<FileSystem>();
		try{
			FileSystem f1 = addFileSystem();
			String arg[] = {f1.getuID(), "15", "10", "MyComputer"};
			f1.waitCommand("CRT", arg);
			JOptionPane.showMessageDialog(null, "CRT Existoso!", "LINDAA", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No sirvio...", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public static FileSystem addFileSystem(){
	 String id = "FS"+fsCounter+1;
	 FileSystem flSys = new FileSystem(id);
	 fs.add(flSys);
	 fsCounter++;
	 return flSys;
	}
}
