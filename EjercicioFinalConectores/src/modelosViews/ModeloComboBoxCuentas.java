package modelosViews;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controller.Controller;
import modeloVO.ClienteTransaccion;


@SuppressWarnings("serial")
public class ModeloComboBoxCuentas extends JComboBox<ClienteTransaccion>{
	
	ModeloComboBoxClientes modelo = new ModeloComboBoxClientes();
	ArrayList<ClienteTransaccion> cuentas= new ArrayList<ClienteTransaccion>();
	Controller controller = new Controller();
	
	public ModeloComboBoxCuentas() {
		super();
		cargarComboBox();
	}
	
	
	public void cargarComboBox() {
		String dni = cuentas.get(modelo.getSelectedIndex() ).getDni();
		
		cuentas = controller.cargarCuentasComboBox(dni);
		for(ClienteTransaccion ct : cuentas) {
			this.addItem(ct);
		}
	}
	
}
