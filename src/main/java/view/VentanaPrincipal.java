package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controller.ControladorMarca;
import controller.ControladorPortatil;
import model.Marca;
import model.Portatil;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfModelo;
	private JTextField jtfNumeroSerie;
	private JTextField jtfFecha;
	private ButtonGroup grupoBotones;
	JRadioButton jrbProcesador1;
	JRadioButton jrbProcesador2;
	JRadioButton jrbProcesador3;
	JRadioButton jrbProcesador4;
	JComboBox<Marca> jcbMarca;
	JCheckBox jcbxVendido;
	JButton jbnPrimero;
	JButton jbnAnterior;
	JButton jbnSiguiente;
	JButton jbnUltimo;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControladorPortatil.findFirst();
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.WEST;
		gbc_toolBar.gridwidth = 3;
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		contentPane.add(toolBar, gbc_toolBar);
		
		jbnPrimero = new JButton("<<");
		jbnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		toolBar.add(jbnPrimero);
		
		jbnAnterior = new JButton("<");
		jbnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnterior();
			}
		});
		toolBar.add(jbnAnterior);
		
		jbnSiguiente = new JButton(">");
		jbnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSiguiente();
			}
		});
		toolBar.add(jbnSiguiente);
		
		jbnUltimo = new JButton(">>");
		jbnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUltimo();
			}
		});
		toolBar.add(jbnUltimo);
		
		JButton jbnNuevo = new JButton("Nuevo");
		jbnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		toolBar.add(jbnNuevo);
		
		JButton jbnGuardar = new JButton("Guardar");
		jbnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		toolBar.add(jbnGuardar);
		
		JButton jbnBorrar = new JButton("Borrar");
		jbnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		toolBar.add(jbnBorrar);
		
		JLabel lblNewLabel = new JLabel("Gestion de Ordenadores Portatiles");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 2;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Marca:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbMarca = new JComboBox<Marca>();
		GridBagConstraints gbc_jcbMarca = new GridBagConstraints();
		gbc_jcbMarca.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMarca.gridx = 1;
		gbc_jcbMarca.gridy = 3;
		contentPane.add(jcbMarca, gbc_jcbMarca);
		
		JButton jbnVerMarca = new JButton("Ver Marca");
		jbnVerMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNuevoDialogo();

			}
		});
		GridBagConstraints gbc_jbnVerMarca = new GridBagConstraints();
		gbc_jbnVerMarca.insets = new Insets(0, 0, 5, 0);
		gbc_jbnVerMarca.gridx = 2;
		gbc_jbnVerMarca.gridy = 3;
		contentPane.add(jbnVerMarca, gbc_jbnVerMarca);
		
		JLabel lblNewLabel_3 = new JLabel("Modelo:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfModelo = new JTextField();
		GridBagConstraints gbc_jtfModelo = new GridBagConstraints();
		gbc_jtfModelo.gridwidth = 2;
		gbc_jtfModelo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfModelo.gridx = 1;
		gbc_jtfModelo.gridy = 4;
		contentPane.add(jtfModelo, gbc_jtfModelo);
		jtfModelo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Serial Number:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfNumeroSerie = new JTextField();
		GridBagConstraints gbc_jtfNumeroSerie = new GridBagConstraints();
		gbc_jtfNumeroSerie.gridwidth = 2;
		gbc_jtfNumeroSerie.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNumeroSerie.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNumeroSerie.gridx = 1;
		gbc_jtfNumeroSerie.gridy = 5;
		contentPane.add(jtfNumeroSerie, gbc_jtfNumeroSerie);
		jtfNumeroSerie.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Num Procesadores:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 6;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		grupoBotones = new ButtonGroup();

		jrbProcesador1 = new JRadioButton("1 Procesador");
		grupoBotones.add(jrbProcesador1);
		GridBagConstraints gbc_jrbProcesador1 = new GridBagConstraints();
		gbc_jrbProcesador1.insets = new Insets(0, 0, 5, 5);
		gbc_jrbProcesador1.gridx = 0;
		gbc_jrbProcesador1.gridy = 0;
		panel.add(jrbProcesador1, gbc_jrbProcesador1);
		
		jrbProcesador2 = new JRadioButton("2 Procesador");
		grupoBotones.add(jrbProcesador2);
		GridBagConstraints gbc_jrbProcesador2 = new GridBagConstraints();
		gbc_jrbProcesador2.insets = new Insets(0, 0, 5, 0);
		gbc_jrbProcesador2.gridx = 1;
		gbc_jrbProcesador2.gridy = 0;
		panel.add(jrbProcesador2, gbc_jrbProcesador2);
		
		jrbProcesador3 = new JRadioButton("3 Procesador");
		grupoBotones.add(jrbProcesador3);
		GridBagConstraints gbc_jrbProcesador3 = new GridBagConstraints();
		gbc_jrbProcesador3.insets = new Insets(0, 0, 0, 5);
		gbc_jrbProcesador3.gridx = 0;
		gbc_jrbProcesador3.gridy = 1;
		panel.add(jrbProcesador3, gbc_jrbProcesador3);
		
		jrbProcesador4 = new JRadioButton("4 Procesador");
		grupoBotones.add(jrbProcesador4);
		GridBagConstraints gbc_jrbProcesador4 = new GridBagConstraints();
		gbc_jrbProcesador4.gridx = 1;
		gbc_jrbProcesador4.gridy = 1;
		panel.add(jrbProcesador4, gbc_jrbProcesador4);
		
		JLabel lblNewLabel_6 = new JLabel("Vendido:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jcbxVendido = new JCheckBox("");
		jcbxVendido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcbxVendido.isSelected()) {
					jtfFecha.setText("");
					jtfFecha.setEnabled(true);
				}
				else {
					jtfFecha.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_jcbxVendido = new GridBagConstraints();
		gbc_jcbxVendido.anchor = GridBagConstraints.WEST;
		gbc_jcbxVendido.insets = new Insets(0, 0, 5, 5);
		gbc_jcbxVendido.gridx = 1;
		gbc_jcbxVendido.gridy = 7;
		contentPane.add(jcbxVendido, gbc_jcbxVendido);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha de venta:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfFecha = new JTextField();
		jtfFecha.setEnabled(false);
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 8;
		contentPane.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		JButton jbnNumeroPortatiles = new JButton("Numero total de portatiles");
		jbnNumeroPortatiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajePortatiles();
			}
		});
		GridBagConstraints gbc_jbnNumeroPortatiles = new GridBagConstraints();
		gbc_jbnNumeroPortatiles.gridwidth = 3;
		gbc_jbnNumeroPortatiles.gridx = 0;
		gbc_jbnNumeroPortatiles.gridy = 9;
		contentPane.add(jbnNumeroPortatiles, gbc_jbnNumeroPortatiles);
		
		cargarPrimero();
	}

	/**
	 * 
	 */
	public void cargarPrimero() {
		cargarDatos(ControladorPortatil.findFirst());
	}
	
	/**
	 * 
	 */
	public void cargarUltimo() {
		cargarDatos(ControladorPortatil.findLast());
	}
	
	public void cargarAnterior() {
		cargarDatos(ControladorPortatil.findPrevious(Integer.parseInt(jtfId.getText())));
	}
	
	public void cargarSiguiente() {
		cargarDatos(ControladorPortatil.findNext(Integer.parseInt(jtfId.getText())));
	}
	
	/**
	 * 
	 * @param p
	 */
	public void cargarDatos(Portatil p) {
		
		jtfId.setText(p.getId() + "");
		jtfModelo.setText(p.getModelo());
		jtfNumeroSerie.setText(p.getSn());
		
		if(p.getNumProcesadores() == 1) {
			grupoBotones.setSelected(jrbProcesador1.getModel(), true);
		}
		
		if(p.getNumProcesadores() == 2) {
			grupoBotones.setSelected(jrbProcesador2.getModel(), true);
		}
		
		if(p.getNumProcesadores() == 3) {
			grupoBotones.setSelected(jrbProcesador3.getModel(), true);
		}
		
		if(p.getNumProcesadores() == 4) {
			grupoBotones.setSelected(jrbProcesador4.getModel(), true);
		}
		
		if(p.getVendido()== 1) {
			jcbxVendido.setSelected(true);
			jtfFecha.setEnabled(true);
		}
		
		jtfFecha.setText("");
		if(p.getFechaVenta() != null) {
			jtfFecha.setText(sdf.format(p.getFechaVenta()));
		}
		
		cargarMarca(p);
		
		// Habilito y deshabilito botones de navegación
//		if (ControladorPortatil.findPrevious(Integer.parseInt(jtfId.getText())) == null) {
//			this.jbnPrimero.setEnabled(false);
//			this.jbnAnterior.setEnabled(false);
//		}
//		else {
//			this.jbnPrimero.setEnabled(true);
//			this.jbnAnterior.setEnabled(true);
//		}
//
//		if (ControladorPortatil.findNext(Integer.parseInt(jtfId.getText())) == null) {
//			this.jbnUltimo.setEnabled(false);
//			this.jbnSiguiente.setEnabled(false);
//		}
//		else {
//			this.jbnUltimo.setEnabled(true);
//			this.jbnSiguiente.setEnabled(true);
//		}

	}
	
	/**
	 * 
	 * @param p
	 */
	public void cargarMarca(Portatil p) {
		jcbMarca.removeAllItems();
		for (Marca m : ControladorMarca.findById(p.getMarca().getId())) {
			jcbMarca.addItem(m);
		}
	}
	
	/**
	 * 
	 * @param id
	 */
	public void borrarDatosPantalla() {
		jtfId.setText("0");
		jtfModelo.setText("");
		jtfNumeroSerie.setText("");
		
		jrbProcesador1.setSelected(true);
		jrbProcesador2.setSelected(false);
		jrbProcesador3.setSelected(false);
		jrbProcesador4.setSelected(false);

		jcbxVendido.setSelected(false);
		
		jcbMarca.removeAllItems();
		for (Marca m : ControladorMarca.findAll()) {
			jcbMarca.addItem(m);
		}

	}
	
	/**
	 * 
	 */
	public void nuevo() {
		borrarDatosPantalla();
	}
	
	/**
	 * 
	 */
	public void modificar() {
		if(jtfId.getText() != "0") {
			Portatil p = new Portatil();
			p.setId(Integer.parseInt(jtfId.getText()));
			p.setMarca((Marca) jcbMarca.getSelectedItem());
			p.setModelo(jtfModelo.getText());
			p.setSn(jtfNumeroSerie.getText());
			if(jrbProcesador1.isSelected()) {
				p.setNumProcesadores(1);
			}
			if(jrbProcesador2.isSelected()) {
				p.setNumProcesadores(1);
			}
			if(jrbProcesador3.isSelected()) {
				p.setNumProcesadores(1);
			}
			if(jrbProcesador4.isSelected()) {
				p.setNumProcesadores(1);
			}
			if(jcbxVendido.isSelected()) {
				p.setVendido((byte) 1);
				try {
					p.setFechaVenta(sdf.parse(jtfFecha.getText()));
				} catch (ParseException e) {
				}
			}
			
			ControladorPortatil.modificarEntidad(p);
		}
		else {
			Portatil p = new Portatil();
			p.setMarca((Marca) jcbMarca.getSelectedItem());
			p.setModelo(jtfModelo.getText());
			p.setSn(jtfNumeroSerie.getText());
			if(jrbProcesador1.isSelected()) {
				p.setNumProcesadores(1);
			}
			if(jrbProcesador2.isSelected()) {
				p.setNumProcesadores(1);
			}
			if(jrbProcesador3.isSelected()) {
				p.setNumProcesadores(1);
			}
			if(jrbProcesador4.isSelected()) {
				p.setNumProcesadores(1);
			}
			if(jcbxVendido.isSelected()) {
				p.setVendido((byte) 1);
				try {
					p.setFechaVenta(sdf.parse(jtfFecha.getText()));
				} catch (ParseException e) {
				}
			}
			
			ControladorPortatil.modificarEntidad(p);
		}
	}
	
	
	/**
	 * 
	 */
	public void eliminar() {
		Portatil p = ControladorPortatil.findById(Integer.parseInt(jtfId.getText()));
		ControladorPortatil.eliminarEntidad(p);
	}
	
	/**
	 * 
	 */
	public void abrirNuevoDialogo() {
		JDialog dialogo = new JDialog();
		// El usuario no puede redimensionar el di�logo
		dialogo.setResizable(true);
		// t�tulo del d�alogo
		dialogo.setTitle("Gestión de empresas");
		// Introducimos el panel creado sobre el di�logo
		dialogo.setContentPane(new PanelMarca((Marca) jcbMarca.getSelectedItem()));
		// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
		dialogo.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
		dialogo.setModal(true);
		// Centro el di�logo en pantalla
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		// Muestro el di�logo en pantalla
		dialogo.setVisible(true);
	}
	
	public void mensajePortatiles() {
		int cont = 0;
		for (@SuppressWarnings("unused") Portatil p : ControladorPortatil.findAll()) {
			cont++;
		}
		JOptionPane.showMessageDialog(null, "Total de portatiles: " + cont);
	}
}
