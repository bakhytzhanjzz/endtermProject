import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin implements MenuOption {
    @Override
    public void execute(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter username: ");
        String adminUsername = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        if (adminUsername.equals("admin") && password.equals("12345")) {
            System.out.println("Admin login successful!");
            // Provide access to admin features
        } else {
            System.out.println("Wrong login or password. Please try again.");
        }
    }

    @Override
    public String getDescription() {
        return "Login as Admin";
    }

}
