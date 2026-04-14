import java.util.Scanner;

public class Login {
    String username = "admin";
    String password = "admin1234";
    public boolean authenticate() {
        Scanner input = new Scanner(System.in);


        System.out.print("Enter username: ");
        String user = input.nextLine();

        System.out.print("Enter password: ");
        String pass = input.nextLine();

        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Invalid Login");
            return false;
        }
    }
}