package testsJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
	private Calculadora calcu;
	@BeforeEach
	@AfterEach
	public void borrarCalculadora() {
		calcu = null;
	}
	@Test
	void testSuma() {
		Calculadora sumainator = new Calculadora(20, 10);
		assertEquals(30, sumainator.suma(), 0);
		assertEquals(31, sumainator.suma(), 1);
		assertEquals(28, sumainator.suma(), 2);
	}

	@Test
	void testResta() {
		Calculadora restainator = new Calculadora(100, 25);
		assertEquals(75, restainator.resta(), 0);
		Calculadora compruebainator = new Calculadora(25, 50);
		assertEquals(25, compruebainator.resta(), 0);
	}

	@Test
	void testMultiplica() {
		Calculadora multiplicaInator = new Calculadora(2, 2);
		assertEquals(4, multiplicaInator.multiplica(), 0, "Failure, skill issue");
	}

	@Test
	void testDivide() {
		Calculadora divideInator = new Calculadora(10, 5);
		assertEquals(2, divideInator.divide2(), 0);
		Calculadora realityVibeChecker = new Calculadora(10, 0);
		assertNull(realityVibeChecker.divide2());
	}

}
