package testsJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MineralTest {

	@Test
	void testHytale() {
		MiningOperation hytaleMining = new MiningOperation(20,10);
		boolean operationCompletion = hytaleMining.miningAttempt();
		assertTrue(operationCompletion);
	}
	@Test
	void testFailTale() {
		MiningOperation hytaleFail = new MiningOperation(10, 20);
		boolean failure = hytaleFail.miningAttempt();
		assertFalse(failure);
	}
}
