package Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Disk implements FileOutput{
	private String name;
	private int sectors;
	private int sectorSize;
	private ArrayList<String> content;
	
	public Disk(String pName, int pSectors, int pSectorSize){
		name = pName;
		sectors = pSectors;
		sectorSize = sectorSize;
		content = new ArrayList<String>();
	}
	
	public void initDisk(){
		String tempSector = "";
		for(int i = 0; i < sectors;i++){
			for(int j=0; j< sectorSize;j++){
				tempSector += '0';
			}
			//tempSector += '\n';
			content.add(tempSector);
		}
	}
	
	public void updateFileSystem(FileComponent pRoot){
		
	}
	
	public void assignFile(FileComponent pFile){
		boolean getsIn = bestFit(pFile);
		if(getsIn){
			//...
			JOptionPane.showMessageDialog(null, "Archivo creado!", "Exito", JOptionPane.INFORMATION_MESSAGE);
		}else{
			//...
			JOptionPane.showMessageDialog(null, "No hay espacio en disco para el archivo", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean bestFit(FileComponent pFile){
		int finalIndex = 9999;
		int lowest = 9999;
		boolean getsIn = false;
		
		for(int i=0; i<sectors; i++){
			if(sectorIsFree(i)){
				int temp = getBlockSize(i, pFile.getSize());
				if(temp > 0){
					getsIn = true;
					if(lowest > temp){
						lowest = temp;
						finalIndex = i;
					}
				}
			}
			
			if(restOfMemFree(i)){
				break;
			}
		}
		return getsIn;
	}
	
	public int getBlockSize(int pIndex, int pFileSize){
		int blockSize = 0;
		while(pFileSize > 0){
			if(sectorIsFree(pIndex)){
				pFileSize -= sectorSize;
				blockSize++;
				pIndex++;
			}else{
				return -1; //No cabe en el bloque
			}
		}
		return blockSize;
	}
	
	public boolean sectorIsFree(int pIndex){
		boolean isFree = true;
		String sector = content.get(pIndex);
		try{
			for(int i=0; i<sectorSize; i++){
				if(sector.charAt(i) != '0'){
					isFree = false;
				}
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return isFree;
	}
	
	public boolean restOfMemFree(int pIndex){
		boolean isFree = true;
		for(int i=pIndex; i<sectors; i++){
			if(!sectorIsFree(i)){
				isFree = false;
			}
		}
		return isFree;
	}

	@Override
	public void writeDiskFile(ArrayList<String> pContent) { //NOTA: Sobreescribe el archivo si ya existe
		try{
		    PrintWriter writer = new PrintWriter(name+".txt", "UTF-8");
		    for(int i=0; i<sectors; i++){
		    	writer.println(pContent.get(i));
		    }
		    writer.close();
		} catch (IOException e) {
		   JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
