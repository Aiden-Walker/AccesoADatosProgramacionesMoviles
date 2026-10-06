package ejSocketsBoletin3;
import java.io.*;
import java.net.*;

public class SocketsEj9Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
		int port = 11037;
		String host = "127.0.0.1";
		Socket aRandomSocket = new Socket(host, port);
		
		aRandomSocket.close();
	}
}
