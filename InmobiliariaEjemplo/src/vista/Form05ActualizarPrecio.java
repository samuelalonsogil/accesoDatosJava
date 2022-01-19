package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modeloVo.Zonas;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Form05ActualizarPrecio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textIncrementoPrecio;
	private ModeloComboZonas comboBox;
	
	private Controlador controlador = new Controlador();
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Form05ActualizarPrecio dialog = new Form05ActualizarPrecio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form05ActualizarPrecio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\ProyectosAccesoDatos\\stock-vector-home-icon-160210421.jpg"));
		setTitle("Gesti\u00F3n Inmobilaria Casas");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Zona");
		lblNewLabel.setBounds(56, 26, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblIncrementoPrecio = new JLabel("% Incremento Precio");
		lblIncrementoPrecio.setBounds(56, 99, 120, 14);
		contentPanel.add(lblIncrementoPrecio);
		
		textIncrementoPrecio = new JTextField();
		textIncrementoPrecio.addKeyListener(new TextIncrementoPrecioKeyListener());
		textIncrementoPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		textIncrementoPrecio.setBounds(54, 120, 136, 20);
		contentPanel.add(textIncrementoPrecio);
		textIncrementoPrecio.setColumns(10);
		
		comboBox = new ModeloComboZonas();
		comboBox.setBounds(100, 23, 296, 20);
		contentPanel.add(comboBox);
		
	
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
			//coordinador.mostrarFormInicio();
		}
	}
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			Zonas zona = (Zonas) comboBox.getSelectedItem();
			
			if(controlador.validarNulo(textIncrementoPrecio.getText())) {
				JOptionPane.showMessageDialog(null, "El incremento n o puede ser nulo");
				textIncrementoPrecio.requestFocus();
			}else {
				if(controlador.actualizarPrecio(zona, textIncrementoPrecio.getText())) {
					JOptionPane.showMessageDialog(null, "La Actualización no se ha podido realizar");
				
				}else {
					JOptionPane.showMessageDialog(null, "Actualización OK");
				}
			}
			
			
		
		}
	}
	private class TextIncrementoPrecioKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if(controlador.isDigito(e.getKeyChar())) {
				e.consume();
			}
		}
	}
}
