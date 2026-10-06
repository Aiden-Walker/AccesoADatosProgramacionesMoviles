package examenFinalProgramacionEV3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Modelo {

	private Map<Medico, List<Cita>> agendaMedica;
	private Set<Persona> pacientesClinica;

	public Modelo() {
		this.agendaMedica = new HashMap<>();
		this.pacientesClinica = new HashSet<>();
	}

	public Set<Persona> getPacientesClinica() {
		return pacientesClinica;
	}

	public void addPaciente(Persona p) {
		this.pacientesClinica.add(p);
	}

	public void addCita(Medico m, Cita c) {
		// Si el médico no existe en el mapa, inicializamos su lista
		this.agendaMedica.putIfAbsent(m, new ArrayList<>());
		this.agendaMedica.get(m).add(c);
	}

	/**
	 * TAREA 1
	 */
	public int cargarPacientesDesdeTexto(String nombreFichero) {
		int addedPatients = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
			String currPatient = br.readLine();
			while (currPatient != null) {
				String[] patientString = currPatient.split(";");
				String currDNI = patientString[1];
				String currName = patientString[0];
				Persona personToAdd = new Persona(currDNI, currName);
				if (this.pacientesClinica.add(personToAdd)) {
					addedPatients++;
				}
				currPatient = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file you're attempting to read does not exist");
		} catch (IOException e1) {
			System.out.println("Something went wrong when attempting to read or write");
		}
		return addedPatients;
	}

	/**
	 * TAREA 2
	 */
	public boolean generarInformeUrgencias(int prioridadMinima) {
		boolean fileCreatedCorrectly = false;
		/*
		 * Primero vamos a comprobar si el fichero existe, y limpiar su contenido, y ya
		 * despues vemos si hay que escribir algo o no
		 */
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("urgencias.txt"))) {
			fileCreatedCorrectly = true;
			/*
			 * Si el try con recursos no lanza una excepcion asumimos que urgencias.txt se
			 * ha generado correctamente, independientemente de si esta vacio o no
			 */
			for (List<Cita> lc : this.agendaMedica.values()) {
				for (Cita c : lc) {
					if (c.getPrioridad() >= prioridadMinima) {
						String patientStr = (c.getPaciente().getDni() + ";" + c.getPaciente().getNombre() + ";"
								+ c.getPrioridad() + "\n");
						bw.write(patientStr);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file you are attempting to act upon does not exist");
		} catch (IOException e1) {
			System.out.println("The read or write you're attempting to do resulted in an error");
		}
		return fileCreatedCorrectly;
	}

	/**
	 * TAREA 3
	 */
	public void exportarCitasMedicoBinario(String dniMedico, String nombreFichero) {
		try (ObjectOutputStream binaryWriter = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
			Medico medToSearch = new Medico(dniMedico, "-", "-");
			for (Cita c : this.agendaMedica.get(medToSearch)) {
				binaryWriter.writeObject(c);
			}
			/*
			 * El motivo del que podamos hacer un medico y buscar por dicho medico, es que
			 * el mapa de citas medicas tiene llaves que se comprueban por DNI
			 */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * TAREA 4
	 */
	public List<Cita> leerCitasDesdeBinario(String nombreFichero) {
		List<Cita> citsToReturn = new LinkedList<>();
		try (ObjectInputStream binaryReader = new ObjectInputStream(new FileInputStream(nombreFichero))) {
			Cita c = (Cita) binaryReader.readObject();
			while (c != null) {
				citsToReturn.add(c);
				c = (Cita) binaryReader.readObject();
			}
		} catch (EOFException e) {
			System.out.println("End of file");
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("You're attempting to convert to a class that does not exist");
		} catch (IOException e3) {
			System.out.println("Something went wrong while attempting to read or write, try again");
		}
		return citsToReturn;
	}

	/**
	 * TAREA 5
	 */
	public Set<Persona> obtenerPacientesSinCita() {
		Set<Persona> patientsWithoutCit = new HashSet<Persona>();
		for (Persona p : this.pacientesClinica) {
			boolean hasCit = false;
			for (List<Cita> lc : this.agendaMedica.values()) {
				for (Cita c : lc) {
					if (c.getPaciente().equals(p)) {
						hasCit = true;
					}
				}
			}
			if (hasCit == false) {
				patientsWithoutCit.add(p);
			}
		}
		return patientsWithoutCit;
		/*
		 * Lo siento Marta, no se me ocurrio otra manera de comprobar que el paciente no
		 * tiene cita aparte de recorrer todas las citas en el modelo
		 */
	}
}