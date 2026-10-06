package testsJUnit;

public class MiningOperation {
	private int pickaxeStrength;
	private int mineralStrength;

	public MiningOperation(int pick, int mineral) {
		pickaxeStrength = pick;
		mineralStrength = mineral;
	}

	public boolean miningAttempt() {
		boolean status = false;
		if (pickaxeStrength > mineralStrength) {
			status = true;
		}
		return status;
	}
}
