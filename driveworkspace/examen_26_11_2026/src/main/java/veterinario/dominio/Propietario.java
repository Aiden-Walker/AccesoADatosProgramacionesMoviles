package veterinario.dominio;

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
@Table(name = "propietario")
public class Propietario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String dni;
	@Column(nullable = false)
	private String nombre;

	private String telefono;

	// int primitivo => NOT NULL en BD

	// cascade PERSIST: al guardar el propietario se guardan sus autores nuevos.
	// (ella pone ALL; con PERSIST basta y evita borrar autores al borrar un libro)
	@OneToMany
	private List<Mascota> mascotas;

	public Propietario() {
		super();
		mascotas = new ArrayList<Mascota>();
	}

	public Propietario(String dni, String nombre, String telefono) {
		this();
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	// --- Mascotas (1:N) ---
	public void addMascota(Mascota e) {
		mascotas.add(e);
		if (!this.equals(e.getPropietario())) {
			e.setPropietario(this);
		}
	}

	public void removeMascota(Mascota e) {
		mascotas.remove(e);
		e.setPropietario(null);
	}

	public boolean containsMascota(Mascota e) {
		return mascotas.contains(e);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propietario other = (Propietario) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Propietario [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + "]";
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
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the mascotas
	 */
	public List<Mascota> getMascotas() {
		return mascotas;
	}

	/**
	 * @param mascotas the mascotas to set
	 */
	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

}