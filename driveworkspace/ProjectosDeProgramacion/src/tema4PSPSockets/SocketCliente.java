package tema4PSPSockets;

import java.io.*;
import java.net.*;

public class SocketCliente {

	public SocketCliente() {
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		int port = 11037;
		String host = "127.0.0.1";
		Socket aRandomSocket = new Socket(host, port);
		BufferedReader br = new BufferedReader(new InputStreamReader(aRandomSocket.getInputStream()));
		String mensajeRecibido = br.readLine();
		System.out.println(mensajeRecibido);
		String mensajeAEnviar = ("Probando a enviar un mensaje");
		mensajeAEnviar = mensajeAEnviar.toLowerCase();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(aRandomSocket.getOutputStream()));
		bw.write(mensajeAEnviar + "\n");
		bw.flush();
		aRandomSocket.close();
	}

}
