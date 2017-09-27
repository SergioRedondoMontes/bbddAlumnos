package vista;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.Controlador;
import modelo.Modelo;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;
	private Controlador controlador;
	private Modelo modelo;
	private JTable table;
	private JTextField tfDNI;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfTlf;
	private JTextField tfNacionalidad;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					controlador.delPersona();
				}
			}
		});
		
		JLabel lblDNI = new JLabel("DNI");
		
		tfDNI = new JTextField();
		tfDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		
		tfTlf = new JTextField();
		tfTlf.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		
		tfNacionalidad = new JTextField();
		tfNacionalidad.setColumns(10);
		
		JLabel lblAnadir = new JLabel("AÑADIR");
		lblAnadir.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		JButton btnInsertarAlumno = new JButton("Insertar Alumno");
		btnInsertarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.InsertPersona();
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.delPersona();
			}
		});
		
		JButton btnEliminarTodo = new JButton("Eliminar todo");
		btnEliminarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.delTodo();
			}
		});
		
		JButton btnGuardarEnFichero = new JButton("Guardar en fichero");
		btnGuardarEnFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.guardarDatos();
			}
		});
		
		JButton btnSubirFichero = new JButton("Subir fichero");
		btnSubirFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.confirmacion();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblAnadir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblTelefono, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblApellido, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblDNI, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
												.addComponent(lblNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNacionalidad, Alignment.LEADING))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(tfNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfTlf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
													.addComponent(tfDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
									.addPreferredGap(ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnEliminarTodo)
										.addComponent(btnEliminar)
										.addComponent(btnGuardarEnFichero)
										.addComponent(btnSubirFichero))
									.addGap(33))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addComponent(btnInsertarAlumno)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblAnadir)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnEliminar)
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDNI)
								.addComponent(tfDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblApellido)
								.addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefono)
								.addComponent(tfTlf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNacionalidad)
								.addComponent(tfNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnInsertarAlumno))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEliminarTodo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnGuardarEnFichero)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSubirFichero)
							.addGap(84))))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.codPersona();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"COD", "DNI", "NOMBRE", "APELLIDO", "TELEFONO","NACIONALIDAD"
			}
		)); 
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

	
	
	public void onLoadTable() {
		controlador.MostrarTabla();
	}

	public TableModel getTablaInfo() {
		return table.getModel();
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public String getTfDNI() {
		return tfDNI.getText();
	}


	public void setTfDNI(JTextField tfDNI) {
		this.tfDNI = tfDNI;
	}


	public String getTfNombre() {
		return tfNombre.getText();
	}


	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}


	public String getTfApellido() {
		return tfApellido.getText();
	}


	public void setTfApellido(JTextField tfApellido) {
		this.tfApellido = tfApellido;
	}


	public String getTfTlf() {
		return tfTlf.getText();
	}


	public void setTfTlf(JTextField tfTlf) {
		this.tfTlf = tfTlf;
	}


	public String getTfNacionalidad() {
		return tfNacionalidad.getText();
	}


	public void setTfNacionalidad(JTextField tfNacionalidad) {
		this.tfNacionalidad = tfNacionalidad;
	}



	public JTable getTable() {
		return table;
	}
}
