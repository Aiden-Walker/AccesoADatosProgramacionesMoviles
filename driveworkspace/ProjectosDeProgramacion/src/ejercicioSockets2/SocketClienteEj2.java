package ejercicioSockets2;

import java.util.Scanner;
import java.io.*;
import java.net.*;

public class SocketClienteEj2 {

	public SocketClienteEj2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		int port = 11037;
		String host = "127.0.0.1";
		Socket aGoofyAhhSocket = new Socket(host, port);
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero entero");
		int numeroAEnviar = sc.nextInt();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(aGoofyAhhSocket.getOutputStream()));
		bw.write(numeroAEnviar);
		bw.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(aGoofyAhhSocket.getInputStream()));
		int numeroCuadradoRecibido = br.read();
		System.out.println(numeroCuadradoRecibido);
		sc.close();
		aGoofyAhhSocket.close();
	}
}
