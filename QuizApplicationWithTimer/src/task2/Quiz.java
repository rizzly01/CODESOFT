package task2;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
	
	private Question[] questions;
    private int score;
    private Scanner scanner;
    private static final int TIME_LIMIT_SECONDS = 15;

    public Quiz() {
        questions = new Question[10];
        score = 0;
        scanner = new Scanner(System.in);
        initializeQuestions();
    }

    private void initializeQuestions() {
        questions[0] = new Question("What is the correct way to declare a variable in Java?",
                new String[]{"var x;", "int x;", "x = int;", "declare x;"}, 2);

        questions[1] = new Question("Which of the following is not a Java keyword?",
                new String[]{"static", "finally", "super", "string"}, 4);

        questions[2] = new Question("What is the output of System.out.println(5 + 5)?",
                new String[]{"5 + 5", "55", "10", "Error"}, 3);

        questions[3] = new Question("Which loop is guaranteed to execute at least once?",
                new String[]{"for loop", "while loop", "do-while loop", "if-else loop"}, 3);

        questions[4] = new Question("What is the correct way to create an object of class MyClass?",
                new String[]{"MyClass obj = new MyClass();", "new MyClass();", "MyClass obj = MyClass();", "obj = new MyClass;"}, 1);

        questions[5] = new Question("Which statement is used to exit a loop in Java?",
                new String[]{"exit", "break", "continue", "return"}, 2);

        questions[6] = new Question("What is the default value of a boolean variable in Java?",
                new String[]{"true", "false", "null", "0"}, 2);

        questions[7] = new Question("Which of the following is not a valid access modifier in Java?",
                new String[]{"public", "private", "protected", "static"}, 4);

        questions[8] = new Question("What is the correct way to declare a constant in Java?",
                new String[]{"const int X = 5;", "final int X = 5;", "static int X = 5;", "int X = 5;"}, 2);

        questions[9] = new Question("Which method is called automatically when an object is created?",
                new String[]{"finalize()", "main()", "constructor()", "init()"}, 3);
    }

    public void start() {
        for (Question question : questions) {
            if (askQuestion(question)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect or time's up.");
            }
            System.out.println();
        }
        displayResult();
    }

    private boolean askQuestion(Question question) {
        question.display();
        System.out.println("You have " + TIME_LIMIT_SECONDS + " seconds to answer.");

        final boolean[] answered = {false};
        final boolean[] correct = {false};

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
           
            public void run() {
                if (!answered[0]) {
                    System.out.println("\nTime's up!");
                    answered[0] = true;
                }
            }
        }, TIME_LIMIT_SECONDS * 1000);

        while (!answered[0]) {
            if (scanner.hasNextInt()) {
                int answer = scanner.nextInt();
                answered[0] = true;
                correct[0] = question.isCorrect(answer);
                break;
            }
        }

        timer.cancel();
        return correct[0];
    }

    private void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + " out of " + questions.length);
        double percentage = (double) score / questions.length * 100;
        System.out.printf("Percentage: %.2f%%\n", percentage);
    }

}
