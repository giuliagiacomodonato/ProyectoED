package Vista;
import Modelo.*;
import Excepciones.*;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class PanelMismaNota extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel m;
	private JTable table;
	private JScrollPane s;
	private static Programa p;
	private JLabel lblNewLabel;
	private JTextField nota;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelMismaNota frame = new PanelMismaNota(p);
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
	public PanelMismaNota(Programa p) {
		setTitle(p.getMateria());
		this.setIconImage((new ImageIcon(VentanaPrincipal.class.getResource("/Imagen/iconn.jpg"))).getImage());
		
		setBounds(100, 100, 499, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(192, 192, 192));
		setContentPane(contentPane);
		m=new DefaultTableModel();
		contentPane.setLayout(null);
		String columnas[]= {"LU"};
		m.setColumnIdentifiers(columnas);
		table = new JTable(m);
		table.setBounds(80, 50,300, 250);
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		
		
		
		s= new JScrollPane();
		s.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false) ;
		s.setBounds(80, 50,300, 250);
		s.setViewportView(table);
	
		contentPane.add(s);
		
		lblNewLabel = new JLabel("INGRESE UNA NOTA:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBackground(new Color(209, 216, 211));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(38, 11, 142, 14);
		contentPane.add(lblNewLabel);
		
		nota = new JTextField();
		nota.addKeyListener(new KeyAdapter() {
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
		nota.setBounds(187, 8, 86, 20);
		contentPane.add(nota);
		nota.setColumns(10);
		
		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setBackground(new Color(255, 255,255));
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					mostrar(p);
			}
		});
		aceptar.setFont(new Font("Arial", Font.PLAIN, 13));
		aceptar.setBounds(291, 7, 105, 20);
		contentPane.add(aceptar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelMismaNota.class.getResource("/Imagen/1-48-6.jpg")));
		lblNewLabel_1.setBounds(-282, -18, 826, 439);
		contentPane.add(lblNewLabel_1);
	
}
	private void mostrar(Programa p){
			if(m.getRowCount() >0) {
				for (int i=m.getRowCount()-1; i>=0; i--){
		                m.removeRow(i);
				 }
			}
			if(!nota.getText().isBlank()) {
				int notaIngresada= Integer.parseInt(nota.getText());
				int fila=0;
				if(notaIngresada>=0 && notaIngresada<=10) {
					for(Integer elemento :  p.alumnosConMismaNota(notaIngresada)) {
						m.insertRow(fila, new Object [] {elemento});
						fila++;
					}
					if(m.getRowCount()==0) {
						m.insertRow(0, new Object [] {"NO HAY ALUMNOS CON ESA NOTA"});
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "LA NOTA INGRESADA NO ES VÁLIDA",null, 0);
				}
		}
		else {
			JOptionPane.showMessageDialog(contentPane, "LA NOTA INGRESADA NO ES VÁLIDA",null, 0);
		}
	}
}
