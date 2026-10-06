package examen3EVJoseMiguelBarberoJimenez;

public class SCP {
	int numero;
	String codename;
	String clasificacion;
	String tipo;
	String procedimientos_de_contencion;
	String descripcion;
	String adendo;
	String incidentes;
	public SCP(int numero, String codename, String clasificacion, String tipo, String procedimientos_de_contencion,
			String descripcion) {
		super();
		this.numero = numero;
		this.codename = codename;
		this.clasificacion = clasificacion;
		this.tipo = tipo;
		this.procedimientos_de_contencion = procedimientos_de_contencion;
		this.descripcion = descripcion;
	}
	public SCP(int numero, String codename, String clasificacion, String tipo, String procedimientos_de_contencion,
			String descripcion, String adendo, String incidentes) {
		super();
		this.numero = numero;
		this.codename = codename;
		this.clasificacion = clasificacion;
		this.tipo = tipo;
		this.procedimientos_de_contencion = procedimientos_de_contencion;
		this.descripcion = descripcion;
		this.adendo = adendo;
		this.incidentes = incidentes;
	}
	public SCP(int numero, String codename, String clasificacion, String tipo, String procedimientos_de_contencion,
			String descripcion, String adendo) {
		super();
		this.numero = numero;
		this.codename = codename;
		this.clasificacion = clasificacion;
		this.tipo = tipo;
		this.procedimientos_de_contencion = procedimientos_de_contencion;
		this.descripcion = descripcion;
		this.adendo = adendo;
	}
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * @return the codename
	 */
	public String getCodename() {
		return codename;
	}
	/**
	 * @param codename the codename to set
	 */
	public void setCodename(String codename) {
		this.codename = codename;
	}
	/**
	 * @return the clasificacion
	 */
	public String getClasificacion() {
		return clasificacion;
	}
	/**
	 * @param clasificacion the clasificacion to set
	 */
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the procedimientos_de_contencion
	 */
	public String getProcedimientos_de_contencion() {
		return procedimientos_de_contencion;
	}
	/**
	 * @param procedimientos_de_contencion the procedimientos_de_contencion to set
	 */
	public void setProcedimientos_de_contencion(String procedimientos_de_contencion) {
		this.procedimientos_de_contencion = procedimientos_de_contencion;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the adendo
	 */
	public String getAdendo() {
		return adendo;
	}
	/**
	 * @param adendo the adendo to set
	 */
	public void setAdendo(String adendo) {
		this.adendo = adendo;
	}
	/**
	 * @return the incidentes
	 */
	public String getIncidentes() {
		return incidentes;
	}
	/**
	 * @param incidentes the incidentes to set
	 */
	public void setIncidentes(String incidentes) {
		this.incidentes = incidentes;
	}
}
