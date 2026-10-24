package fichXMLSAX;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import ficherosXML.Reserva;

public class Tren {
	private List<Vagon> vagones = new ArrayList<>();
	private Maquinista maquinista;

	public Tren() {
		super();
	}

	public Tren(List<Vagon> vagones, Maquinista maquinista) {
		super();
		this.vagones = vagones;
		this.maquinista = maquinista;
	}

	public Tren(Maquinista maquinista) {
		super();
		this.maquinista = maquinista;
	}

	public List<Vagon> getVagones() {
		return vagones;
	}

	public void setVagones(List<Vagon> vagones) {
		this.vagones = vagones;
	}

	public Maquinista getMaquinista() {
		return maquinista;
	}

	public void setMaquinista(Maquinista maquinista) {
		this.maquinista = maquinista;
	}

	public void addVagon(Vagon vagon) {
		this.vagones.add(vagon);
	}

	public void guardarVagonesEnFicheroBinario(File ficheroVagones) {
		try (ObjectOutputStream objectOS = new ObjectOutputStream(new FileOutputStream(ficheroVagones))) {
			for (Vagon theWagon : this.vagones) {
				objectOS.writeObject(theWagon);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean cargarVagonesDeFicheroBinario(File ficheroVagones) {
		boolean status = ficheroVagones.exists();
		if (status) {
			try (ObjectInputStream objectIS = new ObjectInputStream(new FileInputStream(ficheroVagones))) {
				while (true) {
					Vagon vagonActual = (Vagon) objectIS.readObject();
					this.vagones.add(vagonActual);
				}
			} catch (FileNotFoundException e) {
				System.out.println("El archivo no se ha encontrado, porfavor intenta otro nombre");
			} catch (EOFException e) {
				System.out.println("El fin del archivo ha sido alcanzado");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}

	public void guardarVagonesEnFicheroXML(File ficheroXML) {
		Scanner sc = new Scanner(System.in);
		DocumentBuilderFactory teFaltaFabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder bobElConstructor;

		try {
			bobElConstructor = teFaltaFabrica.newDocumentBuilder();
			DOMImplementation implementacionOG = bobElConstructor.getDOMImplementation();
			Document documentoDeAdecuadoTexto = implementacionOG.createDocument(null, "tren", null);
			documentoDeAdecuadoTexto.setXmlVersion("1.0");

			for (Vagon reVagon : this.vagones) {
				Element root /* Raiz en ingles no? */ = documentoDeAdecuadoTexto.createElement("vagon");
				documentoDeAdecuadoTexto.getDocumentElement().appendChild(root);
				crearElementoXML("capacidad-max", Integer.toString(reVagon.getCapacidadMax()), root,
						documentoDeAdecuadoTexto);
				crearElementoXML("mercancia", reVagon.getTipoMercancia(), root, documentoDeAdecuadoTexto);
			}
			Source fuente = new DOMSource(documentoDeAdecuadoTexto);
			Result resultado = new StreamResult(new java.io.File(ficheroXML.toString()));
			Transformer transformador = TransformerFactory.newInstance().newTransformer();
			transformador.transform(fuente, resultado);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {

		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarMercanciaDeXMLSAX(File ficheroXML) {
		try {

			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			parserFactory.setNamespaceAware(true);
			SAXParser parser = parserFactory.newSAXParser();
			XMLReader procesadorXML = parser.getXMLReader();

			GestionContenido gestor = new GestionContenido();
			procesadorXML.setContentHandler(gestor);

			InputSource fileXML = new InputSource(new FileInputStream(ficheroXML));
			procesadorXML.parse(fileXML);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public Element crearElementoXML(String datoAmeter, String funValue, Element rooty, Document documentito) {
		/*
		 * De verdad que siento las graciosadas por ejemplo en los nombres de las cosas
		 * pero es que la cabeza me va a reventar
		 */
		Element elementomori = documentito.createElement(datoAmeter);
		Text muchoTexto = documentito.createTextNode(funValue);
		rooty.appendChild(elementomori);
		elementomori.appendChild(muchoTexto);
		return elementomori;
	}
}
