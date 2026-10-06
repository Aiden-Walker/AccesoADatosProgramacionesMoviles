package customPrograms;

public class DreadnoughtCall {

	public static void main(String[] args) {
		int royalNationTickets = 300;
		int goldenEmpireTickets = 75;
		int playerCount = 20;
		String firstTeam = "Royal_Nation";
		String secondTeam = "Golden_Empire";
		if(tryDeployDreadnought(firstTeam, secondTeam, royalNationTickets, goldenEmpireTickets, playerCount) == "");
		
	}
	private class Dreadnought{
		String team;
		int health = 9000;
	}

	static String tryDeployDreadnought(String teamA, String teamB, int ticketsATeam, int ticketsBTeam,
			int serverCount) {
		String dreadnoughtTeam = "";
		if (ticketsATeam <= 75 && ticketsBTeam >= 300 && serverCount >= 20) {
			dreadnoughtTeam = teamA;
		}
		if (ticketsBTeam <= 75 && ticketsATeam >= 300 && serverCount >= 20) {
			dreadnoughtTeam = teamB;
		}
		return dreadnoughtTeam;
	}
}
