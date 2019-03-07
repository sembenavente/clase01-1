package clase01.upeu.edu.pe.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eliminar extends JFrame {

	private JPanel contentPane;
	private int index;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Eliminar(int i) {
		index = i;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 141);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblConfirmarEliminacinDe = new JLabel("Confirmar Eliminaci\u00F3n de Usuario");
		lblConfirmarEliminacinDe.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		GridBagConstraints gbc_lblConfirmarEliminacinDe = new GridBagConstraints();
		gbc_lblConfirmarEliminacinDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarEliminacinDe.gridx = 3;
		gbc_lblConfirmarEliminacinDe.gridy = 0;
		contentPane.add(lblConfirmarEliminacinDe, gbc_lblConfirmarEliminacinDe);
		
		JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm.usuarioDaoImp.delete(index);
				LoginForm log = new LoginForm();
				log.setVisible(true);
				Cerrar();
			}
		});
		GridBagConstraints gbc_btnEliminarUsuario = new GridBagConstraints();
		gbc_btnEliminarUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminarUsuario.gridx = 3;
		gbc_btnEliminarUsuario.gridy = 1;
		contentPane.add(btnEliminarUsuario, gbc_btnEliminarUsuario);
		
		JButton btnCancelarEliminacin = new JButton("Cancelar Eliminaci\u00F3n");
		btnCancelarEliminacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario menuUsuario = new MenuUsuario(index);
				menuUsuario.setVisible(true);
				Cerrar();
			}
		});
		GridBagConstraints gbc_btnCancelarEliminacin = new GridBagConstraints();
		gbc_btnCancelarEliminacin.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelarEliminacin.gridx = 3;
		gbc_btnCancelarEliminacin.gridy = 2;
		contentPane.add(btnCancelarEliminacin, gbc_btnCancelarEliminacin);
	}

	public void Cerrar() {
		this.setVisible(false);
	}
}
