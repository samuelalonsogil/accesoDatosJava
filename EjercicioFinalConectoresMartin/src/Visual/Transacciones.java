package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import DAOModels.ClienteTransaccionDAO;
import DAOModels.ListadoCuentasDAO;
import DAOModels.TransaccionesDAO;
import VOModels.ClienteTransaccion;
import VOModels.ListadoCuentas;

public class Transacciones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDNI;
	private JTextField textFieldCantidad;
	private JRadioButton btnIngreso;
	private JRadioButton btnReintegro;
	private JRadioButton btnTransferencia;
	private JComboBox comboBoxSeleccionarCuentaDestinatario;
	private JComboBox comboBoxSeleccionarCuenta;

	
	ArrayList<ListadoCuentas> cuentas = ListadoCuentasDAO.getAllCuentas();
	ArrayList<ClienteTransaccion> arrClienteTransaccion = new ArrayList<>();
	private JButton okButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Transacciones dialog = new Transacciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Transacciones() {
		setBounds(100, 100, 700, 300);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTransacciones = new JLabel("Transacciones");
		lblTransacciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTransacciones.setBounds(304, 11, 92, 14);
		contentPanel.add(lblTransacciones);
		
		JPanel panelSeleccionarOperacion = new JPanel();
		panelSeleccionarOperacion.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Seleccionar Operaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSeleccionarOperacion.setBounds(10, 35, 664, 55);
		contentPanel.add(panelSeleccionarOperacion);
		panelSeleccionarOperacion.setLayout(null);
		
		btnIngreso = new JRadioButton("Ingreso");
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionIngreso();
			}
		});
		btnIngreso.setBounds(100, 18, 109, 23);
		panelSeleccionarOperacion.add(btnIngreso);
		
		btnReintegro = new JRadioButton("Reintegro");
		btnReintegro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionReintegro();
			}
		});
		btnReintegro.setBounds(277, 18, 109, 23);
		panelSeleccionarOperacion.add(btnReintegro);
		
		btnTransferencia = new JRadioButton("Transferencia");
		btnTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionTransferencia();
			}
		});
		btnTransferencia.setBounds(454, 18, 109, 23);
		panelSeleccionarOperacion.add(btnTransferencia);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCliente.setBounds(10, 95, 664, 55);
		contentPanel.add(panelCliente);
		panelCliente.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 22, 22, 14);
		panelCliente.add(lblDni);
		
		textFieldDNI = new JTextField();
		textFieldDNI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillCuentasTransaccion();
			}
		});
		textFieldDNI.setBounds(42, 19, 86, 20);
		panelCliente.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblSeleccionarCuenta = new JLabel("Seleccionar Cuenta:");
		lblSeleccionarCuenta.setBounds(148, 22, 162, 14);
		panelCliente.add(lblSeleccionarCuenta);
		
		comboBoxSeleccionarCuenta = new JComboBox();
		comboBoxSeleccionarCuenta.setBounds(268, 18, 210, 22);
		panelCliente.add(comboBoxSeleccionarCuenta);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(488, 22, 55, 14);
		panelCliente.add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(553, 19, 86, 20);
		panelCliente.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JPanel panelDestinatario = new JPanel();
		panelDestinatario.setLayout(null);
		panelDestinatario.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Destinatario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDestinatario.setBounds(10, 155, 664, 55);
		contentPanel.add(panelDestinatario);
		
		JLabel lblSeleccionarCuentaDestinatario = new JLabel("Seleccionar Cuenta:");
		lblSeleccionarCuentaDestinatario.setBounds(30, 22, 132, 14);
		panelDestinatario.add(lblSeleccionarCuentaDestinatario);
		
		comboBoxSeleccionarCuentaDestinatario = new JComboBox();
		fillCuentas();
		comboBoxSeleccionarCuentaDestinatario.setEnabled(false);
		comboBoxSeleccionarCuentaDestinatario.setBounds(157, 18, 210, 22);
		panelDestinatario.add(comboBoxSeleccionarCuentaDestinatario);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (btnIngreso.isSelected()) {
							ingreso();
							fillCuentasTransaccion();
						} else if (btnReintegro.isSelected()) {
							
							if (arrClienteTransaccion.get(comboBoxSeleccionarCuenta.getSelectedIndex()).getSaldo() > Integer.valueOf(textFieldCantidad.getText())) {
								retirar();
								fillCuentasTransaccion();
								
							} else {
								errorInput();
							}
							
						} else if (btnTransferencia.isSelected()) {
							
							if (arrClienteTransaccion.get(comboBoxSeleccionarCuenta.getSelectedIndex()).getSaldo() > Integer.valueOf(textFieldCantidad.getText())) {
								transaccion();
								fillCuentasTransaccion();
							} else {
								errorInput();
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void seleccionIngreso() {
		btnReintegro.setSelected(false);
		btnTransferencia.setSelected(false);
		comboBoxSeleccionarCuentaDestinatario.setEnabled(false);
	}
	
	public void seleccionReintegro() {
		btnIngreso.setSelected(false);
		btnTransferencia.setSelected(false);
		comboBoxSeleccionarCuentaDestinatario.setEnabled(false);
	}
	
	public void seleccionTransferencia() {
		btnIngreso.setSelected(false);
		btnReintegro.setSelected(false);
		comboBoxSeleccionarCuentaDestinatario.setEnabled(true);
	}
	
	public void fillCuentasTransaccion() {
		int dni = Integer.parseInt(textFieldDNI.getText());
		arrClienteTransaccion = ClienteTransaccionDAO.getClienteTransaccion(dni);
		ArrayList<String> arrComboBox = new ArrayList<>();
		
		for (ClienteTransaccion c: arrClienteTransaccion) {
			arrComboBox.add("Num Cuenta: " + c.getNumCuenta() + ", Saldo: " + c.getSaldo());
		}
		
		comboBoxSeleccionarCuenta.setModel(new DefaultComboBoxModel(arrComboBox.toArray()));
	}
	
	public void fillCuentas() {
		
		ArrayList<String> infoCuenta = new ArrayList<>();
		
		for (ListadoCuentas c: cuentas) {
			infoCuenta.add("CodCuenta: " + c.getCodCuenta() + ", Saldo: " + c.getSaldo());
		}
		
		comboBoxSeleccionarCuentaDestinatario.setModel(new DefaultComboBoxModel(infoCuenta.toArray()));
	}
	
	public void ingreso() {
		TransaccionesDAO.modification(arrClienteTransaccion.get(comboBoxSeleccionarCuenta.getSelectedIndex()).getNumCuenta(),
				Integer.valueOf(textFieldCantidad.getText()),
				arrClienteTransaccion.get(comboBoxSeleccionarCuenta.getSelectedIndex()).getCodSucursal());
	}
	
	public void retirar() {
		TransaccionesDAO.modification(arrClienteTransaccion.get(comboBoxSeleccionarCuenta.getSelectedIndex()).getNumCuenta(),
				(Integer.valueOf(textFieldCantidad.getText())*(-1)),
				arrClienteTransaccion.get(comboBoxSeleccionarCuenta.getSelectedIndex()).getCodSucursal());
	}
	
	public void transaccion() {
		TransaccionesDAO.transaction(
				arrClienteTransaccion.get(comboBoxSeleccionarCuenta.getSelectedIndex()).getNumCuenta(),
				cuentas.get(comboBoxSeleccionarCuentaDestinatario.getSelectedIndex()).getCodCuenta(),
				Integer.valueOf(textFieldCantidad.getText()),
				arrClienteTransaccion.get(comboBoxSeleccionarCuenta.getSelectedIndex()).getCodSucursal(),
				cuentas.get(comboBoxSeleccionarCuentaDestinatario.getSelectedIndex()).getCodSucursal()
				);
	}
	
	public void errorInput() {
		int res = JOptionPane.showConfirmDialog(null, "Saldo insuficiente. Desea seguir con la trasferencia");
		if (res != 0) {
			ArrayList<String> arr= new ArrayList<>();
			textFieldDNI.setText("");
			comboBoxSeleccionarCuenta.setModel(new DefaultComboBoxModel(arr.toArray()));
			textFieldCantidad.setText("");
		} 
	}
}
