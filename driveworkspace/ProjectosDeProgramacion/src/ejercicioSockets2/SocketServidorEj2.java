package ejercicioSockets2;

import java.io.*;
import java.net.*;

public class SocketServidorEj2 {

	public SocketServidorEj2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		int port = 11037;
		ServerSocket server = null;
		server = new ServerSocket(port);
		System.out.println("El server esta escuchando en: " + server.getLocalPort());
		Socket cl1 = server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(cl1.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(cl1.getOutputStream()));
		// Inicio bucle
		int numeroARecibir = br.read();
		System.out.println(numeroARecibir);
		int numeroAEnviar = numeroARecibir * numeroARecibir;
		bw.write(numeroAEnviar);
		bw.flush();
		br.close();
		server.close();
	}

}
