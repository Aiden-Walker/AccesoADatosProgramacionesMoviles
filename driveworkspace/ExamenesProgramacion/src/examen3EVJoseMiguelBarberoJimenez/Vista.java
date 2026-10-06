package examen3EVJoseMiguelBarberoJimenez;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
public class Vista extends JFrame{
	private JTabbedPane tabbedPane;
	private JPanel scpStoring;
	private JPanel guardaSCPanel;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JLabel labelNumeroSCP;
	private JTextField textFieldNumeroSCP;
	private JLabel lblNombreEnClave;
	private JTextField tFieldNmbrClave;
	private JLabel lblSCPClass;
	private JLabel lblClasificacion;
	private JTextField textFieldClasificacion;
	private JLabel lblTipo;
	private JTextField textFieldTipo;
	private JTextArea textAreaProcedimientosContencion;
	private JTextArea textAreaIncidentes;
	private JTextArea TextAreaAdendos;
	private JCheckBox chckbxAdendos;
	private JCheckBox chckbxIncidente;
	private JTabbedPane tabbedPane_Borrado_Y_Listado;
	private JPanel panelBorrado;
	private JPanel panelListado;
	private JButton btnBorrarSujeto;
	private JButton btnCancelarBorrado;
	private JLabel lblnumSCPABorrar;
	private JTextField textFieldNumeroSCPAborrar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblSCP;
	private JTextArea textArea;
	private JButton btnNewButton;
	private JTextField textFieldListadoEspecifico;
	private JButton btnListadoEspecifico;
	private JButton btnListadoIncidentes;
	private JButton btnListadoSCPsDecomisionados;
	private JTabbedPane tabbedPaneDecomisionYComparacion;
	private JPanel panel;
	private JPanel panel_1;
	private JTextArea textArea_1;
	private JRadioButton rdbtnDesignacion;
	private JRadioButton rdbtnListarPorNombreClave;
	public Vista() {
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.NORTH);
		scpStoring = new JPanel();
		tabbedPane.addTab("Registro de SCPs", new ImageIcon(Vista.class.getResource("/examen3EVJoseMiguelBarberoJimenez/Logo_SCP_Foundation.jpg")), scpStoring, null);
		guardaSCPanel = new JPanel();
		guardaSCPanel.setBorder(new TitledBorder(null, "Registro SCPs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		guardaSCPanel.setToolTipText("Skibidi");
		
		btnRegistrar = new JButton("Registrar");
		
		btnCancelar = new JButton("Cancelar");
		GroupLayout gl_scpStoring = new GroupLayout(scpStoring);
		gl_scpStoring.setHorizontalGroup(
			gl_scpStoring.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_scpStoring.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_scpStoring.createParallelGroup(Alignment.TRAILING)
						.addComponent(guardaSCPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
						.addGroup(gl_scpStoring.createSequentialGroup()
							.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_scpStoring.setVerticalGroup(
			gl_scpStoring.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_scpStoring.createSequentialGroup()
					.addContainerGap()
					.addComponent(guardaSCPanel, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_scpStoring.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegistrar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		
		labelNumeroSCP = new JLabel("Numero SCP");
		
		textFieldNumeroSCP = new JTextField();
		textFieldNumeroSCP.setColumns(10);
		
		lblNombreEnClave = new JLabel("Nombre en Clave");
		
		tFieldNmbrClave = new JTextField();
		tFieldNmbrClave.setColumns(10);
		
		lblSCPClass = new JLabel("");
		lblSCPClass.setIcon(new ImageIcon(Vista.class.getResource("/examen3EVJoseMiguelBarberoJimenez/safescp.png")));
		
		lblClasificacion = new JLabel("Clasificacion");
		
		textFieldClasificacion = new JTextField();
		textFieldClasificacion.setColumns(10);
		
		lblTipo = new JLabel("Tipo");
		
		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		
		textAreaProcedimientosContencion = new JTextArea();
		
		textAreaIncidentes = new JTextArea();
		textAreaIncidentes.setEnabled(false);
		
		TextAreaAdendos = new JTextArea();
		TextAreaAdendos.setEnabled(false);
		
		chckbxAdendos = new JCheckBox("Tiene el SCP un adendo?");
		
		chckbxIncidente = new JCheckBox("Tiene el SCP algun incidente?");
		GroupLayout gl_guardaSCPanel = new GroupLayout(guardaSCPanel);
		gl_guardaSCPanel.setHorizontalGroup(
			gl_guardaSCPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_guardaSCPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_guardaSCPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_guardaSCPanel.createSequentialGroup()
							.addGroup(gl_guardaSCPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(TextAreaAdendos, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(textAreaProcedimientosContencion, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxAdendos)
								.addComponent(chckbxIncidente, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
							.addGap(67)
							.addComponent(textAreaIncidentes, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_guardaSCPanel.createSequentialGroup()
							.addGroup(gl_guardaSCPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_guardaSCPanel.createSequentialGroup()
									.addComponent(labelNumeroSCP, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldNumeroSCP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNombreEnClave))
								.addGroup(gl_guardaSCPanel.createSequentialGroup()
									.addComponent(lblClasificacion, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldClasificacion, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_guardaSCPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldTipo, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(tFieldNmbrClave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
							.addComponent(lblSCPClass))))
		);
		gl_guardaSCPanel.setVerticalGroup(
			gl_guardaSCPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_guardaSCPanel.createSequentialGroup()
					.addGroup(gl_guardaSCPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_guardaSCPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_guardaSCPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelNumeroSCP)
								.addComponent(textFieldNumeroSCP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombreEnClave)
								.addComponent(tFieldNmbrClave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_guardaSCPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblClasificacion)
								.addComponent(textFieldClasificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTipo)
								.addComponent(textFieldTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblSCPClass))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_guardaSCPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textAreaIncidentes, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_guardaSCPanel.createSequentialGroup()
							.addComponent(chckbxIncidente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxAdendos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textAreaProcedimientosContencion, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(TextAreaAdendos, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		guardaSCPanel.setLayout(gl_guardaSCPanel);
		scpStoring.setLayout(gl_scpStoring);
		
		tabbedPane_Borrado_Y_Listado = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Borrado Y Listado de SCPs", new ImageIcon(Vista.class.getResource("/examen3EVJoseMiguelBarberoJimenez/Logo_SCP_Foundation.jpg")), tabbedPane_Borrado_Y_Listado, null);
		
		panelBorrado = new JPanel();
		tabbedPane_Borrado_Y_Listado.addTab("Borrado", null, panelBorrado, null);
		
		btnBorrarSujeto = new JButton("Borrar Sujeto");
		
		btnCancelarBorrado = new JButton("Cancelar Borrado del sujeto");
		
		lblnumSCPABorrar = new JLabel("Numero del SCP a Borrar");
		
		textFieldNumeroSCPAborrar = new JTextField();
		textFieldNumeroSCPAborrar.setColumns(10);
		
		lblNewLabel = new JLabel("PD: No sabia que mas meter aqu\u00ED, a si que simplemente te voy a decir que Jason sale en");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_1 = new JLabel("Dead By Daylight el 15 de Junio, -Dr. Abe Stern");
		
		lblSCP = new JLabel("");
		lblSCP.setIcon(new ImageIcon(Vista.class.getResource("/examen3EVJoseMiguelBarberoJimenez/securecontainprotecrt.png")));
		GroupLayout gl_panelBorrado = new GroupLayout(panelBorrado);
		gl_panelBorrado.setHorizontalGroup(
			gl_panelBorrado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBorrado.createSequentialGroup()
					.addGroup(gl_panelBorrado.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBorrado.createSequentialGroup()
							.addGap(97)
							.addGroup(gl_panelBorrado.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelBorrado.createSequentialGroup()
									.addComponent(lblnumSCPABorrar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldNumeroSCPAborrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelBorrado.createSequentialGroup()
									.addComponent(btnBorrarSujeto)
									.addGap(93)
									.addComponent(btnCancelarBorrado, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panelBorrado.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panelBorrado.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelBorrado.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSCP)
								.addComponent(lblNewLabel))))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_panelBorrado.setVerticalGroup(
			gl_panelBorrado.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelBorrado.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBorrado.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblnumSCPABorrar)
						.addComponent(textFieldNumeroSCPAborrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(lblSCP, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panelBorrado.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrarSujeto)
						.addComponent(btnCancelarBorrado))
					.addContainerGap())
		);
		panelBorrado.setLayout(gl_panelBorrado);
		
		panelListado = new JPanel();
		tabbedPane_Borrado_Y_Listado.addTab("Listado de Sujetos", null, panelListado, null);
		
		textArea = new JTextArea();
		
		btnNewButton = new JButton("Listado General");
		
		textFieldListadoEspecifico = new JTextField();
		textFieldListadoEspecifico.setColumns(10);
		
		btnListadoEspecifico = new JButton("Listado Especifico");
		
		btnListadoIncidentes = new JButton("Listado De Incidentes");
		
		btnListadoSCPsDecomisionados = new JButton("Listar SCPs Decomisionados/Eliminados");
		GroupLayout gl_panelListado = new GroupLayout(panelListado);
		gl_panelListado.setHorizontalGroup(
			gl_panelListado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelListado.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelListado.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
						.addComponent(btnNewButton)
						.addGroup(gl_panelListado.createSequentialGroup()
							.addComponent(btnListadoEspecifico)
							.addGap(26)
							.addComponent(textFieldListadoEspecifico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnListadoIncidentes)
						.addComponent(btnListadoSCPsDecomisionados))
					.addContainerGap())
		);
		gl_panelListado.setVerticalGroup(
			gl_panelListado.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelListado.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelListado.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnListadoEspecifico)
						.addComponent(textFieldListadoEspecifico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnListadoIncidentes)
					.addGap(18)
					.addComponent(btnListadoSCPsDecomisionados)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
		);
		panelListado.setLayout(gl_panelListado);
		
		tabbedPaneDecomisionYComparacion = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Decomision", new ImageIcon(Vista.class.getResource("/examen3EVJoseMiguelBarberoJimenez/Logo_SCP_Foundation.jpg")), tabbedPaneDecomisionYComparacion, null);
		
		panel = new JPanel();
		tabbedPaneDecomisionYComparacion.addTab("Decomision de Sujetos", null, panel, null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 496, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 356, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		panel_1 = new JPanel();
		tabbedPaneDecomisionYComparacion.addTab("Comparacion de sujetos", null, panel_1, null);
		
		textArea_1 = new JTextArea();
		
		rdbtnDesignacion = new JRadioButton("Comparar por numero de designacion");
		
		rdbtnListarPorNombreClave = new JRadioButton("Comparar por orden alfabetico de nombre en clave");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnDesignacion)
					.addContainerGap(381, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnListarPorNombreClave)
					.addContainerGap(381, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(137, Short.MAX_VALUE)
					.addComponent(rdbtnListarPorNombreClave)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnDesignacion)
					.addGap(18)
					.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
		);
		panel_1.setLayout(gl_panel_1);
	}
}
