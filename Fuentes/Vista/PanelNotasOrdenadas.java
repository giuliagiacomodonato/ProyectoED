package Vista;
import Modelo.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Auxiliares.*;
import TDADiccionario.*;
import TDALista.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PanelNotasOrdenadas extends JFrame {

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
					PanelNotasOrdenadas frame = new PanelNotasOrdenadas(p);
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
	public PanelNotasOrdenadas(Programa p) {
		setTitle(p.getMateria());
		this.setIconImage((new ImageIcon(VentanaPrincipal.class.getResource("/Imagen/iconn.jpg"))).getImage());
		
		setBounds(100, 100, 499, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(192, 192, 192));

		setContentPane(contentPane);

		m=new DefaultTableModel();
		contentPane.setLayout(null);
		String columnas[]= {"LU","NOTA"};
		m.setColumnIdentifiers(columnas);
		table = new JTable(m);
		table.setBounds(82, 45,309, 250);
		
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		
		
		
		s= new JScrollPane();
		s.setEnabled(false);
		s.setBounds(72, 23,302, 209);
		s.setViewportView(table);
	
		
		table.getTableHeader().setReorderingAllowed(false) ;
		contentPane.add(s);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelNotasOrdenadas.class.getResource("/Imagen/1-48-6.jpg")));
		lblNewLabel.setBounds(-325, -105, 833, 486);
		contentPane.add(lblNewLabel);
			Iterable<Pair<Integer, Integer>> d1= p.notasMayorAMenor();
			int fila=0;
			for(Pair<Integer, Integer> elemento : d1) {
				m.insertRow(fila, new Object [] {elemento.getK(),elemento.getV()});
				fila++;
			}
			if(fila==0) {
				table.removeColumn(table.getColumnModel().getColumn(1));
				m.insertRow(0, new Object [] {"NO HAY ALUMNOS REGISTRADOS"});
			}
	}
}

		

