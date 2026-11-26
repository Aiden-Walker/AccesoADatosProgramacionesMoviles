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
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    @Column(nullable = false, unique = true)
    private String isbn;

    private String editorial;

    private int paginas; // int primitivo => NOT NULL en BD

    // cascade PERSIST: al guardar el libro se guardan sus autores nuevos.
    // (ella pone ALL; con PERSIST basta y evita borrar autores al borrar un libro)
    @ManyToMany(mappedBy = "libros", cascade = CascadeType.PERSIST)
    private Set<Autor> autores;

    @OneToMany(mappedBy = "libro")
    private List<Ejemplar> ejemplares;

    public Libro() {
        super();
        autores = new HashSet<Autor>();
        ejemplares = new ArrayList<Ejemplar>();
    }

    public Libro(String titulo, String isbn, String editorial, int paginas) {
        this();
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.paginas = paginas;
    }

    // --- Autores (N:M) ---
    public void addAutor(Autor autor) {
        autores.add(autor);
        if (!autor.containsLibro(this)) {
            autor.addLibro(this);
        }
    }

    public void removeAutor(Autor autor) {
        autores.remove(autor);
        if (autor.containsLibro(this)) {
            autor.removeLibro(this);
        }
    }

    public boolean containsAutor(Autor autor) {
        return autores.contains(autor);
    }

    // --- Ejemplares (1:N) ---
    public void addEjemplar(Ejemplar e) {
        ejemplares.add(e);
        if (!this.equals(e.getLibro())) {
            e.setLibro(this);
        }
    }

    public void removeEjemplar(Ejemplar e) {
        ejemplares.remove(e);
        e.setLibro(null);
    }

    public boolean containsEjemplar(Ejemplar e) {
        return ejemplares.contains(e);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro)) return false;
        return Objects.equals(isbn, ((Libro) o).getIsbn());
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn
                + ", editorial=" + editorial + ", paginas=" + paginas + "]";
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}

    // + getters y setters (menos setAutores y setEjemplares)
    
    
}