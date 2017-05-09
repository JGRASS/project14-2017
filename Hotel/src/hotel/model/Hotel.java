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

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#vratiSveSobe()
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
						datumOd.setTime(rs2.getDate(6));
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#izlistaj(java.util.GregorianCalendar,
	 * java.util.GregorianCalendar, int)
	 */
	@Override
	public void izlistaj(GregorianCalendar datumOd, GregorianCalendar datumDo, int brKreveta) {

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

	public static void main(String[] args) {
		Hotel h = new Hotel();
		h.vratiSveSobe();
	}

}
