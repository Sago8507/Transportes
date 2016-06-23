package com.anncode.transporteshibernate.Camion_camionero;

public class Camion_camionero {
	
	private int id;
	private int id_camion;
	private int id_camionero;
	private String fecha;
	
	public Camion_camionero(){
		super();
	}
	
	
	
	public Camion_camionero(int id, int id_camion, int id_camionero,
			String fecha) {
		super();
		this.id = id;
		this.id_camion = id_camion;
		this.id_camionero = id_camionero;
		this.fecha = fecha;
	}



	public int getId() {
		return id;
	}
	public void setId_camion_camionero(int id) {
		this.id = id;
	}
	public int getId_camion() {
		return id_camion;
	}
	public void setId_camion(int id_camion) {
		this.id_camion = id_camion;
	}
	public int getId_camionero() {
		return id_camionero;
	}
	public void setId_camionero(int id_camionero) {
		this.id_camionero = id_camionero;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
