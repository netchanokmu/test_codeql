# example_code.py

def process_data(user_data):
    # Example of a potentially insecure print statement
    print("User data:", user_data)

def main():
    user_input = input("Enter sensitive data: ")
    process_data(user_input)

if __name__ == "__main__":
    main()

