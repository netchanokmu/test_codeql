# File: example.py

def vulnerable_function(user_input):
    dangerous_query = "SELECT * FROM users WHERE username = '" + user_input + "'"
    # Vulnerable SQL query, user_input is directly concatenated into the query

def safe_function(user_input):
    safe_query = "SELECT * FROM users WHERE username = %s"
    # Safer SQL query, using parameterized query to prevent SQL injection

if __name__ == "__main__":
    user_input = input("Enter username: ")
    vulnerable_function(user_input)
    safe_function(user_input)
