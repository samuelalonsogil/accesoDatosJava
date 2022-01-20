package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controller;
import logic.Logic;
import modeloVo.Zonas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ActualizarPrecios extends JDialog {

	private final JPanel generalPanel = new JPanel();
	private JTextField textFieldIncremento;
	public Controller controller = new Controller();
	public Logic logic = new Logic();
	
	/*Launch the application.*/
	public static void main(String[] args) {
		try {
			ActualizarPrecios dialog = new ActualizarPrecios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*Create the dialog.*/
	public ActualizarPrecios() {
		setTitle("Gesti\u00F3n inmobiliaria de casas");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		generalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(generalPanel, BorderLayout.CENTER);
		generalPanel.setLayout(null);
		
		JLabel lblZona = new JLabel("Zona: ");
		lblZona.setHorizontalAlignment(SwingConstants.CENTER);
		lblZona.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblZona.setBounds(25, 34, 56, 16);
		generalPanel.add(lblZona);
		
		JComboBox comboBoxZonas = new JComboBox();
		comboBoxZonas.setBounds(123, 32, 244, 22);
		comboBoxZonas.setModel(new DefaultComboBoxModel(getNombreZonas().toArray()));
		generalPanel.add(comboBoxZonas);
		
		JLabel lblIncremento = new JLabel("Incremento de Precio %");
		lblIncremento.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncremento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIncremento.setBounds(25, 90, 188, 35);
		generalPanel.add(lblIncremento);
		
		textFieldIncremento = new JTextField();
		textFieldIncremento.setBounds(35, 136, 168, 20);
		generalPanel.add(textFieldIncremento);
		textFieldIncremento.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String codeZona = zonas.get(comboBoxZonas.getSelectedIndex()).getCodigo();
						String porcentaje = textFieldIncremento.getText();
						
						if (!controller.validateNull(porcentaje) && !controller.validateNull(codeZona)) {
							controller.actualizarPrecio(porcentaje, codeZona);
							
							JOptionPane.showMessageDialog(null, "Modificación correcta");
						}else {
							JOptionPane.showMessageDialog(null, "Escribe algo");
						}
						
					}
				});
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
	
	/*cargar las zonas*/
	public ArrayList<Zonas> getZonas(){
		ArrayList<Zonas> zonas = controller.getZonas();
		return zonas;
	}
	
	public ArrayList<Zonas> zonas = getZonas();
	
	/*cargar nombre de las zonas en comboBox*/
	public ArrayList<String> getNombreZonas(){
		ArrayList<String> zonasNombre = new ArrayList<>();
		for(Zonas z : zonas) {
			zonasNombre.add(z.getNombre());
		}
		return zonasNombre;
	}
}
