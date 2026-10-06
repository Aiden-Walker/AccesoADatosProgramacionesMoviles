package ejTurnosEntre3;

public class IamTheOneWhoStops {
	private int nextTurn = 0;

	public synchronized void helloGuysWelcomeToMyMinecraftGameplay(String sayMyName) {
		System.out.println("Hello, I am " + sayMyName);
		if (nextTurn <= 1) {
			nextTurn++;
		} else {
			nextTurn = 0;
		}
		notifyAll();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the nextTurn
	 */
	public int getNextTurn() {
		return nextTurn;
	}

	/**
	 * @param nextTurn the nextTurn to set
	 */
	public void setNextTurn(int nextTurn) {
		this.nextTurn = nextTurn;
	}
}
