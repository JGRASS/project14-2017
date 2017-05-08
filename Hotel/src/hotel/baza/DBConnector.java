package hotel.baza;

import java.sql.*;

public class DBConnector {
	Connection con = null;

	String url = "jdbc:mysql://localhost:3306/HotelReservations";
	String user = "hotelEmployee";
	String pass = "asus";

	public Connection connect() throws SQLException {
		con = DriverManager.getConnection(url, user, pass);
		return con;
	}
}
