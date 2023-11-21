// File: Example.scala

import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet}
import scala.io.StdIn.readLine

object Example extends App {

  def vulnerableFunction(userInput: String): Unit = {
    // Vulnerable SQL query, userInput is directly concatenated into the query
    val dangerousQuery = s"SELECT * FROM users WHERE username = '$userInput'"
    executeQuery(dangerousQuery)
  }

  def safeFunction(userInput: String): Unit = {
    // Safer SQL query, using parameterized query to prevent SQL injection
    val safeQuery = "SELECT * FROM users WHERE username = ?"
    executeQueryWithParameter(userInput, safeQuery)
  }

  def executeQuery(query: String): Unit = {
    val url = "jdbc:your_database_url"
    val connection = DriverManager.getConnection(url, "your_username", "your_password")

    try {
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery(query)

      while (resultSet.next()) {
        // Process the result set
      }
    } finally {
      connection.close()
    }
  }

  def executeQueryWithParameter(userInput: String, query: String): Unit = {
    val url = "jdbc:your_database_url"
    val connection = DriverManager.getConnection(url, "your_username", "your_password")

    try {
      val preparedStatement = connection.prepareStatement(query)
      preparedStatement.setString(1, userInput)

      val resultSet = preparedStatement.executeQuery()

      while (resultSet.next()) {
        // Process the result set
      }
    } finally {
      connection.close()
    }
  }

  // Main entry point
  val userInput = readLine("Enter username: ")
  vulnerableFunction(userInput)
  safeFunction(userInput)
}
