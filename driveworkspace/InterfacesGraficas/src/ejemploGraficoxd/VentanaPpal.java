package ejemploGraficoxd;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPpal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vista vista;
	public VentanaPpal(Vista vista) {
		setTitle("studentManagement");
		this.vista=vista;
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JTextArea myText = new JTextArea();
		scrollPane.setViewportView(myText);
		
		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);
		
		JMenu studentMenu = new JMenu("Alumnos");
		menuBar.add(studentMenu);
		
		JMenuItem highStudentMenuItem = new JMenuItem("Alta");
		studentMenu.add(highStudentMenuItem);
	}

}
