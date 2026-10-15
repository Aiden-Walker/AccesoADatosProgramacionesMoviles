package ficherosXML;

import java.io.Serializable;

public class Reserva implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private Habitacion habitación;
	private Fecha fechaInicio;
	private Fecha fechaFin;

	public Reserva(Cliente cliente, Habitacion habitación, Fecha fechaInicio, Fecha fechaFin) {
		this.cliente = cliente;
		this.habitación = habitación;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Habitacion getHabitación() {
		return habitación;
	}

	public void setHabitación(Habitacion habitación) {
		this.habitación = habitación;
	}

	public Fecha getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Fecha fechaInicio) {
		this.fechaInicio = fechaInicio;

	}

	public Fecha getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Fecha fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return this.cliente + ": " + this.habitación + ":[" + this.fechaInicio + "-" + this.fechaFin + "]";
	}

}
