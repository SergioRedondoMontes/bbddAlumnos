package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import vista.VistaPrincipal;

public class Modelo {
	
	private String dni;
	private String nombre;
	private String apellido;
	private int telefono;
	private String nacionalidad;
	
	private String url;
	private String usuario;
	private String clave;
	
	private VistaPrincipal vistaPrincipal;
	
	public Modelo() {
		super();
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File config = new File("conf/configuracion.ini");
			if (config.exists()) {
				entrada = new FileInputStream(config);

				propiedades.load(entrada);

				url = propiedades.getProperty("BaseDatos");
				usuario = propiedades.getProperty("Usuario");
				clave = propiedades.getProperty("Clave");
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Modelo( String dni, String nombre, String apellido,int telefono, String nacionalidad) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.nacionalidad = nacionalidad;
	}

	public Connection getConnection() {
		Connection con;
		try {
			System.out.println("conectado");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, usuario, clave);
			return con;
		} catch (Exception e) {
			System.out.println("NO conectado");
			JOptionPane.showMessageDialog(null, "No se pudo conectar con la base de datos, modifique la informaci�n en la configuraci�n");
			return null;
			// TODO: handle exception
		}
	}
		
	public void inertPersona(String DNI, String nombre, String apellido, int telefono, String nacionalidad) {
		Connection con = getConnection();
		PreparedStatement ps;
		
//		INSERT INTO `alumnos` (`cod`, `dni`, `nombre`, `apellido`, `telefono`, `nacionalidad`) VALUES (NULL, '34556d', 'dgfcg', 'hol', '1234', 'españa');
		
		String query="INSERT INTO `alumnos` (`cod`, `dni`, `nombre`, `apellido`, `telefono`, `nacionalidad`) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, DNI);
			ps.setString(2,nombre );
			ps.setString(3, apellido);
			ps.setInt(4, telefono);
			ps.setString(5, nacionalidad);

			
			
			
			if (ps.executeUpdate() == 1) {

//				DefaultTableModel model = (DefaultTableModel) vistaPrincipal.getTablaInfo();
//				model.setRowCount(0);
//				ShowJTable();
				JOptionPane.showMessageDialog(null, "Informaci�n almacenada satisfactoriamente");			
			} else {
				JOptionPane.showMessageDialog(null, "La informaci�n no pudo ser almacenada");
			}
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
	
	
	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}
	
	
}
