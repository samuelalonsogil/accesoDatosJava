package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import modeloVO.Cliente;
import modeloVO.Cuenta;
import modeloVO.ListadoCuentas;
import modelosViews.ModeloComboBoxClientes;
import java.awt.Font;
import java.awt.SystemColor;

public class Form02 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JScrollPane scrollPane;
	private ModeloComboBoxClientes boxClientes;

	private DefaultTableModel dm;
	private DefaultTableCellRenderer alinearCentro, alinearDerecha, alinearIzquierda;
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	Controller controller = new Controller();

	private void asignarColumnas() {
		dm = new DefaultTableModel();
		dm.addColumn("Num.Cta");
		dm.addColumn("Num.Sucursal");
		dm.addColumn("Ciudad");
		dm.addColumn("Saldo");
	}

	private void inicializarRenderer() {
		alinearCentro = new DefaultTableCellRenderer();
		alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);

		alinearDerecha = new DefaultTableCellRenderer();
		alinearDerecha.setHorizontalAlignment(SwingConstants.RIGHT);

		alinearIzquierda = new DefaultTableCellRenderer();
		alinearIzquierda.setHorizontalAlignment(SwingConstants.LEFT);
	}

	/*Launch the application.*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form02 frame = new Form02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*Create the frame.*/
	public Form02() {
		setTitle("Banco Vigo");
		setBounds(100, 100, 903, 588);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBounds(10, 70, 867, 65);
			contentPanel.add(panel);
			panel.setLayout(null);

			{

				JLabel lblNewLabel = new JLabel("Seleccionar Cliente: ");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(10, 23, 202, 23);
				panel.add(lblNewLabel);

				boxClientes = new ModeloComboBoxClientes();
				
				boxClientes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						clientes = controller.cargarClientes();
						cargarTabla(nombreCombo(clientes), apellidoCombo(clientes));
					}
				});
				boxClientes.setBounds(252, 14, 388, 32);
				panel.add(boxClientes);
			}

		}

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 146, 867, 359);
		contentPanel.add(scrollPane);
		{
			JLabel lblNewLabel_1 = new JLabel("Listado de cuentas");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel_1.setBounds(314, 21, 214, 19);
			contentPanel.add(lblNewLabel_1);
		}
		
		
		clientes = controller.cargarClientes();
		cargarTabla(nombreCombo(clientes), apellidoCombo(clientes));

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				// okButton.addActionListener(new OkButtonActionListener());
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new BtnCancelActionListener());
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

	}

	public void cargarTabla(String nombre, String apellidos) {
		asignarColumnas();
		inicializarRenderer();

		ArrayList<ListadoCuentas> cuentas = controller.cargarCuentas(nombre, apellidos);
		
		table = new JTable(dm);
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);

		table.getColumnModel().getColumn(0).setCellRenderer(alinearIzquierda);
		table.getColumnModel().getColumn(1).setCellRenderer(alinearCentro);
		table.getColumnModel().getColumn(2).setCellRenderer(alinearDerecha);
		table.getColumnModel().getColumn(3).setCellRenderer(alinearDerecha);

		

		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());

		for (ListadoCuentas cuenta : cuentas) {
			Object[] row = { cuenta.getCodCuenta(), cuenta.getCodSucursal(), cuenta.getCiudad(),nf.format(cuenta.getActivo()) };
			dm.addRow(row);
		}

	}

	public String nombreCombo(ArrayList<Cliente> cliente) {
		String nombre = cliente.get( boxClientes.getSelectedIndex() ).getNombre();
		return nombre;
	}
	
	public String apellidoCombo(ArrayList<Cliente> cliente) {
		String apellido = cliente.get( boxClientes.getSelectedIndex() ).getApellidos();
		return apellido;
	}
	
	public class BtnCancelActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

}
