package solControlPokemon;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaPpal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNombre;
	private JTextField campoNombre;
	private JLabel lblTipo;
	private JComboBox<String> comboTipo;
	private JLabel lblGeneracin;
	private JTextField campoGeneración;
	private JLabel lblEstadoEvolutivo;
	private JRadioButton radioMenor;
	private JRadioButton radioMedio;
	private JRadioButton radioMayor;
	private JButton botonGuardar;
	private JButton botonCancelar;
	private JPanel panel_4;
	private JLabel lblPokemonABorrar;
	private JComboBox<String> comboBorrarPokemon;
	private JButton botonBorrar;
	private JLabel lblLuchador;
	private JComboBox<String> comboLuchador1;
	private JLabel lblLuchador_1;
	private JComboBox<String> comboLuchador2;
	private JRadioButton radioGanador1;
	private JRadioButton radioGanador2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton botonGuardarCombate;
	private JButton botonCancelarCombate;
	private JPanel panel_5;
	private JRadioButton radioTodos;
	private JRadioButton radioPuntos;
	private JTextField campoPuntos;
	private JCheckBox chckbxAlfabtico;
	private JRadioButton radioCombates;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JButton botonListar;
	private JButton botonLimpiar;
	private JScrollPane scrollPane;
	private JTextArea areaListados;
	private Principal controlador;

	public VentanaPpal(Principal controlador) {
		setResizable(false);
		this.controlador = controlador;
		setTitle("Pokemons");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		panel = new JPanel();
		tabbedPane.addTab("Pokemons", null, panel, null);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "A\u00F1adir Pokemon",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Borrar Pokemon",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(127, Short.MAX_VALUE)));

		lblPokemonABorrar = new JLabel("Pokemon a borrar:");

		comboBorrarPokemon = new JComboBox<String>();

		botonBorrar = new JButton("Borrar");
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonBorrarPulsado();
			}
		});
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(botonBorrar, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
								.addGroup(gl_panel_4.createSequentialGroup()
										.addComponent(lblPokemonABorrar, GroupLayout.PREFERRED_SIZE, 104,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(comboBorrarPokemon, 0, 277, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE).addComponent(lblPokemonABorrar)
								.addComponent(comboBorrarPokemon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE).addComponent(botonBorrar)
						.addContainerGap()));
		panel_4.setLayout(gl_panel_4);

		lblNombre = new JLabel("Nombre:");

		campoNombre = new JTextField();
		campoNombre.setColumns(10);

		lblTipo = new JLabel("Tipo:");

		comboTipo = new JComboBox<String>();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] { "Acero", "Agua", "Bicho", "Drag\u00F3n",
				"El\u00E9ctrico", "Fantasma", "Fuego", "Hada", "Hielo", "Lucha", "Normal", "Planta" }));

		lblGeneracin = new JLabel("Generaci\u00F3n (1-7):");

		campoGeneración = new JTextField();
		campoGeneración.setColumns(10);

		lblEstadoEvolutivo = new JLabel("Estado Evolutivo:");

		radioMenor = new JRadioButton("Menor");
		radioMenor.setSelected(true);
		buttonGroup_1.add(radioMenor);

		radioMedio = new JRadioButton("Medio");
		buttonGroup_1.add(radioMedio);

		radioMayor = new JRadioButton("Mayor");
		buttonGroup_1.add(radioMayor);

		botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonGuardarPulsado();
			}
		});

		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonCancelarPulsado();
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addGroup(gl_panel_3
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
								.addComponent(botonGuardar, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(botonCancelar, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup().addGroup(gl_panel_3
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_3.createSequentialGroup()
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(campoNombre, GroupLayout.PREFERRED_SIZE, 167,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
										.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_3.createSequentialGroup()
														.addComponent(lblGeneracin, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(18))
												.addGroup(gl_panel_3.createSequentialGroup()
														.addComponent(lblEstadoEvolutivo).addGap(34)))
										.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
												.addComponent(campoGeneración, GroupLayout.PREFERRED_SIZE, 131,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_panel_3.createSequentialGroup()
														.addComponent(radioMenor, GroupLayout.PREFERRED_SIZE, 66,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(radioMedio, GroupLayout.PREFERRED_SIZE, 66,
																GroupLayout.PREFERRED_SIZE)))))
								.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_3.createSequentialGroup().addGap(18)
												.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 42,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(comboTipo, 0, 232, Short.MAX_VALUE))
										.addGroup(gl_panel_3.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(radioMayor,
														GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre)
								.addComponent(campoNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTipo).addComponent(comboTipo, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(lblGeneracin)
								.addComponent(campoGeneración, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(lblEstadoEvolutivo)
								.addComponent(radioMenor).addComponent(radioMedio).addComponent(radioMayor))
						.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(botonGuardar)
								.addComponent(botonCancelar))
						.addContainerGap()));
		panel_3.setLayout(gl_panel_3);
		panel.setLayout(gl_panel);

		panel_1 = new JPanel();
		tabbedPane.addTab("Combates", null, panel_1, null);

		lblLuchador = new JLabel("Luchador 1:");

		comboLuchador1 = new JComboBox<String>();

		lblLuchador_1 = new JLabel("Luchador 2:");

		comboLuchador2 = new JComboBox<String>();

		radioGanador1 = new JRadioButton("\u00A1Ganador!");
		radioGanador2 = new JRadioButton("");

		radioGanador1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				radioGanadorCambiado();
			}
		});
		radioGanador1.setSelected(true);
		buttonGroup.add(radioGanador1);

		buttonGroup.add(radioGanador2);

		botonGuardarCombate = new JButton("Guardar Combate");
		botonGuardarCombate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonGuardaCombatePulsado();
			}
		});

		botonCancelarCombate = new JButton("Cancelar");
		botonCancelarCombate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonCancelarCombatePulsado();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(botonGuardarCombate, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(botonCancelarCombate, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
						.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblLuchador, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addComponent(comboLuchador1, GroupLayout.PREFERRED_SIZE, 113,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
												.addComponent(lblLuchador_1, GroupLayout.PREFERRED_SIZE, 68,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10))
										.addGroup(gl_panel_1.createSequentialGroup().addComponent(radioGanador1)
												.addGap(116)))
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(radioGanador2)
										.addComponent(comboLuchador2, GroupLayout.PREFERRED_SIZE, 113,
												GroupLayout.PREFERRED_SIZE))
								.addGap(25)))));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(58)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(3).addComponent(lblLuchador_1))
								.addComponent(comboLuchador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblLuchador)
										.addComponent(comboLuchador1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(28)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(radioGanador1)
								.addComponent(radioGanador2))
						.addPreferredGap(ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(botonGuardarCombate)
								.addComponent(botonCancelarCombate))
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		panel_2 = new JPanel();
		tabbedPane.addTab("Listados", null, panel_2, null);

		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tipo de Listado",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 431,
										Short.MAX_VALUE)
								.addComponent(panel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 431,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE).addContainerGap()));

		areaListados = new JTextArea();
		scrollPane.setViewportView(areaListados);

		radioTodos = new JRadioButton("Todos los datos de todos los Pokemons");
		radioPuntos = new JRadioButton("Solo los Pokemon con mas puntos de: ");
		radioCombates = new JRadioButton("Todos los Combates");
		campoPuntos = new JTextField();
		chckbxAlfabtico = new JCheckBox("Alfab\u00E9tico");

		radioTodos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				radioListadosCambiado();
			}
		});
		radioTodos.setSelected(true);
		buttonGroup_2.add(radioTodos);

		radioPuntos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				radioListadosCambiado();
			}
		});
		buttonGroup_2.add(radioPuntos);

		campoPuntos.setEnabled(false);
		campoPuntos.setColumns(10);

		chckbxAlfabtico.setEnabled(false);

		radioCombates.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				radioListadosCambiado();
			}
		});
		buttonGroup_2.add(radioCombates);

		botonListar = new JButton("Listar");
		botonListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonListarPulsado();
			}
		});

		botonLimpiar = new JButton("Limpiar Campos");
		botonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonLimpiarCamposListadosPulsado();
			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addComponent(radioTodos)
						.addGroup(gl_panel_5.createSequentialGroup()
								.addComponent(radioPuntos, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(campoPuntos, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(chckbxAlfabtico))
						.addComponent(radioCombates)
						.addGroup(gl_panel_5.createSequentialGroup()
								.addComponent(botonListar, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(botonLimpiar, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_5
				.createSequentialGroup().addContainerGap().addComponent(radioTodos)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE).addComponent(radioPuntos)
						.addComponent(campoPuntos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxAlfabtico))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(radioCombates)
				.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE).addGroup(gl_panel_5
						.createParallelGroup(Alignment.BASELINE).addComponent(botonListar).addComponent(botonLimpiar))
				.addContainerGap()));
		panel_5.setLayout(gl_panel_5);
		panel_2.setLayout(gl_panel_2);
	}

	protected void botonListarPulsado() {
		if (this.radioTodos.isSelected())
			this.areaListados.setText(this.controlador.getListadoTodos());
		else if (this.radioCombates.isSelected())
			this.areaListados.setText(this.controlador.getListadoCombates());
		else {
			try {
				int mínimoPuntos = Integer.parseInt(this.campoPuntos.getText());
				if (this.chckbxAlfabtico.isSelected()) {
					this.areaListados.setText(this.controlador.getListadoAlfabeticoMayores(mínimoPuntos));
				} else {
					this.areaListados.setText(this.controlador.getListadoMayores(mínimoPuntos));
				}

			} catch (NumberFormatException e) {
				this.error("Debe introducir un valor numérico en el campo puntos.");
			}
		}

	}

	protected void botonLimpiarCamposListadosPulsado() {
		this.radioTodos.setSelected(true);
		this.areaListados.setText("");
	}

	protected void radioListadosCambiado() {
		if (!this.radioPuntos.isSelected()) {
			this.campoPuntos.setText("");
			this.chckbxAlfabtico.setSelected(false);
		}
		this.campoPuntos.setEnabled(this.radioPuntos.isSelected());
		this.chckbxAlfabtico.setEnabled(this.radioPuntos.isSelected());

	}

	protected void botonCancelarCombatePulsado() {
		this.reseteaCamposCombates();
	}

	private void reseteaCamposCombates() {
		this.radioGanador1.setSelected(true);
		if (this.comboLuchador1.getSelectedIndex() > -1) {
			this.comboLuchador1.setSelectedIndex(0);
			this.comboLuchador2.setSelectedIndex(0);
		}
	}

	protected void radioGanadorCambiado() {
		if (this.radioGanador1.isSelected()) {
			this.radioGanador1.setText("¡Ganador!");
			this.radioGanador2.setText("");
		} else {
			this.radioGanador2.setText("¡Ganador!");
			this.radioGanador1.setText("");
		}

	}

	protected void botonGuardaCombatePulsado() {
		String nombreGanador = "";
		String nombrePerdedor = "";

		if (this.comboLuchador1.getSelectedIndex() == -1 || this.comboLuchador2.getSelectedIndex() == -1)
			this.error("Debe seleccionar dos luchadores");
		else if (this.comboLuchador1.getSelectedIndex() == this.comboLuchador2.getSelectedIndex())
			this.error("Un pokemon no puede luchar contra sí mismo.");
		else {
			if (this.radioGanador1.isSelected()) {
				nombreGanador = (String) this.comboLuchador1.getSelectedItem();
				nombrePerdedor = (String) this.comboLuchador2.getSelectedItem();
			} else {
				nombreGanador = (String) this.comboLuchador2.getSelectedItem();
				nombrePerdedor = (String) this.comboLuchador1.getSelectedItem();
			}
			boolean res = this.controlador.guardaCombate(nombreGanador, nombrePerdedor);
			if (res == false)
				this.error("Ese combate ya se había producido");
			else {
				this.msg("Combate guardado.");
				this.reseteaCamposCombates();
			}

		}
	}

	protected void botonBorrarPulsado() {
		if (this.comboBorrarPokemon.getSelectedIndex() == -1)
			this.error("Debe seleccionar un pokemon");
		else {
			this.controlador.borraPokemon((String) this.comboBorrarPokemon.getSelectedItem());
			this.msg("Pokemon borrado");
			this.actualizaTodosCombos();
		}

	}

	protected void botonCancelarPulsado() {
		this.limpiaCampos();
	}

	protected void botonGuardarPulsado() {
		if (this.campoNombre.getText().isEmpty())
			this.error("Debe escribir un nombre");
		else {
			try {
				int generación = Integer.parseInt(this.campoGeneración.getText());

				if (generación < 1 || generación > 7)
					this.error("La generación debe estar entre 1 y 7");
				else {
					String estadoEvolutivo = "";
					if (this.radioMenor.isSelected())
						estadoEvolutivo = "Menor";
					else if (this.radioMedio.isSelected())
						estadoEvolutivo = "Medio";
					else
						estadoEvolutivo = "Mayor";
					Pokemon pokemonProvisional = new Pokemon(campoNombre.getText(),
							(String) this.comboTipo.getSelectedItem(), generación, estadoEvolutivo);
					if (this.controlador.guardaPokemon(pokemonProvisional) == true) {
						this.msg("Pokemon guardado");
						this.limpiaCampos();
						this.actualizaTodosCombos();
					} else
						this.error("Ese pokemon ya existía");
				}

			} catch (NumberFormatException e) {
				this.error("Debe escribir un número en el campo generación");
			}
		}
	}

	private void actualizaTodosCombos() {
		this.actualizaCombo(this.comboBorrarPokemon);
		this.actualizaCombo(this.comboLuchador1);
		this.actualizaCombo(this.comboLuchador2);
	}

	private void actualizaCombo(JComboBox<String> combo) {
		combo.removeAllItems();
		for (Pokemon pokemon : this.controlador.getListaPokemons())
			combo.addItem(pokemon.getNombre());
	}

	private void limpiaCampos() {
		this.campoNombre.setText("");
		this.campoGeneración.setText("");
		this.radioMenor.setSelected(true);
		this.comboTipo.setSelectedIndex(0);
	}

	public void msg(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Correcto", JOptionPane.INFORMATION_MESSAGE);
	}

	public void error(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}

}
