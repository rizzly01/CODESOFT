package task4;
import java.util.Random;
import java.util.Scanner;

public class Game {
	 private final int minNumber;
	    private final int maxNumber;
	    private final int maxAttempts;
	    private int targetNumber;
	    private int score;

	    public Game(int minNumber, int maxNumber, int maxAttempts) {
	        this.minNumber = minNumber;
	        this.maxNumber = maxNumber;
	        this.maxAttempts = maxAttempts;
	        this.score = 0;
	    }

	    public void play() {
	        Scanner scanner = new Scanner(System.in);
	        boolean playAgain = true;

	        while (playAgain) {
	            Round round = new Round(generateTargetNumber(), maxAttempts);
	            boolean wonRound = round.play(scanner);
	            
	            if (wonRound) {
	                score++;
	            }
	            
	            System.out.println("Your current score: " + score);
	            System.out.print("Play again? (yes/no): ");
	            playAgain = scanner.next().toLowerCase().startsWith("y");
	        }

	        System.out.println("Thanks for playing! Final score: " + score);
	    }

	    private int generateTargetNumber() {
	        return new Random().nextInt(maxNumber - minNumber + 1) + minNumber;
	    }

}
