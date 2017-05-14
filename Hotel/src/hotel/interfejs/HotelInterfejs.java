package hotel.interfejs;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import hotel.Soba;
import hotel.SobaPodaci;
/**
 * @author jelica&veljko
 *
 */
public interface HotelInterfejs {

	public int rezervisiSobu(int idSobe, String ime, String prezime, GregorianCalendar datumOd,
			GregorianCalendar datumDo) throws SQLException;

	public boolean otkaziRezervaciju(int idRezervacije) throws SQLException;

	public LinkedList<SobaPodaci> vratiSveSobe() throws SQLException;

	public LinkedList<Soba> izlistaj(GregorianCalendar datumOd, GregorianCalendar datumDo, int brKreveta) throws SQLException;

	public LinkedList<Soba> vratiSaTerasom() throws SQLException;

	public LinkedList<Soba> vratiSaKrevetom(int brKreveta) throws SQLException;
	
	public LinkedList<Soba> vratiSprat(int sprat) throws SQLException;


}
