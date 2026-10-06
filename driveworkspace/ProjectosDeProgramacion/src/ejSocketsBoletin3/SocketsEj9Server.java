package ejSocketsBoletin3;

import java.io.*;
import java.net.*;

public class SocketsEj9Server {
	public static void main(String[] args) throws IOException {
		int port = 11037;
		ServerSocket server = null;
		server = new ServerSocket(port);
		int numToGuess = (int) Math.random() * 100;
		while (true) {
			Socket cl = server.accept();
			HiloSincronoEj9 sharedThread = new HiloSincronoEj9(numToGuess, cl, 5);
		}
	}
}
