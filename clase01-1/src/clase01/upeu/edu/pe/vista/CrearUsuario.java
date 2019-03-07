package clase01.upeu.edu.pe.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase01.upeu.edu.pe.daoImp.UsuarioDaoImp;
import clase01.upeu.edu.pe.entity.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JLabel lblContrasea;
	private JPasswordField pwdPassword;
	private JLabel lblConfirmarContrasea;
	private JPasswordField pwdConfirmpassword;
	private JButton btnLimpiar;
	private JButton btnRegistrar;
	private JButton btnVolverAlMen;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public CrearUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{424, 0};
		gbl_contentPane.rowHeights = new int[]{19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblCrearUsuario = new JLabel("Crear Usuario");
		lblCrearUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblCrearUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCrearUsuario = new GridBagConstraints();
		gbc_lblCrearUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_lblCrearUsuario.anchor = GridBagConstraints.NORTH;
		gbc_lblCrearUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCrearUsuario.gridx = 0;
		gbc_lblCrearUsuario.gridy = 0;
		contentPane.add(lblCrearUsuario, gbc_lblCrearUsuario);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.gridx = 0;
		gbc_txtNombre.gridy = 3;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 0);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 4;
		contentPane.add(lblContrasea, gbc_lblContrasea);
		
		pwdPassword = new JPasswordField();
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 0);
		gbc_pwdPassword.gridx = 0;
		gbc_pwdPassword.gridy = 5;
		contentPane.add(pwdPassword, gbc_pwdPassword);
		
		lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a");
		GridBagConstraints gbc_lblConfirmarContrasea = new GridBagConstraints();
		gbc_lblConfirmarContrasea.insets = new Insets(0, 0, 5, 0);
		gbc_lblConfirmarContrasea.gridx = 0;
		gbc_lblConfirmarContrasea.gridy = 6;
		contentPane.add(lblConfirmarContrasea, gbc_lblConfirmarContrasea);
		
		pwdConfirmpassword = new JPasswordField();
		GridBagConstraints gbc_pwdConfrimpassword = new GridBagConstraints();
		gbc_pwdConfrimpassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdConfrimpassword.insets = new Insets(0, 0, 5, 0);
		gbc_pwdConfrimpassword.gridx = 0;
		gbc_pwdConfrimpassword.gridy = 7;
		contentPane.add(pwdConfirmpassword, gbc_pwdConfrimpassword);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				pwdPassword.setText("");
				pwdConfirmpassword.setText("");
			}
		});
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 0);
		gbc_btnLimpiar.gridx = 0;
		gbc_btnLimpiar.gridy = 8;
		contentPane.add(btnLimpiar, gbc_btnLimpiar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe llenar la casilla de nombre");
				}else {
					String pass1 = new String(pwdPassword.getPassword());
					String pass2 = new String(pwdConfirmpassword.getPassword());
					if (pass1.isEmpty() || pass2.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Debe llenar las casillas de contraseña y confirmación");
					}else {
						if (pass1.equals(pass2)) {
							Usuario user = new Usuario(txtNombre.getText(), pass1);
							if (LoginForm.usuarioDaoImp.readAll().contains(user)) {
								JOptionPane.showMessageDialog(null, "El usuario ya existe");
							}else {
								LoginForm.usuarioDaoImp.create(user);
								JOptionPane.showMessageDialog(null, "El usuario ha sido creado");
								LoginForm lform = new LoginForm();
								lform.setVisible(true);
								Cerrar();
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "La contraseña no coincide con la confirmación");
						}
					}
				}
				
			}
		});
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegistrar.gridx = 0;
		gbc_btnRegistrar.gridy = 9;
		contentPane.add(btnRegistrar, gbc_btnRegistrar);
		
		btnVolverAlMen = new JButton("Volver al Men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginForm lform = new LoginForm();
				lform.setVisible(true);
				Cerrar();
			}
		});
		GridBagConstraints gbc_btnVolverAlMen = new GridBagConstraints();
		gbc_btnVolverAlMen.gridx = 0;
		gbc_btnVolverAlMen.gridy = 10;
		contentPane.add(btnVolverAlMen, gbc_btnVolverAlMen);
	}
	public void Cerrar() {
		this.setVisible(false);
	}

}
