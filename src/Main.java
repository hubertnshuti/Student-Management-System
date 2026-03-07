import dao.StudentDAO;
import db.DatabaseInitializer;
import models.Student;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.initializeDatabase();

        StudentDAO dao = new StudentDAO();

        // First add a test student
        Student originalStudent = new Student(
                "Jane Doe",
                "jane@example.com",
                "001",
                "Information Technology",
                72
        );
        dao.addStudent(originalStudent);

        // Then update the student with id = 2
        Student updatedStudent = new Student(
                "Jane Smith",
                "janesmith@example.com",
                "001",
                "Software Engineering",
                91
        );
        dao.updateStudent(2, updatedStudent);

        System.out.println("Update operation finished.");
    }
}