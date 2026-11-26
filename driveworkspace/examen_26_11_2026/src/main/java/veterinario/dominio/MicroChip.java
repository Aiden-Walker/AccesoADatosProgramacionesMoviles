package veterinario.dominio;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "microchip")
public class MicroChip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	private String Codigo;

	public MicroChip(int id, String codigo, String fecha_implementacion) {
		super();
		this.id = id;
		Codigo = codigo;
		this.fecha_implementacion = fecha_implementacion;
	}

	@Column(nullable = false)
	private String fecha_implementacion;

	@OneToOne
	@JoinColumn(name = "mascota_id", nullable = false)
	private Mascota mascota;

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
		mascota.setChip(this);
	}

	public Mascota getMascota() {
		return mascota;
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
	 * @return the codigo
	 */
	public String getCodigo() {
		return Codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	/**
	 * @return the fecha_implementacion
	 */
	public String getFecha_implementacion() {
		return fecha_implementacion;
	}

	/**
	 * @param fecha_implementacion the fecha_implementacion to set
	 */
	public void setFecha_implementacion(String fecha_implementacion) {
		this.fecha_implementacion = fecha_implementacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Codigo, fecha_implementacion, Integer.valueOf(id), mascota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MicroChip other = (MicroChip) obj;
		return Objects.equals(Codigo, other.Codigo) && Objects.equals(fecha_implementacion, other.fecha_implementacion)
				&& id == other.id && Objects.equals(mascota, other.mascota);
	}

	@Override
	public String toString() {
		return "MicroChip [id=" + id + ", Codigo=" + Codigo + ", fecha_implementacion=" + fecha_implementacion
				+ ", mascota=" + mascota + "]";
	}

}
