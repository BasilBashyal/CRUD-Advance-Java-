import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/Shop";  // Change DB name if needed
        String user = "root";                             // Your DB username
        String password = "password";                     // Your DB password

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
