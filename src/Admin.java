import java.util.*;
class Admin extends Person{
    Admin(String name, String username, String password) {
        super(name, username, password);
    }
    public void addCourse(String courseName) {
        if (!Arrays.asList(Courses.courses).contains(courseName)) {
            Courses.courses = Arrays.copyOf(Courses.courses, Courses.courses.length + 1);
            Courses.courses[Courses.courses.length - 1] = courseName;
            System.out.println("Course added successfully.");
            System.out.println("Here is the updates courses.");
            Courses.showAvailableCourses();
        } else System.out.println("Course: " + courseName + " already exists.\n");
    }
    public void removeCourse(String courseName) {
        if (Arrays.asList(Courses.courses).contains(courseName)) {
            List<String> updatedCourses = new ArrayList<>(Arrays.asList(Courses.courses));
            updatedCourses.remove(courseName);
            Courses.courses = updatedCourses.toArray(new String[0]);
            System.out.println("Course removed successfully.");
            System.out.println("Here is the updates courses.");
            Courses.showAvailableCourses();
        } else System.out.println("Course " + courseName + " not found\n");
    }
}
