package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import modeloVo.*;
import utilidades.ConvertirFechas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controller;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JCheckBox;


public class Form06Alquileres extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	
	private JTextField textFieldContrato;
	private JTextField textFieldFecContrato;
	private JTextField textFieldFecVencimiento;
	private JTextField textFieldPrecio;
	
	private JTextField textFieldTamanho;
	private JCheckBox chckbxPiscina;
	private JCheckBox chckbxGaraje;
	private JCheckBox chckbxJardin;
	private JButton btnBuscar;
	private ModeloComboInquilinos comboBoxInquilinos;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel dm;
	
	public Controller controller = new Controller();
	private  ModeloComboZonas comboBox;
	
	private void asignarColumnas() {
		dm = new DefaultTableModel();
		dm.addColumn("Inmueble");
		dm.addColumn("Dirección");
		dm.addColumn("Precio");
		dm.addColumn("Estado");
		dm.addColumn("Fecha Vencimiento");
		dm.addColumn("Propietario");
		dm.addColumn("Telefono");
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Form06Alquileres dialog = new Form06Alquileres();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form06Alquileres() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\ProyectosAccesoDatos\\stock-vector-home-icon-160210421.jpg"));
		setTitle("Gesti\u00F3n Inmobiliaria Casas");
		setBounds(100, 100, 951, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 42, 887, 36);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblZona = new JLabel("Zona:");
		lblZona.setBounds(10, 11, 46, 14);
		panel.add(lblZona);
		
		JLabel lblTamao = new JLabel("Tama\u00F1o:");
		lblTamao.setBounds(233, 10, 56, 16);
		panel.add(lblTamao);
		
		textFieldTamanho = new JTextField();
		textFieldTamanho.setBounds(303, 7, 116, 22);
		panel.add(textFieldTamanho);
		textFieldTamanho.setColumns(10);
		
		chckbxPiscina = new JCheckBox("Piscina");
		chckbxPiscina.setBounds(427, 6, 75, 25);
		panel.add(chckbxPiscina);
		
		chckbxGaraje = new JCheckBox("Garaje");
		chckbxGaraje.setBounds(506, 6, 75, 25);
		panel.add(chckbxGaraje);
		
		chckbxJardin = new JCheckBox("Jard\u00EDn");
		chckbxJardin.setBounds(585, 6, 75, 25);
		panel.add(chckbxJardin);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new BtnBuscarActionListener());
		
		btnBuscar.setBounds(691, 6, 97, 25);
		panel.add(btnBuscar);
		
		comboBox = new ModeloComboZonas();
		comboBox.setBounds(45, 8, 178, 20);
		panel.add(comboBox);
		
		
		
		JLabel lblListadoInmueblesDisponibles = new JLabel("LISTADO INMUEBLES DISPONIBLES EN LA ZONA");
		lblListadoInmueblesDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoInmueblesDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListadoInmueblesDisponibles.setBounds(64, 13, 539, 16);
		contentPanel.add(lblListadoInmueblesDisponibles);
		
		JPanel panelNuevoContrato = new JPanel();
		panelNuevoContrato.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Nuevo Contrato", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelNuevoContrato.setBounds(20, 222, 901, 135);
		contentPanel.add(panelNuevoContrato);
		panelNuevoContrato.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00BA Contrato:");
		lblNewLabel.setBounds(12, 26, 74, 16);
		panelNuevoContrato.add(lblNewLabel);
		
		textFieldContrato = new JTextField();
		textFieldContrato.setEditable(false);
		textFieldContrato.setBounds(108, 23, 116, 22);
		panelNuevoContrato.add(textFieldContrato);
		textFieldContrato.setColumns(10);
		
		JLabel lblInquilino = new JLabel("Inquilino:");
		lblInquilino.setBounds(236, 26, 56, 16);
		panelNuevoContrato.add(lblInquilino);
		
		
		
		JLabel lblFechaContrato = new JLabel("Fecha Contrato:");
		lblFechaContrato.setBounds(12, 65, 116, 16);
		panelNuevoContrato.add(lblFechaContrato);
		
		textFieldFecContrato = new JTextField();
		textFieldFecContrato.setEditable(false);
		textFieldFecContrato.setBounds(108, 62, 116, 22);
		panelNuevoContrato.add(textFieldFecContrato);
		textFieldFecContrato.setColumns(10);
		
		JLabel lblFechaVencimiento = new JLabel("Fecha Vencimiento:");
		lblFechaVencimiento.setBounds(348, 65, 116, 16);
		panelNuevoContrato.add(lblFechaVencimiento);
		
		textFieldFecVencimiento = new JTextField();
		textFieldFecVencimiento.setEditable(false);
		textFieldFecVencimiento.setBounds(479, 62, 116, 22);
		panelNuevoContrato.add(textFieldFecVencimiento);
		textFieldFecVencimiento.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(12, 94, 56, 16);
		panelNuevoContrato.add(lblPrecio);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setEditable(false);
		textFieldPrecio.setBounds(108, 100, 116, 22);
		panelNuevoContrato.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		JLabel lblDdmmaaaa = new JLabel("dd/mm/aaaa");
		lblDdmmaaaa.setBounds(236, 65, 100, 16);
		panelNuevoContrato.add(lblDdmmaaaa);
		
		comboBoxInquilinos = new ModeloComboInquilinos();
		comboBoxInquilinos.setBounds(302, 24, 293, 20);
		panelNuevoContrato.add(comboBoxInquilinos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 89, 901, 126);
		contentPanel.add(scrollPane);
		
		cargarTabla();
			
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new OkButtonActionListener());
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new CancelButtonActionListener());
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void cargarTabla() {
		asignarColumnas();
		
		table = new JTable(dm);
		table.addMouseListener(new TableMouseListener());
		
		scrollPane.setViewportView(table);
		int size = 0;
		boolean pool = chckbxPiscina.isSelected();
		boolean garaje = chckbxGaraje.isSelected();
		boolean garden = chckbxJardin.isSelected();
			
		Zonas zona = (Zonas) comboBox.getSelectedItem();
		
		ArrayList<InmueblesPropietarios> inmuebles = controller.buscarInmuebles(
				zona.getCodigo(), size, pool, garaje, garden);
		
		for(InmueblesPropietarios inmueble : inmuebles) {
			Object [] row = {
					inmueble.getCodigoInmueble(), 
					inmueble.getDireccion(),
					inmueble.getPrecio(),
					inmueble.isEstado(),
					inmueble.getFechaVencimiento(),
					inmueble.getPropietario(),
					inmueble.getTelefono()
			};
			dm.addRow(row);
			
		}
		
	}
	
	
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if( controller.validateNull(textFieldContrato.getText() ) )
				JOptionPane.showMessageDialog(null, "Introduce un número de contrato");
			else {
				if(controller.validateNull(textFieldFecContrato.getText()))
					JOptionPane.showMessageDialog(null, "Introduce una fecha de contratación");
				else {
					
					if(controller.validateNull(textFieldFecVencimiento.getText()))
						JOptionPane.showMessageDialog(null, "Introduce una fecha de validación");
					else {
						if(controller.validateNull(textFieldPrecio.getText()))
							JOptionPane.showMessageDialog(null, "Introduce un precio");
						
						else {
							Inquilinos inquilino = (Inquilinos) comboBoxInquilinos.getSelectedItem();
							String codeContract = textFieldContrato.getText();
							String dniInquilino = inquilino.getDni();
							String inquilinoName = (String)table.getValueAt(table.getSelectedRow(), 0);		
							Date fechaContratacion = ConvertirFechas.convertirJavaDateASqlDate(ConvertirFechas.convertirStrigDate(textFieldFecContrato.getText() ));
							Date fechaVencimiento = ConvertirFechas.convertirJavaDateASqlDate(ConvertirFechas.convertirStrigDate(textFieldFecVencimiento.getText() ));
							double precio = Double.parseDouble(textFieldPrecio.getText() ) ;
									
							if(controller.newContract(codeContract,dniInquilino,inquilinoName, fechaContratacion, fechaVencimiento, precio ))
									JOptionPane.showMessageDialog(null, "Inserción fallida");
								else {
									JOptionPane.showMessageDialog(null, "Inserción OK");
									cargarTabla();
									resetTabla();
								}
						}
					}
				}
			}
				

		}

		
		
		private void resetTabla() {
			textFieldContrato.setText("");
			textFieldFecContrato.setText("");
			textFieldFecVencimiento.setText("");
			textFieldPrecio.setText("");
			
		}
	}
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}
	private class BtnBuscarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cargarTabla();
		}
	}
	private class TableMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			textFieldContrato.setEditable(true);
			textFieldFecContrato.setEditable(true);
			textFieldFecVencimiento.setEditable(true);
			textFieldPrecio.setEditable(true);
			double pre = (Double) table.getValueAt(table.getSelectedRow(), 2);
			textFieldPrecio.setText(""+pre );
		}
	}
}
