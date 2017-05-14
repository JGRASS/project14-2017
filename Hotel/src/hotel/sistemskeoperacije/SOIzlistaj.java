package hotel.sistemskeoperacije;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import hotel.Soba;
import hotel.baza.DBConnector;

/**
 * @author jelica&veljko
 * 
 */
public class SOIzlistaj {

	/**
	 * metoda koja vraca listu soba koje su slobodne u odredjenom periodu i sa
	 * odgovarajucim brojem kreveta
	 * 
	 * @return slobodneSobe - lista soba koje su slobodne
	 * @throws SQLException
	 */
	public static LinkedList<Soba> izvrsi(GregorianCalendar datumOd, GregorianCalendar datumDo, int brKreveta)
			throws SQLException {
		DBConnector connector = new DBConnector();
		LinkedList<Soba> slobodneSobe = new LinkedList<Soba>();
		boolean nemaRez = true;

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
		return slobodneSobe;
	}
}
