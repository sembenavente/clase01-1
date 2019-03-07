package clase01.upeu.edu.pe.entity;

public class Usuario {
 private String nomuser;
 private String clave;
 
public Usuario() {
	super();
}
public Usuario(String nomuser, String clave) {
	super();
	this.nomuser = nomuser;
	this.clave = clave;
}
public String getNomuser() {
	return nomuser;
}
public void setNomuser(String nomuser) {
	this.nomuser = nomuser;
}
public String getClave() {
	return clave;
}
public void setClave(String clave) {
	this.clave = clave;
}

public boolean equals(Object obj) {
	Usuario us = (Usuario) obj;
	//System.out.println("el nombre que llega es: " + us.getNomuser());
	//System.out.println("el nombre del local es: " + nomuser);
	//me ayudo a ver si el frame de modificar estaba funcionando correctamente
	return us.getNomuser().equals(this.getNomuser());
}

 
}
