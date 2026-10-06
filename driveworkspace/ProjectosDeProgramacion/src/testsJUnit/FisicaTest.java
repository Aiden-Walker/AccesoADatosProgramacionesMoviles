package testsJUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FisicaTest {

	Fisica f = new Fisica();

	@Test
	public void testVelocidad() {
		assertEquals(10.0, f.calcularVelocidad(100, 10)); // 100m / 10s = 10 m/s
		assertThrows(IllegalArgumentException.class, () -> f.calcularVelocidad(100, 0));
		// Si el tiempo es 0 lance una excepcion
	}

	@Test
	public void testEnergiaCinetica() {
		assertEquals(9.0, f.energiaCinetica(2, 3)); // 0.5 * 2kg * 3^2m/s = 9 J
	}

	@Test
	public void testFuerza() {
		assertEquals(20.0, f.fuerza(5, 4)); // 5kg * 4m/s² = 20 N
	}

	@Test
	public void testPeso() {
		assertEquals(19.62, f.peso(2), 0.001); // 2kg * 9.81 ≈ 19.62 N, delta/variacion 0.001 para decimales
	}

	@Test
	public void testTrabajo() {
		assertEquals(50.0, f.trabajo(10, 5)); // fuerza=10N, desplazamiento=5m ; Trabajo=50J
	}

	@Test
	public void testDensidad() {
		assertEquals(2.0, f.densidad(10, 5)); // 10kg / 5m³ = 2 kg/m³
		assertThrows(IllegalArgumentException.class, () -> f.densidad(10, 0)); // Si el volumen es 0, lanza excepcion
	}
}
