package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import DAOModels.ClienteDAO;
import VOModels.Cliente;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import DAOModels.ClienteDAO;
import DAOModels.ListadoCuentasDAO;
import DAOModels.SucursalDAO;
import DAOModels.CuentaMantenimientoDAO;
import VOModels.Cliente;
import VOModels.ListadoCuentas;
import VOModels.Sucursal;

public class Mantenimiento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNCuenta;
	private JTextField textFieldFecha;
	private JTextField textFieldSaldo;
	private JComboBox comboBoxCuenta;
	
	public ArrayList<Cliente> clientes = getClientes();
	public String nombreActual = clientes.get(0).getNombre();
	public String apellidoActual = clientes.get(0).getApellidos();
	
	public ArrayList<Sucursal> sucursales = getSucursales();
	private JComboBox comboBoxSucursal;
	private JButton btnNuevo;
	private JButton btnListado;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Mantenimiento dialog = new Mantenimiento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Mantenimiento() {
		setBounds(100, 100, 700, 300);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelCuentas = new JPanel();
			panelCuentas.setBounds(20, 0, 664, 157);
			panelCuentas.setBorder(new TitledBorder(null, "Cuentas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panelCuentas);
			panelCuentas.setLayout(null);
			
			JLabel lblNewLabelNCuenta = new JLabel("N\u00BA Cuenta:");
			lblNewLabelNCuenta.setBounds(20, 24, 75, 14);
			panelCuentas.add(lblNewLabelNCuenta);
			
			JLabel lblNewLabelSucursal = new JLabel("Sucursal:");
			lblNewLabelSucursal.setBounds(20, 85, 75, 14);
			panelCuentas.add(lblNewLabelSucursal);
			
			JLabel lblNewLabelCuenta = new JLabel("Cliente: ");
			lblNewLabelCuenta.setBounds(20, 55, 75, 14);
			panelCuentas.add(lblNewLabelCuenta);
			
			JLabel lblNewLabelFecha = new JLabel("Fecha:");
			lblNewLabelFecha.setBounds(20, 115, 75, 14);
			panelCuentas.add(lblNewLabelFecha);
			
			textFieldNCuenta = new JTextField();
			textFieldNCuenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			textFieldNCuenta.setBounds(100, 21, 300, 20);
			panelCuentas.add(textFieldNCuenta);
			textFieldNCuenta.setColumns(10);
			
			comboBoxCuenta = new JComboBox();
			comboBoxCuenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nombreActual = clientes.get(comboBoxCuenta.getSelectedIndex()).getNombre();
					apellidoActual = clientes.get(comboBoxCuenta.getSelectedIndex()).getApellidos();
				}
			});
			comboBoxCuenta.setBounds(100, 51, 300, 22);
			comboBoxCuenta.setModel(new DefaultComboBoxModel(getClientNames().toArray()));
			clientes = getClientes();
			nombreActual = clientes.get(0).getNombre();
			apellidoActual = clientes.get(0).getApellidos();
			panelCuentas.add(comboBoxCuenta);
			
			comboBoxSucursal = new JComboBox();
			comboBoxSucursal.setModel(new DefaultComboBoxModel(getNombresSucursales().toArray()));
			comboBoxSucursal.setBounds(100, 81, 300, 22);
			panelCuentas.add(comboBoxSucursal);
			
			textFieldFecha = new JTextField();
			textFieldFecha.setBounds(100, 112, 86, 20);
			panelCuentas.add(textFieldFecha);
			textFieldFecha.setColumns(10);
			
			JLabel lblNewLabelSaldo = new JLabel("Saldo:");
			lblNewLabelSaldo.setBounds(258, 115, 46, 14);
			panelCuentas.add(lblNewLabelSaldo);
			
			textFieldSaldo = new JTextField();
			textFieldSaldo.setBounds(314, 112, 86, 20);
			panelCuentas.add(textFieldSaldo);
			textFieldSaldo.setColumns(10);
			
			btnNuevo = new JButton("Nuevo");
			btnNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nuevaCuenta();
				}
			});
			btnNuevo.setBounds(490, 21, 100, 23);
			panelCuentas.add(btnNuevo);
			
			JButton btnActualizar = new JButton("Actualizar");
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizarCuentas();
				}
			});
			btnActualizar.setBounds(490, 51, 100, 23);
			panelCuentas.add(btnActualizar);
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarCuenta();
				}
			});
			btnEliminar.setBounds(490, 81, 100, 23);
			panelCuentas.add(btnEliminar);
			
			btnListado = new JButton("Listado");
			btnListado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Visual.Listado.main(null);
				}
			});
			btnListado.setBounds(490, 111, 100, 23);
			panelCuentas.add(btnListado);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
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
	
	public ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> clientes = ClienteDAO.getClientes();
		return clientes;
	}
	
	public ArrayList<String> getClientNames() {
		
		ArrayList<String> nombres = new ArrayList<String>();
		
		for (Cliente c: clientes) {
			nombres.add(c.getApellidos() + ", " + c.getNombre());
		}
		
		return nombres;
	}
	
	public ArrayList<Sucursal> getSucursales() {
		ArrayList<Sucursal> sol = SucursalDAO.getSucursales();
		return sol;
	}
	
	public ArrayList<String> getNombresSucursales() {
		ArrayList<String> nombres = new ArrayList<>();
		
		for (Sucursal s: sucursales) {
			nombres.add(s.getCiudad());
		}
		
		return nombres;
	}
	
	public void nuevaCuenta() {
		
		int nAcc = Integer.parseInt(textFieldNCuenta.getText());
		int dniCliente = clientes.get(comboBoxCuenta.getSelectedIndex()).getDni();
		int codSucursal = sucursales.get(comboBoxSucursal.getSelectedIndex()).getCod();
		Date fecha = (java.sql.Date) Date.valueOf(textFieldFecha.getText());
		int saldo = Integer.parseInt(textFieldSaldo.getText());
		
		CuentaMantenimientoDAO.newAcc(nAcc, dniCliente, codSucursal, fecha, saldo);
	}
	
	public void actualizarCuentas() {
		int nAcc = Integer.parseInt(textFieldNCuenta.getText());
		int dniCliente = clientes.get(comboBoxCuenta.getSelectedIndex()).getDni();
		int codSucursal = sucursales.get(comboBoxSucursal.getSelectedIndex()).getCod();
		Date fecha = (java.sql.Date) Date.valueOf(textFieldFecha.getText());
		int saldo = Integer.parseInt(textFieldSaldo.getText());
		
		CuentaMantenimientoDAO.updateAcc(nAcc, dniCliente, codSucursal, fecha, saldo);
	}

	public void eliminarCuenta() {
		int nAcc = Integer.parseInt(textFieldNCuenta.getText());
		
		CuentaMantenimientoDAO.deleteAcc(nAcc);
	}
}