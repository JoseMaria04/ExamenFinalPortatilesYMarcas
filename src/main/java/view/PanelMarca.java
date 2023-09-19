package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import controller.ControladorContinente;
import controller.ControladorMarca;
import controller.ControladorPais;
import model.Continente;
import model.Marca;
import model.Pai;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMarca extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfDenominacion;
	private Marca m = null;
	JComboBox<Continente> jcbContinente;
	JComboBox<Pai> jcbPais;

	/**
	 * Create the panel.
	 */
	public PanelMarca(Marca m) {
		this.m = m;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestion de Marcas");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Denominacion:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfDenominacion = new JTextField();
		GridBagConstraints gbc_jtfDenominacion = new GridBagConstraints();
		gbc_jtfDenominacion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDenominacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDenominacion.gridx = 1;
		gbc_jtfDenominacion.gridy = 2;
		add(jtfDenominacion, gbc_jtfDenominacion);
		jtfDenominacion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Continente:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcbContinente = new JComboBox<Continente>();
		GridBagConstraints gbc_jcbContinente = new GridBagConstraints();
		gbc_jcbContinente.insets = new Insets(0, 0, 5, 0);
		gbc_jcbContinente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbContinente.gridx = 1;
		gbc_jcbContinente.gridy = 3;
		add(jcbContinente, gbc_jcbContinente);
		
		JLabel lblNewLabel_4 = new JLabel("Pais:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbPais = new JComboBox<Pai>();
		GridBagConstraints gbc_jcbPais = new GridBagConstraints();
		gbc_jcbPais.insets = new Insets(0, 0, 5, 0);
		gbc_jcbPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbPais.gridx = 1;
		gbc_jcbPais.gridy = 4;
		add(jcbPais, gbc_jcbPais);
		
		JButton jbnGuardar = new JButton("Guardar");
		jbnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_jbnGuardar = new GridBagConstraints();
		gbc_jbnGuardar.anchor = GridBagConstraints.NORTH;
		gbc_jbnGuardar.weighty = 1.0;
		gbc_jbnGuardar.gridwidth = 2;
		gbc_jbnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_jbnGuardar.gridx = 0;
		gbc_jbnGuardar.gridy = 5;
		add(jbnGuardar, gbc_jbnGuardar);
		cargarDatos();
	}

	private void cargarDatos() {
		jtfId.setText(m.getId()+ "");
		jtfDenominacion.setText(m.getDenominacion());
		
		Continente l = m.getPai().getContinente();
		
		jcbPais.removeAllItems();
		for (Pai m : ControladorPais.findById(m.getPai().getId(), l.getId())){
			jcbPais.addItem(m);
		}
		
		jcbContinente.removeAllItems();
		for (Continente p  : ControladorContinente.findById(l.getId())) {
			jcbContinente.addItem(p);
		}
	}
	
	public void guardar() {
		Marca marca = new Marca();
		
		marca.setId(Integer.parseInt(jtfId.getText()));
		
		marca.setPai((Pai) jcbPais.getSelectedItem());
		
		
		if(jtfDenominacion.getText().length() >= 2) {
			marca.setDenominacion(jtfDenominacion.getText());
			ControladorMarca.modificarEntidad(marca);
		}
		else {
			JOptionPane.showMessageDialog(null, "No se ha podido guardar");
		}
		
	}
}
