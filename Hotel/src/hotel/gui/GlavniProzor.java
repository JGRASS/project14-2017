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
import java.awt.HeadlessException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldIDRez;

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		setTitle("Hotelske rezervacije");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(140, 10));
		contentPane.add(panel, BorderLayout.WEST);

		JButton btnRezervisiSobu = new JButton("Rezervisi sobu");
		btnRezervisiSobu.setBounds(10, 5, 119, 23);
		btnRezervisiSobu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RezervisiProzor rp = new RezervisiProzor();
				rp.setVisible(true);
				rp.setLocationRelativeTo(null);
			}
		});
		panel.setLayout(null);
		btnRezervisiSobu.setMinimumSize(new Dimension(119, 23));
		btnRezervisiSobu.setMaximumSize(new Dimension(119, 23));
		btnRezervisiSobu.setPreferredSize(new Dimension(119, 23));
		panel.add(btnRezervisiSobu);

		JButton btnNewButton = new JButton("Otkazi rezervaciju");
		btnNewButton.setBounds(10, 39, 119, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = table.getSelectedRow();

				if (i == -1 || table.getValueAt(table.getSelectedRow(), 4)== "Ne postoji") {
					JOptionPane.showMessageDialog(contentPane,
							"Izaberite sobu sa rezervacijom koju zelite da otkazete!", "Greska!!!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						int idRezervacije = (int) table.getValueAt(table.getSelectedRow(), 4);
						GUIKontroler.otkaziRezervaciju(idRezervacije);
						JOptionPane.showMessageDialog(contentPane,
								"Otkazali ste rezervaciju broj " + idRezervacije + ".");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		panel.add(btnNewButton);

		JButton btnOtkaziPrekoId = new JButton("Otkazi  ");
		btnOtkaziPrekoId.setBounds(0, 315, 120, 23);
		btnOtkaziPrekoId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldIDRez == null || textFieldIDRez.getText() == null || textFieldIDRez.getText().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Upisite broj rezervacije koju zelite da otkazete!",
							"Greska!!!", JOptionPane.ERROR_MESSAGE);
				} else
					try {
						if(GUIKontroler.otkaziRezervaciju(Integer.parseInt(textFieldIDRez.getText())) == false){
							JOptionPane.showMessageDialog(contentPane, "Upisite broj rezervacije koja postoji!",
									"Greska!!!", JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								int idRezervacije = Integer.parseInt(textFieldIDRez.getText());
								GUIKontroler.otkaziRezervaciju(idRezervacije);
								JOptionPane.showMessageDialog(contentPane,
										"Otkazali ste rezervaciju broj " + idRezervacije + ".");
							} catch (SQLException e1) {
								e1.printStackTrace();
								JOptionPane.showMessageDialog(contentPane, "Ne postoji data rezervacija!",
										"Greska!!!", JOptionPane.ERROR_MESSAGE);
							}
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});btnOtkaziPrekoId.setPreferredSize(new Dimension(119,23));panel.add(btnOtkaziPrekoId);

	JLabel lblId = new JLabel("Broj rezervacije:");
	lblId.setBounds(10, 349, 93, 14);panel.add(lblId);

	textFieldIDRez=new JTextField();
	textFieldIDRez.setBounds(10, 374, 36, 20);panel.add(textFieldIDRez);textFieldIDRez.setColumns(10);

	JScrollPane scrollPane = new JScrollPane();scrollPane.setBackground(Color.WHITE);contentPane.add(scrollPane,BorderLayout.CENTER);

	try
	{
		table = getTable();
		scrollPane.setViewportView(table);
		scrollPane.setViewportView(table);
	}catch(
	SQLException e)
	{
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
