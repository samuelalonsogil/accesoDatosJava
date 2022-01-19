package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form01Inicial extends JFrame {

	private JPanel contentPane;
	Form02NuevaPuja form02NuevaPuja = new Form02NuevaPuja();
	Form03PujasMasAltas form03PujasMasAltas = new Form03PujasMasAltas();

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
		setTitle("Subastas Vigo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNuevaPuja = new JButton("Nueva Puja");
	
		contentPane.add(btnNuevaPuja, BorderLayout.WEST);
		
		JButton btnListadoPujas = new JButton("Listado Pujas");
	
		
		contentPane.add(btnListadoPujas, BorderLayout.CENTER);
		
		JButton btnSalir = new JButton("Salir");
	
		contentPane.add(btnSalir, BorderLayout.EAST);
	}

	
}
