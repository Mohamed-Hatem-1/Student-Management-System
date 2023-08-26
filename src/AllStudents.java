import java.util.*;
public class AllStudents {
    private static List<Student> enrolledStudents = new ArrayList<>();
    public static void addStudent(Student student) {
        enrolledStudents.add(student);
    }
    public static void viewEnrolledStudents() {
        if (enrolledStudents.isEmpty()) {
            System.out.println("There are no students yet\n");
        } else {
            for (Student st : enrolledStudents) {
                st.showInformation();
                st.viewEnrolledCourses();
                System.out.println("****************************");
            }
        }
    }
}
