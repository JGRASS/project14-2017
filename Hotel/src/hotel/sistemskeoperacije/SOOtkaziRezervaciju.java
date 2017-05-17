package hotel.sistemskeoperacije;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import hotel.SobaPodaci;
import hotel.baza.DBConnector;

/**
 * @author jelica&veljko
 * 
 */
public class SOOtkaziRezervaciju {
	
	/**
	 * Metoda za otkazivanje rezervacije sobe (sluzice da klikom na sobu u tabeli u GUI-ju obrisemo rezervaciju)
	 * @return postoji - true ili false da li je soba uspesno rezervisana (da li postoji rezervacija)
	 * @throws SQLException 
	 */
	public static boolean izvrsi(int idRezervacije) throws SQLException {
		DBConnector connector = new DBConnector();
		Connection conn = connector.connect();
		
		LinkedList<SobaPodaci> sobe = SOVratiSveSobe.izvrsi();
		boolean postoji = false;
		for(SobaPodaci s: sobe) {
			if(s.getIdRezervacije() == idRezervacije) {
				postoji = true;
			}
		}
		
		String upit = "DELETE FROM Rezervacija WHERE idRezervacije = ?";

		PreparedStatement ps = conn.prepareStatement(upit);
		ps.setInt(1, idRezervacije);
		ps.execute();
		ps.close();
		
		return postoji;
	}
}
