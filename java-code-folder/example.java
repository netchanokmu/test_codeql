// File: Example.java

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Example {

    public static void vulnerableFunction(String userInput) throws SQLException {
        // Vulnerable SQL query, userInput is directly concatenated into the query
        String dangerousQuery = "SELECT * FROM users WHERE username = '" + userInput + "'";
        executeQuery(dangerousQuery);
    }

    public static void safeFunction(String userInput) throws SQLException {
        // Safer SQL query, using parameterized query to prevent SQL injection
        String safeQuery = "SELECT * FROM users WHERE username = ?";
        executeQueryWithParameter(userInput, safeQuery);
    }

    private static void executeQuery(String query) throws SQLException {
        Connection connection = // initialize your database connection here
        java.sql.Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            // Process the result set
        }

        // Close resources
        resultSet.close();
        statement.close();
        connection.close();
    }

    private static void executeQueryWithParameter(String userInput, String query) throws SQLException {
        Connection connection = // initialize your database connection here
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userInput);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            // Process the result set
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String userInput = scanner.nextLine();

        try {
            vulnerableFunction(userInput);
            safeFunction(userInput);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
