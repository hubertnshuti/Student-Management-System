import controller.DashboardController;
import db.DatabaseInitializer;

import javax.swing.table.DefaultTableModel;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.initializeDatabase();

        DashboardController controller = new DashboardController();

        DefaultTableModel model = controller.loadAllStudentsTable();

        System.out.println("Rows loaded into table model: " + controller.getRowCount(model));

        System.out.println("Step 18 finished.");
    }
}