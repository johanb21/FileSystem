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

public class CommandFactory {

	public CommandFactory(){
		
	}
	
	public CommandAbstract getCommand(Command command, String[] args){
		switch(command){
		case CRT:
			return new CRT();
			
		case FLE:
			return new FLE();
			
		case MKDIR:
			return new MKDIR();
			
		case CHDIR:
			return new CHDIR();
			
		case LDIR:
			return new LDIR();
			
		case MFLE:
			return new MFLE();
			
		case PPT:
			return new PPT();
			
		case VIEW:
			return new VIEW();
			
		case CPY:
			return new CPY();
			
		case MOV:
			return new MOV();
			
		case REM:
			return new REM();
			
		case TREE:
			return new TREE();
		}
		return null;
	}
}
