package com.anncode.transporteshibernate.Camionero;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.anncode.transporteshibernate.Camion.Camion;

@Entity
@Table(name="camionero")
public class Camionero {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="dni")
	private String dni;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="salario")
	private double salario;
	
	@Column(name="poblacion")
	private String poblacion;
	
	@Column(name="camiones")
	private List<Camion> camiones = new ArrayList<Camion>();
	


	public Camionero(){
		super();
	}
	
	
	
	public Camionero(int id, String dni, String nombre, String telefono,
			String direccion, double salario, String poblacion) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.salario = salario;
		this.poblacion = poblacion;
	}



	public int getId() {
		return id;
	}
	public void setId_camionero(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public List<Camion> getCamiones() {
		return camiones;
	}
	public void setCamiones(List<Camion> camiones) {
		this.camiones = camiones;
	}
	
}
