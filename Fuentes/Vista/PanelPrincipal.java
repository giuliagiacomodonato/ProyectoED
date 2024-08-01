package Vista;
import Modelo.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.UIManager;
import Auxiliares.*;
public class PanelPrincipal extends JFrame {

	private JPanel contentPane;
	private static Programa p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal frame = new PanelPrincipal(p);
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
	public PanelPrincipal(Programa p) {
		setTitle(p.getMateria());
		this.setIconImage((new ImageIcon(VentanaPrincipal.class.getResource("/Imagen/iconn.jpg"))).getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ingresarNotaAlumno = new JButton("INGRESAR NOTA ALUMNO");
		ingresarNotaAlumno.setBackground(new Color(255, 255,255));
		ingresarNotaAlumno.setOpaque(true);
		ingresarNotaAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelIngresarAlumno p1= new PanelIngresarAlumno(p);
				p1.setVisible(true);
			}
		});
		ingresarNotaAlumno.setHorizontalAlignment(SwingConstants.LEADING);
		ingresarNotaAlumno.setFont(new Font("Arial", Font.PLAIN, 11));
		ingresarNotaAlumno.setBounds(40, 32, 199, 51);
		contentPane.add(ingresarNotaAlumno);
		
		JButton verNotaMinima = new JButton("VER NOTA MINIMA");
		verNotaMinima.setBackground(new Color(255, 255,255));
		verNotaMinima.setOpaque(true);
		verNotaMinima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelNotaMinima p6= new PanelNotaMinima(p);
				p6.setVisible(true);
			}
		});
		verNotaMinima.setFont(new Font("Arial", Font.PLAIN, 11));
		verNotaMinima.setHorizontalAlignment(SwingConstants.LEADING);
		verNotaMinima.setBounds(362, 32, 199, 51);
		contentPane.add(verNotaMinima);
		
		JButton consultarNota = new JButton("CONSULTAR NOTA DE ALUMNO");
		consultarNota.setBackground(new Color(255, 255,255));
		consultarNota.setOpaque(true);
		consultarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelVerNotaAlumno p2= new PanelVerNotaAlumno(p);
				p2.setVisible(true);
			}
		});
		consultarNota.setHorizontalAlignment(SwingConstants.LEADING);
		consultarNota.setToolTipText("");
		consultarNota.setFont(new Font("Arial", Font.PLAIN, 11));
		consultarNota.setBounds(40, 113, 199, 51);
		contentPane.add(consultarNota);
		
		JButton eliminarAlumno = new JButton("ELIMINAR ALUMNO");
		eliminarAlumno.setBackground(new Color(255, 255,255));
		eliminarAlumno.setOpaque(true);
		eliminarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelEliminarAlumno p3= new PanelEliminarAlumno(p);
				p3.setVisible(true);
			}
		});
		eliminarAlumno.setFont(new Font("Arial", Font.PLAIN, 11));
		eliminarAlumno.setHorizontalAlignment(SwingConstants.LEADING);
		eliminarAlumno.setBounds(40, 195, 199, 51);
		contentPane.add(eliminarAlumno);
		
		JButton verNotas = new JButton("VER TODAS LAS NOTAS");
		verNotas.setBackground(new Color(255, 255,255));
		verNotas.setOpaque(true);
		verNotas.setFont(new Font("Arial", Font.PLAIN, 11));
		verNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelVerNotas p4= new PanelVerNotas(p);
				p4.setVisible(true);
			}
		});
		verNotas.setHorizontalAlignment(SwingConstants.LEADING);
		verNotas.setBounds(40, 273, 199, 51);
		contentPane.add(verNotas);
		
		JButton verPromedio = new JButton("VER PROMEDIO");
		verPromedio.setBackground(new Color(255, 255,255));
		verPromedio.setOpaque(true);
		verPromedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPromedio p5= new PanelPromedio(p);
				p5.setVisible(true);
			}
		});
		verPromedio.setHorizontalAlignment(SwingConstants.LEADING);
		verPromedio.setFont(new Font("Arial", Font.PLAIN, 11));
		verPromedio.setBounds(40, 353, 199, 51);
		contentPane.add(verPromedio);
		
		JButton notasOrdenadas = new JButton("VER NOTAS ORDENADAS");
		notasOrdenadas.setBackground(new Color(255, 255,255));
		notasOrdenadas.setOpaque(true);
		notasOrdenadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelNotasOrdenadas p7= new PanelNotasOrdenadas(p);
				p7.setVisible(true);
			}
		});
		notasOrdenadas.setHorizontalAlignment(SwingConstants.LEADING);
		notasOrdenadas.setFont(new Font("Arial", Font.PLAIN, 11));
		notasOrdenadas.setBounds(362, 113, 199, 51);
		contentPane.add(notasOrdenadas);
		
		JButton alumnosMismaNota = new JButton("ALUMNOS CON MISMA NOTA");
		alumnosMismaNota.setBackground(new Color(255, 255,255));
		alumnosMismaNota.setOpaque(true);
		alumnosMismaNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMismaNota p8= new PanelMismaNota(p);
				
				p8.setVisible(true);
			}
		});
		alumnosMismaNota.setHorizontalAlignment(SwingConstants.LEADING);
		alumnosMismaNota.setFont(new Font("Arial", Font.PLAIN, 11));
		alumnosMismaNota.setBounds(362, 195, 199, 51);
		contentPane.add(alumnosMismaNota);
		
		JButton verAprobados = new JButton("VER APROBADOS");
		verAprobados.setBackground(new Color(255, 255,255));
		verAprobados.setOpaque(true);
		verAprobados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAprobados p9= new PanelAprobados(p);
				p9.setVisible(true);
			}
		});
		verAprobados.setHorizontalAlignment(SwingConstants.LEADING);
		verAprobados.setFont(new Font("Arial", Font.PLAIN, 11));
		verAprobados.setBounds(362, 273, 199, 51);
		contentPane.add(verAprobados);
		
		JButton verDesaprobados = new JButton("VER DESAPROBADOS");
		verDesaprobados.setBackground(new Color(255, 255,255));
		verDesaprobados.setOpaque(true);
		verDesaprobados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelDesaprobados p10= new PanelDesaprobados(p);
				p10.setVisible(true);
			}
		});
		verDesaprobados.setHorizontalAlignment(SwingConstants.LEADING);
		verDesaprobados.setFont(new Font("Arial", Font.PLAIN, 11));
		verDesaprobados.setBounds(362, 353, 199, 51);
		contentPane.add(verDesaprobados);
		
		JLabel lblNewLabel = new JLabel("MENÚ");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(64, 0, 64));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(247, 0, 103, 26);
		contentPane.add(lblNewLabel);
	}

}
