import java.io.*;
import java.util.*;


class LowAttendanceException extends Exception {
    public LowAttendanceException(String message) {
        super(message);
    }
}

// Serializable Student class
class Student implements Serializable {
    private int rollno;
    private String sname;
    private String course;
    private double attendance_percentage;
    private double score;
    private char grade;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(int rollno, String sname, String course, double attendance_percentage, double score) {
        this.rollno = rollno;
        this.sname = sname;
        this.course = course;
        this.attendance_percentage = attendance_percentage;
        this.score = score;
    }

    // Method to calculate grade
    public void calculateGrade() throws LowAttendanceException {
        if (attendance_percentage < 60) {
            throw new LowAttendanceException("Attendance below 60% for student: " + sname);
        }

        if (score >= 90)
            grade = 'A';
        else if (score >= 75)
            grade = 'B';
        else if (score >= 60)
            grade = 'C';
        else if (score >= 50)
            grade = 'D';
        else
            grade = 'F';
    }

    public double getAttendancePercentage() {
        return attendance_percentage;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollno + ", Name: " + sname + ", Course: " + course +
                ", Attendance: " + attendance_percentage + "%, Score: " + score + ", Grade: " + grade;
    }
}

// Main Class
public class StudentMain {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Creating 10 Student objects
        students.add(new Student(1, "Rohan", "CS", 85, 88));
        students.add(new Student(2, "Priya", "IT", 72, 92));
        students.add(new Student(3, "Amit", "CS", 55, 80)); // Low attendance
        students.add(new Student(4, "Neha", "ECE", 95, 93));
        students.add(new Student(5, "Kiran", "ME", 62, 70));
        students.add(new Student(6, "Sita", "IT", 78, 85));
        students.add(new Student(7, "Ravi", "EE", 88, 75));
        students.add(new Student(8, "Anjali", "CS", 91, 95));
        students.add(new Student(9, "Nikhil", "ECE", 66, 65));
        students.add(new Student(10, "Meera", "IT", 59, 50)); // Low attendance

        // Calculate grade and handle exceptions
        for (Student s : students) {
            try {
                s.calculateGrade();
            } catch (LowAttendanceException e) {
                System.out.println("Error " + e.getMessage());
            }
        }

        // Serialization - Writing objects to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            oos.writeObject(students);
            System.out.println("\n Student objects serialized successfully to 'students.ser'\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sorting students in decreasing order of attendance
        Collections.sort(students, (a, b) -> Double.compare(b.getAttendancePercentage(), a.getAttendancePercentage()));

        System.out.println(" Students sorted by decreasing attendance percentage:\n");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
