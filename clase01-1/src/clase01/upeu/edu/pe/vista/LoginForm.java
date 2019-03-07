package clase01.upeu.edu.pe.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clase01.upeu.edu.pe.daoImp.UsuarioDaoImp;

import java.awt.Font;

public class LoginForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static UsuarioDaoImp usuarioDaoImp = new UsuarioDaoImp();
	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu de Usuarios");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblNewLabel.setBounds(137, 11, 134, 23);
		contentPane.add(lblNewLabel);
		
		
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				CrearUsuario crear = new CrearUsuario();
				crear.setVisible(true);
				Cerrar();
			}
			
		});
		btnCrear.setBounds(119, 88, 176, 23);
		contentPane.add(btnCrear);
		
		
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingresar ing = new Ingresar();
				ing.setVisible(true);
				Cerrar();
			}
		});
		btnIngresar.setBounds(119, 149, 176, 23);
		contentPane.add(btnIngresar);
	}
	public void Cerrar() {
		this.setVisible(false);
	}
}

