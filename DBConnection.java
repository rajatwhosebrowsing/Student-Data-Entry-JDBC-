import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Manages JDBC connection to MySQL
public class DBConnection {
    private static final String URL      = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER     = "root";     
    private static final String PASSWORD = "2-Liccolony";         
 
    // Returns a live Connection object
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
