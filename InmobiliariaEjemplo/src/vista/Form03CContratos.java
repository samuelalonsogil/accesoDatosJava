package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.Controlador;
import convertirFechasDate.ConvertirFechas;
import modeloVo.*;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form03CContratos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCodigo;
	private JTextField textFieldDniInqui;
	private JTextField textFieldNbInqui;
	private JTextField textFieldDireccion;
	private JTextField textFieldDniPropi;
	private JTextField textFieldNbPropi;
	private JTextField textFieldFecContrato;
	private JTextField textFieldFecVencimiento;
	private JTextField textFieldPrecio;

	private Controlador controlador = new Controlador();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Form03CContratos dialog = new Form03CContratos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the dialog.
	 */
	public Form03CContratos() {
		setTitle("Gesti\u00F3n Inmobiliaria Casas");
		setBounds(100, 100, 693, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setBounds(38, 39, 46, 14);
			contentPanel.add(lblNewLabel);
		}

		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(94, 36, 139, 20);
		contentPanel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 64, 657, 208);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Inquilino");
		lblNewLabel_1.setBounds(10, 14, 67, 14);
		panel.add(lblNewLabel_1);

		textFieldDniInqui = new JTextField();
		textFieldDniInqui.setEditable(false);
		textFieldDniInqui.setBounds(87, 11, 86, 20);
		panel.add(textFieldDniInqui);
		textFieldDniInqui.setColumns(10);

		textFieldNbInqui = new JTextField();
		textFieldNbInqui.setEditable(false);
		textFieldNbInqui.setBounds(208, 11, 439, 20);
		panel.add(textFieldNbInqui);
		textFieldNbInqui.setColumns(10);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(10, 52, 67, 14);
		panel.add(lblDireccin);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setEditable(false);
		textFieldDireccion.setBounds(87, 49, 560, 20);
		panel.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);

		JLabel lblPropietario = new JLabel("Propietario");
		lblPropietario.setBounds(10, 88, 79, 14);
		panel.add(lblPropietario);

		textFieldDniPropi = new JTextField();
		textFieldDniPropi.setEditable(false);
		textFieldDniPropi.setBounds(87, 85, 86, 20);
		panel.add(textFieldDniPropi);
		textFieldDniPropi.setColumns(10);

		textFieldNbPropi = new JTextField();
		textFieldNbPropi.setEditable(false);
		textFieldNbPropi.setBounds(188, 85, 459, 20);
		panel.add(textFieldNbPropi);
		textFieldNbPropi.setColumns(10);

		JLabel lblFechaContratoddmmaaaa = new JLabel("Fecha Contrato: (dd/mm/aaaa)");
		lblFechaContratoddmmaaaa.setBounds(10, 125, 151, 14);
		panel.add(lblFechaContratoddmmaaaa);

		textFieldFecContrato = new JTextField();
		textFieldFecContrato.setEditable(false);
		textFieldFecContrato.setBounds(171, 122, 121, 20);
		panel.add(textFieldFecContrato);
		textFieldFecContrato.setColumns(10);

		JLabel lblFechaVencimientoddmmaaaa = new JLabel("Fecha Vencimiento: (dd/mm/aaaa)");
		lblFechaVencimientoddmmaaaa.setBounds(322, 125, 194, 14);
		panel.add(lblFechaVencimientoddmmaaaa);

		textFieldFecVencimiento = new JTextField();
		textFieldFecVencimiento.setEditable(false);
		textFieldFecVencimiento.setBounds(526, 122, 121, 20);
		panel.add(textFieldFecVencimiento);
		textFieldFecVencimiento.setColumns(10);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setEditable(false);
		textFieldPrecio.setBounds(106, 158, 86, 20);
		panel.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 161, 46, 14);
		panel.add(lblPrecio);

		JLabel lblNewLabel_2 = new JLabel("CONSULTAS CONTRATOS");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 11, 657, 14);
		contentPanel.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPrimero = new JButton("<<");
				btnPrimero.addActionListener(new BtnPrimeroActionListener());
				buttonPane.add(btnPrimero);
			}
			{
				JButton btnAnterior = new JButton("<");
				btnAnterior.addActionListener(new BtnAnteriorActionListener());
				buttonPane.add(btnAnterior);
			}
			{
				JButton btnSiguiente = new JButton(">");
				buttonPane.add(btnSiguiente);
			}
			{
				JButton btnUltimo = new JButton(">>");
				btnUltimo.addActionListener(new BtnUltimoActionListener());
				buttonPane.add(btnUltimo);
			}
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
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if(controlador.validarNulo(textFieldCodigo.getText())) {
				JOptionPane.showMessageDialog(null, "El código no puede ser nulo");
				textFieldCodigo.requestFocus();
			}else {

				ConsultaContrato cContrato = controlador.consultaContrato(textFieldCodigo.getText());

				if(cContrato == null) {
					JOptionPane.showMessageDialog(null, "Contrato inexistente");
					textFieldCodigo.requestFocus();
				}else {

					textFieldCodigo.setText(cContrato.getCodContrato());
					textFieldDireccion.setText(cContrato.getDireccion());
					textFieldDniInqui.setText(cContrato.getDniInquilino());
					textFieldDniPropi.setText(cContrato.getDniPropietario());
					textFieldFecContrato.setText(ConvertirFechas.convertirDateString(cContrato.getFecContrato()));
					textFieldFecVencimiento.setText(ConvertirFechas.convertirDateString(cContrato.getFecVencimiento()));
					textFieldNbInqui.setText(cContrato.getNbInquilino());
					textFieldNbPropi.setText(cContrato.getNbPropietario());
					textFieldPrecio.setText(""+cContrato.getPrecio());
				}
			}
		}
	}
	private class BtnPrimeroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			ConsultaContrato cContrato = controlador.consultaPrimero();
			
			if(cContrato == null) {
				JOptionPane.showMessageDialog(null, "No hay contratos");
			}else {
				textFieldCodigo.setText(cContrato.getCodContrato());
				textFieldDireccion.setText(cContrato.getDireccion());
				textFieldDniInqui.setText(cContrato.getDniInquilino());
				textFieldDniPropi.setText(cContrato.getDniPropietario());
				textFieldFecContrato.setText(ConvertirFechas.convertirDateString(cContrato.getFecContrato()));
				textFieldFecVencimiento.setText(ConvertirFechas.convertirDateString(cContrato.getFecVencimiento()));
				textFieldNbInqui.setText(cContrato.getNbInquilino());
				textFieldNbPropi.setText(cContrato.getNbPropietario());
				textFieldPrecio.setText(""+cContrato.getPrecio());
			}
		}
	}
	private class BtnUltimoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ConsultaContrato cContrato = controlador.consultaUltimo();
			
			if(cContrato == null) {
				JOptionPane.showMessageDialog(null, "No hay contratos");
			}else {
				textFieldCodigo.setText(cContrato.getCodContrato());
				textFieldDireccion.setText(cContrato.getDireccion());
				textFieldDniInqui.setText(cContrato.getDniInquilino());
				textFieldDniPropi.setText(cContrato.getDniPropietario());
				textFieldFecContrato.setText(ConvertirFechas.convertirDateString(cContrato.getFecContrato()));
				textFieldFecVencimiento.setText(ConvertirFechas.convertirDateString(cContrato.getFecVencimiento()));
				textFieldNbInqui.setText(cContrato.getNbInquilino());
				textFieldNbPropi.setText(cContrato.getNbPropietario());
				textFieldPrecio.setText(""+cContrato.getPrecio());
			}
		}
	}
	private class BtnAnteriorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(controlador.validarNulo(textFieldCodigo.getText())) {
				JOptionPane.showMessageDialog(null, "El código no puede ser nulo");
				textFieldCodigo.requestFocus();
			}else {

				ConsultaContrato cContrato = controlador.consultaAnterior(textFieldCodigo.getText());

				if(cContrato == null) {
					JOptionPane.showMessageDialog(null, "Contrato inexistente");
					textFieldCodigo.requestFocus();
				}else {

					textFieldCodigo.setText(cContrato.getCodContrato());
					textFieldDireccion.setText(cContrato.getDireccion());
					textFieldDniInqui.setText(cContrato.getDniInquilino());
					textFieldDniPropi.setText(cContrato.getDniPropietario());
					textFieldFecContrato.setText(ConvertirFechas.convertirDateString(cContrato.getFecContrato()));
					textFieldFecVencimiento.setText(ConvertirFechas.convertirDateString(cContrato.getFecVencimiento()));
					textFieldNbInqui.setText(cContrato.getNbInquilino());
					textFieldNbPropi.setText(cContrato.getNbPropietario());
					textFieldPrecio.setText(""+cContrato.getPrecio());
				}
			}
		}
	}
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textFieldCodigo.setText("");
			textFieldDireccion.setText("");
			textFieldDniInqui.setText("");
			textFieldDniPropi.setText("");
			textFieldFecContrato.setText("");
			textFieldFecVencimiento.setText("");
			textFieldNbInqui.setText("");
			textFieldNbPropi.setText("");
			textFieldPrecio.setText("");
			textFieldCodigo.requestFocus();
		}
	}
}
