# command_injection.py

import subprocess

def execute_command(user_input):
    # Example of a potentially insecure command execution
    command = f"echo {user_input}"
    result = subprocess.check_output(command, shell=True)
    print(f"Command result: {result.decode().strip()}")

def main():
    user_input = input("Enter data: ")
    execute_command(user_input)

if __name__ == "__main__":
    main()
