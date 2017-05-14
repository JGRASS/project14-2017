package hotel.gui;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import hotel.Soba;
import hotel.model.Hotel;

public class GUIKontroler {

	private static GlavniProzor glavniProzor;
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
	
	public static void otkaziRezervaciju(int idRezervacije) throws SQLException {
		Hotel hotel = new Hotel();
		hotel.otkaziRezervaciju(idRezervacije);
		glavniProzor.osveziTabelu();
	}
	
	public static int rezervisi(int idSobe,String ime, String prezime, GregorianCalendar datumOd, GregorianCalendar datumDo) throws SQLException {
		Hotel hotel = new Hotel();
		return hotel.rezervisiSobu(idSobe, ime, prezime, datumOd, datumDo);
	}
	
	public static LinkedList<Soba> izlistaj(GregorianCalendar datumOd, GregorianCalendar datumDo, int brojKreveta) throws SQLException {
		Hotel hotel = new Hotel();
		return hotel.izlistaj(datumOd, datumDo,brojKreveta);
	}
	
	

}
