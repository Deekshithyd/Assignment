import java.util.Random;
import java.util.Scanner;

public class Numguess {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the number guessing game!");
        System.out.println("I am thinking of a number between 1 and 100.");

        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == numberToGuess) {
                System.out.println(
                    "Congratulations! You guessed the number in "
                    + attempts + " attempts."
                );
                break;
            }
            else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            }
            else {
                System.out.println("Too low! Try again.");
            }
        }

        scanner.close();
    }
}

