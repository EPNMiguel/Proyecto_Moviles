package ec.edu.epn.modelo.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name="juego")
@NamedQuery(name="Juego.findAll", query="SELECT j FROM juego j ")
@Table(name="juego")	
public class Juego implements Serializable{
	
	@Id
	@Column(name="titulo")
	private String titulo;
	
	private String descripcion;
	private String categoria;
	private String plataforma;
	private String nombre_imagen;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getNombre_imagen() {
		return nombre_imagen;
	}
	public void setNombre_imagen(String nombre_imagen) {
		this.nombre_imagen = nombre_imagen;
	}
	
	

}
