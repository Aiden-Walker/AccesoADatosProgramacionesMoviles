package veterinario.dominio;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mascota")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	private String nombre;
	@Column(nullable = false)
	private String especie;
	private double peso;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "propietario_id", nullable = false)
	private Propietario propietario;

	@ManyToMany
	private Set<Tratamiento> tratamientos;

	@OneToOne
	private MicroChip chip;

	// setter a mano (NO lo generes con Eclipse)
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
		if (propietario != null && !propietario.containsMascota(this)) {
			propietario.addMascota(this);
		}
	}

	// --- Tratamiento (N:M) ---
	public void addTratamiento(Tratamiento tratamiento) {
		tratamientos.add(tratamiento);
		if (!tratamiento.containsMascota(this)) {
			tratamiento.addMascota(this);
		}
	}

	public void removeTratamiento(Tratamiento tratamiento) {
		tratamientos.remove(tratamiento);
		if (tratamiento.containsMascota(this)) {
			tratamiento.removeMascota(this);
		}
	}

	public boolean containsTratamiento(Tratamiento tratamiento) {
		return tratamientos.contains(tratamiento);
	}

	public Mascota(String nombre, String especie, double peso) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(especie, Integer.valueOf(id), nombre, Double.valueOf(peso), propietario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return Objects.equals(especie, other.especie) && id == other.id && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso)
				&& Objects.equals(propietario, other.propietario);
	}

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", peso=" + peso + ", propietario="
				+ propietario + "]";
	}

	public Propietario getPropietario() {
		return propietario;
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
	 * @return the especie
	 */
	public String getEspecie() {
		return especie;
	}

	/**
	 * @param especie the especie to set
	 */
	public void setEspecie(String especie) {
		this.especie = especie;
	}

	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * @return the chip
	 */
	public MicroChip getChip() {
		return chip;
	}

	/**
	 * @param chip the chip to set
	 */
	public void setChip(MicroChip chip) {
		this.chip = chip;
	}
}
