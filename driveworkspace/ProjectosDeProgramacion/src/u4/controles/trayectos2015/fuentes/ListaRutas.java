package u4.controles.trayectos2015.fuentes;

import java.util.Arrays;

public class ListaRutas {
	private Ruta[] rutas;
	private int numRutas = 0;

	public ListaRutas(Ruta[] rutas) {
		super();
		setRutas(rutas);
	}

	public ListaRutas() {
		super();
		rutas = new Ruta[10];
	}

	public Ruta[] getRutas() {
		return rutas;
	}

	public int getNumRutas() {
		return numRutas;
	}

	public void setRutas(Ruta[] rutas) {
		this.rutas = rutas;
		numRutas = 0;
		for (int i = 0; i < rutas.length && rutas[i] != null; i++) {
			numRutas++;
		}
	}

	public void addRuta(Ruta r) {
		if (this.rutas.length <= this.numRutas) {
			this.rutas = Arrays.copyOf(rutas, this.rutas.length + 1);
		}
		this.rutas[numRutas++] = r;
	}

	// a
	public boolean hayRutaEntre(Ciudad origen, Ciudad destino) {
		boolean isThereRoute = false;
		for (int i = 0; i < this.numRutas && !isThereRoute; i++) {
			if (rutas[i].getOrigen().equals(origen) && rutas[i].getDestino().equals(destino)) {
				isThereRoute = true;
			}
		}
		return isThereRoute;
	}

	// b
	public boolean hayRutaDeIdaYVueltaEntre(Ciudad origen, Ciudad destino) {
		boolean isThereForthAndBack = false;
		if (this.hayRutaEntre(origen, destino) && this.hayRutaEntre(destino, origen)) {
			isThereForthAndBack = true;
		}
		return isThereForthAndBack;
	}

	// c
	public ListaRutas getRutasDesde(Ciudad origen) {
		ListaRutas skibidiList = new ListaRutas();
		for (int i = 0; i < numRutas; i++) {
			if (rutas[i].getOrigen().equals(origen)) {
				skibidiList.addRuta(rutas[i]);
			}
		}
		return skibidiList;
	}

	// d
	public Ciudad[] getCiudadesImportantes(int numHabitantes) {
		Ciudad[] bigCities = new Ciudad[10];
		int numBigCities = 0;
		for (int i = 0; i < numRutas; i++) {
			if (rutas[i].getOrigen().getNumHabitantes() >= numHabitantes
					&& !ListaRutas.isCityInserted(bigCities, rutas[i].getOrigen(), numBigCities)) {
				if (numBigCities >= bigCities.length) {
					Arrays.copyOf(bigCities, numBigCities + 1);
				}
				bigCities[numBigCities++] = rutas[i].getOrigen();
			}
			if (rutas[i].getDestino().getNumHabitantes() >= numHabitantes
					&& !ListaRutas.isCityInserted(bigCities, rutas[i].getDestino(), numBigCities)) {
				if (numBigCities >= bigCities.length) {
					Arrays.copyOf(bigCities, numBigCities + 1);
				}
				bigCities[numBigCities++] = rutas[i].getDestino();
			}
		}
		bigCities = Arrays.copyOf(bigCities, numBigCities);
		return bigCities;
	}

	public static boolean isCityInserted(Ciudad[] arrayToCheckIn, Ciudad cityToCheck, int nCities) {
		boolean isCityIn = false;
		for (int i = 0; i < nCities && !isCityIn; i++) {
			if (arrayToCheckIn[i].equals(cityToCheck)) {
				isCityIn = true;
			}
		}
		return isCityIn;
	}

	// e)
	public ListaRutas getListaOrdenada() {
		ListaRutas newRoutes = new ListaRutas();
		newRoutes.setRutas(Arrays.copyOf(rutas, numRutas));
		Arrays.sort(newRoutes.getRutas());
		return newRoutes;
	}

	@Override
	public String toString() {
		return "ListaRutas [rutas=" + Arrays.toString(Arrays.copyOf(rutas, numRutas)) + "]";
	}
}
