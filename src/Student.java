import java.util.*;
class Student extends Person{
    Scanner in = new Scanner(System.in);
    private static int id = 1000;
    private int gradeYear;
    private String studentId;
    private List<String> enrolledCourses;
    public Student(String name, String username, String password, int gradeYear) {
        super(name, username, password);
        this.gradeYear = gradeYear;
        enrolledCourses = new ArrayList<>();
        setStudentId();
    }
    private void setStudentId() {
        id++;
        this.studentId = gradeYear + String.valueOf(id);
    }
    public void showInformation() {
        System.out.println("Name: " + name + "\n" +
                "Username: " + username + "\n" +
                "Password: " + password + "\n" +
                "Grade Year: " + gradeYear + "\n" +
                "Student Id: "+ studentId + "\n");
    }
    public void showAvailableCourses() {
        Courses.showAvailableCourses();
    }
    public void enrollCourse(String courseName) {
        while (true) {
            if (isValidCourse(courseName)) {
                enrolledCourses.add(courseName);
                System.out.println("Course enrolled successfully\n");
                break;
            } else {
                System.out.println("Invalid course. Please choose a course from the available courses.\n");
                Courses.showAvailableCourses();
                System.out.print("Enter course name (Make sure you wrote the course right): ");
                courseName = in.nextLine();
            }
        }
    }
    private boolean isValidCourse(String courseName) {
        for (String course : Courses.courses) {
            if (course.equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }
    public void viewEnrolledCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println("Not enrolled courses yet\n");
        } else {
            System.out.println("Enrolled Courses:");
            for (String course : enrolledCourses) {
                System.out.println("\t- " + course);
            }
            System.out.println();
        }
    }
}