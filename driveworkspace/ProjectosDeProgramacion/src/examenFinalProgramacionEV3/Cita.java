package examenFinalProgramacionEV3;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Cita implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Persona paciente;
	private LocalDateTime fecha;
	private int prioridad;

	public Cita(Persona paciente, LocalDateTime fecha, int prioridad) {
		this.paciente = paciente;
		this.fecha = fecha;
		this.prioridad = prioridad;
	}

	public Persona getPaciente() {
		return paciente;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public void setPaciente(Persona paciente) {
		this.paciente = paciente;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

}
