package hotel.baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author veljko
 *
 */
public class DBConnector {

	Connection con = null;

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/Hotel";
	String user = "HotelEmployee";
	String pass = "asus";

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
