package com.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.entities.Usuario;
import usuario.VentanaRegistrarUsuario;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio(new Usuario());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInicio(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Iniciar Sesion");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(200, 11, 150, 44);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(218, 135, 150, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 181, 150, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaGeneral ventanaGeneral = new VentanaGeneral(usuario);
				ventanaGeneral.setLocation(400, 150);
				ventanaGeneral.setVisible(true);
				dispose();
			}
		});
		
		btnIngresar.setBounds(218, 232, 150, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(147, 143, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Constrase\u00F1a");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(147, 189, 61, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnRegistrarme = new JButton("Registrarme");
		btnRegistrarme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaRegistrarUsuario ventanaRegistrarUsuario = new VentanaRegistrarUsuario(usuario);
				ventanaRegistrarUsuario.setLocation(400, 150);
				ventanaRegistrarUsuario.setVisible(true);
				dispose();
			}
		});
		btnRegistrarme.setBounds(218, 266, 150, 23);
		contentPane.add(btnRegistrarme);
	}
}
