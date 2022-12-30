package cu.edu.unah.Proyectov1.auxiliar;

import java.util.Date;

public class Acumuladas {
    
	private int codArea;
	private String nomArea;
	private int idObrero;
	 private String nomObrero;
	 private int minAcumulados;
	public Acumuladas() {
		
	}
	public Acumuladas(int codArea, String nomArea, int idObrero, String nomObrero, int minAcumulados) {
		super();
		this.codArea = codArea;
		this.nomArea = nomArea;
		this.idObrero = idObrero;
		this.nomObrero = nomObrero;
		this.minAcumulados = minAcumulados;
	}
	public int getCodArea() {
		return codArea;
	}
	public void setCodArea(int codArea) {
		this.codArea = codArea;
	}
	public String getNomArea() {
		return nomArea;
	}
	public void setNomArea(String nomArea) {
		this.nomArea = nomArea;
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
	public int getMinAcumulados() {
		return minAcumulados;
	}
	public void setMinAcumulados(int minAcumulados) {
		this.minAcumulados = minAcumulados;
	}
	 
	 
	
}
