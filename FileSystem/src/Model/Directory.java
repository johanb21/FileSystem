package Model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Directory extends FileComponent{
	ArrayList<FileComponent> children;
	
	public Directory(String pUID,String pName, FileComponent pFather){
		super();
		children = new ArrayList<FileComponent>();
		this.setuID(pUID);
		this.setName(pName);
		this.setFather(pFather);
		this.setCreationDate(this.getCurrentDate());
		this.setModificationDate(this.getCurrentDate());
		this.setSize(1);
	}
	
	
	public ArrayList<FileComponent> getChildren() {
		return children;
	}



	public void setChildren(ArrayList<FileComponent> children) {
		this.children = children;
	}



	@Override
	public String getName(){
		return this.name;
	}

	@Override
	public String getRoute() {
		FileComponent current = this;
		String route = getName();
		while(current.getFather() != null){
			route = current.getFather().getName()+'/'+route;
			current = current.getFather();
		}
		route = "C:/"+route; //"C" se podria cambiar por el nombre del disco
		return route;
	}

	@Override
	public void add(FileComponent pFile) {
		try{
			children.add(pFile);
			setModificationDate(getCurrentDate());
			setSize(this.getSize() + pFile.getSize());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void remove(FileComponent pFile) {
		
		try{
			if(pFile instanceof File){
				children.remove(pFile);
				setSize(this.getSize() - pFile.getSize());
			}
			/**MAS COMPLICADO QUE ARCHIVOS
			 * SE DEBE HACER BORRADO EN CASCADA**/
			if(pFile instanceof Directory){
				setSize(this.getSize() - pFile.getSize());
				/*for(FileComponent child : children){
					remove(child);
				}*/
				children.remove(pFile);
			}
			else throw new IllegalArgumentException();
			
			setModificationDate(getCurrentDate());
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public boolean isDir(){
		return true;
	}
	
	@Override
	public String toString() {
		return ("Nombre: "+this.name+"\nElementos: "+this.children.size()
		+"\nTamaño: "+getSize()+" bytes\nUbicacion: "+getRoute()
		+"\nCreacion: "+getCreationDate()+"\nUltima modificacion: "+getModificationDate());
	}
}
