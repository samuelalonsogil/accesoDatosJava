package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Controller;

import modeloVO.ClienteTransaccion;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Form03_b extends JDialog {

	private final JPanel contentPanelGeneral = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	
	public JComboBox boxCuentas;
	public JComboBox comboBox02;
	
	Controller controller = new Controller();
	
	/*Launch the application.*/
	public static void main(String[] args) {
		try {
			Form03_b dialog = new Form03_b();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Create the dialog.*/
	public Form03_b() {
		setTitle("BancoVigo");
		setBounds(100, 100, 982, 523);
		getContentPane().setLayout(new BorderLayout());
		contentPanelGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanelGeneral, BorderLayout.CENTER);
		contentPanelGeneral.setLayout(null);
		{
			JLabel lblTitle = new JLabel("Transacciones");
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setBounds(388, 22, 141, 33);
			lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanelGeneral.add(lblTitle);
		}
		
		JPanel panelOpcion = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelOpcion.getLayout();
		flowLayout.setHgap(150);
		panelOpcion.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Selecci\u00F3n Operaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOpcion.setBounds(10, 66, 946, 70);
		contentPanelGeneral.add(panelOpcion);
		
		JRadioButton optionIngreso = new JRadioButton("Ingreso");
		panelOpcion.add(optionIngreso);
		
		JRadioButton optionReintegro = new JRadioButton("Reintegro");
		optionReintegro.setHorizontalAlignment(SwingConstants.CENTER);
		panelOpcion.add(optionReintegro);
		
		JRadioButton optionTransferencia = new JRadioButton("Transferencia");
		panelOpcion.add(optionTransferencia);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCliente.setBounds(10, 165, 946, 95);
		contentPanelGeneral.add(panelCliente);
		panelCliente.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setBounds(25, 39, 29, 16);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		panelCliente.add(lblDni);
		
		textField = new JTextField();
		textField.setBounds(74, 37, 86, 20);
		panelCliente.add(textField);
		textField.setColumns(10);
		
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fillCuentasTransaccion();
			}
		});
		
		JLabel lblSeleccionarCuenta = new JLabel("Seleccionar cuenta:");
		lblSeleccionarCuenta.setBounds(180, 39, 113, 16);
		lblSeleccionarCuenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCliente.add(lblSeleccionarCuenta);
		
		/*cargar comboBox*/
		boxCuentas = new JComboBox();
		boxCuentas.setBounds(313, 36, 262, 22);
		boxCuentas.setMaximumRowCount(20);
		panelCliente.add(boxCuentas);
		
		JLabel lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidad.setBounds(598, 39, 86, 16);
		panelCliente.add(lblCantidad);
		
		textField_1 = new JTextField();
		textField_1.setBounds(663, 38, 167, 20);
		panelCliente.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panelDestinatario = new JPanel();
		panelDestinatario.setLayout(null);
		panelDestinatario.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Destinatario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDestinatario.setBounds(10, 295, 946, 95);
		contentPanelGeneral.add(panelDestinatario);
		
		JLabel lblSeleccionarCuentaDestinatario = new JLabel("Seleccionar cuenta:");
		lblSeleccionarCuentaDestinatario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSeleccionarCuentaDestinatario.setBounds(180, 39, 113, 16);
		panelDestinatario.add(lblSeleccionarCuentaDestinatario);
		
		comboBox02 = new JComboBox();
		comboBox02.setMaximumRowCount(20);
		comboBox02.setBounds(313, 36, 262, 22);
		panelDestinatario.add(comboBox02);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
	ArrayList<ClienteTransaccion> clienteTransaccion = new ArrayList<>();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void fillCuentasTransaccion() {
		String dni = textField.getText() ;
		clienteTransaccion = controller.cargarCuentasComboBox(dni);
		
		ArrayList<String> datosCuentasComboBox = new ArrayList<>();
		
		for (ClienteTransaccion c: clienteTransaccion) {
			datosCuentasComboBox.add("Num Cuenta: " + c.getCodCuenta() + ", Saldo: " + c.getActivos());
		}
		
		boxCuentas.setModel(new DefaultComboBoxModel(datosCuentasComboBox.toArray()));
	}
	
	
	
}
