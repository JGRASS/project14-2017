package hotel.sistemskeoperacije;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import hotel.baza.DBConnector;

/**
 * @author jelica&veljko
 * 
 */
public class SORezervisiSobu {
	
	/**
	 * Metoda za rezervaciju sobe (sluzice da klikom na sobu u tabeli u GUI-ju rezervisemo sobu)
	 * @return rez - idRezervacije
	 * @throws SQLException 
	 */
	public static int izvrsi(int idSobe, String ime, String prezime, GregorianCalendar datumOd, GregorianCalendar datumDo) throws SQLException {
		DBConnector connector = new DBConnector();
		Connection conn = connector.connect();
		java.sql.Date datOd = new java.sql.Date(datumOd.getTimeInMillis());
		java.sql.Date datDo = new java.sql.Date(datumDo.getTimeInMillis());

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
}
