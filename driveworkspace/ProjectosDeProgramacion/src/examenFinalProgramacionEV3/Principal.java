package examenFinalProgramacionEV3;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Principal {
	public static void main(String[] args) {
		Modelo modelo = new Modelo();

		// --- 1. CREACIÓN DE DATOS ---
		Medico m1 = new Medico("11111111A", "Dr. House", "Diagnostico");
		Medico m2 = new Medico("22222222B", "Dra. Grey", "Cirugia");

		Persona p1 = new Persona("Juan Perez", "12312312X");
		Persona p2 = new Persona("Ana Lopez", "45645645Y");
		Persona p3 = new Persona("Carlos Garcia", "78978978Z"); // Este no tendrá cita

		// --- 2. CARGA DE DATOS EN EL MODELO ---
		modelo.addPaciente(p1);
		modelo.addPaciente(p2);
		modelo.addPaciente(p3);

		// Cita urgente para p1 con Dr. House (Prioridad 10)
		modelo.addCita(m1, new Cita(p1, LocalDateTime.now().plusDays(1), 10));
		// Cita normal para p2 con Dra. Grey (Prioridad 2)
		modelo.addCita(m2, new Cita(p2, LocalDateTime.now().plusDays(2), 2));

		System.out.println("=== SISTEMA DE PRUEBAS PARA EL ALUMNO ===");

		// --- PRUEBA TAREA 1: Cargar pacientes desde texto ---
		// Se recomienda crear un archivo "pacientes.txt" previo a la ejecución
		System.out.println("\n[Prueba 1] Cargar Pacientes desde TXT:");
		int anyadidos = modelo.cargarPacientesDesdeTexto("pacientes.txt");
		System.out.println(">> Resultado: " + anyadidos + " pacientes nuevos añadidos. Los pacientes actuales son:");
		System.out.println(modelo.getPacientesClinica());

		// --- PRUEBA TAREA 2: Generar informe urgencias ---
		System.out.println("\n[Prueba 2] Generar Informe de Urgencias (mínimo 5):");
		boolean informeOk = modelo.generarInformeUrgencias(5);
		System.out.println(">> ¿Archivo generado/limpiado correctamente?: " + informeOk);

		// --- PRUEBA TAREA 3: Exportar citas a binario ---
		System.out.println("\n[Prueba 3] Exportar Citas del Dr. House (111A):");
		modelo.exportarCitasMedicoBinario("11111111A", "citas_house.dat");
		System.out.println(">> Exportación finalizada. Verifique la creación de 'citas_house.dat'.");

		// --- PRUEBA TAREA 4: Importar citas desde binario ---
		System.out.println("\n[Prueba 4] Importar Citas desde binario:");
		List<Cita> recuperadas = modelo.leerCitasDesdeBinario("citas_house.dat");
		if (recuperadas != null) {
			System.out.println(">> Éxito: Se han recuperado " + recuperadas.size() + " citas.");
		} else {
			System.out.println(">> Error: El método devolvió null o falló la lectura.");
		}

		// --- PRUEBA TAREA 5: Obtener pacientes sin cita ---
		System.out.println("\n[Prueba 5] Pacientes sin cita:");
		Set<Persona> rezagados = modelo.obtenerPacientesSinCita();
		if (rezagados != null) {
			System.out.println(">> Pacientes encontrados: " + rezagados.size());
			for (Persona p : rezagados) {
				System.out.println("   - " + p.getNombre());
			}
		} else {
			System.out.println(">> Error: El método devolvió null.");
		}

		System.out.println("\n--- Fin del Test ---");
	}
}