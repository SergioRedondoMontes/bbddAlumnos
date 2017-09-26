package controlador;

import java.awt.Component;
import java.awt.Container;

import modelo.Modelo;
import vista.VistaPrincipal;

public class Controlador {
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
	
	public void enableComponents(Container container, boolean enable) {
		Component[] components = container.getComponents();
		for (Component component : components) {
			component.setEnabled(enable);
			if (component instanceof Container) {
				enableComponents((Container) component, enable);
			}
		}
	}
	
}
