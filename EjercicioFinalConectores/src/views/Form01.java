package views;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controller.Controller;
import convertirFechasDate.ConvertirFechas;
import modeloDao.CuentaDAO;
import modeloVO.Cliente;
import modeloVO.Cuenta;
import modeloVO.CuentaCliente;
import modeloVO.Sucursal;
import modelosViews.ModeloComboBoxClientes;
import modelosViews.ModeloComboBoxSucursales;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form01 extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNumeroCuenta;
	private JTextField textFieldFecha01;
	private JTextField textFieldSaldo;
	public ConvertirFechas conversor = new ConvertirFechas();
	
	/*Launch the application.*/
	public static void main(String[] args) {
		try {
			Form01 dialog = new Form01();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/*Create the dialog.*/
	public Form01() {
		setBounds(100, 100, 857, 315);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 831, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setToolTipText("");
			panel.setBorder(new TitledBorder(null, "Cuentas", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel.setBounds(10, 21, 822, 196);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel label01 = new JLabel("N\u00BA Cuenta:");
			label01.setBounds(30, 27, 156, 17);
			panel.add(label01);
			{
				JLabel label02 = new JLabel("Cliente: ");
				label02.setBounds(30, 66, 147, 14);
				panel.add(label02);
			}
			{
				JLabel label03 = new JLabel("Sucursal: ");
				label03.setBounds(30, 102, 147, 14);
				panel.add(label03);
			}
			{
				JLabel label04 = new JLabel("Fecha: ");
				label04.setBounds(167, 137, 48, 14);
				panel.add(label04);
			}
			
			textFieldNumeroCuenta = new JTextField();
			textFieldNumeroCuenta.setBounds(187, 24, 270, 20);
			panel.add(textFieldNumeroCuenta);
			textFieldNumeroCuenta.setColumns(10);
			
			textFieldFecha01 = new JTextField();
			textFieldFecha01.setBounds(211, 134, 86, 20);
			panel.add(textFieldFecha01);
			textFieldFecha01.setColumns(10);
			
			textFieldSaldo = new JTextField();
			textFieldSaldo.setBounds(371, 134, 86, 20);
			panel.add(textFieldSaldo);
			textFieldSaldo.setColumns(10);
			
			JLabel label05 = new JLabel("Saldo: ");
			label05.setBounds(327, 137, 54, 14);
			panel.add(label05);
			
			/*ComboBox clientes*/
			ModeloComboBoxClientes boxClientes = new ModeloComboBoxClientes();
			boxClientes.setBounds(187, 62, 270, 22);
			panel.add(boxClientes);
			
			/*ComboBox sucursales*/
			ModeloComboBoxSucursales boxSucursales = new ModeloComboBoxSucursales();
			boxSucursales.setBounds(187, 98, 270, 22);
			panel.add(boxSucursales);
			
			/*new account*/
			JButton btnNew = new JButton("Nuevo");
			btnNew.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					Cliente clienteCombo = (Cliente) boxClientes.getSelectedItem();
					Cuenta cuenta = new Cuenta();
					CuentaCliente cuentaCliente = new CuentaCliente();
					Controller controller = new Controller();
					
					if(textFieldNumeroCuenta.getText().isEmpty() || textFieldSaldo.getText().isEmpty() || textFieldFecha01.getText().isEmpty() ) {
						JOptionPane.showMessageDialog(null, "Completa todos los campos");
					}else {
					
					cuenta.setCodCuenta( Integer.parseInt(textFieldNumeroCuenta.getText() ) );
					cuenta.setCodSucursal( boxSucursales.getSelectedIndex() + 1 );
					cuenta.setFechaCreacion( ConvertirFechas.convertirJavaDateASqlDate( ConvertirFechas.convertirStringDate( textFieldFecha01.getText() ) ) ) ;
					cuenta.setSaldo( Integer.parseInt( textFieldSaldo.getText() ) );
					
					cuentaCliente.setDni( clienteCombo.getDni() );
					cuentaCliente.setCodCuenta( cuenta.getCodCuenta() );
					
					controller.newAccount(cuenta, clienteCombo);
					
					JOptionPane.showMessageDialog(null, "Inserción correcta");
					}
				}
			});
			
			btnNew.setBounds(679, 18, 107, 23);
			panel.add(btnNew);
			
			JButton btnActualizar = new JButton("Actualizar");
			btnActualizar.setBounds(679, 57, 107, 23);
			panel.add(btnActualizar);
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.setBounds(679, 93, 107, 23);
			panel.add(btnEliminar);
			
			JButton btnListado = new JButton("Listado");
			btnListado.setBounds(679, 128, 107, 23);
			panel.add(btnListado);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 228, 821, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
