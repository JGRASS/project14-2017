package hotel.interfejs;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import hotel.Soba;
import hotel.SobaPodaci;
/**
 * @author veljko
 *
 */
public interface HotelInterfejs {

	public void rezervisi(int idSobe);

	public void otkazi(int idRezervacije);

	public LinkedList<SobaPodaci> vratiSveSobe();

	public LinkedList<Soba> izlistaj(GregorianCalendar datumOd, GregorianCalendar datumDo, int brKreveta);

	public void vratiSaTerasom();

	public void vratiSaKrevetom(int brKreveta);
	
	public void vratiSprat(int sprat);

}
