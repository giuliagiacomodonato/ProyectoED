package Vista;

import Modelo.Programa;
import Auxiliares.*;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelVerNotaAlumno  extends JFrame {

	private JPanel contentPane;
	private JTextField leer_lu;
	private static Programa p;
	private JButton aceptar;
	private JLabel notaa;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelVerNotaAlumno frame = new PanelVerNotaAlumno(p);
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
	public PanelVerNotaAlumno(Programa p) {
		setTitle(p.getMateria());
		this.setIconImage((new ImageIcon(VentanaPrincipal.class.getResource("/Imagen/iconn.jpg"))).getImage());
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INGRESE LU DEL ALUMNO A CONSULTAR:");
		lblNewLabel.setBackground(new Color(209, 216, 211));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(25, 34, 281, 16);
		
		
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 499, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.add(lblNewLabel);
		
		leer_lu = new JTextField();
		leer_lu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
		        if(car<'0' || car>'9') e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					mostrar(p);
				}
			}
		});
		leer_lu.setBounds(316, 31, 142, 22);
		contentPane.add(leer_lu);
		leer_lu.setColumns(10);
		
		aceptar = new JButton("ACEPTAR");
		aceptar.setBackground(new Color(255, 255,255));
		aceptar.setFont(new Font("Arial", Font.PLAIN, 13));
		aceptar.setBounds(316, 76, 142, 22);
		contentPane.add(aceptar);
		
		notaa = new JLabel(" ");
		notaa.setFont(new Font("Arial", Font.PLAIN, 13));
		notaa.setBounds(25, 223, 177, 48);
		contentPane.add(notaa);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelVerNotaAlumno.class.getResource("/Imagen/1-48-6.jpg")));
		lblNewLabel_1.setBounds(-230, 0, 785, 368);
		contentPane.add(lblNewLabel_1);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar(p);
			}});
	
		
		
	}
	private void mostrar(Programa p) {
		notaa.setText(null);
		if(!leer_lu.getText().isBlank()) {
			Integer n= Integer.parseInt(leer_lu.getText());
			Integer notaAlumno = p.verNotaAlumno(n);
			if (notaAlumno!=null)
				notaa.setText("LA NOTA ES: "+String.valueOf(notaAlumno));
			else {
				JOptionPane.showMessageDialog(contentPane, "EL ALUMNO INGRESADO NO EXISTE",null,0);
			}
		}
		else {
			notaa.setText(null);
			JOptionPane.showMessageDialog(contentPane, "LOS VALORES INGRESADOS NO SON CORRECTOS",null, 0);
	}
	}

}