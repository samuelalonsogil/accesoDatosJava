package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;
import modeloVO.ListaContratos;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConsultasContratos extends JDialog {

	private final JPanel generalPanel = new JPanel();
	private JTextField textFieldCode;
	private JTextField textFieldInquilinoNombre;
	private JTextField textFieldDireccion;
	private JTextField textFieldPropietarioNombre;
	private JTextField textFieldFechaContrato;
	private JTextField textFieldPrecio;
	private JTextField textFieldPropietarioApellidos;
	private JTextField textFieldFechaVencimiento;
	
	public Controller controller = new Controller();
	
	
	
	/*Launch the application.*/
	public static void main(String[] args) {
		try {
			ConsultasContratos dialog = new ConsultasContratos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*Create the dialog.*/
	public ConsultasContratos() {
		setTitle("Gesti\u00F3n Inmobiliaria Casas");
		setBounds(100, 100, 1037, 508);
		getContentPane().setLayout(new BorderLayout());
		generalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(generalPanel, BorderLayout.CENTER);
		generalPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 92, 1001, 344);
		generalPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblInquilino = new JLabel("Inquilino: ");
		lblInquilino.setHorizontalAlignment(SwingConstants.CENTER);
		lblInquilino.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInquilino.setBounds(35, 31, 70, 22);
		panel.add(lblInquilino);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n: ");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDireccion.setBounds(35, 90, 70, 22);
		panel.add(lblDireccion);
		
		JLabel lblPropietario = new JLabel("Propietario: ");
		lblPropietario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPropietario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPropietario.setBounds(35, 152, 81, 22);
		panel.add(lblPropietario);
		
		JLabel lblFechaContrato = new JLabel("Fecha Contrato:");
		lblFechaContrato.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaContrato.setBounds(35, 215, 110, 22);
		panel.add(lblFechaContrato);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(35, 286, 70, 22);
		panel.add(lblPrecio);
		
		textFieldInquilinoNombre = new JTextField();
		textFieldInquilinoNombre.setColumns(10);
		textFieldInquilinoNombre.setBounds(115, 33, 760, 20);
		panel.add(textFieldInquilinoNombre);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(115, 92, 760, 20);
		panel.add(textFieldDireccion);
		
		textFieldPropietarioNombre = new JTextField();
		textFieldPropietarioNombre.setColumns(10);
		textFieldPropietarioNombre.setBounds(126, 154, 132, 20);
		panel.add(textFieldPropietarioNombre);
		
		textFieldFechaContrato = new JTextField();
		textFieldFechaContrato.setColumns(10);
		textFieldFechaContrato.setBounds(155, 217, 132, 20);
		panel.add(textFieldFechaContrato);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(126, 288, 132, 20);
		panel.add(textFieldPrecio);
		
		textFieldPropietarioApellidos = new JTextField();
		textFieldPropietarioApellidos.setColumns(10);
		textFieldPropietarioApellidos.setBounds(297, 154, 578, 20);
		panel.add(textFieldPropietarioApellidos);
		
		JLabel lblFechaVencimiento = new JLabel("Fecha Vencimiento:");
		lblFechaVencimiento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaVencimiento.setBounds(338, 215, 140, 22);
		panel.add(lblFechaVencimiento);
		
		textFieldFechaVencimiento = new JTextField();
		textFieldFechaVencimiento.setColumns(10);
		textFieldFechaVencimiento.setBounds(488, 217, 173, 20);
		panel.add(textFieldFechaVencimiento);
		
		JLabel lblCode = new JLabel("C\u00F3digo: ");
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCode.setBounds(62, 59, 70, 22);
		generalPanel.add(lblCode);
		
		textFieldCode = new JTextField();
		textFieldCode.setBounds(142, 61, 132, 20);
		generalPanel.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		JLabel lblConsultaContratos = new JLabel("Consultas Contratos");
		lblConsultaContratos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaContratos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConsultaContratos.setBounds(370, 11, 180, 33);
		generalPanel.add(lblConsultaContratos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnFirstContract = new JButton("<<");
			buttonPane.add(btnFirstContract);
			
			JButton btnPreviousContract = new JButton("<");
			buttonPane.add(btnPreviousContract);
			
			JButton btnNextContract = new JButton(">");
			buttonPane.add(btnNextContract);
			
			JButton btnLastContract = new JButton(">>");
			buttonPane.add(btnLastContract);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						
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
	public ArrayList<ListaContratos> getListadoContratos(){
		ArrayList<ListaContratos> listaContratos = controller.getListaContratos(textFieldCode.getText());
		return listaContratos;
	}
	
	public ArrayList<ListaContratos> listadoContratos = getListadoContratos();
	
	public ArrayList<String> getListadoContratosParams(){
		ArrayList<String> listaContratos = new ArrayList<>();
		for(ListaContratos l : listadoContratos) {
			listaContratos.add(l.getCodigoCuenta() );
		}
		return listaContratos;
	}
	
	
}
