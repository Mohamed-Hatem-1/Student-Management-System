public class Courses {
    public static String[] courses = {"History", "Math", "Computer Science", "English", "Chemistry"};
    static final int costOfCourse = 600;
    public static void showAvailableCourses() {
        System.out.println("Available courses are:");
        for (String course : courses) {
            System.out.println("\t- " + course);
        }
        System.out.println();
    }
}