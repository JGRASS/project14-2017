package hotel.baza;

import java.sql.*;
/**
 * @author veljko
 *
 */
public class DBConnector {
	Connection con = null;

	String url = "jdbc:mysql://localhost:3306/HotelReservations";
	String user = "HotelEmployee";
	String pass = "asus";

	public Connection connect() throws SQLException {
		con = DriverManager.getConnection(url, user, pass);
		return con;
	}
}
