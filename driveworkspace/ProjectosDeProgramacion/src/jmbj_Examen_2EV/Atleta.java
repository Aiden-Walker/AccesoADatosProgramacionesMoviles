package jmbj_Examen_2EV;

import java.util.Arrays;
import java.util.Objects;

import ejercicioTipoExamenListaMiembros.ListaMiembros;

public class Atleta implements Comparable<Atleta> {
	private String nombre;
	private int medallasOro;
	private ListaAtletas rivales;

	public Atleta(String nombre, int medallasOro) {
		this.nombre = nombre;
		this.medallasOro = medallasOro;
		this.rivales = new ListaAtletas();
	}
	/* No hay metodo equals, por lo tanto lo vamos a hacer nosotros */

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		return Objects.equals(nombre, other.nombre);
		/*
		 * Decimos que dos atletas son iguales si sus nombres son identicos, como dice
		 * explicitamente el ejercicio, no se tienen en cuenta los demas atributos
		 */
	}

	public ListaAtletas getRivales() {
		return rivales;
	}

	public String getNombre() {
		return nombre;
	}

	public int getMedallasOro() {
		return medallasOro;
	}

	public void setMedallasOro(int medallasOro) {
		this.medallasOro = medallasOro;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRivales(ListaAtletas rivales) {
		this.rivales = rivales;
	}

	// Apartado b)
	public void registrarRival(Atleta a) {
		/*
		 * Aqui podemos hacer uso del metodo creado en el ejercicioo anterior para
		 * comprobar si el atleta que queremos añadir ya existe en nuestra lista de
		 * rivales
		 */
		if (!this.rivales.contieneAtleta(a) && !a.equals(this)) {
			/*
			 * En este caso solo queremos añadir el atleta si no esta en la tabla, a si que
			 * por eso decimos "si el atleta NO esta"
			 */
			rivales.anyadeAtleta(a);
		}
	}

	// Apartado f)
	public ListaAtletas rivalesEnComun(Atleta otro) {
		ListaAtletas rivalesEncontrados = new ListaAtletas();
		for (int i = 0; i < this.getRivales().getNumAtletas(); i++) {
			if (otro.getRivales().contieneAtleta(this.rivales.getAtleta(i))) {
				rivalesEncontrados.anyadeAtleta(this.rivales.getAtleta(i));
			}
		}
		return rivalesEncontrados;
	}

	@Override
	public String toString() {
		String nombresRivales = "[";
		for (int i = 0; i < this.rivales.getNumAtletas(); i++) {
			nombresRivales += rivales.getAtleta(i).nombre;
			if (i < this.rivales.getNumAtletas() - 1) {
				nombresRivales += ", ";
			}
			;

		}
		nombresRivales += "]";
		return "Atleta [nombre=" + nombre + ", medallasOro=" + medallasOro + ", rivales=" + nombresRivales + "]";
	}

	@Override
	/*
	 * El ejercicio dice explicitamente que la ordenacion natural de los atletas es
	 * descendente, por el numero de medallas, si el numero de medallas es igual, se
	 * ordenara por nombre, esto se puede hacer en el mismo compareTo
	 */
	public int compareTo(Atleta o) {
		int res;
		if (this.medallasOro > o.medallasOro) {
			res = -1;
		} else if (this.medallasOro < o.medallasOro) {
			res = 1;
		} else {
			/*
			 * Normalmente aqui quedaria la cosa, pero hemos dicho que si el numero de
			 * medallas es igual se ordenara por orden alfabetico del nombre
			 */
			res = this.nombre.compareTo(o.nombre);
			/*
			 * Como sabemos que los atributos tipo string tienen su propio compareTo,
			 * utilizaremos eso para obtener nuestro resultado
			 */
		}
		return res;
	}

}
