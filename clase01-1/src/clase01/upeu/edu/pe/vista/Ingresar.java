package clase01.upeu.edu.pe.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import clase01.upeu.edu.pe.entity.Usuario;

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

public class Ingresar extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Ingresar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblIngresarAlSistema = new JLabel("Ingresar al Sistema");
		lblIngresarAlSistema.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		GridBagConstraints gbc_lblIngresarAlSistema = new GridBagConstraints();
		gbc_lblIngresarAlSistema.gridwidth = 2;
		gbc_lblIngresarAlSistema.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresarAlSistema.gridx = 2;
		gbc_lblIngresarAlSistema.gridy = 0;
		contentPane.add(lblIngresarAlSistema, gbc_lblIngresarAlSistema);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		GridBagConstraints gbc_lblNombreDeUsuario = new GridBagConstraints();
		gbc_lblNombreDeUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeUsuario.gridx = 1;
		gbc_lblNombreDeUsuario.gridy = 2;
		contentPane.add(lblNombreDeUsuario, gbc_lblNombreDeUsuario);
		
		txtUser = new JTextField();
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.insets = new Insets(0, 0, 5, 5);
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.gridx = 3;
		gbc_txtUser.gridy = 2;
		contentPane.add(txtUser, gbc_txtUser);
		txtUser.setColumns(10);
		
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
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtUser.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de usuario");
				}else {
					String pass = new String(pwdPassword.getPassword());
					if (pass.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Debe llenar la casilla de contraseña");
					}else {
						Usuario user = new Usuario(txtUser.getText(), pass);
						if (LoginForm.usuarioDaoImp.readAll().contains(user)) {
							int index = LoginForm.usuarioDaoImp.readAll().indexOf(user);
							MenuUsuario menuUsuario = new MenuUsuario(index);
							menuUsuario.setVisible(true);
							Cerrar();
						}else {
							JOptionPane.showMessageDialog(null, "El usuarion y contraseña no coinciden");
						}
					}
				}
			}
		});
		GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
		gbc_btnIngresar.insets = new Insets(0, 0, 0, 5);
		gbc_btnIngresar.gridx = 1;
		gbc_btnIngresar.gridy = 6;
		contentPane.add(btnIngresar, gbc_btnIngresar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUser.setText("");
				pwdPassword.setText("");
			}
		});
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpiar.gridx = 3;
		gbc_btnLimpiar.gridy = 6;
		contentPane.add(btnLimpiar, gbc_btnLimpiar);
		
		JButton btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm lform = new LoginForm();
				lform.setVisible(true);
				Cerrar();
			}
		});
		GridBagConstraints gbc_btnVolverAlMen = new GridBagConstraints();
		gbc_btnVolverAlMen.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolverAlMen.gridx = 5;
		gbc_btnVolverAlMen.gridy = 6;
		contentPane.add(btnVolverAlMen, gbc_btnVolverAlMen);
	}
	public void Cerrar() {
		this.setVisible(false);
	}
}
