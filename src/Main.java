import db.DatabaseInitializer;
import models.Student;
import service.StudentService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.initializeDatabase();

        StudentService service = new StudentService();

        System.out.println("Sorted by Name A-Z:");
        List<Student> nameSorted = service.sortStudentsByNameAZ();
        for (Student s : nameSorted) {
            s.displayInfo();
        }

        System.out.println("\nSorted by Marks:");
        List<Student> marksSorted = service.sortStudentsByMarks();
        for (Student s : marksSorted) {
            s.displayInfo();
        }

        System.out.println("\nFiltered by max marks = 88:");
        List<Student> filtered = service.filterStudentsByMaxMarks(88);
        for (Student s : filtered) {
            s.displayInfo();
        }

        System.out.println("\nStep 17 finished.");
    }
}