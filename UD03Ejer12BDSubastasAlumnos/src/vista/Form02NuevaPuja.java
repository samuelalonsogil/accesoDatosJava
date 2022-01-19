package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import aaConvertirFechasDate.ConvertirFechas;
import controlador.Controlador;
import modeloVo.*;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class Form02NuevaPuja extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldFecha;
	private JTextField textFieldCantidad;
	
	
	
private Controlador controlador = new Controlador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Form02NuevaPuja dialog = new Form02NuevaPuja();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form02NuevaPuja() {
		setTitle("Subastas Vigo. Nueva Puja");
		setBounds(100, 100, 616, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelLotes = new JPanel();
		panelLotes.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lotes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLotes.setBounds(10, 11, 562, 59);
		contentPanel.add(panelLotes);
		panelLotes.setLayout(null);
		

		
		JPanel panelClientes = new JPanel();
		panelClientes.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelClientes.setBounds(10, 103, 562, 67);
		contentPanel.add(panelClientes);
		panelClientes.setLayout(null);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setBounds(463, 21, 89, 23);
		panelClientes.add(btnNewButton);
		
	
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 189, 562, 81);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha (DD-MM-AAAA HH:MM:SS):");
		lblFecha.setBounds(10, 31, 180, 14);
		panel.add(lblFecha);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(218, 28, 148, 20);
		panel.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(395, 31, 61, 14);
		panel.add(lblCantidad);
		
		
		
	
		
	
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(466, 28, 86, 20);
		panel.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
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
	
}
