import java.sql.*;
import java.util.Scanner;

public class Deleted {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Shop"; // Your DB
        String user = "root"; // Your DB user
        String password = "password"; // Your DB password

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student ID to delete: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM student WHERE id = ?";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection con = DriverManager.getConnection(url, user, password);

            // Prepare and execute DELETE
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Deleted successfully!");
            } else {
                System.out.println("No student found with ID " + id);
            }

            // Clean up
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
