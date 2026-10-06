package ejercicioTipoExamenGuerra;

import java.util.Arrays;

import ejercicioTipoExamenListaMiembros.Miembro;

public class Gestion {
	private static Guerra tablaGuerras[];
	private static int nGuerras;

	public static void main(String args[]) {

		// Datos de ejemplo para poder hacer pruebas
		// Creación de varios países.

		Pais francia = new Pais("Francia");
		Pais reinoUnido = new Pais("Reino Unido");
		Pais rusia = new Pais("Rusia");
		Pais usa = new Pais("Estados Unidos");
		Pais austria = new Pais("Austria");
		Pais hungría = new Pais("Hungría");
		Pais turquía = new Pais("Turquía");
		Pais alemania = new Pais("Alemania");
		Pais japón = new Pais("Japón");
		Pais italia = new Pais("Italia");
		Pais polonia = new Pais("Polonia");

		// Creación de Bandos para las distintas guerras

		Bando aliados1 = new Bando("Aliados I");
		Bando centroeuropeo = new Bando("Centro Europeo");
		Bando aliados2 = new Bando("Aliados II");
		Bando eje = new Bando("Eje Berlín-Roma-Tokio");

		// Añadimos a cada bando de las guerras los países que lo componían.

		aliados1.anyadePais(francia);
		aliados1.anyadePais(reinoUnido);
		aliados1.anyadePais(usa);
		aliados1.anyadePais(rusia);

		centroeuropeo.anyadePais(austria);
		centroeuropeo.anyadePais(hungría);
		centroeuropeo.anyadePais(turquía);
		centroeuropeo.anyadePais(alemania);

		aliados2.anyadePais(francia);
		aliados2.anyadePais(polonia);
		aliados2.anyadePais(reinoUnido);
		aliados2.anyadePais(usa);
		aliados2.anyadePais(rusia);

		eje.anyadePais(alemania);
		eje.anyadePais(italia);
		eje.anyadePais(japón);

		// creamos varias batallas

		Batalla tannenberg = new Batalla("Tannenberg", rusia, alemania);
		Batalla verdún = new Batalla("Verdún", francia, alemania);
		Batalla gallipoli = new Batalla("Gallipoli", francia, turquía);
		Batalla elAlamein = new Batalla("El Alamein", reinoUnido, alemania);
		Batalla midway = new Batalla("Midway", usa, japón);
		Batalla stalingrado = new Batalla("Stalingrado", alemania, rusia);
		Batalla normandía = new Batalla("Normandía", usa, alemania);

		// creamos dos guerras, con sus respectivos bandos

		Guerra mundialI = new Guerra("Primera guerra mundial", aliados1, centroeuropeo);
		Guerra mundialII = new Guerra("Segunda guerra mundial", eje, aliados2);

		// colocamos las batallas en las guerras correspondientes

		mundialI.añadeBatalla(tannenberg);
		mundialI.añadeBatalla(verdún);
		mundialI.añadeBatalla(gallipoli);

		mundialII.añadeBatalla(elAlamein);
		mundialII.añadeBatalla(midway);
		mundialII.añadeBatalla(stalingrado);
		mundialII.añadeBatalla(normandía);

		// hacemos que cada país sepa en qué guerras ha participado

		francia.participóEn(mundialI);
		reinoUnido.participóEn(mundialI);
		rusia.participóEn(mundialI);
		usa.participóEn(mundialI);
		austria.participóEn(mundialI);
		hungría.participóEn(mundialI);
		turquía.participóEn(mundialI);
		alemania.participóEn(mundialI);

		japón.participóEn(mundialII);
		italia.participóEn(mundialII);
		alemania.participóEn(mundialII);
		polonia.participóEn(mundialII);
		francia.participóEn(mundialII);
		reinoUnido.participóEn(mundialII);
		rusia.participóEn(mundialII);
		usa.participóEn(mundialII);

		// por último colocamos las guerras en la tabla de Guerras de la gestión

		tablaGuerras = new Guerra[10];
		nGuerras = 0;

		tablaGuerras[nGuerras++] = mundialI;
		tablaGuerras[nGuerras++] = mundialII;

		// mostramos los datos almacenados

		mostrarTablaGuerras();
		System.out.println(Arrays.toString(usa.posiblesEnemigos()));

		System.out.println(usa.haSidoAliadoDe(reinoUnido));
		System.out.println(usa.haSidoAliadoDe(alemania));

		System.out.println(aliados2.equals(aliados2));
		System.out.println(aliados2.equals(eje));

		System.out.println(Gestion.mayorConflagracion());
		System.out.println(Gestion.masBeligerante());
	}

	private static void mostrarTablaGuerras() {
		for (int i = 0; i < nGuerras; i++)
			System.out.println(tablaGuerras[i]);
	}

	public static void anyadePais(Pais m, Pais[] tablaAUsar, int nPaises) {
		tablaAUsar[nPaises] = m;
	}

	public static boolean contienePais(Pais m, Pais[] tablaACheckar, int nElementos) {
		for (int i = 0; i < nElementos; i++) {
			if (tablaACheckar[i].equals(m)) {
				return true;
			}
		}
		return false;
	}

	public static boolean anyadePaisSinRepetir(Pais p, Pais[] tablaAUsar, int nElementos) {
		boolean anyadido = false;
		if (!contienePais(p, tablaAUsar, nElementos)) {
			anyadePais(p, tablaAUsar, nElementos);
			anyadido = true;
		}
		return anyadido;
	}

	public static Guerra mayorConflagracion() {
		Guerra bigWar = tablaGuerras[0];
		for (int i = 0; i < nGuerras; i++) {
			if ((Gestion.tablaGuerras[i].compareTo(bigWar) > 0)) {
				bigWar = Gestion.tablaGuerras[i];
			}
		}
		return bigWar;
	}

	public static Pais masBeligerante() {
		Pais paisMasAgresivo = tablaGuerras[0].getBandoA().getPais(0);
		for (int i = 0; i < nGuerras; i++) {
			for (int j = 0; j < tablaGuerras[i].getBandoA().getnPaises(); j++) {
				if (tablaGuerras[i].getBandoA().getPais(j).getNBatallas() > paisMasAgresivo.getNBatallas()) {
					paisMasAgresivo = tablaGuerras[i].getBandoA().getPais(j);
				}
			}
			for (int j = 0; j < tablaGuerras[i].getBandoB().getnPaises(); j++) {
				if (tablaGuerras[i].getBandoB().getPais(j).getNBatallas() > paisMasAgresivo.getNBatallas()) {
					paisMasAgresivo = tablaGuerras[i].getBandoB().getPais(j);
				}
			}
		}
		return paisMasAgresivo;
	}

}
