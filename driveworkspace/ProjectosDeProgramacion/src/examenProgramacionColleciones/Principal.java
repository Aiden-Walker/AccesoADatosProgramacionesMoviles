package examenProgramacionColleciones;

import java.util.HashSet;

/*
import solucion.Agencia;
import solucion.Ciudad;
import solucion.Modelo;
import solucion.Operacion;
import solucion.Persona;
import solucion.Vivienda;
No se porque esos imports estan ahi, los voy a comentar.
*/
public class Principal {

	public static void main(String[] args) {
		Modelo m = new Modelo();

		// 1. PERSONAS
		Persona ramon = new Persona("111Z", "Ramon");
		Persona elena = new Persona("222X", "Elena");
		Persona luis = new Persona("333W", "Luis");
		Persona marta = new Persona("444S", "Marta");

		// 2. VIVIENDAS
		Vivienda v1 = new Vivienda("REF-MAD-01", 400000, Ciudad.MADRID, ramon);
		Vivienda v2 = new Vivienda("REF-SEV-02", 210000, Ciudad.SEVILLA, luis);
		Vivienda v3 = new Vivienda("REF-MAL-03", 150000, Ciudad.MALAGA, ramon);

		m.altaVivienda(v1);
		m.altaVivienda(v2);
		m.altaVivienda(v3);

		// 3. CENSO
		m.registrarEmpadronamiento(elena, "REF-MAD-01"); // Elena vive en casa de Ramon
		m.registrarEmpadronamiento(ramon, "REF-MAD-01"); // Ramon vive en su propia casa
		m.registrarEmpadronamiento(luis, "REF-MAD-01"); // Luis vive en casa de Ramon
		m.registrarEmpadronamiento(marta, "REF-SEV-02"); // Marta vive en casa de Luis

		// 4. OPERACIONES E INCREMENTOS
		Agencia inmoNy = new Agencia("InmoNy", "A123");
		// Op 1: de 400.000 a 410.000 (Subida 10.000)
		Operacion op1 = new Operacion(v1, 410000, "2024-01-01", false);
		// Op 2: de 150.000 a 170.000 (Subida 20.000)
		Operacion op2 = new Operacion(v3, 170000, "2024-02-01", false);

		m.anyadirOperacionAAgencia(inmoNy, op1);
		m.anyadirOperacionAAgencia(inmoNy, op2);

		// ---------------------------------------------------------
		// EJECUCIÓN DE PRUEBAS
		// ---------------------------------------------------------
		System.out.println("--- RESULTADOS ---");

		// Método 2: obtenerCaseroDePersona
		System.out.println("\n[2] Prueba Caseros:");
		System.out.println("Casero de Elena (debe ser Ramon): " + m.obtenerCaseroDePersona(elena));
		System.out.println("Casero de Marta (debe ser Luis): " + m.obtenerCaseroDePersona(marta));

		// Método 3: contarPersonasViviendoEnCiudad
		System.out.println("\n[3] Prueba Censo por Ciudad:");
		System.out.println("Viviendo en MADRID (deben ser 3): " + m.contarPersonasViviendoEnCiudad(Ciudad.MADRID));
		System.out.println("Viviendo en SEVILLA (debe ser 1): " + m.contarPersonasViviendoEnCiudad(Ciudad.SEVILLA));

		// Método 4: incrementoMedioPorAgencia
		System.out.println("\n[4] Prueba Incremento Medio:");
		System.out.println("Media InmoNy (debe ser 15000.0): " + m.incrementoMedioPorAgencia(inmoNy));

		// Método 5: obtenerInquilinos
		System.out.println("\n[5] Prueba Inquilinos (No viven en su propiedad):");
		HashSet<Persona> inquilinos = m.obtenerInquilinos();
		if (inquilinos != null) {
			for (Persona p : inquilinos) {
				System.out.println("- " + p.getNombre());
			}
		} else {
			System.out.println("Metodo no implementado (devuelve null)");
		}
	}

}
