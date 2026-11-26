package com.accesodatos.hibernate.libros.dominio;

import java.io.Serializable;
import java.util.Objects;

public class PrestamoId implements Serializable {

    private int usuario;   // mismo nombre y tipo (int) que las @Id de Prestamo
    private int ejemplar;

    public PrestamoId() {
    }

    public PrestamoId(int usuario, int ejemplar) {
        this.usuario = usuario;
        this.ejemplar = ejemplar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, ejemplar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrestamoId)) return false;
        PrestamoId other = (PrestamoId) o;
        return usuario == other.usuario && ejemplar == other.ejemplar;
    }

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public int getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(int ejemplar) {
		this.ejemplar = ejemplar;
	}

    // + getters y setters
    
    
}