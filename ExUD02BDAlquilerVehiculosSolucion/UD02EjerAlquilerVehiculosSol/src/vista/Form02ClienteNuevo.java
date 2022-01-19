package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modeloVo.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Form02ClienteNuevo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private Controlador controlador;
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldDireccion;
	private JTextField textFieldCodPostal;
	private JTextField textFieldCiudad;
	private JTextField textFieldProvincia;
	private JTextField textFieldTelefono;
	private JTextField textFieldNumTarjeta;



	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Form02ClienteNuevo dialog = new Form02ClienteNuevo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form02ClienteNuevo() {
		setTitle("Alquiler Veh\u00EDculos");
		setBounds(100, 100, 803, 374);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nuevo Cliente");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 11, 767, 32);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(20, 54, 757, 237);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblDni = new JLabel("DNI:");
				lblDni.setBounds(10, 11, 46, 14);
				panel.add(lblDni);
			}

			textFieldDni = new JTextField();
			textFieldDni.setBounds(76, 8, 86, 20);
			panel.add(textFieldDni);
			textFieldDni.setColumns(10);

			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(226, 11, 46, 14);
			panel.add(lblNombre);

			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(339, 8, 309, 20);
			panel.add(textFieldNombre);
			textFieldNombre.setColumns(10);

			textFieldDireccion = new JTextField();
			textFieldDireccion.setBounds(76, 62, 198, 20);
			panel.add(textFieldDireccion);
			textFieldDireccion.setColumns(10);

			textFieldCodPostal = new JTextField();
			textFieldCodPostal.addActionListener(new TextFieldCodPostalActionListener());
			textFieldCodPostal.addKeyListener(new TextFieldCodPostalKeyListener());
			textFieldCodPostal.setBounds(392, 62, 86, 20);
			panel.add(textFieldCodPostal);
			textFieldCodPostal.setColumns(10);

			textFieldCiudad = new JTextField();
			textFieldCiudad.setBounds(589, 62, 86, 20);
			panel.add(textFieldCiudad);
			textFieldCiudad.setColumns(10);

			textFieldProvincia = new JTextField();
			textFieldProvincia.setBounds(76, 119, 86, 20);
			panel.add(textFieldProvincia);
			textFieldProvincia.setColumns(10);

			textFieldTelefono = new JTextField();
			textFieldTelefono.setBounds(265, 119, 86, 20);
			panel.add(textFieldTelefono);
			textFieldTelefono.setColumns(10);

			textFieldNumTarjeta = new JTextField();
			textFieldNumTarjeta.setBounds(472, 119, 86, 20);
			panel.add(textFieldNumTarjeta);
			textFieldNumTarjeta.setColumns(10);

			JLabel lblDireccin = new JLabel("Direcci\u00F3n");
			lblDireccin.setBounds(10, 65, 46, 14);
			panel.add(lblDireccin);

			JLabel lblCp = new JLabel("C.P.: ");
			lblCp.setBounds(320, 65, 46, 14);
			panel.add(lblCp);

			JLabel lblCiudad = new JLabel("Ciudad:");
			lblCiudad.setBounds(512, 65, 46, 14);
			panel.add(lblCiudad);

			JLabel lblProvincia = new JLabel("Provincia:");
			lblProvincia.setBounds(10, 122, 46, 14);
			panel.add(lblProvincia);

			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setBounds(194, 122, 46, 14);
			panel.add(lblTelfono);

			JLabel lblTarjeta = new JLabel("N\u00BA Tarjeta:");
			lblTarjeta.setBounds(405, 122, 46, 14);
			panel.add(lblTarjeta);
		}
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
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

	private class TextFieldCodPostalKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			//comprueba si el caracter tecleado es un digito devuelve true si es digito
			if(!controlador.isDigitte(e.getKeyChar())) {
				//... no lo escribe
				e.consume();
			}
		}
	}
	private class TextFieldCodPostalActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//comprueba que la longitiud sea 5
			if(!controlador.comprobarLongitud(textFieldCodPostal.getText().length(), 5)) {
				JOptionPane.showMessageDialog(null, "El C.P. tiene que tener 5 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
				textFieldCodPostal.requestFocus();
				textFieldCodPostal.selectAll();
			}
		}
	}

	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(controlador.validarNulo(textFieldDni.getText())) {
				JOptionPane.showMessageDialog(null, "El DNI no puede ser nulo", "Error", JOptionPane.ERROR_MESSAGE);
				textFieldDni.requestFocus();
				textFieldDni.selectAll();
			}else {
				if(controlador.validarNulo(textFieldNombre.getText())) {
					JOptionPane.showMessageDialog(null, "El Nombre no puede ser nulo", "Error", JOptionPane.ERROR_MESSAGE);
					textFieldNombre.requestFocus();
					textFieldNombre.selectAll();
				}else {
					if(controlador.validarNulo(textFieldDireccion.getText())) {
						JOptionPane.showMessageDialog(null, "La dirección no puede ser nula", "Error", JOptionPane.ERROR_MESSAGE);
						textFieldDireccion.requestFocus();
						textFieldDireccion.selectAll();
					}else {
						if(controlador.validarNulo(textFieldCodPostal.getText())) {
							JOptionPane.showMessageDialog(null, "El C.P. no puede ser nulo", "Error", JOptionPane.ERROR_MESSAGE);
							textFieldCodPostal.requestFocus();
							textFieldCodPostal.selectAll();
						}else {
							if(controlador.validarNulo(textFieldCiudad.getText())) {
								JOptionPane.showMessageDialog(null, "La ciudad no puede ser nula", "Error", JOptionPane.ERROR_MESSAGE);
								textFieldCiudad.requestFocus();
								textFieldCiudad.selectAll();
							}else {
								if(controlador.validarNulo(textFieldTelefono.getText())) {
									JOptionPane.showMessageDialog(null, "El Teléfono no puede ser nulo", "Error", JOptionPane.ERROR_MESSAGE);
									textFieldTelefono.requestFocus();
									textFieldTelefono.selectAll();
								}else {
									if(controlador.validarNulo(textFieldNumTarjeta.getText())) {
										JOptionPane.showMessageDialog(null, "El Nº de Tarjeta no puede ser nulo", "Error", JOptionPane.ERROR_MESSAGE);
										textFieldNumTarjeta.requestFocus();
										textFieldNumTarjeta.selectAll();
									}else {
										Cliente cliente = new Cliente(
												textFieldDni.getText(),
												textFieldNombre.getText(),
												textFieldDireccion.getText(),
												textFieldCiudad.getText(),
												Integer.parseInt(textFieldCodPostal.getText()),
												textFieldProvincia.getText(),
												Integer.parseInt(textFieldTelefono.getText()),
												textFieldNumTarjeta.getText());		
										
										if(controlador.consultarCliente(textFieldDni.getText()) == null)
											if(controlador.nuevoCliente(cliente) != 0)
												JOptionPane.showMessageDialog(null,"Inserción correcta","Inforación",
													JOptionPane.INFORMATION_MESSAGE);
											else
												JOptionPane.showMessageDialog(null, "No se ha podido "
														+ "añadir el nuevo Departamento", "Error", JOptionPane.ERROR_MESSAGE);
									}
								}
							}
						}
					}	
				}
			}
		}		
	}
}