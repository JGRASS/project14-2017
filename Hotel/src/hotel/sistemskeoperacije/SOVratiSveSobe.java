package hotel.sistemskeoperacije;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import hotel.SobaPodaci;
import hotel.baza.DBConnector;

/**
 * @author jelica&veljko
 * 
 */
public class SOVratiSveSobe {

	/**
	 * metoda za vracanje lista svih soba i rezervacija ukoliko ih ima
	 * 
	 * @return listaSoba - lista objekata klase SobaPodaci
	 * @throws SQLException 
	 */
	public static LinkedList<SobaPodaci> izvrsi() throws SQLException {
		DBConnector connector = new DBConnector();
		
		LinkedList<SobaPodaci> listaSoba = new LinkedList<SobaPodaci>();

			Connection con = connector.connect();
			String query = "SELECT * FROM soba";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				boolean ubacena = false;
				int idSobe = rs.getInt(1);
				
				SobaPodaci soba = new SobaPodaci();
				soba.setIdSobe(rs.getInt(1));
				soba.setBrojKreveta(rs.getInt(2));
				soba.setCena(rs.getInt(3));
				soba.setSprat(rs.getInt(4));
				soba.setTerasa(rs.getBoolean(5));
				
				PreparedStatement ps2 = con.prepareStatement("SELECT * FROM rezervacija");
				ResultSet rs2 = ps2.executeQuery();
				
				while (rs2.next()) {
					int rezSobeID = rs2.getInt(2);
					if (idSobe == rezSobeID) {
						SobaPodaci rezSobe = new SobaPodaci();
						rezSobe.setIdSobe(rs.getInt(1));
						rezSobe.setBrojKreveta(rs.getInt(2));
						rezSobe.setCena(rs.getInt(3));
						rezSobe.setSprat(rs.getInt(4));
						rezSobe.setTerasa(rs.getBoolean(5));

						rezSobe.setIdRezervacije(rs2.getInt(1));
						rezSobe.setImeGosta(rs2.getString(3));
						rezSobe.setPrezimeGosta(rs2.getString(4));

						GregorianCalendar datumOd = new GregorianCalendar();
						datumOd.setTime(rs2.getDate(5));
						rezSobe.setDatumOd(datumOd);

						GregorianCalendar datumDo = new GregorianCalendar();
						datumDo.setTime(rs2.getDate(6));
						rezSobe.setDatumDo(datumDo);
						listaSoba.addLast(rezSobe);
						ubacena = true;
					}
					
				}
				if(ubacena == false) {
					listaSoba.add(soba);
				}
			}
			con.close();
			
		return listaSoba;
	}
	
}
