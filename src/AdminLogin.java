import java.util.Scanner;

public class AdminLogin {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "naye123";

    public static boolean login(Scanner scanner) {

        System.out.println("========================================");
        System.out.println("     NAYEPANKH FOUNDATION LOGIN");
        System.out.println("========================================");

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (USERNAME.equals(username) &&
                PASSWORD.equals(password)) {

            System.out.println("\n✓ Login Successful!");
            return true;
        }

        System.out.println("\n✗ Invalid Username or Password.");
        return false;
    }
}