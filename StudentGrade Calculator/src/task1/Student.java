package task1;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String name;
    private ArrayList<Subject> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public int getTotalMarks() {
        int total = 0;
        for (Subject subject : subjects) {
            total += subject.getMarks();
        }
        return total;
    }

    public double getAveragePercentage() {
        return (double) getTotalMarks() / subjects.size();
    }

    public String getGrade() {
        double percentage = getAveragePercentage();
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        return "F";
    }

    public void displayResults() {
        System.out.println("\nResults for " + name + ":");
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.printf("Average Percentage: %.2f%%\n", getAveragePercentage());
        System.out.println("Grade: " + getGrade());
    }

}
