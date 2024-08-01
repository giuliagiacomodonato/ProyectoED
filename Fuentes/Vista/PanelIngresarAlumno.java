package Vista;
import Modelo.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import Auxiliares.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class PanelIngresarAlumno extends JFrame {

	private JPanel contentPane;
	private JTextField escribir_LU;
	private JTextField escribir_nota;
	private static Programa p;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelIngresarAlumno frame = new PanelIngresarAlumno(p);
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
	public PanelIngresarAlumno(Programa p) {
		setTitle(p.getMateria());
		this.setIconImage((new ImageIcon(VentanaPrincipal.class.getResource("/Imagen/iconn.jpg"))).getImage());
		
		setBounds(100, 100, 499, 381);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ACEPTAR = new JButton("ACEPTAR ");
		ACEPTAR.setBackground(new Color(255, 255,255));
		ACEPTAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean agrego=false;
					if(!escribir_LU.getText().isBlank() && !escribir_nota.getText().isBlank()) {
						if(String.valueOf(escribir_nota.getText()) !="NaN") {
							Integer lu= Integer.parseInt(escribir_LU.getText());
							Integer nota= Integer.parseInt(escribir_nota.getText());
							if(nota>=0 && nota<=10) {
								agrego= p.agregarAlumno(lu,nota);
								if (agrego) {
									JOptionPane.showMessageDialog(contentPane, "SE AGREGÓ CORRECTAMENTE EL ALUMNO");
									escribir_LU.setText(null);
									escribir_nota.setText(null);
								}
								else {
									JOptionPane.showMessageDialog(contentPane, "EL ALUMNO YA EXISTE",null, 0);
								}
							}
							else {
								JOptionPane.showMessageDialog(contentPane, "LA NOTA NO ES VÁLIDA",null, 0);
							}
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "LOS VALORES INGRESADOS NO SON CORRECTOS",null, 0);
						}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "LOS VALORES INGRESADOS NO SON CORRECTOS",null, 0);
				}
			
		}
		});
		
		ACEPTAR.setBounds(22, 122, 139, 35);
		contentPane.add(ACEPTAR);
		
		escribir_LU = new JTextField();
		escribir_LU.addKeyListener(new KeyAdapter() {
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
		escribir_LU.setBounds(267, 18, 129, 29);
		contentPane.add(escribir_LU);
		escribir_LU.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("INGRESE NÚMERO DE LU DEL ALUMNO:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(22, 21, 235, 23);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(209, 216, 211));
		lblNewLabel.setOpaque(true);
		
		JLabel lblIngreseNotaDel = new JLabel("INGRESE NOTA DEL ALUMNO:");
		lblIngreseNotaDel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIngreseNotaDel.setBounds(22, 88, 235, 23);
		lblIngreseNotaDel.setBackground(new Color(209, 216, 211));
		lblIngreseNotaDel.setOpaque(true);
		
		contentPane.add(lblIngreseNotaDel);
		
		escribir_nota = new JTextField();
		escribir_nota.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
		        if((car<'0' || car>'9') ) e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					mostrar(p);
				}
		
			}});
		escribir_nota.setColumns(10);
		escribir_nota.setBounds(267, 85, 129, 29);
		contentPane.add(escribir_nota);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelIngresarAlumno.class.getResource("/Imagen/1-48-6.jpg")));
		lblNewLabel_1.setBounds(-244, -24, 752, 465);
		contentPane.add(lblNewLabel_1);
		
	}
	private void mostrar(Programa p) {
		boolean agrego=false;
		if(!escribir_LU.getText().isBlank() && !escribir_nota.getText().isBlank()) {
				Integer lu= Integer.parseInt(escribir_LU.getText());
				Integer nota= Integer.parseInt(escribir_nota.getText());
				if(nota>=0 && nota<=10) {
					agrego= p.agregarAlumno(lu,nota);
					if (agrego) {
						JOptionPane.showMessageDialog(contentPane, "SE AGREGÓ CORRECTAMENTE EL ALUMNO");
						escribir_LU.setText(null);
						escribir_nota.setText(null);
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "EL ALUMNO YA EXISTE",null, 0);
						escribir_LU.setText(null);
						escribir_nota.setText(null);
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "LA NOTA NO ES VÁLIDA",null, 0);
				}
	}
	else {
		JOptionPane.showMessageDialog(contentPane, "LOS VALORES INGRESADOS NO SON CORRECTOS",null, 0);
		}
	}
}

