package controlador;

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
	
}
