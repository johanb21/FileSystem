package Commands;

import javax.swing.JOptionPane;

import Model.CommandAbstract;
import Model.File;
import Model.FileComponent;
import Model.FileSystem;

public class FLE extends CommandAbstract{

	@Override
	public String exec(String[] args) {

		if(args.length < 4) throw new IllegalArgumentException("Cantidad insuficientes de argumentos");

		try {
			String fsID = args[0];
			String fileName = args[1];
			String fileExt = args[2];
			String fileContent = args[3];

			FileSystem fs = getFileSystem(fsID);
			FileComponent file = new File(""+FileSystem.fileCounter+1, fileName, fileExt, fileContent, fs.getCurrentFile());
			FileComponent dir = fs.getCurrentFile();
			boolean getsIn = fs.disk.bestFit(file);
			if(getsIn){
				dir.add(file);
				FileSystem.fileCounter++;

				return "Archivo creado con éxito";
			}
		} catch (Exception e) {}
		return "Error al crear archivo";
	}

}
