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
import javax.swing.JFrame;
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
import modeloVO.ListadoCuentas;
import modelosViews.ModeloComboBoxClientes;

public class Form02_b extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JScrollPane scrollPane;
	private ModeloComboBoxClientes comboBoxClientes;

	private DefaultTableModel dm;
	private DefaultTableCellRenderer alinearCentro, alinearDerecha, alinearIzquierda;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form02_b frame = new Form02_b();
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
	public Form02_b() {
		setTitle("Banco Vigo");
		setBounds(100, 100, 903, 588);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBounds(10, 11, 867, 65);
			contentPanel.add(panel);
			panel.setLayout(null);

			{

				JLabel lblNewLabel = new JLabel("Seleccionar Cliente: ");
				lblNewLabel.setBounds(10, 23, 196, 14);
				panel.add(lblNewLabel);

				comboBoxClientes = new ModeloComboBoxClientes();
				comboBoxClientes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cargarTabla();
					}
				});
				comboBoxClientes.setBounds(252, 14, 248, 32);
				panel.add(comboBoxClientes);
			}

		}

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 867, 418);
		contentPanel.add(scrollPane);
		cargarTabla();

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

	public void cargarTabla() {
		asignarColumnas();
		inicializarRenderer();

		table = new JTable(dm);
		scrollPane.setViewportView(table);

		table.getColumnModel().getColumn(0).setCellRenderer(alinearIzquierda);
		table.getColumnModel().getColumn(1).setCellRenderer(alinearCentro);
		table.getColumnModel().getColumn(2).setCellRenderer(alinearDerecha);
		table.getColumnModel().getColumn(3).setCellRenderer(alinearDerecha);

		ArrayList<ListadoCuentas> cuentas = controller.cargarCuentas( );
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());

		for (ListadoCuentas cuenta : cuentas) {
			Object[] row = { cuenta.getCodCuenta(), cuenta.getCodSucursal(), cuenta.getCiudad(),
					nf.format(cuenta.getActivo()) };
			dm.addRow(row);
		}

	}

	public class BtnCancelActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

}
