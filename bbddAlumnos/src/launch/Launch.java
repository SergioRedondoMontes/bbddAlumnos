package launch;

import controlador.Controlador;
import modelo.Modelo;
import vista.VistaPrincipal;

public class Launch {
	public static void main(String[] args) {
		
		VistaPrincipal vistaPrincipal = new VistaPrincipal();
		Modelo modelo = new Modelo();

		
		Controlador controlador = new Controlador();
		
		controlador.setModelo(modelo);
		controlador.setVistaPrincipal(vistaPrincipal);


		vistaPrincipal.setControlador(controlador);
		vistaPrincipal.setModelo(modelo);

		modelo.setVistaPrincipal(vistaPrincipal);


		
		//vistaPrincipal.onLoadTable();
		modelo.getConnection();
		
		vistaPrincipal.setVisible(true);
	}
}
