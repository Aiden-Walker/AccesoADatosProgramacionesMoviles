package examenFinalProgramacionEV3;

public class Medico extends Persona {
	private String especialidad;

	public Medico(String dni, String nombre, String especialidad) {
		super(nombre, dni);
		this.especialidad = especialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
}
