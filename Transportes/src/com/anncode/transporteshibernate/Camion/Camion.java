package com.anncode.transporteshibernate.Camion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="camion")
public class Camion implements Serializable{
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="matricula")
	private String matricula;
	
	@Column(name="potencia")
	private double potencia;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="tipo")
	private String tipo;
	
	
	//@Column(name="camioneros")
	//private List<Camionero> camioneros =  new ArrayList<>();
	
	
	public Camion() {
		super();
	}
	
	
	
	public Camion(String matricula, double potencia, String modelo,
			String tipo) {
		super();
		this.matricula = matricula;
		this.potencia = potencia;
		this.modelo = modelo;
		this.tipo = tipo;
	}



	//POJO Plain Old Java Object
	public int getId() {
		return id;
	}
	public void setId_camion(int id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getPotencia() {
		return potencia;
	}
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/*
	public List<Camionero> getCamioneros() {
		return camioneros;
	}
	public void setCamioneros(List<Camionero> camioneros) {
		this.camioneros = camioneros;
	}
	*/
	
}
