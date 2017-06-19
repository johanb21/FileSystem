package main;

import java.io.Serializable;

public class BeanFileSystem implements Serializable{

	private static final long serialVersionUID = -3630369354954019068L;
	
	private boolean status;
	private String mensaje;
	private String uid;

	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
}
