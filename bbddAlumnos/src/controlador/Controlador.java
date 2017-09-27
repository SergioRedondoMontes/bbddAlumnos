package controlador;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JOptionPane;

import modelo.Modelo;
import vista.VistaPrincipal;

public class Controlador {
	
	private int cod;
	private Modelo Modelo;
	private VistaPrincipal VistaPrincipal;
	
	public void setModelo(Modelo modelo) {
		this.Modelo = modelo;
	}

	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.VistaPrincipal = vistaPrincipal;
	}
	
	public void MostrarTabla() {
		Modelo.ShowJTable();
	}

	public void InsertPersona() {
		Modelo.insertPersona(VistaPrincipal.getTfDNI(), VistaPrincipal.getTfNombre(), VistaPrincipal.getTfApellido(), Integer.parseInt(VistaPrincipal.getTfTlf()),VistaPrincipal.getTfNacionalidad());
	}
	
	public void delPersona(){
		Modelo.delPersona(cod);
	}
	
	public void enableComponents(Container container, boolean enable) {
		Component[] components = container.getComponents();
		for (Component component : components) {
			component.setEnabled(enable);
			if (component instanceof Container) {
				enableComponents((Container) component, enable);
			}
		}
	}

	public void codPersona() {
		cod = Integer.parseInt(String.valueOf(VistaPrincipal.getTable().getValueAt(VistaPrincipal.getTable().getSelectedRow(), 0)));
	}

	public void guardarDatos() {
		Modelo.guardaTabla();
		
	}

	public void delTodo() {
		Modelo.delTodo();
		
	}

	public void confirmacion() {
		int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
		Modelo.ficheroABBDD(resp);
	}
	
}
