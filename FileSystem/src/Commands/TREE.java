package Commands;

import Model.CommandAbstract;
import Model.FileSystem;

public class TREE extends CommandAbstract{

	@Override
	public String exec(String[] args) {
		String fsID = args[0];
		FileSystem fs = getFileSystem(fsID);
		//SimpleTree tree = new SimpleTree(fs);
		
		return "Tree";
	}

}
