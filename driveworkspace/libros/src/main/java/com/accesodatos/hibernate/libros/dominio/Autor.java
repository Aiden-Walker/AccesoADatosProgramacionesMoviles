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
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @ManyToMany
    private Set<Libro> libros;

    public Autor() {
        super();
        libros = new HashSet<Libro>();
    }

    public Autor(String nombre) {
        this();
        this.nombre = nombre;
    }

    public void addLibro(Libro libro) {
        libros.add(libro);
        if (!libro.containsAutor(this)) {
            libro.addAutor(this);
        }
    }

    public void removeLibro(Libro libro) {
        libros.remove(libro);
        if (libro.containsAutor(this)) {
            libro.removeAutor(this);
        }
    }

    public boolean containsLibro(Libro libro) {
        return libros.contains(libro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        return Objects.equals(nombre, ((Autor) o).getNombre());
    }

    @Override
    public String toString() {
        return "Autor [id=" + id + ", nombre=" + nombre + "]";
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Libro> getLibros() {
		return libros;
	}


    
}