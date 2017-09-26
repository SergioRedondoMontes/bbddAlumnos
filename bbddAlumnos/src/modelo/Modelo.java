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
	
	private int cod;
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

	public Modelo(int cod, String dni, String nombre, String apellido,int telefono, String nacionalidad) {
		this.cod= cod;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.nacionalidad = nacionalidad;
	}

	public Connection getConnection() {
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, usuario, clave);
			return con;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo conectar con la base de datos, modifique la informaci�n en la configuraci�n");
			return null;
			// TODO: handle exception
		}
	}
		
	public void insertPersona(String DNI, String nombre, String apellido, int telefono, String nacionalidad) {
		Connection con = getConnection();
		PreparedStatement ps;
		
//		INSERT INTO `alumnos` (`cod`, `dni`, `nombre`, `apellido`, `telefono`, `nacionalidad`) VALUES (NULL, '34556d', 'dgfcg', 'hol', '1234', 'españa');
		
		String query="INSERT INTO `alumnos` (`dni`, `nombre`, `apellido`, `telefono`, `nacionalidad`) VALUES (?,?,?,?,?)";
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
	
	public ArrayList<Modelo> getInscripcionesList() {
		ArrayList<Modelo> inscripcionesList = new ArrayList<Modelo>();
		Connection connection = getConnection();
		String query = "SELECT * FROM `alumnos`";
		Statement st;
		ResultSet rs;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Modelo database;
			while (rs.next()) {
				database = new Modelo(rs.getInt("cod"),rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getInt("telefono"), rs.getString("nacionalidad"));
				inscripcionesList.add(database);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return inscripcionesList;
	}

	/*
	 * Mostrar Tabla
	 */

	public void ShowJTable() {
		ArrayList<Modelo> list = getInscripcionesList();
		DefaultTableModel model = (DefaultTableModel) vistaPrincipal.getTablaInfo();

		Object[] row = new Object[6];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getCod();
			row[1] = list.get(i).getDni();
			row[2] = list.get(i).getNombre();
			row[3] = list.get(i).getApellido();
			row[4] = list.get(i).getTelefono();
			row[5] = list.get(i).getNacionalidad();
			//row[5] = list.get(i).getEstado();

			model.addRow(row);
		}
	}
	
	
	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getUrl() {
		return url;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getClave() {
		return clave;
	}

	public VistaPrincipal getVistaPrincipal() {
		return vistaPrincipal;
	}

	public int getCod() {
		return cod;
	}
	
	
}

