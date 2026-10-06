package tema4PSPSockets;

import java.io.*;
import java.net.*;

public class SocketServidor {

	public SocketServidor() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		int port = 11037;
		ServerSocket server = null;
		server = new ServerSocket(port);
		System.out.println("El servidor esta escuchando en: " + server.getLocalPort());
		Socket cl1 = server.accept();
		PrintWriter mandaMensajes = new PrintWriter(cl1.getOutputStream(), true);
		String skibidiSigma = ("Hello guys, today we have a top 10 Minecraft gameplay");
		mandaMensajes.println(skibidiSigma);
		//mandaMensajes.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(cl1.getInputStream()));
		String mensajeRecibido = br.readLine();
		System.out.println(mensajeRecibido);
		br.close();
		server.close();
	}

}
