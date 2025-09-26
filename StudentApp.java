// Import Section 
import java.util.*;

// Student class
class Student {
    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;  //this keyword to specify the variable to there own object 
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }

    // To display student details to string is used 
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

// Main class
public class StudentApp {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Add Student
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println(" Student Added Successfully!\n");
    }

    // View Students
    public static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found!\n");
            return;
        }
        System.out.println("\n ------------ Student List -----------");
        for (Student s : studentList) {
            System.out.println(s);
        }
        System.out.println();
    }

    // Update Student
    public static void updateStudent() {
        System.out.print("Enter ID to Update: ");
        int id = sc.nextInt();
        boolean f = false;

        for (Student s : studentList) {
            if (s.getId() == id) {
                sc.nextLine(); 
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();
                System.out.print("Enter New Marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setMarks(marks);
                System.out.println(" Student Updated Successfully!\n");
                f = true;
                break;
            }
        }
        if (!f) {
            System.out.println(" Student ID Not Found!\n");
        }
    }

    // Delete Student
    public static void deleteStudent() {
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();
        boolean removed =studentList.removeIf(s -> s.getId() == id);

        if (removed) {
            System.out.println(" Student Deleted Successfully!\n");
        } else {
            System.out.println(" Student ID Not Found!\n");
        }
    }

    // Main Menu
    public static void main(String[] args) {
        int choice;
        int flag = 1;
        while(flag ==1){
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                 addStudent();
                 break;
                case 2: 
                 viewStudents();
                 break;
                case 3: 
                 updateStudent();
                 break;
                case 4:
                 deleteStudent();
                 break;
                case 5:
                 flag =0;
                 System.out.println(" Exiting... ");
                 break;
                default:
                 System.out.println(" Invalid Choice! Try Again./n");
            }
        } 
    }
}
