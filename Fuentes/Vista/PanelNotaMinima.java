package Vista;
import Modelo.Programa;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;

import Auxiliares.*;
public class PanelNotaMinima extends JFrame {
	private JPanel contentPane;
	private static Programa p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelNotaMinima frame = new PanelNotaMinima(p);
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
	public PanelNotaMinima(Programa p) {
		getContentPane().setBackground(new Color(192, 192, 192));
		setTitle(p.getMateria());
		this.setIconImage((new ImageIcon(VentanaPrincipal.class.getResource("/Imagen/iconn.jpg"))).getImage());
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 499, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("NOTA MÍNIMA ENTRE TODOS LOS ALUMNOS:");
		lblNewLabel.setBackground(new Color(209, 216, 211));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 358, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel notaMin = new JLabel("");
		notaMin.setFont(new Font("Arial", Font.PLAIN, 13));
		notaMin.setBounds(384, 11, 74, 21);
		getContentPane().add(notaMin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelNotaMinima.class.getResource("/Imagen/1-48-6.jpg")));
		lblNewLabel_1.setBounds(-229, -20, 895, 455);
		getContentPane().add(lblNewLabel_1);
		if(p.notaMinima() == null ) {
			JOptionPane.showMessageDialog(contentPane, "NO HAY ALUMNOS REGISTRADOS",null, 0);
		}
		else {
			notaMin.setText(String.valueOf(p.notaMinima()));}
	}
}
