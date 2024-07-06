package task1;
import java.util.ArrayList;
import java.util.Scanner;

public class Subject {
    private String name;
    private int marks;

    public Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public String toString() {
        return name + ": " + marks;
    }
	

}
