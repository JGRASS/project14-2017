package hotel.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotel.gui.modeli.SobaPodaciTableModel;
import hotel.model.Hotel;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

@SuppressWarnings("serial")
public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(140, 10));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnRezervisiSobu = new JButton("Rezervisi sobu");
		btnRezervisiSobu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RezervisiProzor rp = new RezervisiProzor();
				rp.setVisible(true);
				rp.setLocationRelativeTo(null);
			}
		});
		btnRezervisiSobu.setMinimumSize(new Dimension(119, 23));
		btnRezervisiSobu.setMaximumSize(new Dimension(119, 23));
		btnRezervisiSobu.setPreferredSize(new Dimension(119, 23));
		panel.add(btnRezervisiSobu);
		
		JButton btnNewButton = new JButton("Otkazi rezervaciju");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = table.getSelectedRow();

				if (i == -1) {
					JOptionPane.showMessageDialog(contentPane, "Izaberite sobu sa rezervacijom koju zelite da otkazete!", "Greska!!!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						int idRezervacije = (int) table.getValueAt(table.getSelectedRow(), 4);
						GUIKontroler.otkaziRezervaciju(idRezervacije);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		try {
			table = getTable();
			scrollPane.setViewportView(table);
			scrollPane.setViewportView(table);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private JTable getTable() throws SQLException {
		Hotel hotel = new Hotel();
		if (table == null) {
			table = new JTable();
			SobaPodaciTableModel model = new SobaPodaciTableModel(hotel.vratiSveSobe());
			table.setModel(model);
		}
		return table;
	}
	
	public void osveziTabelu() throws SQLException {
		Hotel hotel = new Hotel();
		SobaPodaciTableModel model = new SobaPodaciTableModel(hotel.vratiSveSobe());
		table.setModel(model);
	}

}
