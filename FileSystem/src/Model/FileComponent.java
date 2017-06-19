package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public abstract class FileComponent {
	
	protected String name;
	private String uID;
	private int size;
	private Date creationDate;
	private Date modificationDate;
	private FileComponent father;
	
	public abstract String getName();
	public abstract String getRoute();
	
	public boolean isDir(){
		return false;
	}
	public boolean isFile(){
		return false;
	}
	public abstract void add(FileComponent pFile);
	public abstract void remove(FileComponent pFile);
	
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public FileComponent getFather() {
		return father;
	}
	public void setFather(FileComponent father) {
		this.father = father;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCurrentDate(){
		Date dateWithoutTime = null;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return dateWithoutTime;
	}
	
	public abstract String toString();
	
	public void updateSizes(int oldSize, int newSize){
		FileComponent current = this;
		current.setSize(newSize);
		current.setModificationDate(getCurrentDate());
		while(current.getFather() != null){
			if(current.getFather()!= null){
				int fatherSize = current.father.getSize();
				current.father.setSize(fatherSize-oldSize+newSize);
				current.father.setModificationDate(getCurrentDate());
			}
			current = current.getFather();
		}
	}
}
