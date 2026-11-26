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
import javax.persistence.Table;

@Entity
@Table(name = "partido")

public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private LocalDateTime fechaHora;

	@Column
	private int marcadorEquipo1;

	@Column
	private int marcadorEquipo2;

	
	@ManyToMany
	@JoinTable(name= "partido_equipo")
	private Set<Equipo> equipos = new HashSet<Equipo>();

	public Partido() {
		super();
	}

	public Partido(LocalDateTime fechaHora, int marcadorEquipo1, int marcadorEquipo2) {
		this();
		this.fechaHora = fechaHora;
		this.marcadorEquipo1 = marcadorEquipo1;
		this.marcadorEquipo2 = marcadorEquipo2;
	}
	
    public void addEquipo(Equipo equipo) {
    	equipos.add(equipo);
        if (!equipo.containsPartido(this)) {
        	equipo.addPartido(this);
        }
        
    }
    public void removeEquipo(Equipo equipo) {
    	equipos.remove(equipo);
        if (equipo.containsPartido(this)) {
        	equipo.removePartido(this);
        }
    }
    
    public boolean containsEquipo(Equipo equipo) {
        return equipos.contains(equipo);
    }

	@Override
	public int hashCode() {
		return Objects.hash(equipos, fechaHora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(equipos, other.equipos) && Objects.equals(fechaHora, other.fechaHora);
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public int getMarcadorEquipo1() {
		return marcadorEquipo1;
	}

	public void setMarcadorEquipo1(int marcadorEquipo1) {
		this.marcadorEquipo1 = marcadorEquipo1;
	}

	public int getMarcadorEquipo2() {
		return marcadorEquipo2;
	}

	public void setMarcadorEquipo2(int marcadorEquipo2) {
		this.marcadorEquipo2 = marcadorEquipo2;
	}

	public Set<Equipo> getEquipos() {
		return equipos;
	}

	@Override
	public String toString() {
		return "Partido [id=" + id + ", fechaHora=" + fechaHora + ", marcadorEquipo1=" + marcadorEquipo1
				+ ", marcadorEquipo2=" + marcadorEquipo2 + "]";
	}
}
