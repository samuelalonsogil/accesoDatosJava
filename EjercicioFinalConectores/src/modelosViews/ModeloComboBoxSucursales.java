package modelosViews;

import java.util.ArrayList;
import javax.swing.JComboBox;
import controller.Controller;
import modeloVO.Sucursal;

@SuppressWarnings("serial")
public class ModeloComboBoxSucursales extends JComboBox<Sucursal>{
	ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
	Controller controller = new Controller();
	
	public ModeloComboBoxSucursales() {
		super();
		cargarComboBox();
	}
	
	
	public void cargarComboBox() {
		sucursales = controller.cargarSucursales();
		for(Sucursal sucursal: sucursales) {
			this.addItem(sucursal);
		}
	}
}
