package com.anncode.transporteshibernate.Paquete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paquete")
public class Paquete {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="destinatario")
	private String destinatario;
	
	@Column(name="direccion_destinatario")
	private String direccion_destinatario;
	
	@Column(name="id_camionero")
	private int id_camionero;
	
	@Column(name="id_provincia")
	private int id_provincia;
	
	public Paquete() {
		super();
	}
	
	
	
	public Paquete(int id, String codigo, String descripcion,
			String destinatario, String direccion_destinatario,
			int id_camionero, int id_provincia) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.destinatario = destinatario;
		this.direccion_destinatario = direccion_destinatario;
		this.id_camionero = id_camionero;
		this.id_provincia = id_provincia;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getDireccion_destinatario() {
		return direccion_destinatario;
	}
	public void setDireccion_destinatario(String direccion_destinatario) {
		this.direccion_destinatario = direccion_destinatario;
	}
	public int getId_camionero() {
		return id_camionero;
	}
	public void setId_camionero(int id_camionero) {
		this.id_camionero = id_camionero;
	}
	public int getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}

}
