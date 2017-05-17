package hotel.baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Klasa koja sluzi za povezivanje s bazom
 * 
 * @author veljko
 *
 */

public class DBConnector {

	/**
	 * Veza
	 */
	Connection con = null;

	/**
	 * Driver za povezivanje
	 */
	String driver = "com.mysql.jdbc.Driver";
	/**
	 * URL baze
	 */
	String url = "jdbc:mysql://localhost:3306/Hotel";
	/**
	 * Naziv korisnika baze
	 */
	String user = "HotelEmployee";
	/**
	 * Password korisnika baze
	 */
	String pass = "asus";

	/**
	 * Metoda za povezivanje s bazom
	 *@return con - vraca vezu, Connection 
	 */
	public Connection connect() throws SQLException {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
