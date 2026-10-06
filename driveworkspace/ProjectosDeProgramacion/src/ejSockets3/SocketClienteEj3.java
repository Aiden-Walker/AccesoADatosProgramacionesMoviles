package ejSockets3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class SocketClienteEj3 {

	public SocketClienteEj3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		int port = 11037;
		String host = "127.0.0.1";
		Socket aGoofyAhhSocket = new Socket(host, port);
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(aGoofyAhhSocket.getInputStream()));
		int numeroRecibido = br.read();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(aGoofyAhhSocket.getOutputStream()));
		System.out.println(numeroRecibido);
		bw.close();
		//sc.close();
		aGoofyAhhSocket.close();
	}

}
