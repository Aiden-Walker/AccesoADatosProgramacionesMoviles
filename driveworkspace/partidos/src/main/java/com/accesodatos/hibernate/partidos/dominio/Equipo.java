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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipo")

public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int anioFundacion;
	@Column //opcional si no tiene condicionales la columna
	private String ciudadOrigen;

	@Column(nullable = false, unique = true)
	private String nombre;
	
	
	
	@OneToOne(mappedBy = "equipo")
	private Entrenador entrenador;
	
	
	
				//mapped by va la varible destino de la fk tanto para 1:n n:m
	@ManyToMany(mappedBy = "equipos")
	private Set<Partido> Partidos = new HashSet<Partido>();
	
	
	//los one to many es con una lista de la clave foranea y inicializandolo en la declaracion
	@OneToMany(mappedBy = "equipo")
	private List<Jugador> jugadores = new ArrayList<Jugador>();

	public Equipo() {
		super();
	}

	public Equipo(int anioFundacion, String ciudadOrigen, String nombre) {
		super();
		this.anioFundacion = anioFundacion;
		this.ciudadOrigen = ciudadOrigen;
		this.nombre = nombre;
	}

	public boolean containsPartido(Partido partido) {
		return Partidos.contains(partido);
	}

	public void removePartido(Partido partido) {
		Partidos.remove(partido);
		if (partido.containsEquipo(this)) {
			partido.removeEquipo(this);
		}

	}

	public void addPartido(Partido partido) {
		Partidos.add(partido);
		if (!partido.containsEquipo(this)) {
			partido.addEquipo(this);
		}
	}

	public boolean containsJugadores(Jugador jugador) {
		return jugadores.contains(jugador);
	}

	//las actulizaciones en la tabla padre
	public void removeJugadores(Jugador jugador) {
		jugadores.remove(jugador);
		//
		jugador.setEquipo(null);
		//
	}

	public void addJugadores(Jugador jugador) {
		jugadores.add(jugador);
		jugador.setEquipo(this);

	}
	

//se compara por campo unicos, no por id, (o eso pienso), si no tenemos campo unico se haria de manera logica

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
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public int getId() {
		return id;
	}

	public int getAnioFundacion() {
		return anioFundacion;
	}

	public void setAnioFundacion(int anioFundacion) {
		this.anioFundacion = anioFundacion;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
		entrenador.setEquipo(this);
	}

	public Set<Partido> getPartidos() {
		return Partidos;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", anioFundacion=" + anioFundacion + ", ciudadOrigen=" + ciudadOrigen + ", nombre="
				+ nombre + "]";
	}
	
	

}
