package modelosViews;

import java.util.ArrayList;
import javax.swing.JComboBox;
import controller.Controller;
import modeloVO.Cliente;

@SuppressWarnings("serial")
public class ModeloComboBoxClientes extends JComboBox<Cliente>{
	
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	Controller controller = new Controller();
	
	public ModeloComboBoxClientes() {
		super();
		cargarComboBox();
	}
	
	
	public void cargarComboBox() {
		clientes = controller.cargarClientes();
		for(Cliente cliente : clientes) {
			System.out.println(cliente);
			this.addItem(cliente);
		}
	}
	
	
	public static void main(String[] args) {
		ModeloComboBoxClientes modelo = new ModeloComboBoxClientes();
		modelo.cargarComboBox();
	}
}
