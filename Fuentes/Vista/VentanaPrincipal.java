package Vista;
import Modelo.Programa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.awt.Toolkit;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField leer_materia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setTitle("REGISTRO DE ALUMNOS");
		this.setIconImage((new ImageIcon(VentanaPrincipal.class.getResource("/Imagen/iconn.jpg"))).getImage());
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 381);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel ingresarMateria = new JLabel("INGRESE UNA MATERIA:");
		ingresarMateria.setHorizontalAlignment(SwingConstants.CENTER);
		ingresarMateria.setBackground(new Color(209, 216, 211));
		ingresarMateria.setOpaque(true);
		ingresarMateria.setFont(new Font("Arial", Font.PLAIN, 13));
		ingresarMateria.setBounds(53, 43, 173, 36);
		contentPane.add(ingresarMateria);
		
		
		leer_materia = new JTextField();
		leer_materia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					crearMateria();
			}
		});
		
		leer_materia.setBounds(236, 43, 146, 36);
		contentPane.add(leer_materia);
		leer_materia.setColumns(10);		
		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setBackground(new Color(255, 255,255));
		aceptar.setOpaque(true);
		
		aceptar.setFont(new Font("Arial", Font.PLAIN, 13));
		aceptar.setBounds(236, 90, 146, 23);
		contentPane.add(aceptar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Imagen/1-48-6.jpg")));
		lblNewLabel.setBounds(-287, 0, 798, 411);
		contentPane.add(lblNewLabel);
		
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearMateria();
		}});
		}
		private void crearMateria() {
			if(!leer_materia.getText().isBlank()) {
				Programa p= new Programa (leer_materia.getText().toUpperCase());
				PanelPrincipal p0= new PanelPrincipal(p);
				setVisible(false);
				p0.setVisible(true);
			}
			else {
					JOptionPane.showMessageDialog(contentPane, "EL NOMBRE DE LA MATERIA NO PUEDE ESTAR EN BLANCO",null, 0);
			}
		}
}
