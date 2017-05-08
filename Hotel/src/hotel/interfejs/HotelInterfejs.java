package hotel.interfejs;

import java.util.GregorianCalendar;
/**
 * @author veljko
 *
 */
public interface HotelInterfejs {

	public void rezervisi(int idSobe);

	public void otkazi(int idRezervacije);

	public void vratiSveSobe();

	public void izlistaj(GregorianCalendar datumOd, GregorianCalendar datumDo, int brKreveta);

	public void vratiSaTerasom();

	public void vratiSaKrevetom(int brKreveta);
	
	public void vratiSprat(int sprat);

}
