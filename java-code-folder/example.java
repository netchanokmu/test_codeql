// File: java-code-folder/Example.java

public class Example {
    public static void main(String[] args) {
        String userInput = args.length > 0 ? args[0] : "";
        processInput(userInput);
    }

    public static void processInput(String input) {
        if (input.startsWith("admin")) {
            System.out.println("Admin access granted!");
        } else {
            System.out.println("Regular user access granted.");
        }
    }
}
