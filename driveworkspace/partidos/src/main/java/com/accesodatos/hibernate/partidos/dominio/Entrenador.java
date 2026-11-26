package com.accesodatos.hibernate.partidos.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="entrenador")

public class Entrenador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column
	private int experiencia;
	
	@Column(nullable = false, unique = true)
	private String nombre;
	
	
	
	@OneToOne
	@JoinColumn(name = "equipo_id")
	private Equipo equipo;
	
	
	
	public Entrenador() {
		super();
	}

	public Entrenador(int experiencia, String nombre) {
		super();
		this.experiencia = experiencia;
		this.nombre = nombre;
		this.equipo = equipo;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrenador other = (Entrenador) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public int getExperiencia() {
		return experiencia;
	}
	
	public int getId() {
		return id;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Entrenador [id=" + id + ", experiencia=" + experiencia + ", nombre=" + nombre + ", equipo=" + equipo
				+ "]";
	}
	
	
}
