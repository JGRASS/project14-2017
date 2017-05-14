package hotel.model;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import hotel.Soba;
import hotel.SobaPodaci;
import hotel.baza.DBConnector;
import hotel.interfejs.HotelInterfejs;
import hotel.sistemskeoperacije.SOIzlistaj;
import hotel.sistemskeoperacije.SOOtkaziRezervaciju;
import hotel.sistemskeoperacije.SORezervisiSobu;
import hotel.sistemskeoperacije.SOVratiSaKrevetom;
import hotel.sistemskeoperacije.SOVratiSaTerasom;
import hotel.sistemskeoperacije.SOVratiSprat;
import hotel.sistemskeoperacije.SOVratiSveSobe;

/**
 * @author jelica&veljko
 * 
 */

public class Hotel implements HotelInterfejs {

	public static DBConnector connector = new DBConnector();

	/**
	 * Metoda za rezervaciju sobe (sluzice da klikom na sobu u tabeli u GUI-ju
	 * rezervisemo sobu)
	 * 
	 * @return rez - idRezervacije
	 * @throws SQLException
	 */
	@Override
	public int rezervisiSobu(int idSobe, String ime, String prezime, GregorianCalendar datumOd,
			GregorianCalendar datumDo) throws SQLException {
		return SORezervisiSobu.izvrsi(idSobe, ime, prezime, datumOd, datumDo);
	}

	/**
	 * Metoda za otkazivanje rezervacije sobe (sluzice da klikom na sobu u
	 * tabeli u GUI-ju obrisemo rezervaciju)
	 * 
	 * @throws SQLException
	 */
	@Override
	public boolean otkaziRezervaciju(int idRezervacije) throws SQLException {
		return SOOtkaziRezervaciju.izvrsi(idRezervacije);
	}

	/**
	 * metoda za vracanje lista svih soba i rezervacija ukoliko ih ima
	 * 
	 * @return listaSoba - lista objekata klase SobaPodaci
	 * @throws SQLException 
	 */
	@Override
	public LinkedList<SobaPodaci> vratiSveSobe() throws SQLException {
		return SOVratiSveSobe.izvrsi();
	}

	/**
	 * metoda koja vraca listu soba koje su slobodne u odredjenom periodu i sa
	 * odgovarajucim brojem kreveta
	 * 
	 * @return slobodneSobe - lista soba koje su slobodne
	 */
	@Override
	public LinkedList<Soba> izlistaj(GregorianCalendar datumOd, GregorianCalendar datumDo, int brKreveta) throws SQLException {
		return SOIzlistaj.izvrsi(datumOd, datumDo, brKreveta);
	}

	/**
	 * Metoda za vracanje soba sa terasom
	 * 
	 * @return sobe - LinkedList soba sa terasom
	 * @throws SQLException
	 */
	@Override
	public LinkedList<Soba> vratiSaTerasom() throws SQLException {
		return SOVratiSaTerasom.izvrsi();
	}

	/**
	 * Metoda za vracanje soba sa odredjenim brojem kreveta
	 * 
	 * @return sobe - LinkedList soba sa odredjenim brojem kreveta
	 * @throws SQLException
	 */
	@Override
	public LinkedList<Soba> vratiSaKrevetom(int brKreveta) throws SQLException {
		return SOVratiSaKrevetom.izvrsi(brKreveta);
	}

	/**
	 * Metoda za vracanje soba na odredjenom spratu
	 * 
	 * @return sobe - LinkedList soba na odredjenom spratu
	 * @throws SQLException
	 */
	@Override
	public LinkedList<Soba> vratiSprat(int sprat) throws SQLException {
		return SOVratiSprat.izvrsi(sprat);
	}

}
