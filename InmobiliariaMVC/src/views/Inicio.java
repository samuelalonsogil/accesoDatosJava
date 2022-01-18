package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Inicio extends JDialog {

	private final JPanel panelGeneral = new JPanel();

	/*Launch the application.*/
	public static void main(String[] args) {
		try {
			Inicio dialog = new Inicio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*Create the dialog.*/
	public Inicio() {
		setTitle("Gesti\u00F3n Inmobiliaria Casas");
		setBounds(100, 100, 391, 455);
		getContentPane().setLayout(new BorderLayout());
		panelGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelGeneral, BorderLayout.CENTER);
		panelGeneral.setLayout(null);
		{
			JButton newContract = new JButton("Nuevo Contrato");
			newContract.setBounds(10, 104, 155, 33);
			panelGeneral.add(newContract);
		}
		{
			JButton consultContracts = new JButton("Consultar contratos");
			consultContracts.setBounds(207, 104, 155, 33);
			panelGeneral.add(consultContracts);
		}
		
		JButton update = new JButton("Actualizar precios");
		update.setBounds(10, 184, 155, 33);
		panelGeneral.add(update);
		
		JButton alquileres = new JButton("Alquileres");
		alquileres.setBounds(207, 184, 155, 33);
		panelGeneral.add(alquileres);
		
		JButton gestionPropietarios = new JButton("Gesti\u00F3n propietarios");
		gestionPropietarios.setBounds(10, 262, 155, 33);
		panelGeneral.add(gestionPropietarios);
		
		JLabel lblNewLabel = new JLabel("Selecciona una opci\u00F3n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(99, 32, 185, 33);
		panelGeneral.add(lblNewLabel);
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
