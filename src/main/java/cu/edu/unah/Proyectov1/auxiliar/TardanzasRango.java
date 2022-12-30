package cu.edu.unah.Proyectov1.auxiliar;

import java.util.Date;

public class TardanzasRango {
 private int idObrero;
 private String nomObrero;
 private Date fecha;
 private int numMinutos;
 
 
 
public TardanzasRango() {
	
}
public TardanzasRango(int idObrero, String nomObrero, Date fecha, int numMinutos) {
	
	this.idObrero = idObrero;
	this.nomObrero = nomObrero;
	this.fecha = fecha;
	this.numMinutos = numMinutos;
}
public int getIdObrero() {
	return idObrero;
}
public void setIdObrero(int idObrero) {
	this.idObrero = idObrero;
}
public String getNomObrero() {
	return nomObrero;
}
public void setNomObrero(String nomObrero) {
	this.nomObrero = nomObrero;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public int getNumMinutos() {
	return numMinutos;
}
public void setNumMinutos(int numMinutos) {
	this.numMinutos = numMinutos;
}
 
 
 
}
