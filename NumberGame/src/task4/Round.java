package task4;
import java.util.Random;
import java.util.Scanner;

public class Round {
	
	private final int targetNumber;
    private final int maxAttempts;

    public Round(int targetNumber, int maxAttempts) {
        this.targetNumber = targetNumber;
        this.maxAttempts = maxAttempts;
    }

    public boolean play(Scanner scanner) {
        System.out.println("\nNew round! Guess a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts.");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Attempt " + attempt + ": Enter your guess: ");
            int guess = scanner.nextInt();

            if (guess == targetNumber) {
                System.out.println("Congratulations! You've guessed correctly in " + attempt + " attempts!");
                return true;
            }

            String hint = (guess < targetNumber) ? "Too low!" : "Too high!";
            System.out.println(hint + " Try again.");
        }

        System.out.println("Sorry, you've run out of attempts. The number was " + targetNumber + ".");
        return false;
    }
	
	

}
