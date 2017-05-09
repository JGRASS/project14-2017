package hotel.sistemskeoperacije;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hotel.baza.DBConnector;

/**
 * @author jelica&veljko
 * 
 */
public class SOOtkaziRezervaciju {
	
	/**
	 * Metoda za otkazivanje rezervacije sobe (sluzice da klikom na sobu u tabeli u GUI-ju obrisemo rezervaciju)
	 * @throws SQLException 
	 */
	public static void izvrsi(int idRezervacije) throws SQLException {
		DBConnector connector = new DBConnector();
		Connection conn = connector.connect();

		String upit = "DELETE FROM Rezervacija WHERE idRezervacije = ?";

		PreparedStatement ps = conn.prepareStatement(upit);
		ps.setInt(1, idRezervacije);
		ps.execute();
		ps.close();
	}
}
