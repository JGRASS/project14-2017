package hotel.gui;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import hotel.Soba;
import hotel.SobaPodaci;
import hotel.model.Hotel;

/**
 * @author jelica
 *
 */

public class GUIKontroler {

	private static GlavniProzor glavniProzor;
	private static Hotel hotel = new Hotel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new GlavniProzor();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void otkaziRezervacijuNaKlik(int idRezervacije) {
		try {
			hotel.otkaziRezervaciju(idRezervacije);
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					"Otkazali ste rezervaciju broj " + idRezervacije + ".");
			glavniProzor.osveziTabelu();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Doslo je do greske, pokusajte ponovo!",
					"Greska!!!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void otkaziRezervacijuID(int idRezervacije) {
		try {
			boolean otkazana = hotel.otkaziRezervaciju(idRezervacije);
			if (otkazana == true) {
				JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
						"Otkazali ste rezervaciju broj " + idRezervacije + ".");
				glavniProzor.osveziTabelu();
			} else {
				JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Upisite broj rezervacije koja postoji!",
						"Greska!!!", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Ne postoji data rezervacija!", "Greska!!!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static int rezervisi(int idSobe, String ime, String prezime, GregorianCalendar datumOd,
			GregorianCalendar datumDo) {
		Hotel hotel = new Hotel();
		int rezervacija=-1;
		try {
			rezervacija = hotel.rezervisiSobu(idSobe, ime, prezime, datumOd, datumDo);
			glavniProzor.osveziTabelu();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Doslo je do greske, pokusajte ponovo.", "Greska!!!",
					JOptionPane.ERROR_MESSAGE);
		}
		return rezervacija;
	}

	public static LinkedList<Soba> izlistaj(GregorianCalendar datumOd, GregorianCalendar datumDo, int brojKreveta) {
		Hotel hotel = new Hotel();
		try {
			LinkedList<Soba> sobe = hotel.izlistaj(datumOd, datumDo, brojKreveta);
			return sobe;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Doslo je do greske, pokusajte ponovo.", "Greska!!!",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public static LinkedList<Soba> vratiSaTerasom() {
		try {
			return hotel.vratiSaTerasom();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Ne postoji soba sa terasom! ", "Greska!!!",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;

	}

	public static LinkedList<Soba> vratiSaKrevetom(int brojKreveta) {
		try {
			return hotel.vratiSaKrevetom(brojKreveta);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					"Ne postoji soba sa datim brojem kreveta(" + brojKreveta + ")! ", "Greska!!!",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public static LinkedList<Soba> vratiSprat(int sprat) {
		try {
			return hotel.vratiSprat(sprat);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Ne postoji soba na " + sprat + " spratu!",
					"Greska!!!", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(glavniProzor, "Da li zelite da zatvorite program?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_CANCEL_OPTION);
		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static LinkedList<SobaPodaci> vratiSveSobe() {
		try {
			return hotel.vratiSveSobe();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					"Ne postoji nijedna soba!", "Greska!!!",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	
}
