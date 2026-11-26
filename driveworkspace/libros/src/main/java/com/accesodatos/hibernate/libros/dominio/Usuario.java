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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> prestamos;

    public Usuario() {
        super();
        prestamos = new ArrayList<Prestamo>();
    }

    public Usuario(String nombre) {
        this();
        this.nombre = nombre;
    }

    public void addPrestamo(Prestamo p) {
        prestamos.add(p);
        if (!this.equals(p.getUsuario())) {
            p.setUsuario(this);
        }
    }

    public void removePrestamo(Prestamo p) {
        prestamos.remove(p);
        p.setUsuario(null);
    }

    public boolean containsPrestamo(Prestamo p) {
        return prestamos.contains(p);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        return Objects.equals(nombre, ((Usuario) o).getNombre());
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + "]";
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

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}
	
    // + getters y setters (menos setPrestamos)
    
    
}