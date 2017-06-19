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
		sectorSize = pSectorSize;
		content = new ArrayList<String>();
	}
	
	public void initDisk(){
		if(content.size()==0){
			String tempSector = "";
			for(int i = 0; i < sectors;i++){
				for(int j=0; j< sectorSize;j++){
					tempSector += '0';
				}
				//tempSector += '\n';
				content.add(tempSector);
				tempSector = "";
			}
			writeDiskFile(content);
		}
	}
	
	public void updateFileSystem(FileComponent pRoot){
		//...
	}
	
	public void assignFile(FileComponent pFile, int pNumBlock){
		String temp;
		int size = pFile.getSize();
		while(size>0){
			temp = "";
			for(int i=0; i<sectorSize; i++){
				if(size>0) temp += pFile.getuID();	
				else temp += '0';
				size--;
			}
			content.set(pNumBlock, temp);
			pNumBlock++;
		}
		writeDiskFile(content);
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
		if(getsIn){
			assignFile(pFile, finalIndex);
		}
		return getsIn;
	}
	
	public int getBlockSize(int pIndex, int pFileSize){
		int size = pFileSize;
		int index = pIndex;
		int blockSize = 0;
		while(size > 0){
			if(sectorIsFree(pIndex)){
				size -= sectorSize;
				blockSize++;
				index++;
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
					break;
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
		    JOptionPane.showMessageDialog(null, "Archivo creado", "Exito", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
		   JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
