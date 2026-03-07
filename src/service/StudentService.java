package service;

import dao.StudentDAO;
import models.Student;
import util.StringUtil;
import util.Validator;

import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    public String addStudent(String name, String email, String course, String marksText) {

        name = StringUtil.toTitleCase(name);
        email = StringUtil.normalizeEmail(email);
        course = StringUtil.cleanText(course);
        marksText = StringUtil.cleanText(marksText);

        if (!Validator.isStudentValid(name, email, course, marksText)) {
            return "Invalid student data.";
        }

        double marks = Double.parseDouble(marksText);

        Student student = new Student(name, email, "", course, marks);
        studentDAO.addStudent(student);

        return "Student added successfully.";
    }

    public String updateStudent(String idText, String name, String email, String course, String marksText) {

        name = StringUtil.toTitleCase(name);
        email = StringUtil.normalizeEmail(email);
        course = StringUtil.cleanText(course);
        marksText = StringUtil.cleanText(marksText);
        idText = StringUtil.cleanText(idText);

        if (idText.isEmpty()) {
            return "Student ID is required.";
        }

        if (!Validator.isStudentValid(name, email, course, marksText)) {
            return "Invalid student data.";
        }

        int id;
        try {
            id = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            return "Invalid student ID.";
        }

        double marks = Double.parseDouble(marksText);

        Student student = new Student(name, email, idText, course, marks);
        studentDAO.updateStudent(id, student);

        return "Student updated successfully.";
    }

    public String deleteStudent(String idText) {

        idText = StringUtil.cleanText(idText);

        if (idText.isEmpty()) {
            return "Student ID is required.";
        }

        int id;
        try {
            id = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            return "Invalid student ID.";
        }

        studentDAO.deleteStudent(id);
        return "Delete operation completed.";
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public List<Student> searchStudents(String keyword) {
        keyword = StringUtil.cleanText(keyword);
        return studentDAO.searchStudents(keyword);
    }
}