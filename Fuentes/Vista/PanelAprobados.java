package Vista;
import Modelo.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import Auxiliares.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import TDADiccionario.*;
import TDALista.*;
import javax.swing.JLabel;

public class PanelAprobados extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel m;
	private JTable table;
	private JScrollPane s;
	private static Programa p;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAprobados frame = new PanelAprobados(p);
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
	public PanelAprobados(Programa p) {
		setTitle(p.getMateria());
		this.setIconImage((new ImageIcon(VentanaPrincipal.class.getResource("/Imagen/iconn.jpg"))).getImage());
		
		setBounds(100, 100, 499, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(192, 192, 192));
		setContentPane(contentPane);
		m=new DefaultTableModel();
		contentPane.setLayout(null);
		String columnas[]= {"LU APROBADOS"};
		m.setColumnIdentifiers(columnas);
		table = new JTable(m);
		table.setBounds(82, 45,309, 250);
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		
		
		
		s= new JScrollPane();
		s.setEnabled(false);
		s.setBounds(72, 23,302, 209);
		s.setViewportView(table);
		contentPane.add(s);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelAprobados.class.getResource("/Imagen/1-48-6.jpg")));
		lblNewLabel.setBounds(-329, -95, 855, 467);
		contentPane.add(lblNewLabel);
		table.getTableHeader().setReorderingAllowed(false) ;
		Iterable<Integer> d1= p.aprobados();
		int colu=0;

		for(Integer elemento : d1) {
			m.insertRow(colu, new Object [] {elemento});
			colu++;
		}
		if(colu==0) {
			m.insertRow(0, new Object [] {"NO HAY APROBADOS"});
		}

}
	
}
