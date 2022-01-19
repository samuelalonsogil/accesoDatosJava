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

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controlador.Controlador;
import convertirFechasDate.ConvertirFechas;
import modeloVo.*;

import java.awt.Color;

import javax.swing.JComboBox;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Form04NContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;

	private JTextField textFechaContrato;
	private JTextField textFechaVencimiento;
	private JTextField textPrecio;
	private ModeloComboInquilinos comboBoxInquilinos;
	private ModeloComboInmuebles comboBox;
	
	private Controlador controlador = new Controlador();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Form04NContrato dialog = new Form04NContrato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * Create the dialog.
	 */
	public Form04NContrato() {
		
		setTitle("Gesti\u00F3n Inmobiliaria Casas ");
		setBounds(100, 100, 631, 378);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONTRATO NUEVO");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 36, 569, 245);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 11, 63, 14);
		panel.add(lblCdigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(83, 8, 86, 20);
		panel.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblInquilino = new JLabel("Inquilino:");
		lblInquilino.setBounds(10, 45, 63, 14);
		panel.add(lblInquilino);
		
	
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 81, 63, 14);
		panel.add(lblDireccin);
		
		
		
		JLabel lblFechaContratoddmmyyyy = new JLabel("Fecha Contrato: (DD/MM/YYYY)");
		lblFechaContratoddmmyyyy.setBounds(10, 118, 184, 14);
		panel.add(lblFechaContratoddmmyyyy);
		
		JLabel lblFechaCvencimientoddmmyyyy = new JLabel("Fecha Vencimiento: (DD/MM/YYYY)");
		lblFechaCvencimientoddmmyyyy.setBounds(10, 143, 262, 14);
		panel.add(lblFechaCvencimientoddmmyyyy);
		
		textFechaContrato = new JTextField();
		textFechaContrato.setBounds(233, 115, 86, 20);
		panel.add(textFechaContrato);
		textFechaContrato.setColumns(10);
		
		textFechaVencimiento = new JTextField();
		textFechaVencimiento.setBounds(233, 140, 86, 20);
		panel.add(textFechaVencimiento);
		textFechaVencimiento.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 179, 46, 14);
		panel.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.addKeyListener(new TextPrecioKeyListener());
		textPrecio.setBounds(83, 176, 86, 20);
		panel.add(textPrecio);
		textPrecio.setColumns(10);
		
		comboBoxInquilinos = new ModeloComboInquilinos();
		comboBoxInquilinos.setBounds(83, 42, 460, 20);
		panel.add(comboBoxInquilinos);
		
		comboBox = new ModeloComboInmuebles();
		comboBox.setBounds(83, 78, 460, 20);
		panel.add(comboBox);
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
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(controlador.validarNulo(textCodigo.getText())) {
				JOptionPane.showMessageDialog(null, "El Nº Contrato no puede ser nulo");
				textCodigo.requestFocus();
			}else {
				Inquilinos inquilino = (Inquilinos) comboBoxInquilinos.getSelectedItem();
				Inmuebles inmueble = (Inmuebles) comboBox.getSelectedItem();
				if(controlador.validarNulo(textFechaContrato.getText())) {
					JOptionPane.showMessageDialog(null, "La fecha del contrato no puede ser nula");
					textFechaContrato.requestFocus();
				}else {
					if(controlador.validarNulo(textFechaVencimiento.getText())) {
						JOptionPane.showMessageDialog(null, "La fecha de vencimiento no puede ser nula");
						textFechaVencimiento.requestFocus();
					}else {
						if(controlador.validarNulo(textPrecio.getText())) {
							JOptionPane.showMessageDialog(null, "El Precio no puede ser nulo");
							textPrecio.requestFocus();
						}else {
							Contratos contrato = new Contratos(
									textCodigo.getText(),
									inquilino.getDni(),
									inmueble.getCodigo(),
									ConvertirFechas.convertirStringDate(textFechaContrato.getText()),
									ConvertirFechas.convertirStringDate(textFechaVencimiento.getText()),
									Double.parseDouble(textPrecio.getText()));
									
									
							if(controlador.insertarContrato(contrato)!= 0)
								JOptionPane.showMessageDialog(null, "Inserción OK");
							else
								JOptionPane.showMessageDialog(null, "Error al insertar");
							
						}
					}
					
				}
				
				
			}
			
		}
	}
	private class TextPrecioKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			//comprobar que no se pulsan letras
			if(controlador.isDigito(e.getKeyChar())) {
				e.consume();
			}
		}
	}
}
