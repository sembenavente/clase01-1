package clase01.upeu.edu.pe.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase01.upeu.edu.pe.entity.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modificar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private int index;
	private JPasswordField pwdPassword;
	private JPasswordField pwdConfirmpassword;
	private JTextField txtNombre;
	private Usuario user;
	private Usuario newUser = new Usuario();

	/**
	 * Create the frame.
	 */
	public Modificar(int i) {
		index = i;
		user = LoginForm.usuarioDaoImp.readAll().get(index);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblModificarUsuario = new JLabel("Modificar Usuario");
		lblModificarUsuario.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		GridBagConstraints gbc_lblModificarUsuario = new GridBagConstraints();
		gbc_lblModificarUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblModificarUsuario.gridx = 3;
		gbc_lblModificarUsuario.gridy = 0;
		contentPane.add(lblModificarUsuario, gbc_lblModificarUsuario);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 2;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 4;
		contentPane.add(lblContrasea, gbc_lblContrasea);
		
		pwdPassword = new JPasswordField();
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 5);
		gbc_pwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPassword.gridx = 3;
		gbc_pwdPassword.gridy = 4;
		contentPane.add(pwdPassword, gbc_pwdPassword);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a");
		GridBagConstraints gbc_lblConfirmarContrasea = new GridBagConstraints();
		gbc_lblConfirmarContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarContrasea.gridx = 1;
		gbc_lblConfirmarContrasea.gridy = 5;
		contentPane.add(lblConfirmarContrasea, gbc_lblConfirmarContrasea);
		
		pwdConfirmpassword = new JPasswordField();
		GridBagConstraints gbc_pwdConfirmpassword = new GridBagConstraints();
		gbc_pwdConfirmpassword.insets = new Insets(0, 0, 5, 5);
		gbc_pwdConfirmpassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdConfirmpassword.gridx = 3;
		gbc_pwdConfirmpassword.gridy = 5;
		contentPane.add(pwdConfirmpassword, gbc_pwdConfirmpassword);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario menuUsuario = new MenuUsuario(index);
				menuUsuario.setVisible(true);
				Cerrar();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 7;
		contentPane.add(btnCancelar, gbc_btnCancelar);
		
		JButton btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
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
							newUser.setNomuser(txtNombre.getText());
							newUser.setClave(pass1);
							if (LoginForm.usuarioDaoImp.readAll().contains(newUser)) {
								JOptionPane.showMessageDialog(null, "El usuario ya existe");
							}else {
								LoginForm.usuarioDaoImp.update(index, newUser);
								JOptionPane.showMessageDialog(null, "El usuario ha sido modificado con exito");
								MenuUsuario menuUsuario = new MenuUsuario(index);
								menuUsuario.setVisible(true);
								Cerrar();
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "La contraseña no coincide con la confirmación");
						}
					}
				}
			}
		});
		GridBagConstraints gbc_btnGuardarCambios = new GridBagConstraints();
		gbc_btnGuardarCambios.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardarCambios.gridx = 3;
		gbc_btnGuardarCambios.gridy = 7;
		contentPane.add(btnGuardarCambios, gbc_btnGuardarCambios);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				pwdPassword.setText("");
				pwdConfirmpassword.setText("");
			}
		});
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpiar.gridx = 4;
		gbc_btnLimpiar.gridy = 7;
		contentPane.add(btnLimpiar, gbc_btnLimpiar);
	}

	public void Cerrar() {
		this.setVisible(false);
	}
}
