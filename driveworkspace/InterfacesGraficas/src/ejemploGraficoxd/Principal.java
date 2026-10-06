package ejemploGraficoxd;

public class Principal {
	private Modelo modelo;
	private Vista vista;

	public static void main(String[] args) {
		new Principal();
	}

	public Principal() {
		super();
		this.modelo = new Modelo();
		this.vista = new Vista(this);
	}
}
