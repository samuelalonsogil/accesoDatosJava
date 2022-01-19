package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import convertirFechasDate.ConvertirFechas;
import modeloVo.Cliente;
import modeloVo.ModeloComboCliente;
import modeloVo.ModeloComboVehiculosDisponibles;
import modeloVo.Vehiculo;
import modeloVo.VehiculoCliente;
import modeloVo.VehiculoDisponibles;


import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Form01Alquileres extends JFrame {

	private JPanel contentPane;
	private ModeloComboCliente comboBoxClientes;

	private Controlador controlador;
	private JTextField textFieldNumPlazas;
	private JTextField textFieldNumPuertas;
	private JTextField textFieldCapacidad;
	private JTextField textFieldAntiguedad;
	private JTextField textFieldPrecio;
	private JScrollPane scrollPane;
	private JTable table;

	private DefaultTableModel dm;
	private DefaultTableCellRenderer alinearCentro, alinearDerecha, alinearIzquierda;
	private JTextField textFieldFecha;
	private JTextField textFieldDias;
	private JTextField textFieldSeguro;


	private void asignarModeloTabla(){
		dm = new DefaultTableModel();
		dm.addColumn("Matricula");
		dm.addColumn("Marca");
		dm.addColumn("Modelo");
		dm.addColumn("Antigüedad");
		dm.addColumn("Precio");
	}

	private void inicializarRenderers(){
		alinearCentro = new DefaultTableCellRenderer();
		alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);

		alinearDerecha = new DefaultTableCellRenderer();
		alinearDerecha.setHorizontalAlignment(SwingConstants.RIGHT);

		alinearIzquierda = new DefaultTableCellRenderer();
		alinearIzquierda.setHorizontalAlignment(SwingConstants.LEFT);
	}


	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form01Alquileres frame = new Form01Alquileres();
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
	public Form01Alquileres() {
		setTitle("Alquiler Veh\u00EDculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelClientes = new JPanel();
		panelClientes.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelClientes.setBounds(10, 52, 777, 67);
		contentPane.add(panelClientes);
		panelClientes.setLayout(null);

		comboBoxClientes = new ModeloComboCliente();
		comboBoxClientes.setBounds(60, 22, 378, 20);
		panelClientes.add(comboBoxClientes);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new BtnNuevoActionListener());
		btnNuevo.setBounds(633, 21, 89, 23);
		panelClientes.add(btnNuevo);

		JLabel lblAlquilerVehculos = new JLabel("ALQUILER VEH\u00CDCULOS");
		lblAlquilerVehculos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlquilerVehculos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlquilerVehculos.setForeground(Color.BLACK);
		lblAlquilerVehculos.setBounds(10, 11, 777, 30);
		contentPane.add(lblAlquilerVehculos);

		JPanel panelCaracteristicas = new JPanel();
		panelCaracteristicas.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Caracter\u00EDsticas Veh\u00EDculos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCaracteristicas.setBounds(10, 138, 777, 103);
		contentPane.add(panelCaracteristicas);
		panelCaracteristicas.setLayout(null);

		JLabel lblNPlazas = new JLabel("N\u00BA Plazas");
		lblNPlazas.setBounds(24, 27, 73, 14);
		panelCaracteristicas.add(lblNPlazas);

		textFieldNumPlazas = new JTextField();
		textFieldNumPlazas.setBounds(107, 24, 86, 20);
		panelCaracteristicas.add(textFieldNumPlazas);
		textFieldNumPlazas.setColumns(10);

		JLabel lblNPuertas = new JLabel("N\u00BA Puertas");
		lblNPuertas.setBounds(223, 27, 96, 14);
		panelCaracteristicas.add(lblNPuertas);

		textFieldNumPuertas = new JTextField();
		textFieldNumPuertas.setBounds(329, 24, 106, 20);
		panelCaracteristicas.add(textFieldNumPuertas);
		textFieldNumPuertas.setColumns(10);

		JLabel lblCapacidad = new JLabel("Capacidad Maletero:");
		lblCapacidad.setBounds(460, 27, 159, 14);
		panelCaracteristicas.add(lblCapacidad);

		textFieldCapacidad = new JTextField();
		textFieldCapacidad.setBounds(638, 24, 86, 20);
		panelCaracteristicas.add(textFieldCapacidad);
		textFieldCapacidad.setColumns(10);

		JLabel lblAntigedad = new JLabel("Antig\u00FCedad");
		lblAntigedad.setBounds(24, 58, 74, 14);
		panelCaracteristicas.add(lblAntigedad);

		textFieldAntiguedad = new JTextField();
		textFieldAntiguedad.setBounds(107, 55, 86, 20);
		panelCaracteristicas.add(textFieldAntiguedad);
		textFieldAntiguedad.setColumns(10);

		JLabel lblPrecioMnimoDa = new JLabel("Precio M\u00EDnimo D\u00EDa");
		lblPrecioMnimoDa.setBounds(223, 65, 131, 14);
		panelCaracteristicas.add(lblPrecioMnimoDa);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(349, 62, 86, 20);
		panelCaracteristicas.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new BtnBuscarActionListener());
		btnBuscar.setBounds(635, 55, 89, 23);
		panelCaracteristicas.add(btnBuscar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 266, 777, 151);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new TableMouseListener());
		scrollPane.setColumnHeaderView(table);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Alquiler", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 438, 777, 80);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblFechaInicioddmmaa = new JLabel("Fecha Inicio: (DD/MM/AAAA)");
		lblFechaInicioddmmaa.setBounds(24, 25, 186, 14);
		panel.add(lblFechaInicioddmmaa);

		textFieldFecha = new JTextField();
		textFieldFecha.setEditable(false);
		textFieldFecha.setBounds(206, 22, 86, 20);
		panel.add(textFieldFecha);
		textFieldFecha.setColumns(10);

		JLabel lblDas = new JLabel("D\u00EDas:");
		lblDas.setBounds(379, 25, 46, 14);
		panel.add(lblDas);

		textFieldDias = new JTextField();
		textFieldDias.setEditable(false);
		textFieldDias.setBounds(451, 22, 86, 20);
		panel.add(textFieldDias);
		textFieldDias.setColumns(10);

		JLabel lblNewLabel = new JLabel("Seguro:");
		lblNewLabel.setBounds(575, 25, 46, 14);
		panel.add(lblNewLabel);

		textFieldSeguro = new JTextField();
		textFieldSeguro.setEditable(false);
		textFieldSeguro.setBounds(651, 22, 86, 20);
		panel.add(textFieldSeguro);
		textFieldSeguro.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new BtnOkActionListener());
		btnOk.setBounds(347, 529, 89, 23);
		contentPane.add(btnOk);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new BtnSalirActionListener());
		btnSalir.setBounds(698, 529, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnNuevo_1 = new JButton("Nuevo");
		btnNuevo_1.addActionListener(new BtnNuevo_1ActionListener());
		btnNuevo_1.setBounds(464, 529, 89, 23);
		contentPane.add(btnNuevo_1);


	}
	private class BtnNuevoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			controlador.mostrarNuevoCliente();
		}
	}
	private class BtnBuscarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cargarTabla();
		}
	}
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	private class TableMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			textFieldDias.setEditable(true);
			textFieldSeguro.setEditable(true);
			textFieldFecha.setEditable(true);
		}
	}
	private class BtnOkActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if(controlador.validarNulo(textFieldFecha.getText())) {
				JOptionPane.showMessageDialog(null, "La Fecha no puede ser nula", "Error", JOptionPane.ERROR_MESSAGE);
				textFieldFecha.requestFocus();
				textFieldFecha.selectAll();
			}else {
				if(controlador.validarNulo(textFieldDias.getText())) {
					JOptionPane.showMessageDialog(null, "El Nº de Dias no puede ser nulo", "Error", JOptionPane.ERROR_MESSAGE);
					textFieldDias.requestFocus();
					textFieldDias.selectAll();
				}else {
					if(controlador.validarNulo(textFieldSeguro.getText())) {
						JOptionPane.showMessageDialog(null, "El tipo de Seguro no puede ser nulo", "Error", JOptionPane.ERROR_MESSAGE);
						textFieldSeguro.requestFocus();
						textFieldSeguro.selectAll();
					}else {

						int fila = table.getSelectedRow();
						if(fila == -1) {
							JOptionPane.showMessageDialog(null, "Debe seleccionar un Coche", "Información", 
									JOptionPane.INFORMATION_MESSAGE);
						}else {
							Cliente cliente = (Cliente)comboBoxClientes.getSelectedItem();
							String matricula = (String) table.getValueAt(fila, 0);

									VehiculoCliente vehCli = new VehiculoCliente(
											cliente.getDni(), matricula, ConvertirFechas.convertirStringDate(textFieldFecha.getText()), 
											Integer.parseInt(textFieldDias.getText()), 								textFieldSeguro.getText());


							if(controlador.nuevoNuevoAlquiler(vehCli) != 0)
								JOptionPane.showMessageDialog(null,"Inserción correcta","Inforación",
										JOptionPane.INFORMATION_MESSAGE);
							else
								JOptionPane.showMessageDialog(null, "No se ha podido "
										+ "añadir el Alquiler", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}		
				}		
			}

		}
	}
	private class BtnNuevo_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textFieldAntiguedad.setText("");
			textFieldCapacidad.setText("");
			textFieldDias.setText("");
			textFieldNumPlazas.setText("");
			textFieldNumPuertas.setText("");
			textFieldFecha.setText("");
			textFieldPrecio.setText("");
			textFieldSeguro.setText("");
			
			textFieldDias.setEditable(false);
			textFieldFecha.setEditable(false);
			textFieldSeguro.setEditable(false);
			
			table = new JTable();
			scrollPane.setViewportView(table);
		}
	}
		private void cargarTabla() {

			asignarModeloTabla();
			inicializarRenderers();

			table = new JTable(dm);

			table.addMouseListener(new TableMouseListener());
			table.setEnabled(true);

			scrollPane.setViewportView(table);

			table.getColumnModel().getColumn(0).setCellRenderer(alinearCentro);

			table.getColumnModel().getColumn(1).setCellRenderer(alinearIzquierda);
			table.getColumnModel().getColumn(2).setCellRenderer(alinearIzquierda);

			table.getColumnModel().getColumn(3).setCellRenderer(alinearDerecha);
			table.getColumnModel().getColumn(4).setCellRenderer(alinearCentro);
		

			ArrayList <VehiculoDisponibles>vehiculos = controlador.cargarVehiculosDisponibles(textFieldNumPlazas.getText(), textFieldNumPuertas.getText(), 
					textFieldCapacidad.getText(), textFieldAntiguedad.getText(), textFieldPrecio.getText());



			//poner formato moneda
			NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
			for(VehiculoDisponibles vehi : vehiculos) {
				Object[] row = {vehi.getMatricula(), vehi.getMarca(), vehi.getModelo(), vehi.getAntiguedad(), nf.format(vehi.getPrecio())};
				dm.addRow(row);
			}
		}
	}
