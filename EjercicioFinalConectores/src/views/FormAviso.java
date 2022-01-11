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
import java.awt.Canvas;
import java.awt.Color;

public class FormAviso extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormAviso dialog = new FormAviso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormAviso() {
		setTitle("Select an Option");
		setResizable(false);
		setBounds(100, 100, 614, 165);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saldo insuficiente. \u00BFDesea seguir con la transferencia?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(106, 11, 389, 22);
		contentPanel.add(lblNewLabel);
		
		JButton buttonYes = new JButton("Yes");
		buttonYes.setBounds(140, 48, 77, 28);
		contentPanel.add(buttonYes);
		
		JButton buttonNo = new JButton("No");
		buttonNo.setBounds(227, 48, 77, 28);
		contentPanel.add(buttonNo);
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(314, 48, 77, 28);
		contentPanel.add(buttonCancel);
	}
}
