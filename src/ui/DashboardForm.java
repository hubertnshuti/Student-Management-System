package ui;

import controller.DashboardController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DashboardForm extends JFrame {

    private JPanel mainPanel;
    private JTextField txtName;
    private JTextField txtEmail;
    private JComboBox<String> comboBox1;
    private JSlider slider1;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton showAllButton;
    private JRadioButton sortNameByARadioButton;
    private JRadioButton sortNameByZRadioButton;
    private JRadioButton sortByMarksRadioButton;
    private JRadioButton radioButton4;
    private JTextField txtSearch;
    private JButton searchButton1;
    private JTable studentTable;
    private JTextField txtMarks;

    private final DashboardController dashboardController;

    public DashboardForm() {
        dashboardController = new DashboardController();

        setTitle("Student Management System - Dashboard");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        setupTable();
        setupCourseCombo();
        wireActions();
        loadAllStudents();
    }

    private void setupTable() {
        String[] columnNames = {"ID", "Name", "Email", "Course", "Marks"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        studentTable.setModel(tableModel);
    }

    private void setupCourseCombo() {
        comboBox1.removeAllItems();
        comboBox1.addItem("Computer Science");
        comboBox1.addItem("Information Technology");
        comboBox1.addItem("Software Engineering");
    }

    private void wireActions() {
        showAllButton.addActionListener(e -> loadAllStudents());
        addButton.addActionListener(e -> handleAddStudent());
    }

    private void loadAllStudents() {
        DefaultTableModel model = dashboardController.loadAllStudentsTable();
        studentTable.setModel(model);
    }

    private void handleAddStudent() {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String course = comboBox1.getSelectedItem() == null ? "" : comboBox1.getSelectedItem().toString();
        String marks = txtMarks.getText();

        String message = dashboardController.addStudent(name, email, course, marks);

        JOptionPane.showMessageDialog(
                this,
                message,
                "Add Student",
                message.toLowerCase().contains("success")
                        ? JOptionPane.INFORMATION_MESSAGE
                        : JOptionPane.WARNING_MESSAGE
        );

        if (message.toLowerCase().contains("success")) {
            clearForm();
            loadAllStudents();
        }
    }

    private void clearForm() {
        txtName.setText("");
        txtEmail.setText("");
        txtMarks.setText("");
        comboBox1.setSelectedIndex(0);
        txtName.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DashboardForm form = new DashboardForm();
            form.setVisible(true);
        });
    }
}