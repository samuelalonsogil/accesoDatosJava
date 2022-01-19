package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Form03PujasMasAltas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Form03PujasMasAltas dialog = new Form03PujasMasAltas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form03PujasMasAltas() {
		setTitle("BD Subastas. Listado Pujas m\u00E1s altas");
		setBounds(100, 100, 655, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JLabel lblListadoPujas = new JLabel("LISTADO PUJAS ");
			lblListadoPujas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblListadoPujas.setHorizontalAlignment(SwingConstants.CENTER);
			lblListadoPujas.setBounds(10, 11, 619, 34);
			contentPanel.add(lblListadoPujas);
		}
		
	
		
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
