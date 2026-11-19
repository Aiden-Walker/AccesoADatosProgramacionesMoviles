package com.accesodatos.hibernate.otrreumas2.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "acta")
public class Acta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String contenido;
	@OneToOne
	@JoinColumn
	private Reunion reunion;
	public Acta() {
		super();
	}
	public Acta(String contenido, Reunion reunion) {
		super();
		this.contenido = contenido;
		this.reunion = reunion;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}
	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	/**
	 * @return the reunion
	 */
	public Reunion getReunion() {
		return reunion;
	}
	/**
	 * @param reunion the reunion to set
	 */
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	@Override
	public String toString() {
		return "Acta [id=" + id + ", contenido=" + contenido + ", reunion=" + reunion + "]";
	}
}
