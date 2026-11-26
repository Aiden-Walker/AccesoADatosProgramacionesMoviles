package veterinario.dominio;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Tratamiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	private String nombre;
	@Column(nullable = false)
	private double coste;
	private String descripcion;

	@Override
	public String toString() {
		return "Tratamiento [id=" + id + ", nombre=" + nombre + ", coste=" + coste + ", descripcion=" + descripcion
				+ ", mascotas=" + mascotas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Double.valueOf(coste), descripcion, Integer.valueOf(id), mascotas, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tratamiento other = (Tratamiento) obj;
		return Double.doubleToLongBits(coste) == Double.doubleToLongBits(other.coste)
				&& Objects.equals(descripcion, other.descripcion) && id == other.id
				&& Objects.equals(mascotas, other.mascotas) && Objects.equals(nombre, other.nombre);
	}

	public Tratamiento(String nombre, double coste, String descripcion) {
		super();
		this.nombre = nombre;
		this.coste = coste;
		this.descripcion = descripcion;
	}

	@ManyToMany(mappedBy = "mascotas", cascade = CascadeType.PERSIST)
	private Set<Mascota> mascotas;

	public void addMascota(Mascota mascota) {
		mascotas.add(mascota);
		if (!mascota.containsTratamiento(this)) {
			mascota.addTratamiento(this);
		}
	}

	public void removeMascota(Mascota mascota) {
		mascotas.remove(mascota);
		if (mascota.containsTratamiento(this)) {
			mascota.removeTratamiento(this);
		}
	}

	public boolean containsMascota(Mascota mascota) {
		return mascotas.contains(mascota);
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
	 * @return the coste
	 */
	public double getCoste() {
		return coste;
	}

	/**
	 * @param coste the coste to set
	 */
	public void setCoste(double coste) {
		this.coste = coste;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the mascotas
	 */
	public Set<Mascota> getMascotas() {
		return mascotas;
	}

	/**
	 * @param mascotas the mascotas to set
	 */
	public void setMascotas(Set<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

}
