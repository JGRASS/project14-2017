/**
 * 
 */
package hotel.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import hotel.Rezervacija;
import hotel.Soba;
import hotel.baza.DBConnector;
import hotel.interfejs.HotelInterfejs;

/**
 * @author jelica&veljko
 *
 */

public class Hotel implements HotelInterfejs {

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#rezervisi(int)
	 */

	public static DBConnector connector = new DBConnector();

	@Override
	public void rezervisi(int idSobe) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#otkazi(int)
	 */
	@Override
	public void otkazi(int idRezervacije) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#vratiSveSobe()
	 */
	@Override
	public void vratiSveSobe() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#izlistaj(java.util.GregorianCalendar,
	 * java.util.GregorianCalendar, int)
	 */
	@Override
	public void izlistaj(GregorianCalendar datumOd, GregorianCalendar datumDo, int brKreveta) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#vratiSaTerasom()
	 */
	@Override
	public void vratiSaTerasom() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#vratiSaKrevetom(int)
	 */
	@Override
	public void vratiSaKrevetom(int brKreveta) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hotel.interfejs.HotelInterfejs#vratiSprat(int)
	 */
	@Override
	public void vratiSprat(int sprat) {

	}
	
	public static void main(String[] args) {
		Hotel h=new Hotel();
		h.vratiSveSobe();
	}

}
