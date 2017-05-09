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

import hotel.Soba;
import hotel.SobaPodaci;
import hotel.baza.DBConnector;
import hotel.interfejs.HotelInterfejs;

/**
 * @author jelica&veljko
 * 
 *
 */

public class Hotel implements HotelInterfejs {

	public static DBConnector connector = new DBConnector();

	/**
	 * Metoda za rezervaciju sobe (sluzice da klikom na sobu u tabeli u GUI-ju rezervisemo sobu)
	 * @return rez - idRezervacije
	 * @throws SQLException 
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
	

	/**
	 * Metoda za otkazivanje rezervacije sobe (sluzice da klikom na sobu u tabeli u GUI-ju obrisemo rezervaciju)
	 * @throws SQLException 
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

	/**
	 * Metoda za vracanje soba sa terasom
	 * @return sobe - LinkedList soba sa terasom
	 * @throws SQLException 
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

	/**
	 * Metoda za vracanje soba sa odredjenim brojem kreveta
	 * @return sobe - LinkedList soba sa odredjenim brojem kreveta 
	 * @throws SQLException 
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

	/**
	 * Metoda za vracanje soba na odredjenom spratu
	 * @return sobe - LinkedList soba na odredjenom spratu
	 * @throws SQLException 
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
