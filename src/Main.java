import util.StringUtil;
import util.Validator;

public class Main {

    public static void main(String[] args) {

        String rawName = "   jAnE doE   ";
        String rawEmail = "   JaneDoe@Example.COM   ";
        String rawCourse = "Computer Science";
        String rawMarks = "85";

        String formattedName = StringUtil.toTitleCase(rawName);
        String formattedEmail = StringUtil.normalizeEmail(rawEmail);

        System.out.println("Formatted Name: " + formattedName);
        System.out.println("Formatted Email: " + formattedEmail);

        boolean valid = Validator.isStudentValid(
                formattedName,
                formattedEmail,
                rawCourse,
                rawMarks
        );

        System.out.println("Student data valid: " + valid);
    }
}