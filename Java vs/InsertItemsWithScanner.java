
import java.sql.*;
import java.util.Scanner;

public class InsertItemsWithScanner {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Shop";
        String user = "root"; // Change this
        String password = "password"; // Change this

        Scanner scanner = new Scanner(System.in);

        try {
            // Connect to database
            Connection con = DriverManager.getConnection(url, user, password);

            // Prepare SQL insert statement
            String query = "INSERT INTO Item (ItemID, Name, UnitPrice, Units, ExpiryDate) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            // Loop for 3 records
            for (int i = 1; i <= 3; i++) {
                System.out.println("Enter details for Item " + i);

                System.out.print("Item ID: ");
                int id = scanner.nextInt();

                scanner.nextLine(); // Consume leftover newline

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Unit Price: ");
                double price = scanner.nextDouble();

                System.out.print("Units: ");
                int units = scanner.nextInt();

                scanner.nextLine(); // Consume newline

                System.out.print("Expiry Date (YYYY-MM-DD): ");
                String dateStr = scanner.nextLine();

                // Set parameters and execute
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setDouble(3, price);
                ps.setInt(4, units);
                ps.setDate(5, Date.valueOf(dateStr));

                ps.executeUpdate();
                System.out.println("Item " + i + " inserted.\n");
            }

            // Close resources
            ps.close();
            con.close();
            scanner.close();

            System.out.println("All records inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}