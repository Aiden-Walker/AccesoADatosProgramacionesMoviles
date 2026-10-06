package ejercicioTipoExamenInventario;

import java.io.*;

public class Modelo {

	private Inventario inventario = new Inventario();

	public Inventario getInventario() {
		return inventario;
	}

	// a) Este método leerá los datos de productos del fichero de texto recibido por
	// parámetro, y añadirá dichos productos al modelo. Este fichero tendrá el
	// formato del fichero aportado “productos.txt”.
	// El método devolverá un entero indicando el número de productos que ha añadido
	// al modelo. Ojo, puede haber objetos que se lean pero, al estar ya contenidos
	// en el Set del Modelo, no serán añadidos, y por tanto no entrarán en ese
	// cómputo.
	public int leerFicheroTexto(File ficheroTexto) {
		int addedProducts = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(ficheroTexto))) {
			String currProduct = br.readLine();
			while (currProduct != null) {
				String[] productStrings = currProduct.split(",");
				Integer id = Integer.parseInt(productStrings[0]);
				String nombre = productStrings[1];
				Double precio = Double.parseDouble(productStrings[2]);
				Integer cantidad = Integer.parseInt(productStrings[3]);
				Producto productToAdd = new Producto(id, nombre, precio, cantidad);
				if (this.inventario.addProducto(productToAdd)) {
					addedProducts++;
				}
				currProduct = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file you're attempting to read does not exist");
		} catch (IOException e1) {
			System.out.println("Something went wrong when attempting to read or write");
		}
		return addedProducts;
	}

	// b) Este método escribirá los objetos Producto del inventario en el fichero de
	// texto que se reciba por parámetro (en el mismo formato que el archivo
	// productos.txt que se aporta.
	public void escribirFicheroTexto(File ficheroTexto) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroTexto))) {
			for (Producto p : this.inventario.getProductos()) {
				Integer id = p.getId();
				String nombre = p.getNombre();
				Double precio = p.getPrecio();
				Integer cantidad = p.getCantidad();
				String productStr = (id + "," + nombre + "," + precio + "," + cantidad + "\n");
				bw.write(productStr);
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file you are attempting to act upon does not exist");
		} catch (IOException e1) {
			System.out.println("The read or write you're attempting to do resulted in an error");
		}
	}

	// c) Este método escribirá los objetos Producto del inventario en el fichero
	// binario recibido por parámetro sólo si este archivo no existe. En este caso,
	// el método devolverá true. En el caso de que el fichero exista, el método
	// devolverá false y no escribirá nada.
	public boolean escribirFicheroBinario(File ficheroBinario) {
		if (!ficheroBinario.exists()) {
			try (ObjectOutputStream binaryWriter = new ObjectOutputStream(new FileOutputStream(ficheroBinario))) {
				for (Producto p : this.inventario.getProductos()) {
					binaryWriter.writeObject(p);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	/*
	 * In order to write or read in binary the class you're using needs to be
	 * serializable, all primitive datatypes are serializable
	 */
	// d) Este método leerá los objetos Producto escritos en el fichero binario que
	// se recibe por parámetro y los añadirá al inventario del modelo.
	public void leerFicheroBinario(File ficheroBinario) {
		try (ObjectInputStream binaryReader = new ObjectInputStream(new FileInputStream(ficheroBinario))) {
			Producto p = (Producto) binaryReader.readObject();
			while (p != null) {
				this.inventario.addProducto(p);
				p = (Producto) binaryReader.readObject();
			}
		} catch (EOFException e) {
			System.out.println("End of file");
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("You're attempting to convert to a class that does not exist");
		} catch (IOException e3) {
			System.out.println("Something went wrong while attempting to read or write, try again");
		}
	}

	// e)
	public void escribirFicheroXML(File ficheroXml) {

	}

	public void leerFicheroXML(File ficheroXml) {

	}
}
