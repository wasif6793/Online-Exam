/** Online-Exam
An Online Exam project where a person can give examination.
 **/
import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

class OnlineExam {
    private static final int EXAM_DURATION_MINUTES = 30;
    private static final int NUM_QUESTIONS = 5;
    private static final int MAX_SCORE = 5;

    private static Map<String, String> users = new HashMap<>();
    private static Map<String, Integer> scores = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Online Examination System!");

        boolean running = true;

        while (running) {
            System.out.println("---------");
            System.out.println("Main Menu");
            System.out.println("---------");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void signUp() {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        users.put(username, password);

        System.out.println("Sign up successful. You can now login.");
    }

    private static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if (!users.containsKey(username)) {
            System.out.println("Username not found. Please sign up first.");
            return;
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (!password.equals(users.get(username))) {
            System.out.println("Incorrect password. Please try again.");
            return;
        }

        System.out.println("Login successful. Welcome, " + username + "!");

        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("-----------------------");
            System.out.println("Logged-in User Menu");
            System.out.println("-----------------------");
            System.out.println("1. Update Profile and Password");
            System.out.println("2. Start Exam");
            System.out.println("3. Logout");
            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    updateProfile(username);
                    break;
                case 2:
                    startExam(username);
                    break;
                case 3:
                    loggedIn = false;
                    logout(username);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void updateProfile(String username) {
        System.out.println("Update Profile and Password for " + username);
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        users.put(username, newPassword);
        System.out.println("Profile and password updated successfully.");
    }

    private static void startExam(String username) {
        if (scores.containsKey(username)) {
            System.out.println("You have already completed the exam. Your score: " + scores.get(username));
            return;
        }

        System.out.println("Starting exam for " + username);
        System.out.println("You have " + EXAM_DURATION_MINUTES + " minutes to complete the exam.");

        int score = 0;

        for (int i = 1; i <= NUM_QUESTIONS; i++) {
            System.out.println("Question " + i + ":");
            // Present the MCQ options here and get the user's answer
            // Compare the answer with the correct option and update the score accordingly
            // You can use additional methods to handle this logic
        }

        scores.put(username, score);
        System.out.println("Exam completed. Your score: " + score + "/" + MAX_SCORE);
    }

    private static void logout(String username) {
        System.out.println("Logging out " + username);
        System.out.println("Thank you for using the Online Examination System!");
    }
}
