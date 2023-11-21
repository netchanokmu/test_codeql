// File: Example.cs

using System;
using System.Data.SqlClient;

class Example
{
    static void VulnerableFunction(string userInput)
    {
        // Vulnerable SQL query, userInput is directly concatenated into the query
        string dangerousQuery = "SELECT * FROM users WHERE username = '" + userInput + "'";
        ExecuteQuery(dangerousQuery);
    }

    static void SafeFunction(string userInput)
    {
        // Safer SQL query, using parameterized query to prevent SQL injection
        string safeQuery = "SELECT * FROM users WHERE username = @Username";
        ExecuteQueryWithParameter(userInput, safeQuery);
    }

    static void ExecuteQuery(string query)
    {
        using (SqlConnection connection = new SqlConnection("YourConnectionString"))
        {
            connection.Open();
            using (SqlCommand command = new SqlCommand(query, connection))
            {
                using (SqlDataReader reader = command.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        // Process the result set
                    }
                }
            }
        }
    }

    static void ExecuteQueryWithParameter(string userInput, string query)
    {
        using (SqlConnection connection = new SqlConnection("YourConnectionString"))
        {
            connection.Open();
            using (SqlCommand command = new SqlCommand(query, connection))
            {
                // Add parameter to prevent SQL injection
                command.Parameters.AddWithValue("@Username", userInput);

                using (SqlDataReader reader = command.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        // Process the result set
                    }
                }
            }
        }
    }

    static void Main()
    {
        Console.Write("Enter username: ");
        string userInput = Console.ReadLine();

        VulnerableFunction(userInput);
        SafeFunction(userInput);
    }
}
