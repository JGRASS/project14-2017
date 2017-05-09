/**
 * 
 */
package hotel.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import hotel.Rezervacija;
import hotel.Soba;
import hotel.SobaPodaci;
import hotel.baza.DBConnector;
import hotel.interfejs.HotelInterfejs;

/**
 * @author jelica&veljko
 *
 */

public class Hotel implements HotelInterfejs {

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#rezervisi(int)
	 */

	public static DBConnector connector = new DBConnector();

	@Override
	public void rezervisi(int idSobe) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#otkazi(int)
	 */
	@Override
	public void otkazi(int idRezervacije) {

	}

	/**
	 * metoda za vracanje lista svih soba i rezervacija ukoliko ih ima
	 * 
	 * @return listaSoba - lista objekata klase SobaPodaci
	 */
	@Override
	public LinkedList<SobaPodaci> vratiSveSobe() {

		LinkedList<SobaPodaci> listaSoba = new LinkedList<SobaPodaci>();

		try {
			Connection con = connector.connect();
			String query = "SELECT * FROM soba";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idSobe = rs.getInt(1);
				PreparedStatement ps2 = con.prepareStatement("SELECT * FROM rezervacija");
				ResultSet rs2 = ps2.executeQuery();
				SobaPodaci rezSobe = new SobaPodaci();
				rezSobe.setBrojKreveta(rs.getInt(2));
				rezSobe.setCena(rs.getInt(3));
				rezSobe.setSprat(rs.getInt(4));
				rezSobe.setTerasa(rs.getBoolean(5));
				rezSobe.setIdSobe(rs.getInt(1));

				while (rs2.next()) {
					int rezSobeID = rs2.getInt(2);
					if (idSobe == rezSobeID) {

						rezSobe.setIdRezervacije(rs2.getInt(1));
						rezSobe.setImeGosta(rs2.getString(3));
						rezSobe.setPrezimeGosta(rs2.getString(4));

						GregorianCalendar datumOd = new GregorianCalendar();
						datumOd.setTime(rs2.getDate(5));
						rezSobe.setDatumOd(datumOd);

						GregorianCalendar datumDo = new GregorianCalendar();
						datumDo.setTime(rs2.getDate(6));
						rezSobe.setDatumDo(datumDo);

					}
				}
				listaSoba.add(rezSobe);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaSoba;
	}

	/**
	 * metoda koja vraca listu soba koje su slobodne u odredjenom periodu i sa odgovarajucim
	 * brojem kreveta
	 * @return slobodneSobe - lista soba koje su slobodne
	 */
	@Override
	public LinkedList<Soba> izlistaj(GregorianCalendar datumOd, GregorianCalendar datumDo, int brKreveta) {
		LinkedList<Soba> slobodneSobe = new LinkedList<Soba>();
		boolean nemaRez = true;
		try {
			Connection con = connector.connect();
			String query = "SELECT * FROM soba";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(2) == brKreveta) {
					nemaRez = true;
					int idSobe = rs.getInt(1);
					Soba rezSobe = new Soba();
					rezSobe.setBrojKreveta(rs.getInt(2));
					rezSobe.setCena(rs.getInt(3));
					rezSobe.setSprat(rs.getInt(4));
					rezSobe.setTerasa(rs.getBoolean(5));
					rezSobe.setIdSobe(rs.getInt(1));

					PreparedStatement ps2 = con.prepareStatement("SELECT * FROM rezervacija");
					ResultSet rs2 = ps2.executeQuery();
					while (rs2.next()) {
						int rezSobeID = rs2.getInt(2);
						if (idSobe == rezSobeID) {
							nemaRez = false;

							GregorianCalendar datOd = new GregorianCalendar();
							datOd.setTime(rs2.getDate(5));

							GregorianCalendar datDo = new GregorianCalendar();
							datDo.setTime(rs2.getDate(6));

							if ((datumDo.before(datOd) || datumOd.after(datDo)) && !slobodneSobe.contains(rezSobe)) {
								slobodneSobe.add(rezSobe);
							}
						}
					}
					if (nemaRez == true)
						slobodneSobe.add(rezSobe);
				}
			}
			con.close();
		} catch (SQLException e) {
		}
		return slobodneSobe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#vratiSaTerasom()
	 */
	@Override
	public void vratiSaTerasom() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#vratiSaKrevetom(int)
	 */
	@Override
	public void vratiSaKrevetom(int brKreveta) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#vratiSprat(int)
	 */
	@Override
	public void vratiSprat(int sprat) {

	}

}
