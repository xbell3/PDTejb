package usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.EJBLocator;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.UsuariosBeanRemote;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNombreDeUsuario;
	private JTextField txtCorreo;
	private JTextField txtContrasena;
	private JFrame frame;
	public VentanaRegistrarUsuario(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	/*	JComboBox<String> comboBoxRol = new JComboBox<>();
		comboBoxRol.setForeground(new Color(65, 105, 225));
		comboBoxRol.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBoxRol.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrador", "Experto", "Comun"}));
		comboBoxRol.setBounds(327, 94, 174, 42);
		contentPane.add(comboBoxRol);
		comboBoxRol.setToolTipText(usuario.getRol().toString());*/
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(195, 11, 174, 42);
		contentPane.add(lblRegistro);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setText("Nombre");
		txtNombre.setBounds(100, 63, 168, 42);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setText("Apellido");
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtApellido.setColumns(10);
		txtApellido.setBounds(100, 116, 168, 42);
		contentPane.add(txtApellido);
		
		txtNombreDeUsuario = new JTextField();
		txtNombreDeUsuario.setText("Nombre de Usuario");
		txtNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombreDeUsuario.setColumns(10);
		txtNombreDeUsuario.setBounds(100, 169, 168, 42);
		contentPane.add(txtNombreDeUsuario);
		
		txtCorreo = new JTextField();
		txtCorreo.setText("Correo");
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(100, 222, 168, 42);
		contentPane.add(txtCorreo);
		
		txtContrasena = new JTextField();
		txtContrasena.setText("Contrase\u00F1a");
		txtContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(100, 275, 168, 42);
		contentPane.add(txtContrasena);
		
		JButton btnRegistrarme = new JButton("Registrarme");
		btnRegistrarme.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				UsuariosBeanRemote usuarioBeanRemote;
				usuario.setNombreUsuario(txtNombreDeUsuario.getText());
				usuario.setContrasena(txtContrasena.getText());
				usuario.setApellido(txtApellido.getText());
				usuario.setCorreo(txtCorreo.getText());
				usuario.setNombre(txtNombre.getText());
//Por resolver...	usuario.setRol( comboBoxRol.getSelectedItem().toString());

				try {
					usuarioBeanRemote = EJBLocator.getInstance().lookup(UsuariosBeanRemote.class);
				
					if(txtNombreDeUsuario.getText().isEmpty() || txtCorreo.getText().isEmpty()|| txtApellido.getText().isEmpty()
							|| txtContrasena.getText().isEmpty()|| txtNombre.getText().isEmpty()){
						JOptionPane.showMessageDialog(frame, "Debe completar todos los campos",
								"Campos Incompletos!", JOptionPane.INFORMATION_MESSAGE);
						
						return;
						
					}else if(usuario.getIdUsuario() == null ){
						usuarioBeanRemote.crearUsuario(usuario);

						JOptionPane.showMessageDialog(frame, "El Usuario ha sido registrado con éxito.",
								"Usuario Registrado!", JOptionPane.INFORMATION_MESSAGE);
						
						dispose();
					
					}else {
						usuarioBeanRemote.actualizar(usuario);
						JOptionPane.showMessageDialog(frame, "El Usuario ha sido actualizado con éxito.",
								"Usuario Actualizado!", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						}
					
					
				} catch (NamingException e1) {
					e1.printStackTrace();
				} catch (ServiciosException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnRegistrarme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarme.setBounds(327, 293, 174, 42);
		contentPane.add(btnRegistrarme);
		
		
	}

}
