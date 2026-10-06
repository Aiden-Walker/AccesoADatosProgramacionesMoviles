package ejSocketsBoletin3;

import java.io.*;
import java.net.*;

public class HiloSincronoEj9 extends Thread{
	int numToGuess;
	Socket connection;
	int tries;
	public HiloSincronoEj9(int numToGuess, Socket conexionAUsar, int attempts) {
		super();
		this.numToGuess = numToGuess;
		this.connection = conexionAUsar;
		this.tries = attempts;
	}
	private void Synchronized() {
		
	}
		public void run() {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			bw.write("Attempt to guess the number");
			bw.flush();
			int fails = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while(fails < tries) {
				
			}
		}
	}
}
