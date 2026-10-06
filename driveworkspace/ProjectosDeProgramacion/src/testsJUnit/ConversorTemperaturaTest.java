package testsJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ConversorTemperaturaTest {

	@Test
	void testCelsiusAKelvin() {
		assertEquals(273.15, ConversorTemperatura.celsiusAKelvin(0), 0.01);
	}

	@Test
	void testKelvinACelsius() {
		assertEquals(0, ConversorTemperatura.kelvinACelsius(273.15), 0.01);
	}

	@Test
	void testFahrenheitAKelvin() {
		assertEquals(273.15, ConversorTemperatura.fahrenheitAKelvin(32), 0.01);
	}

	@Test
	void testKelvinAFahrenheit() {
		assertEquals(32, ConversorTemperatura.kelvinAFahrenheit(273.15), 0.01);
	}
}
