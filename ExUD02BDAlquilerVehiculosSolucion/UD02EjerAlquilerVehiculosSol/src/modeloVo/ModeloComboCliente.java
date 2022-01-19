package modeloVo;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controlador;

public class ModeloComboCliente extends JComboBox<Cliente>{
	
	ArrayList<Cliente> clientes = null;
	
	Controlador controlador = new Controlador();
	
	public ModeloComboCliente(){
		cargarClientes();
	}
	
	public void cargarClientes(){
			
		clientes = controlador.cargarClientes();
		for(Cliente cliente : clientes){
			this.addItem(cliente);
		}	
	}

	
}