package com.accesodatos.hibernate.libros.dominio;

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
import javax.persistence.Table;

@Entity
@Table(name = "prestamo")
@IdClass(PrestamoId.class)
public class Prestamo implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "ejemplar_id")
    private Ejemplar ejemplar;

    @Column(name = "fecha_prestamo")
    private LocalDateTime fechaPrestamo;

    @Column(name = "fecha_devolucion")
    private LocalDateTime fechaDevolucion;

    public Prestamo() {
        super();
    }

    // como el constructor de Acta de la profesora: deja la relación bidireccional consistente
    public Prestamo(Usuario usuario, Ejemplar ejemplar, LocalDateTime fechaPrestamo) {
        this();
        this.fechaPrestamo = fechaPrestamo;
        setUsuario(usuario);
        setEjemplar(ejemplar);
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        if (usuario != null && !usuario.containsPrestamo(this)) {
            usuario.addPrestamo(this);
        }
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
        if (ejemplar != null && !ejemplar.containsPrestamo(this)) {
            ejemplar.addPrestamo(this);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, ejemplar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prestamo)) return false;
        Prestamo p = (Prestamo) o;
        return Objects.equals(usuario, p.getUsuario()) && Objects.equals(ejemplar, p.getEjemplar());
    }

    @Override
    public String toString() {
        return "Prestamo [usuario=" + (usuario != null ? usuario.getNombre() : null)
                + ", ejemplar=" + (ejemplar != null ? ejemplar.getCodigo() : null)
                + ", fechaPrestamo=" + fechaPrestamo
                + ", fechaDevolucion=" + fechaDevolucion + "]";
    }

	public LocalDateTime getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

    // + getters y setters de usuario, ejemplar (ya hechos arriba), fechaPrestamo y fechaDevolucion
    
    
}