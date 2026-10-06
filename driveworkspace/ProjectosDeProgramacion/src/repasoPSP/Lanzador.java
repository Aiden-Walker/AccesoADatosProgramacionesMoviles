import java.io.*;

public class Lanzador {
	public static void main(String[] args) throws IOException, InterruptedException {
		//args[0]: texto.txt
		//args[1] con rutas absolutas: "C:\Users\inmac\Desktop\HnosMachado 21-22\eclipsePRY2122\UD01_Palabras\bin"
	    //args[1] con rutas relativas: .\bin
		String ficheroEntrada = args[0];
	    String classpathProcesadorFichero = args[1];

	    String[] palabras = {
	    		"servicio", "hilo", "proceso", "multihilo", "concurrencia"};
	    
	    /* Se lanzan los procesos*/
	    for (int i = 0; i < palabras.length; i++) {
	        String fichErrores = "Errores_" + palabras[i] + ".txt";
	        
	        ProcessBuilder pb;
	        pb = new ProcessBuilder("java", "-cp", classpathProcesadorFichero, 
	        		                "ProcesadorFichero", 
	        		                ficheroEntrada,
	        		                palabras[i], 
	        		                palabras[i] + ".txt");
	        
	        //Si hay algún error, almacenarlo en un fichero
	        pb.redirectError(new File(fichErrores));
	       
	        Process pr = pb.start();
	        //Fin del for
	    }
	    /* Esperamos un poco*/
	    Thread.sleep(3000);
	    /* La recogida de resultados se deja como ejercicio al lector. ;) */
	}
}
