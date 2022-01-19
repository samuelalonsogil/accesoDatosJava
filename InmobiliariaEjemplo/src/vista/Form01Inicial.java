package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form01Inicial extends JFrame {

	private JPanel contentPane;
	Form02GPropietarios form02Gpropietarios;
	Form03CContratos form03CContratos;
	Form04NContrato form04NContrato;
	Form05ActualizarPrecio form05ActualizarPrecio;
	Form06Alquileres form06Alquileres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form01Inicial frame = new Form01Inicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form01Inicial() {
		setTitle("Gesti\u00F3n INmibiliaria Casas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnGestinPropietarios = new JButton("Gesti\u00F3n Propietarios");
		btnGestinPropietarios.addActionListener(new BtnGestinPropietariosActionListener());
		contentPane.add(btnGestinPropietarios);
		
		JButton btnNuevoContrato = new JButton("Nuevo Contrato");
		btnNuevoContrato.addActionListener(new BtnNuevoContratoActionListener());
		contentPane.add(btnNuevoContrato);
		
		JButton btnConsultaContratos = new JButton("Consulta Contratos");
		btnConsultaContratos.addActionListener(new BtnConsultaContratosActionListener());
		contentPane.add(btnConsultaContratos);
		
		JButton btnActualizarPrecios = new JButton("Actualizar Precios");
		btnActualizarPrecios.addActionListener(new BtnActualizarPreciosActionListener());
		contentPane.add(btnActualizarPrecios);
		
		JButton btnAlquileres = new JButton("Alquileres");
		btnAlquileres.addActionListener(new BtnAlquileresActionListener());
		contentPane.add(btnAlquileres);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new BtnSalirActionListener());
		contentPane.add(btnSalir);
	}

	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	private class BtnGestinPropietariosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			form02Gpropietarios = new Form02GPropietarios();
			form02Gpropietarios.setVisible(true);
			
			
		}
	}
	private class BtnNuevoContratoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			form04NContrato = new Form04NContrato();
			form04NContrato.setVisible(true);
			
		}
	}
	private class BtnConsultaContratosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			form03CContratos = new Form03CContratos();
			form03CContratos.setVisible(true);
		}
	}
	private class BtnActualizarPreciosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			form05ActualizarPrecio = new Form05ActualizarPrecio();
			form05ActualizarPrecio.setVisible(true);
		}
	}
	private class BtnAlquileresActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			form06Alquileres = new Form06Alquileres();
			form06Alquileres.setVisible(true);
		}
	}
}
