package Model;

import javax.swing.JOptionPane;

public class File extends FileComponent{
	
	private String extension;
	private String content;
	
	public File(String pUID, String pName, String pExtension, String pContent,
			FileComponent pFather){
		super();
		extension = pExtension;
		content = pContent;
		setuID(pUID);
		setName(pName);
		setSize(content.length());
		setCreationDate(getCurrentDate());
		setModificationDate(getCurrentDate());
		setFather(pFather);
	}
	
	@Override
	public String getName() {
		String res = this.name+'.'+extension;
		return res;
	}

	@Override
	public String getRoute() {
		FileComponent current = this;
		String route = getName();
		while(current.getFather() != null){
			route = current.getFather().name+'/'+route;
			current = current.getFather();
		}
		route = "C:/"+route;
		return route;
	}

	@Override
	public void add(FileComponent pFile) {
		try{
			throw new IllegalArgumentException();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void remove(FileComponent pFile) {
		try{
			throw new IllegalArgumentException();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
