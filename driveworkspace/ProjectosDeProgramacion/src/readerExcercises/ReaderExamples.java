package readerExcercises;
import java.io.*;
public class ReaderExamples {

	public ReaderExamples() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try (FileReader in = new FileReader("Skibidi.txt")){
			String text = "";
			int c = in.read();
			while(c != -1) {
				text = text +(char)c;
				c = in.read();
			}
			System.out.println(text);
		} catch (IOException e) {
			System.out.println(e);
		}
		try (BufferedReader br = new BufferedReader(new FileReader("Skibidi.txt"))){
			String linea = br.readLine();
			System.out.println(linea);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
