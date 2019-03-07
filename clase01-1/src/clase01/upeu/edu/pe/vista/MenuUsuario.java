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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private int index;
	private Usuario user;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MenuUsuario(int i) {
		index = i;
		user = LoginForm.usuarioDaoImp.readAll().get(index);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblMenuUsuario = new JLabel("Menu Usuario");
		lblMenuUsuario.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		GridBagConstraints gbc_lblMenuUsuario = new GridBagConstraints();
		gbc_lblMenuUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblMenuUsuario.gridx = 3;
		gbc_lblMenuUsuario.gridy = 3;
		contentPane.add(lblMenuUsuario, gbc_lblMenuUsuario);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		GridBagConstraints gbc_lblNombreUsuario = new GridBagConstraints();
		gbc_lblNombreUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreUsuario.gridx = 2;
		gbc_lblNombreUsuario.gridy = 5;
		contentPane.add(lblNombreUsuario, gbc_lblNombreUsuario);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 5;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		
		
		JButton btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm lform = new LoginForm();
				lform.setVisible(true);
				Cerrar();
				
			}
		});
		GridBagConstraints gbc_btnVolverAlMen = new GridBagConstraints();
		gbc_btnVolverAlMen.insets = new Insets(0, 0, 5, 5);
		gbc_btnVolverAlMen.gridx = 2;
		gbc_btnVolverAlMen.gridy = 7;
		contentPane.add(btnVolverAlMen, gbc_btnVolverAlMen);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar modificar = new Modificar(index);
				modificar.setVisible(true);
				Cerrar();
			}
		});
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 3;
		gbc_btnModificar.gridy = 7;
		contentPane.add(btnModificar, gbc_btnModificar);
		
		JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar eliminar = new Eliminar(index);
				eliminar.setVisible(true);
				Cerrar();
			}
		});
		GridBagConstraints gbc_btnEliminarUsuario = new GridBagConstraints();
		gbc_btnEliminarUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminarUsuario.gridx = 5;
		gbc_btnEliminarUsuario.gridy = 7;
		contentPane.add(btnEliminarUsuario, gbc_btnEliminarUsuario);
		
		txtNombre.setText(user.getNomuser());
	}

	

	public void Cerrar() {
		this.setVisible(false);
	}
}
