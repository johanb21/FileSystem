package Commands;

import Model.CommandAbstract;
import Model.FileSystem;

public class TREE extends CommandAbstract{

	@Override
	public void exec(String[] args) {
		String fsID = args[0];
		FileSystem fs = getFileSystem(fsID);
		SimpleTree tree = new SimpleTree(fs);
	}

}
