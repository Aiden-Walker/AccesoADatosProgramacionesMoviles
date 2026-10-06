package ejercicioTipoExamenArticulo;

import java.util.Comparator;

public class CompArtTotalVentas implements Comparator<Articulo> {
	private ModeloDeDatos mod;

	public CompArtTotalVentas(ModeloDeDatos mod) {
		super();
		this.mod = mod;
	}

	@Override
	public int compare(Articulo o1, Articulo o2) {
		int unidadesVendidasO1 = mod.totalUnidadesVendidas(o1);
		int unidadesVendidasO2 = mod.totalUnidadesVendidas(o2);
		return Integer.compare(unidadesVendidasO2, unidadesVendidasO1);
	}

}
