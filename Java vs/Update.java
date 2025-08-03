import java.sql.*;
import java.util.Scanner;

public class Update {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Shop"; // Change as needed
        String user = "root";                            // Your DB user
        String password = "password";                    // Your DB password

        Scanner scanner = new Scanner(System.in);

        try {
            // Get input from user
            System.out.print("Enter student ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();

            System.out.print("Enter new email: ");
            String newEmail = scanner.nextLine();

            // SQL Update query
            String sql = "UPDATE student SET name = ?, price = ?, email = ? WHERE id = ?";

            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to DB
            Connection con = DriverManager.getConnection(url, user, password);

            // Prepare and execute update
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newName);
            ps.setString(2, newEmail);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student record updated successfully!");
            } else {
                System.out.println("No student found with ID " + id);
            }

            // Close resources
            ps.close();
            con.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
