package ficherosXML;

import java.util.Arrays;

public class Receta {
	String titulo;
	Ingrediente[] ingredientes = new Ingrediente[2];
	String procedimiento;
	String tiempo;

	public Receta(String titulo, Ingrediente[] ingredientes, String procedimiento, String tiempo) {
		super();
		this.titulo = titulo;
		this.ingredientes = ingredientes;
		this.procedimiento = procedimiento;
		this.tiempo = tiempo;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the ingredientes
	 */
	public Ingrediente[] getIngredientes() {
		return ingredientes;
	}

	/**
	 * @param ingredientes the ingredientes to set
	 */
	public void setIngredientes(Ingrediente[] ingredientes) {
		this.ingredientes = ingredientes;
	}

	/**
	 * @return the procedimiento
	 */
	public String getProcedimiento() {
		return procedimiento;
	}

	/**
	 * @param procedimiento the procedimiento to set
	 */
	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	/**
	 * @return the tiempo
	 */
	public String getTiempo() {
		return tiempo;
	}

	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "Receta [titulo=" + titulo + ", ingredientes=" + Arrays.toString(ingredientes) + ", procedimiento="
				+ procedimiento + ", tiempo=" + tiempo + "]";
	}
}
