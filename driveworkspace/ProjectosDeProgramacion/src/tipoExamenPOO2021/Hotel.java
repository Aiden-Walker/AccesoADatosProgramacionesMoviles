package tipoExamenPOO2021;

import java.util.Arrays;

public class Hotel {
	private Reserva tReservas[];
	private Cliente tClientes[];
	private Habitacion tHabitaciones[];

	public Hotel() {
		this.tClientes = new Cliente[0];
		this.tHabitaciones = new Habitacion[0];
		this.tReservas = new Reserva[0];
	}

	public void anyadeCliente(Cliente cliente) {
		Cliente tNueva[] = new Cliente[this.tClientes.length + 1];
		for (int i = 0; i < this.tClientes.length; i++)
			tNueva[i] = this.tClientes[i];
		tNueva[this.tClientes.length] = cliente;
		this.tClientes = tNueva;
	}

	public void anyadeHabitacion(Habitacion habitacion) {
		Habitacion tNueva[] = new Habitacion[this.tHabitaciones.length + 1];
		for (int i = 0; i < this.tHabitaciones.length; i++)
			tNueva[i] = this.tHabitaciones[i];
		tNueva[this.tHabitaciones.length] = habitacion;
		this.tHabitaciones = tNueva;
	}

	public void anyadeReserva(Reserva reserva) {
		Reserva tNueva[] = new Reserva[this.tReservas.length + 1];
		for (int i = 0; i < this.tReservas.length; i++)
			tNueva[i] = this.tReservas[i];
		tNueva[this.tReservas.length] = reserva;
		this.tReservas = tNueva;
	}

	public Reserva[] getReservasDeHabitacion(Habitacion habitacion) {// comentario xd
																		// Peak
		Reserva[] reservations = new Reserva[this.tReservas.length];
		int nReserves = 0;
		for (int i = 0; i < this.tReservas.length; i++) {
			if (this.tReservas[i].getHabitacion().equals(habitacion)) {
				reservations[nReserves] = this.tReservas[i];
				nReserves++;
			}
		}
		reservations = Arrays.copyOf(reservations, nReserves);
		return reservations;
	}

	public Habitacion[] habitacionesOcupadasElDia(Fecha fecha) {
		Habitacion[] occupied = new Habitacion[this.tHabitaciones.length];
		int nOccupiedRooms = 0;
		for (int i = 0; i < this.tReservas.length; i++) {
			if (fecha.compareTo(this.tReservas[i].getFechaInicio()) >= 0
					&& fecha.compareTo(this.tReservas[i].getFechaFin()) <= 0) {
				occupied[nOccupiedRooms] = this.tReservas[i].getHabitacion();
				nOccupiedRooms++;
			}
		}
		occupied = Arrays.copyOf(occupied, nOccupiedRooms);
		return occupied;
	}

	public boolean habitacionDisponible(Habitacion habitacion, Fecha inicio, Fecha fin) {
		boolean isRoomAvailable = false;
		Reserva[] roomReserves = this.getReservasDeHabitacion(habitacion);
		for (int i = 0; i < roomReserves.length; i++) {
			if ((fin.compareTo(this.tReservas[i].getFechaInicio()) < 0
					|| inicio.compareTo(this.tReservas[i].getFechaFin()) > 0)) {
				isRoomAvailable = true;
			}
		}
		return isRoomAvailable;
	}

	public boolean hayErroresEnReservas() {
		// boolean isThereAMistake = false;
		for (Reserva r1 : this.tReservas) {
			for (Reserva r2 : this.tReservas) {
				if (!(r1.getCliente().equals(r2.getCliente())) && r1.getHabitacion().equals(r2.getHabitacion())) {
					if (!(r1.getFechaFin().compareTo(r2.getFechaInicio()) < 0
							|| r1.getFechaInicio().compareTo(r2.getFechaFin()) > 0)) {
						// isThereAMistake = true;
						return true;
					}
				}
			}
		}
		return false;
	}

}