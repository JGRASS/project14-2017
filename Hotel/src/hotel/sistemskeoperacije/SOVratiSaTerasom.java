package hotel.sistemskeoperacije;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import hotel.Soba;
import hotel.baza.DBConnector;

/**
 * @author jelica&veljko
 * 
 */
public class SOVratiSaTerasom {

	
	/**
	 * Metoda za vracanje soba sa terasom
	 * @return sobe - LinkedList soba sa terasom
	 * @throws SQLException 
	 */
	public static LinkedList<Soba> izvrsi()  throws SQLException {
		DBConnector connector = new DBConnector();
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
}
