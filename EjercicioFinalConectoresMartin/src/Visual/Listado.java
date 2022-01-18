package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAOModels.ClienteDAO;
import DAOModels.ListadoCuentasDAO;
import VOModels.Cliente;
import VOModels.ListadoCuentas;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class Listado extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public ArrayList<Cliente> clientes = getClientes();
	public String nombreActual = clientes.get(0).getNombre();
	public String apellidoActual = clientes.get(0).getApellidos();
	
	private DefaultTableModel model;
	private JTable table;
	private JLabel title;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Listado dialog = new Listado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Listado() {
		setBounds(100, 100, 700, 300);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		{
			title = new JLabel("LISTADO CUENTAS", SwingConstants.CENTER);
			sl_contentPanel.putConstraint(SpringLayout.NORTH, title, 5, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, title, 5, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, title, 42, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, title, 679, SpringLayout.WEST, contentPanel);
			title.setFont(new Font("Tahoma", Font.BOLD, 15));
			contentPanel.add(title);
		}
		
		JPanel panel = new JPanel();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, panel, 16, SpringLayout.SOUTH, title);
		sl_contentPanel.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, panel, -111, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, panel, 669, SpringLayout.WEST, contentPanel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel SeleccionClienteLabel = new JLabel("Seleccionar Cliente:");
		SeleccionClienteLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		SeleccionClienteLabel.setBounds(40, 19, 143, 14);
		panel.add(SeleccionClienteLabel);
		
		JComboBox comboClientes = new JComboBox();
		comboClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombreActual = clientes.get(comboClientes.getSelectedIndex()).getNombre();
				apellidoActual = clientes.get(comboClientes.getSelectedIndex()).getApellidos();

				fill();
				
			}
		});
		comboClientes.setBounds(193, 15, 291, 22);
		comboClientes.setModel(
				new DefaultComboBoxModel(getClientNames().toArray()));
		panel.add(comboClientes);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, scrollPane, 15, SpringLayout.SOUTH, panel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, scrollPane, 5, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, scrollPane, 213, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, scrollPane, 669, SpringLayout.WEST, contentPanel);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		fill();
		scrollPane.setColumnHeaderView(table);
		{
			clientes = getClientes();
			nombreActual = clientes.get(0).getNombre();
			apellidoActual = clientes.get(0).getApellidos();
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
	
	//public
	
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
	
	public void getTableModel(String nombreLista, String apellidosLista) {
		
		ArrayList<ListadoCuentas> arr = ListadoCuentasDAO.getLista(nombreLista, apellidosLista);
		
		String[] columnNames = {"Codigo Cuenta", "Codigo Sucursal", "Ciudad", "Saldo"};
		DefaultTableModel modelTable = new DefaultTableModel(columnNames, 0);
		
		
		for (ListadoCuentas l: arr) {	
			Object[] data = {l.getCodCuenta(), l.getCodSucursal(), l.getNomSucursal(), l.getSaldo()};
			modelTable.addRow(data);
		}
		
		table.setModel(modelTable);
	}
	
	public void fill() {
		getTableModel(nombreActual, apellidoActual);
	}
}
