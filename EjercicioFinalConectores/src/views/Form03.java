package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Form03 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/*Launch the application.*/
	public static void main(String[] args) {
		try {
			Form03 dialog = new Form03();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*Create the dialog.*/
	public Form03() {
		
		this.setResizable(false);
		setBounds(100, 100, 994, 491);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setToolTipText("");
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(65, 68, 857, 54);
			contentPanel.add(panel);
			
			JLabel lblNewLabel_1 = new JLabel("Seleccionar cliente");
			lblNewLabel_1.setBounds(54, 11, 163, 22);
			panel.add(lblNewLabel_1);
			
			JComboBox comboBoxClientes = new JComboBox();
			comboBoxClientes.setBounds(227, 11, 310, 22);
			panel.add(comboBoxClientes);
		}
		
		JLabel lblNewLabel = new JLabel("Listado de cuentas");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(62, 21, 551, 14);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(65, 146, 857, 218);
		contentPanel.add(panel);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num. Cuenta", "Num. Sucursal", "Ciudad", "Saldo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		table.getColumnModel().getColumn(1).setMinWidth(86);
		table.getColumnModel().getColumn(1).setMaxWidth(86888888);
		table.getColumnModel().getColumn(2).setPreferredWidth(94);
		table.getColumnModel().getColumn(2).setMinWidth(94);
		table.getColumnModel().getColumn(3).setPreferredWidth(123);
		table.getColumnModel().getColumn(3).setMinWidth(123);
		table.setBounds(10, 11, 837, 196);
		panel.add(table);
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
