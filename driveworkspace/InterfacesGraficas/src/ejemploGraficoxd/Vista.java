package ejemploGraficoxd;

public class Vista {
	private Principal controlador;
	private VentanaPpal ventanaPpal;
	private DialogoAltaAlumno dialogoAltaAlumno;

	public Vista(Principal principal) {
		super();
		this.controlador = principal;
		this.ventanaPpal = new VentanaPpal(this);
		this.dialogoAltaAlumno = new DialogoAltaAlumno(this);
		this.muestraVentanaPpal();
	}

	private void muestraVentanaPpal() {
		this.ventanaPpal.setVisible(true);
	}

}
