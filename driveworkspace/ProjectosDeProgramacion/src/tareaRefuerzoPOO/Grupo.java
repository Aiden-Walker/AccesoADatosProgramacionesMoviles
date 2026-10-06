package tareaRefuerzoPOO;

public class Grupo {
	private String nombre;
	private Profesor tutor;
	private final static int MAXALUMNOS = 30;
	private Alumno[] alumnosGrupo;
	private int nAlum;

	public Grupo(String nombre, Profesor tutor) {
		super();
		this.nombre = nombre;
		this.tutor = tutor;
		alumnosGrupo = new Alumno[MAXALUMNOS];
		nAlum = 0;
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
	 * @return the tutor
	 */
	public Profesor getTutor() {
		return tutor;
	}

	/**
	 * @param tutor the tutor to set
	 */
	public void setTutor(Profesor tutor) {
		this.tutor = tutor;
	}

	public boolean addAlumn(Alumno alumnoAIntroducir) {
		boolean isAlumnoIntroducido = false;
		if (nAlum < alumnosGrupo.length && !isAlumnoRepetido(alumnoAIntroducir)) {
			alumnosGrupo[nAlum++] = alumnoAIntroducir;
			isAlumnoIntroducido = true;
		} else {
			System.out.println("No se pueden introducir mas alumnos");
		}
		return isAlumnoIntroducido;
	}

	public boolean isAlumnoRepetido(Alumno alumnoAComprobar) {
		boolean hayAlumnoRepetido = true;
		for (int i = 0; i < nAlum && hayAlumnoRepetido; i++) {
			if (alumnoAComprobar.getNombre().equals(alumnosGrupo[i].getNombre())) {
				hayAlumnoRepetido = false;
			}
		}
		return hayAlumnoRepetido;
	}

	public boolean existeAlumn(Alumno alumnoACheckear) {
		boolean existeAlumno = false;
		for (int i = 0; i < nAlum && !existeAlumno; i++) {
			if (alumnoACheckear.getExpediente() == (alumnosGrupo[i].getExpediente())) {
				existeAlumno = true;
			}
		}
		return existeAlumno;
	}

	/**
	 * @return the alumnosGrupo
	 */
	public Alumno[] getAlumnosGrupo() {
		return alumnosGrupo;
	}

	@Override
	public String toString() {
		String datosAlumnosInsertados = "";
		for (int i = 0; i < nAlum; i++) {
			datosAlumnosInsertados += alumnosGrupo[i];
		}
		return "Grupo [nombre=" + nombre + ", tutor=" + tutor + ", alumnosGrupo=" + datosAlumnosInsertados + "]";
	}

	/**
	 * @return the nAlum
	 */
	public int getnAlum() {
		return nAlum;
	}
}
