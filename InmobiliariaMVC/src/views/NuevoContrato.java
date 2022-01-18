package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;
import modeloVO.Inquilinos;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class NuevoContrato extends JDialog {

	private final JPanel panelGeneral = new JPanel();
	private JTextField textField;
	private JTextField textFieldFechContrato;
	private JTextField textFieldFechVencimiento;
	private JTextField precioTextfield;
	
	public Controller controller = new Controller();
	
	/*Launch the application.*/
	public static void main(String[] args) {
		try {
			NuevoContrato dialog = new NuevoContrato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*Create the dialog.*/
	public NuevoContrato() {
		setBounds(100, 100, 664, 467);
		getContentPane().setLayout(null);
		panelGeneral.setBounds(0, 0, 809, 411);
		panelGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelGeneral);
		panelGeneral.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBounds(10, 59, 620, 308);
			panelGeneral.add(panel);
			panel.setLayout(null);
			{
				JLabel codeLbl = new JLabel("C\u00F3digo:");
				codeLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
				codeLbl.setHorizontalAlignment(SwingConstants.CENTER);
				codeLbl.setBounds(10, 21, 62, 27);
				panel.add(codeLbl);
			}
			
			textField = new JTextField();
			textField.setBounds(95, 25, 142, 20);
			panel.add(textField);
			textField.setColumns(10);
			
			JLabel inquilinoLbl = new JLabel("Inquilino: ");
			inquilinoLbl.setHorizontalAlignment(SwingConstants.CENTER);
			inquilinoLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
			inquilinoLbl.setBounds(10, 59, 62, 27);
			panel.add(inquilinoLbl);
			
			JLabel direccionLbl = new JLabel("Direcci\u00F3n:");
			direccionLbl.setHorizontalAlignment(SwingConstants.CENTER);
			direccionLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
			direccionLbl.setBounds(10, 97, 62, 27);
			panel.add(direccionLbl);
			
			JLabel fechaContratoLbl = new JLabel("Fecha contrato:");
			fechaContratoLbl.setHorizontalAlignment(SwingConstants.CENTER);
			fechaContratoLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
			fechaContratoLbl.setBounds(10, 135, 94, 27);
			panel.add(fechaContratoLbl);
			
			JLabel fechaVencimientoLbl = new JLabel("Fecha vencimiento: ");
			fechaVencimientoLbl.setHorizontalAlignment(SwingConstants.CENTER);
			fechaVencimientoLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
			fechaVencimientoLbl.setBounds(10, 173, 110, 27);
			panel.add(fechaVencimientoLbl);
			
			JLabel precioLbl = new JLabel("Precio:");
			precioLbl.setHorizontalAlignment(SwingConstants.CENTER);
			precioLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
			precioLbl.setBounds(10, 211, 62, 27);
			panel.add(precioLbl);
			
			JComboBox comboBoxInquilinos = new JComboBox();
			comboBoxInquilinos.setBounds(95, 62, 280, 22);
			comboBoxInquilinos.setModel(new DefaultComboBoxModel(getNombreInquilinos().toArray()));
			panel.add(comboBoxInquilinos);
			
			JComboBox comboBoxDireccion = new JComboBox();
			comboBoxDireccion.setBounds(95, 100, 280, 22);
			panel.add(comboBoxDireccion);
			
			textFieldFechContrato = new JTextField();
			textFieldFechContrato.setColumns(10);
			textFieldFechContrato.setBounds(124, 139, 142, 20);
			panel.add(textFieldFechContrato);
			
			textFieldFechVencimiento = new JTextField();
			textFieldFechVencimiento.setColumns(10);
			textFieldFechVencimiento.setBounds(124, 177, 142, 20);
			panel.add(textFieldFechVencimiento);
			
			precioTextfield = new JTextField();
			precioTextfield.setColumns(10);
			precioTextfield.setBounds(124, 215, 142, 20);
			panel.add(precioTextfield);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 378, 621, 33);
			panelGeneral.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
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
		
		JLabel lblTitle = new JLabel("Contrato nuevo");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitle.setBounds(237, 11, 117, 27);
		panelGeneral.add(lblTitle);
	}

	public ArrayList<Inquilinos> getInquilinos(){
		ArrayList<Inquilinos> inquilinos = controller.cargarBoxInquilinos();
		return inquilinos;
	}
	
	public ArrayList<Inquilinos> inquilinos = getInquilinos();
	
	public ArrayList<String> getNombreInquilinos(){
		ArrayList<String> inquilinosNombre = new ArrayList<>();
		for(Inquilinos i : inquilinos) {
			inquilinosNombre.add(i.getNombre());
		}
		return inquilinosNombre;
	}
}
