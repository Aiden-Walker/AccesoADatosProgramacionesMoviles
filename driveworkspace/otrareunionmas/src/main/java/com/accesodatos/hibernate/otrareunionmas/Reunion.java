package com.accesodatos.hibernate.otrareunionmas;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "reunion")
public class Reunion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime fecha;
	private String asunto;
	public Reunion(int id, LocalDateTime fecha, String asunto) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.asunto = asunto;
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
	 * @return the fecha
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the asunto
	 */
	public String getAsunto() {
		return asunto;
	}
	/**
	 * @param asunto the asunto to set
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
}
