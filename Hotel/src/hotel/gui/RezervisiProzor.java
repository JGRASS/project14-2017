package hotel.gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

import hotel.gui.modeli.SobaTableModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * @author veljko
 *
 */
@SuppressWarnings("serial")
public class RezervisiProzor extends JFrame {
	public RezervisiProzor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RezervisiProzor.class.getResource("/icon/hotel.png")));

		getContentPane().setLayout(new BorderLayout(0, 0));
		setBounds(100, 100, 680, 452);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblOd = new JLabel("Od");
		panel.add(lblOd);

		final JComboBox<Integer> comboBoxDanDatumOd = new JComboBox<Integer>();
		panel.add(comboBoxDanDatumOd);
		comboBoxDanDatumOd.addItem(1);
		comboBoxDanDatumOd.addItem(2);
		comboBoxDanDatumOd.addItem(3);
		comboBoxDanDatumOd.addItem(4);
		comboBoxDanDatumOd.addItem(5);
		comboBoxDanDatumOd.addItem(6);
		comboBoxDanDatumOd.addItem(7);
		comboBoxDanDatumOd.addItem(8);
		comboBoxDanDatumOd.addItem(9);
		comboBoxDanDatumOd.addItem(10);
		comboBoxDanDatumOd.addItem(11);
		comboBoxDanDatumOd.addItem(12);
		comboBoxDanDatumOd.addItem(13);
		comboBoxDanDatumOd.addItem(14);
		comboBoxDanDatumOd.addItem(15);
		comboBoxDanDatumOd.addItem(16);
		comboBoxDanDatumOd.addItem(17);
		comboBoxDanDatumOd.addItem(18);
		comboBoxDanDatumOd.addItem(19);
		comboBoxDanDatumOd.addItem(20);
		comboBoxDanDatumOd.addItem(21);
		comboBoxDanDatumOd.addItem(22);
		comboBoxDanDatumOd.addItem(23);
		comboBoxDanDatumOd.addItem(24);
		comboBoxDanDatumOd.addItem(25);
		comboBoxDanDatumOd.addItem(26);
		comboBoxDanDatumOd.addItem(27);
		comboBoxDanDatumOd.addItem(28);
		comboBoxDanDatumOd.addItem(29);
		comboBoxDanDatumOd.addItem(30);
		comboBoxDanDatumOd.addItem(31);

		JComboBox<Integer> comboBoxMesecDatumOd = new JComboBox<Integer>();
		panel.add(comboBoxMesecDatumOd);
		comboBoxMesecDatumOd.addItem(1);
		comboBoxMesecDatumOd.addItem(2);
		comboBoxMesecDatumOd.addItem(3);
		comboBoxMesecDatumOd.addItem(4);
		comboBoxMesecDatumOd.addItem(5);
		comboBoxMesecDatumOd.addItem(6);
		comboBoxMesecDatumOd.addItem(7);
		comboBoxMesecDatumOd.addItem(8);
		comboBoxMesecDatumOd.addItem(9);
		comboBoxMesecDatumOd.addItem(10);
		comboBoxMesecDatumOd.addItem(11);
		comboBoxMesecDatumOd.addItem(12);

		JComboBox<Integer> comboBoxGodinaDatumOd = new JComboBox<Integer>();
		panel.add(comboBoxGodinaDatumOd);

		comboBoxGodinaDatumOd.addItem(2017);
		comboBoxGodinaDatumOd.addItem(2018);
		comboBoxGodinaDatumOd.addItem(2019);
		comboBoxGodinaDatumOd.addItem(2020);

		JLabel lblDo = new JLabel("Do");
		panel.add(lblDo);

		JComboBox<Integer> comboBoxDanDatumDo = new JComboBox<Integer>();
		panel.add(comboBoxDanDatumDo);

		comboBoxDanDatumDo.addItem(1);
		comboBoxDanDatumDo.addItem(2);
		comboBoxDanDatumDo.addItem(3);
		comboBoxDanDatumDo.addItem(4);
		comboBoxDanDatumDo.addItem(5);
		comboBoxDanDatumDo.addItem(6);
		comboBoxDanDatumDo.addItem(7);
		comboBoxDanDatumDo.addItem(8);
		comboBoxDanDatumDo.addItem(9);
		comboBoxDanDatumDo.addItem(10);
		comboBoxDanDatumDo.addItem(11);
		comboBoxDanDatumDo.addItem(12);
		comboBoxDanDatumDo.addItem(13);
		comboBoxDanDatumDo.addItem(14);
		comboBoxDanDatumDo.addItem(15);
		comboBoxDanDatumDo.addItem(16);
		comboBoxDanDatumDo.addItem(17);
		comboBoxDanDatumDo.addItem(18);
		comboBoxDanDatumDo.addItem(19);
		comboBoxDanDatumDo.addItem(20);
		comboBoxDanDatumDo.addItem(21);
		comboBoxDanDatumDo.addItem(22);
		comboBoxDanDatumDo.addItem(23);
		comboBoxDanDatumDo.addItem(24);
		comboBoxDanDatumDo.addItem(25);
		comboBoxDanDatumDo.addItem(26);
		comboBoxDanDatumDo.addItem(27);
		comboBoxDanDatumDo.addItem(28);
		comboBoxDanDatumDo.addItem(29);
		comboBoxDanDatumDo.addItem(30);
		comboBoxDanDatumDo.addItem(31);

		JComboBox<Integer> comboBoxMesecDatumDo = new JComboBox<Integer>();
		panel.add(comboBoxMesecDatumDo);

		comboBoxMesecDatumDo.addItem(1);
		comboBoxMesecDatumDo.addItem(2);
		comboBoxMesecDatumDo.addItem(3);
		comboBoxMesecDatumDo.addItem(4);
		comboBoxMesecDatumDo.addItem(5);
		comboBoxMesecDatumDo.addItem(6);
		comboBoxMesecDatumDo.addItem(7);
		comboBoxMesecDatumDo.addItem(8);
		comboBoxMesecDatumDo.addItem(9);
		comboBoxMesecDatumDo.addItem(10);
		comboBoxMesecDatumDo.addItem(11);
		comboBoxMesecDatumDo.addItem(12);
		JComboBox<Integer> comboBoxGodinaDatumDo = new JComboBox<Integer>();
		panel.add(comboBoxGodinaDatumDo);

		comboBoxGodinaDatumDo.addItem(2017);
		comboBoxGodinaDatumDo.addItem(2018);
		comboBoxGodinaDatumDo.addItem(2019);
		comboBoxGodinaDatumDo.addItem(2020);

		JLabel lblBrKreveta = new JLabel("Br. kreveta");
		panel.add(lblBrKreveta);

		JComboBox<Integer> comboBoxBrojKreveta = new JComboBox<Integer>();
		panel.add(comboBoxBrojKreveta);
		comboBoxBrojKreveta.addItem(1);
		comboBoxBrojKreveta.addItem(2);
		comboBoxBrojKreveta.addItem(3);
		comboBoxBrojKreveta.addItem(4);
		comboBoxBrojKreveta.addItem(5);

		JButton btnProveriSlobodneSobe = new JButton("Proveri slobodne sobe");

		panel.add(btnProveriSlobodneSobe);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);

		JLabel lblIme = new JLabel("Ime");
		panel_2.add(lblIme);

		textFieldIme = new JTextField();
		panel_2.add(textFieldIme);
		textFieldIme.setColumns(10);

		JLabel lblPrezime = new JLabel("Prezime");
		panel_2.add(lblPrezime);

		textFieldPrezime = new JTextField();
		panel_2.add(textFieldPrezime);
		textFieldPrezime.setColumns(10);

		JButton btnRezervisi = new JButton("Rezervisi");
		btnRezervisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ime = textFieldIme.getText();
				String prezime = textFieldPrezime.getText();

				if (ime.isEmpty() || prezime.isEmpty() || proveriTekst(ime) || proveriTekst(prezime)) {
					JOptionPane.showMessageDialog(contentPane, "Neispravan unos imena ili prezimena!", "GRESKA",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				GregorianCalendar datumOd = new GregorianCalendar();
				datumOd.set(Integer.parseInt(comboBoxGodinaDatumOd.getSelectedItem().toString()),
						Integer.parseInt(comboBoxMesecDatumOd.getSelectedItem().toString()) - 1,
						Integer.parseInt(comboBoxDanDatumOd.getSelectedItem().toString()));
				GregorianCalendar datumDo = new GregorianCalendar();
				datumDo.set(Integer.parseInt(comboBoxGodinaDatumDo.getSelectedItem().toString()),
						Integer.parseInt(comboBoxMesecDatumDo.getSelectedItem().toString()) - 1,
						Integer.parseInt(comboBoxDanDatumDo.getSelectedItem().toString()));

				if (table == null) {
					JOptionPane.showMessageDialog(contentPane,
							"Morate ucitati sobe i izabrati onu koju hocete da rezervisete!", "Greska!!!",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				int i = table.getSelectedRow();

				if (i == -1) {
					JOptionPane.showMessageDialog(contentPane, "Izaberite sobu koju zelite da rezervisete!",
							"Greska!!!", JOptionPane.ERROR_MESSAGE);
				} else {
					int idSobe = (int) table.getValueAt(table.getSelectedRow(), 0);
					int idRez = GUIKontroler.rezervisi(idSobe, ime, prezime, datumOd, datumDo);
					JOptionPane.showMessageDialog(contentPane, "Uspesno ste rezervisali sobu na ime: " + ime + " "
							+ prezime + " brojRezervacije: " + idRez);
					setVisible(false);
				}
			}
		});
		panel_2.add(btnRezervisi);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBackground(Color.WHITE);

		scrollPane.setViewportView(table);

		btnProveriSlobodneSobe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					GregorianCalendar datumOd = new GregorianCalendar();
					datumOd.set(Integer.parseInt(comboBoxGodinaDatumOd.getSelectedItem().toString()),
							Integer.parseInt(comboBoxMesecDatumOd.getSelectedItem().toString()) - 1,
							Integer.parseInt(comboBoxDanDatumOd.getSelectedItem().toString()));
					GregorianCalendar datumDo = new GregorianCalendar();
					datumDo.set(Integer.parseInt(comboBoxGodinaDatumDo.getSelectedItem().toString()),
							Integer.parseInt(comboBoxMesecDatumDo.getSelectedItem().toString()) - 1,
							Integer.parseInt(comboBoxDanDatumDo.getSelectedItem().toString()));
					int brojKreveta = Integer.parseInt(comboBoxBrojKreveta.getSelectedItem().toString());

					if (datumDo.before(datumOd) || datumOd.equals(datumDo) || datumOd.before(new GregorianCalendar())
							|| datumDo.before(new GregorianCalendar())) {
						JOptionPane.showMessageDialog(contentPane, "Neispravan unos datuma!", "GRESKA",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					table = getTable(datumOd, datumDo, brojKreveta);
					scrollPane.setViewportView(table);
			}
		});
	}

	private JTable table;
	private JTextField textFieldIme;
	private JTextField textFieldPrezime;
	private JPanel contentPane;

	private JTable getTable(GregorianCalendar datumOd, GregorianCalendar datumDo, int brojKreveta) {
		table = new JTable();
		if (GUIKontroler.izlistaj(datumOd, datumDo, brojKreveta).isEmpty()
				|| GUIKontroler.izlistaj(datumOd, datumDo, brojKreveta) == null) {
			JOptionPane.showMessageDialog(contentPane, "Nazalost, nema takvih slobodnih soba.", "GRESKA",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
		SobaTableModel model = new SobaTableModel(GUIKontroler.izlistaj(datumOd, datumDo, brojKreveta));
		table.setModel(model);

		return table;
	}

	/**
	 * Launch the application.
	 */

	private boolean proveriTekst(String t) {
		if (t.matches(".*\\d.*"))
			return true;
		return false;
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RezervisiProzor frame = new RezervisiProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
