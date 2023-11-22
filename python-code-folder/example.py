# hardcoded_secret.py

def send_request(api_key, data):
    # Simulate sending a request with the API key
    print(f"Sending request with API key: {api_key}")
    print(f"Data: {data}")

def main():
    # Example of a potentially insecure hardcoded API key
    api_key = "your_hardcoded_api_key"
    user_data = input("Enter sensitive data: ")

    # Send a request with the hardcoded API key and user data
    send_request(api_key, user_data)

if __name__ == "__main__":
    main()
