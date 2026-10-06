package ejTipoExamenFeria;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Modelo {
	ListaPrecios listaPrecios;
	ListaSocios listaSocios;
	HashMap<Socio, LinkedList<Consumicion>> listaCuentas;

	public Modelo() {
		this.listaPrecios = new ListaPrecios();
		this.listaSocios = new ListaSocios();
		this.listaCuentas = new HashMap<Socio, LinkedList<Consumicion>>();
	}

	public boolean aniadeArticulo(String nombreArticulo, String tamanyoArticulo, float precio) {
		boolean insertedNew = false;
		Articulo articleToInsert = new Articulo(nombreArticulo, tamanyoArticulo);
		if (listaPrecios.put(articleToInsert, precio) == null) {
			insertedNew = true;
		}
		return insertedNew;
	}

	public boolean borraArticulo(String nombre, String tamanio) {
		boolean wasRemoved = false;
		if (listaPrecios.remove(nombre, tamanio) == true) {
			wasRemoved = true;
		}
		return wasRemoved;
	}

	public boolean hayCuentaPendienteConEseArticulo(String art, String tamanio) {
		boolean isAccountPending = false;
		Articulo article = new Articulo(art, tamanio);
		Iterator<LinkedList<Consumicion>> accountItr = listaCuentas.values().iterator();
		while (accountItr.hasNext() && !isAccountPending) {
			LinkedList<Consumicion> currentReview = accountItr.next();
			for (Consumicion c : currentReview) {
				if (c.getArticulo().equals(article)) {
					isAccountPending = true;
				}
			}
		}
		return isAccountPending;
	}

	public boolean aniadeConsumicion(Socio socio, Articulo articulo, int cantidad) {
		boolean wasAdded = false;
		Consumicion skibidi = new Consumicion(articulo, cantidad);
		LinkedList<Consumicion> miBombo = new LinkedList<Consumicion>();
		if (!listaSocios.contains(socio)) {
			listaSocios.add(socio);
		}
		if (!listaCuentas.containsKey(socio)) {
			listaCuentas.put(socio, miBombo);
			wasAdded = true;
		}
		getListaConsumiciones(socio).add(skibidi);
		return wasAdded;
	}

	/**
	 * @return the listaPrecios
	 */
	public ListaPrecios getListaPrecios() {
		return listaPrecios;
	}

	/**
	 * @param listaPrecios the listaPrecios to set
	 */
	public void setListaPrecios(ListaPrecios listaPrecios) {
		this.listaPrecios = listaPrecios;
	}

	/**
	 * @return the listaSocios
	 */
	public ListaSocios getListaSocios() {
		return listaSocios;
	}

	/**
	 * @param listaSocios the listaSocios to set
	 */
	public void setListaSocios(ListaSocios listaSocios) {
		this.listaSocios = listaSocios;
	}

	/**
	 * @return the listaCuentas
	 */
	public HashMap<Socio, LinkedList<Consumicion>> getListaCuentas() {
		return listaCuentas;
	}

	/**
	 * @param listaCuentas the listaCuentas to set
	 */
	public void setListaCuentas(HashMap<Socio, LinkedList<Consumicion>> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}

	public LinkedList<Consumicion> getListaConsumiciones(Socio socio) {
		return listaCuentas.get(socio);
	}

	public String calculaTotalCuenta(Socio socio) {
		float totalCuenta = 0.0f;
		String outtahere = "";
		LinkedList<Consumicion> lc = listaCuentas.get(socio);
		for (Consumicion c : lc) {
			float precioArtAct = (listaPrecios.get(c.getArticulo()) * c.getCantidad());
			totalCuenta += precioArtAct;
		}
		outtahere = ("La cuenta para el socio " + socio + " es: " + totalCuenta);
		return outtahere;
	}
}