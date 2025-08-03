import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class display {

    public static void main(String[] args) {
        display(); // Call the method from main
    }

    public static void display() {
        try {
            Connection conn = DbConnect.getConnection(); // Assuming this works
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            boolean data = false;
            while (rs.next()) {
                data = true;
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println(); // Blank line to separate students
            }

            if (!data) {
                System.out.println("No records found in the database.");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public class DbConnect {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/Shop";
        String user = "root";
        String password = "password";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}

}
