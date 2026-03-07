import dao.StudentDAO;
import db.DatabaseInitializer;
import models.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.initializeDatabase();

        StudentDAO dao = new StudentDAO();

        List<Student> results = dao.searchStudents("Jane");

        for (Student s : results) {
            s.displayInfo();
        }

        System.out.println("Search operation finished.");
    }
}