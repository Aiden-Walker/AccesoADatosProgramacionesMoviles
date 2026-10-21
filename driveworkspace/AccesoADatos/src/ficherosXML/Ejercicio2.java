package ficherosXML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio2 {

	public static void main(String[] args) {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder buildSkibidi = factoria.newDocumentBuilder();
			Document losPapeles = buildSkibidi.parse(new File("peliculas.xml"));
			losPapeles.getDocumentElement().normalize();
			System.out.printf("Root element: %s %n", losPapeles.getDocumentElement().getNodeName());
			NodeList peliculas = losPapeles.getElementsByTagName("Pelicula");
			System.out.printf("Movie elements to run through: %d %n", peliculas.getLength());
			/* Time to run through the movies */
			for (int i = 0; i < peliculas.getLength(); i++) {
				Node peliActual = peliculas.item(i);
				if (peliActual.getNodeType() == Node.ELEMENT_NODE) {
					Element elementoskibidi = (Element) peliActual;
					System.out.printf("Titulo = %s %n",
							elementoskibidi.getElementsByTagName("Titulo").item(0).getTextContent());
					System.out.printf("* Duracion = %s %n",
							elementoskibidi.getElementsByTagName("Duracion").item(0).getTextContent());
					System.out.printf("* Genero = %s %n",
							elementoskibidi.getElementsByTagName("Genero").item(0).getTextContent());
					System.out.printf("* sinopsis = %s %n",
							elementoskibidi.getElementsByTagName("sinopsis").item(0).getTextContent());
					System.out.printf("* Actor = %s %n",
							elementoskibidi.getElementsByTagName("Actor").item(0).getTextContent());
					System.out.printf("* Actor = %s %n",
							elementoskibidi.getElementsByTagName("Actor").item(0).getTextContent());
					System.out.printf("* Actor = %s %n",
							elementoskibidi.getElementsByTagName("Actor").item(0).getTextContent());
					System.out.printf("* Fecha = %s %n",
							elementoskibidi.getElementsByTagName("Fecha").item(0).getTextContent());
					System.out.printf("* Director = %s %n",
							elementoskibidi.getElementsByTagName("Director").item(0).getTextContent());
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
