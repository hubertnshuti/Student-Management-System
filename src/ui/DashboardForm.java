package ui;

import controller.DashboardController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DashboardForm extends JFrame {

    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
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
    private JTextField textField3;
    private JButton searchButton1;
    private JTable studentTable;

    private final DashboardController dashboardController;

    public DashboardForm() {
        dashboardController = new DashboardController();

        setTitle("Student Management System - Dashboard");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        setupTable();
        wireActions();
        loadAllStudents();
    }

    private void setupTable() {
        String[] columnNames = {"ID", "Name", "Email", "Course", "Marks"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        studentTable.setModel(tableModel);
    }

    private void wireActions() {
        showAllButton.addActionListener(e -> loadAllStudents());
    }

    private void loadAllStudents() {
        DefaultTableModel model = dashboardController.loadAllStudentsTable();
        studentTable.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DashboardForm form = new DashboardForm();
            form.setVisible(true);
        });
    }
}