import dao.StudentDAO;
import db.DatabaseInitializer;
import models.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Quick model test
        Student s = new Student(
                "Hubert Nshuti Ngendahayo",
                "nshutihubert04@gmail.com",
                "001",
                "Computer Scince",
                90.5
        );

        s.displayInfo();

        // Quick DAO placeholder test
        StudentDAO dao = new StudentDAO();

        List<Student> results = dao.searchStudents("Jane");

        for (Student s : results) {
            s.displayInfo();
        }

        System.out.println("Search operation finished.");
    }
}