package task1;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeCalculator {
	   private Scanner scanner;

	    public GradeCalculator() {
	        scanner = new Scanner(System.in);
	    }

	    public void run() {
	        while (true) {
	            System.out.println("\n1. Calculate grades for students");
	            System.out.println("2. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = Integer.parseInt(scanner.nextLine());

	            if (choice == 1) {
	                calculateGrades();
	            } else if (choice == 2) {
	                System.out.println("Exit the program");
	                break;
	            } else {
	                System.out.println("Invalid choice");
	            }
	        }
	    }

	    private void calculateGrades() {
	        System.out.print("Enter the number of students: ");
	        int numStudents = Integer.parseInt(scanner.nextLine());

	        for (int i = 1; i <= numStudents; i++) {
	            System.out.print("Enter name for Student " + i + ": ");
	            String name = scanner.nextLine();
	            Student student = new Student(name);

	            System.out.print("Enter the number of subjects: ");
	            int numSubjects = Integer.parseInt(scanner.nextLine());

	            for (int j = 1; j <= numSubjects; j++) {
	                System.out.print("Enter name for subject " + j + ": ");
	                String subjectName = scanner.nextLine();
	                
	                int marks;
	                while (true) {
	                    System.out.print("Enter marks for " + subjectName + " (out of 100): ");
	                    try {
	                        marks = Integer.parseInt(scanner.nextLine());
	                        if (marks >= 0 && marks <= 100) {
	                            break;
	                        } else {
	                            System.out.println("Invalid marks. Please enter marks between 0 and 100.");
	                        }
	                    } catch (NumberFormatException e) {
	                        System.out.println("Invalid input. Please enter a number.");
	                    }
	                }
	                
	                student.addSubject(new Subject(subjectName, marks));
	            }

	            student.displayResults();
	        }
	    

}
}
