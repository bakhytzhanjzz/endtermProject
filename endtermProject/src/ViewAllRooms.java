import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ViewAllRooms implements MenuOption {
    @Override
    public void execute(Connection connection, Scanner scanner) throws SQLException {
        String sql = "SELECT * FROM bookdata ORDER BY id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Room number\tRoom layout\tPrice\tOptions\tStatus");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" +
                        resultSet.getString("room_layout") + "\t" +
                        resultSet.getInt("price") + "\t" +
                        resultSet.getString("options") + "\t" +
                        (resultSet.getBoolean("status") ? "Available" : "Occupied"));
            }
        }
    }
    @Override
    public String getDescription() {
        return "View All Rooms";
    }
}
