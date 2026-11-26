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
@Table(name = "ejemplar")
public class Ejemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String codigo;

    private String localizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    @OneToMany(mappedBy = "ejemplar")
    private List<Prestamo> prestamos;

    public Ejemplar() {
        super();
        prestamos = new ArrayList<Prestamo>();
    }

    public Ejemplar(String codigo, String localizacion) {
        this();
        this.codigo = codigo;
        this.localizacion = localizacion;
    }

    // setter a mano (NO lo generes con Eclipse)
    public void setLibro(Libro libro) {
        this.libro = libro;
        if (libro != null && !libro.containsEjemplar(this)) {
            libro.addEjemplar(this);
        }
    }

    // --- Prestamos (1:N) ---
    public void addPrestamo(Prestamo p) {
        prestamos.add(p);
        if (!this.equals(p.getEjemplar())) {
            p.setEjemplar(this);
        }
    }

    public void removePrestamo(Prestamo p) {
        prestamos.remove(p);
        p.setEjemplar(null);
    }

    public boolean containsPrestamo(Prestamo p) {
        return prestamos.contains(p);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ejemplar)) return false;
        return Objects.equals(codigo, ((Ejemplar) o).getCodigo());
    }

    @Override
    public String toString() {
        return "Ejemplar [id=" + id + ", codigo=" + codigo + ", localizacion=" + localizacion + "]";
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

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public Libro getLibro() {
		return libro;
	}

    // + getters y setters (menos setLibro, que ya está, y setPrestamos)
    
    
}