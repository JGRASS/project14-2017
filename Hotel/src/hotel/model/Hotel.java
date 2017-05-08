/**
 * 
 */
package hotel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import hotel.interfejs.HotelInterfejs;
import hotel.Soba;
import hotel.baza.DBConnector;

/**
 * @author jelica&veljko
 *
 */
public class Hotel implements HotelInterfejs {

	public static DBConnector connector = new DBConnector();

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#rezervisi(int)
	 */
	@Override
	public int rezervisiSobu(int idSobe, String ime, String prezime, GregorianCalendar datumOd, GregorianCalendar datumDo) throws SQLException {
		Connection conn = connector.connect();
		java.sql.Date datOd = new java.sql.Date(datumOd.getTimeInMillis());
		java.sql.Date datDo = new java.sql.Date(datumOd.getTimeInMillis());

		String upit1 = "INSERT INTO Rezervacija(idSobe, imeGosta, prezimeGosta, datumOd, datumDo) VALUES(?, ?, ?, ?, ?)";

		PreparedStatement ps1 = conn.prepareStatement(upit1);

		ps1.setInt(1, idSobe);
		ps1.setString(2, ime);
		ps1.setString(3, prezime);
		ps1.setDate(4, datOd);
		ps1.setDate(5, datDo);
		ps1.execute();
		ps1.close();

		String upit2 = "SELECT * FROM Rezervacija WHERE datumOd = ? AND datumDo = ?";
		PreparedStatement ps2 = conn.prepareStatement(upit2);
		ps2.setDate(1, datOd);
		ps2.setDate(2, datDo);
		ResultSet rs = ps2.executeQuery();
		int rez = -1;

		while (rs.next()) {
			rez = rs.getInt(1);
		}
		ps2.close();
		rs.close();
		return rez;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#otkazi(int)
	 */
	@Override
	public void otkaziRezervaciju(int idRezervacije) throws SQLException {
		Connection conn = connector.connect();

		String upit = "DELETE FROM Rezervacija WHERE idRezervacije = ?";

		PreparedStatement ps = conn.prepareStatement(upit);
		ps.setInt(1, idRezervacije);
		ps.execute();
		ps.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#vratiSveSobe()
	 */
	@Override
	public void vratiSveSobe() {

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
	public LinkedList<Soba> vratiSaTerasom() throws SQLException {
		LinkedList<Soba> sobe = new LinkedList<Soba>();
		Connection conn = connector.connect();

		String upit = "SELECT * FROM Soba";

		PreparedStatement ps = conn.prepareStatement(upit);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int id = rs.getInt(1);
			int brojKreveta = rs.getInt(2);
			int cena = rs.getInt(3);
			int sprat = rs.getInt(4);
			boolean terasa = rs.getBoolean(5);

			if (terasa == true) {
				Soba soba = new Soba(id, brojKreveta, cena, sprat, terasa);
				sobe.add(soba);
			}
		}
		ps.close();
		rs.close();
		return sobe;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#vratiSaKrevetom(int)
	 */
	@Override
	public LinkedList<Soba> vratiSaKrevetom(int brKreveta) throws SQLException {
		LinkedList<Soba> sobe = new LinkedList<Soba>();
		Connection conn = connector.connect();

		String upit = "SELECT * FROM Soba";

		PreparedStatement ps = conn.prepareStatement(upit);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int id = rs.getInt(1);
			int brojKreveta = rs.getInt(2);
			int cena = rs.getInt(3);
			int sprat = rs.getInt(4);
			boolean terasa = rs.getBoolean(5);

			if (brojKreveta == brKreveta) {
				Soba soba = new Soba(id, brojKreveta, cena, sprat, terasa);
				sobe.add(soba);
			}
		}
		ps.close();
		rs.close();
		return sobe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#vratiSprat(int)
	 */
	@Override
	public LinkedList<Soba> vratiSprat(int sprat) throws SQLException {
		LinkedList<Soba> sobe = new LinkedList<Soba>();
		Connection conn = connector.connect();

		String upit = "SELECT * FROM Soba";

		PreparedStatement ps = conn.prepareStatement(upit);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int id = rs.getInt(1);
			int brojKreveta = rs.getInt(2);
			int cena = rs.getInt(3);
			int spratt = rs.getInt(4);
			boolean terasa = rs.getBoolean(5);

			if (spratt == sprat) {
				Soba soba = new Soba(id, brojKreveta, cena, sprat, terasa);
				sobe.add(soba);
			}
		}
		ps.close();
		rs.close();
		return sobe;
	}

	

}
