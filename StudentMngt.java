import java.sql.*;

public class StudentMngt{
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Hari@123##";

    // JDBC variables for opening, closing, and managing connection
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            // Open a connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Execute a query
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM students");

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resultSet
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // Close the statement
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // Close the connection
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
