
import java.util.Random;
import java.util.Scanner;

public class Wordguess {
    public static void main(String[] args) {
        String[] words = {"java","array","object","class","method","compiler","keyboard"};
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];
        char[] display = new char[wordToGuess.length()];
        for (int i = 0; i < display.length; i++) {
            display[i] = '_';
        }
        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        boolean guessed = false;
        System.out.println("=== Word Guessing Game ===");
        while (!guessed) {
            System.out.print("\nWord: ");
            for (char c : display) {
                System.out.print(c + " ");
            }
            System.out.print("\nEnter a letter: ");
            
            char letter = sc.next().charAt(0);
            attempts++;
            boolean found = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == letter) {
                    display[i] = letter;
                    found = true;
                }
            }
            if (found)
                System.out.println("Correct!");
            else
                System.out.println("Wrong!");

            // Check if fully guessed
            guessed = true;
            for (char c : display) {
                if (c == '_') {
                    guessed = false;
                    break;
                }
            }
        }
        System.out.println("\n🎉 You guessed the word: " + wordToGuess);
        System.out.println("Attempts: " + attempts);
        sc.close();
    }
}
