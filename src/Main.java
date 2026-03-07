import dao.StudentDAO;
import db.DatabaseInitializer;
import models.Student;
import util.TableUtil;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.initializeDatabase();

        StudentDAO dao = new StudentDAO();

        List<Student> students = dao.getAllStudents();

        DefaultTableModel model = TableUtil.buildStudentTableModel(students);

        System.out.println("Rows loaded: " + model.getRowCount());
    }
}