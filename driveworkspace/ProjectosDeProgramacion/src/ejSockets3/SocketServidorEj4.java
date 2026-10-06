package ejSockets3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidorEj4 {
	private static int n;

	public SocketServidorEj4(int num) {
		super();
		n = num;
	}

	public static void main(String[] args) throws IOException {
		int port = 11037;
		ServerSocket server = null;
		server = new ServerSocket(port);
		Socket cl = server.accept();
		System.out.println("El server esta escuchando en: " + server.getLocalPort());
		BufferedReader br = new BufferedReader(new InputStreamReader(cl.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(cl.getOutputStream()));
		// Inicio bucle
		for (int i = 0; i < n; i++) {
			int numeroAEnviar = i;
			cl = server.accept();
			bw.write(numeroAEnviar);
			bw.flush();
		}
		br.close();
		server.close();
	}

}
