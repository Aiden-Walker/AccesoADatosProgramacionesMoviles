package ejTipoExamenAnimales;

import java.util.Objects;

public class Area implements Comparable<Area> {
	private String nombre;
	private float extension;

	public Area(String string, float f) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(extension, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Area other = (Area) obj;
		return Float.floatToIntBits(extension) == Float.floatToIntBits(other.extension)
				&& Objects.equals(nombre, other.nombre);
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
	 * @return the extension
	 */
	public float getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(float extension) {
		this.extension = extension;
	}

	@Override
	public int compareTo(Area o) {
		int res = (int) (this.getExtension() - o.getExtension());
		return res;
	}

}
