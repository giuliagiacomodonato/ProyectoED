package Vista;
import Modelo.Programa;

import Excepciones.*;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelEliminarAlumno extends JFrame {

	private JPanel contentPane;
	private JTextField escribir_lu;
	private static Programa p;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelEliminarAlumno frame = new PanelEliminarAlumno(p);
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
	public PanelEliminarAlumno(Programa p) {
		setTitle(p.getMateria());
		this.setIconImage((new ImageIcon(VentanaPrincipal.class.getResource("/Imagen/iconn.jpg"))).getImage());
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 499, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(192, 192, 192));
		JLabel lblNewLabel = new JLabel("INGRESE EL LU DEL ALUMNO A ELIMINAR:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 29, 291, 41);
		contentPane.add(lblNewLabel);
		
		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setBackground(new Color(255, 255,255));
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar(p);
			}
		});
		aceptar.setFont(new Font("Arial", Font.PLAIN, 13));
		aceptar.setBounds(362, 76, 111, 25);
		contentPane.add(aceptar);
		
		escribir_lu = new JTextField();
		escribir_lu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
		        if((car<'0' || car>'9') && (car<',' || car>'.')) e.consume();
		        
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					mostrar(p);
			}
		}});
		escribir_lu.setBounds(283, 34, 194, 36);
		contentPane.add(escribir_lu);
		escribir_lu.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelEliminarAlumno.class.getResource("/Imagen/1-48-6.jpg")));
		lblNewLabel_1.setBounds(-242, -22, 750, 451);
		contentPane.add(lblNewLabel_1);
	}
	private void mostrar(Programa p) {
		if(!escribir_lu.getText().isBlank() ) {
			Integer lu = Integer.parseInt(escribir_lu.getText());
			boolean elimino= p.eliminarAlumno(lu);
			if (elimino) {
				JOptionPane.showMessageDialog(contentPane, "SE ELIMINÓ CORRECTAMENTE EL ALUMNO");
				escribir_lu.setText(null);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "EL ALUMNO INGRESADO NO EXISTE",null,0);
				escribir_lu.setText(null);
			}
	}
	else {
		JOptionPane.showMessageDialog(contentPane, "LOS VALORES INGRESADOS NO SON CORRECTOS",null, 0);
		
	}
}
}
