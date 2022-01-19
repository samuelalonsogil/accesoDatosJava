package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modeloVo.Propietario;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form02GPropietarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldDireccion;
	private JTextField textFieldCP;
	private JTextField textFieldCiudad;
	private JTextField textFieldProvincia;
	private JTextField textFieldTelefono;
	private DefaultTableModel dm;
	private JScrollPane scrollPane;
	private JTable table;
	
	private Controlador controlador = new Controlador();
	
	private void asignarModeloTabla() {
		dm = new DefaultTableModel();
		
		dm.addColumn("DNI");
		dm.addColumn("Nombre");
		dm.addColumn("Apellidos");
		dm.addColumn("Direccion");
		dm.addColumn("C.P.");
		dm.addColumn("Ciudad");
		dm.addColumn("Provincia");
		dm.addColumn("Teléfono");
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Form02GPropietarios dialog = new Form02GPropietarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	/**
	 * Create the dialog.
	 */
	public Form02GPropietarios() {
		setTitle("Gesti\u00F3n Inmobiliaria Casa");
		setBounds(100, 100, 890, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTI\u00D3N PROPIETARIOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 854, 14);
		contentPanel.add(lblNewLabel);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new BtnNuevoActionListener());
		
		btnNuevo.setBounds(749, 43, 89, 23);
		contentPanel.add(btnNuevo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new BtnModificarActionListener());
		btnModificar.setBounds(749, 94, 89, 23);
		contentPanel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		btnEliminar.setBounds(749, 147, 89, 23);
		contentPanel.add(btnEliminar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Propietarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 36, 716, 146);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 21, 22, 14);
		panel.add(lblDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(84, 15, 113, 20);
		panel.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(202, 21, 57, 14);
		panel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(258, 15, 108, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(378, 21, 73, 14);
		panel.add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(461, 18, 241, 20);
		panel.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n: ");
		lblDireccin.setBounds(10, 52, 64, 14);
		panel.add(lblDireccin);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(84, 46, 254, 20);
		panel.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JLabel lblCdigoPostal = new JLabel("C\u00F3digo Postal:");
		lblCdigoPostal.setBounds(377, 52, 89, 14);
		panel.add(lblCdigoPostal);
		
		textFieldCP = new JTextField();
		textFieldCP.setBounds(461, 49, 86, 20);
		panel.add(textFieldCP);
		textFieldCP.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 77, 64, 14);
		panel.add(lblCiudad);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setBounds(84, 74, 239, 20);
		panel.add(textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(378, 80, 78, 14);
		panel.add(lblProvincia);
		
		textFieldProvincia = new JTextField();
		textFieldProvincia.setBounds(461, 77, 199, 20);
		panel.add(textFieldProvincia);
		textFieldProvincia.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(84, 105, 177, 20);
		panel.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 111, 64, 14);
		panel.add(lblTelfono);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 193, 775, 119);
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
		
		asignarModeloTabla();
		
		table = new JTable(dm);
		table.addMouseListener(new TableMouseListener());
		
		scrollPane.setViewportView(table);
		
		ArrayList<Propietario> propietarios = controlador.cargarPropietarios();
		
		for( Propietario propietario : propietarios) {
			Object [] row = {
					propietario.getDni(),
					propietario.getNombre(),
					propietario.getApellidos(),
					propietario.getDireccion(),
					propietario.getCiudad(),
					propietario.getCodPostal(),
					propietario.getProvincia(),
					propietario.getTelefono()
			};
			dm.addRow(row);
		}
	}
	private class TableMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int fila = table.getSelectedRow();
			textFieldDni.setText(""+table.getValueAt(fila, 0));
			textFieldNombre.setText((String) table.getValueAt(fila, 1));
			textFieldApellidos.setText(""+table.getValueAt(fila, 2));
			textFieldDireccion.setText(""+table.getValueAt(fila, 3));
			textFieldCiudad.setText(""+table.getValueAt(fila, 4));
			textFieldCP.setText(""+table.getValueAt(fila, 5));
			textFieldProvincia.setText(""+table.getValueAt(fila, 6));
			textFieldTelefono.setText(""+table.getValueAt(fila, 7));
			
			textFieldDni.setEditable(false);
		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Propietario propietario = new Propietario(
					textFieldDni.getText(),
					textFieldNombre.getText(),
					textFieldApellidos.getText(),
					textFieldDireccion.getText(),
					textFieldCiudad.getText(),
					Integer.parseInt(textFieldCP.getText()),
					textFieldProvincia.getText(),
					textFieldTelefono.getText()
					); 
					
			if(controlador.modificarPropietario(propietario) != 0) {
				JOptionPane.showMessageDialog(null, "Actualización OK");
				cargarTabla();
				limpiar();
				
			}else {
				JOptionPane.showMessageDialog(null, "Error Actualización ");
			}
			}

		
	}
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(controlador.comprobarInmuebles(textFieldDni.getText()).size() != 0){
				JOptionPane.showMessageDialog(null, "El propietario no se puede eliminar");
			}else {
				if(controlador.eliminarPropietario(textFieldDni.getText()) != 0) {
					JOptionPane.showMessageDialog(null, "Eliminación OK");
					cargarTabla();
					limpiar();
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Error al Eliminar ");
				}
			}
			
		} 
	}
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			limpiar();
		}
	}
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	private class BtnNuevoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private void limpiar() {
		textFieldDni.setText("");
		textFieldNombre.setText("");
		textFieldApellidos.setText("");
		textFieldDireccion.setText("");
		textFieldCiudad.setText("");
		textFieldCP.setText("");
		textFieldProvincia.setText("");
		textFieldTelefono.setText("");
		textFieldDni.requestFocus();
		textFieldDni.setEditable(true);
		
		
	}
}
