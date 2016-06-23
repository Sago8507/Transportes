package com.anncode.transporteshibernate.Provincia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="provincia")
public class Provincia {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	public Provincia() {
		super();
	}
	
	
	
	public Provincia(int id, String codigo, String nombre) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
