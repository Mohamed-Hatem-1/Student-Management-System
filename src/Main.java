import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Admin admin1 = new Admin("mohamed", "mohamed99", "1234");
        Admin admin2 = new Admin("ayman", "ayman55", "123456");

        Student student1 = new Student("amir", "amir999", "1234", 4);
        Student student2 = new Student("asem", "asem10", "123456", 2);

        AllStudents.addStudent(student1);
        AllStudents.addStudent(student2);

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tWelcome To FCAI-USC Student Management System :)");

        do {
            System.out.println("1. Student Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            int choice = in.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter username: ");
                    String studentUsername = in.next();
                    System.out.print("Enter password: ");
                    String studentPassword = in.next();

                    if (studentUsername.equals(student1.username) && studentPassword.equals(student1.password))
                        performStudentTasks(student1);
                    else if (studentUsername.equals(student2.username) && studentPassword.equals(student2.password))
                        performStudentTasks(student2);
                    else System.out.println("Invalid credentials....Try again.\n");
                }
                case 2 -> {
                    System.out.print("Enter username: ");
                    String adminUsername = in.next();
                    System.out.print("Enter password: ");
                    String adminPassword = in.next();

                    if (adminUsername.equals(admin1.username) && adminPassword.equals(admin1.password))
                        performAdminTasks(admin1);
                    else if (adminUsername.equals(admin2.username) && adminPassword.equals(admin2.password))
                        performAdminTasks(admin1);
                    else System.out.println("Invalid...Try Again");
                }
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
        while (true);

    }
    public static void performAdminTasks(Admin newAdmin) {
        Scanner in = new Scanner(System.in);

        System.out.println("Admin logged in successfully!\n");
        System.out.println("Welcome, " + newAdmin.getName());
        int subChoice;
        do {
            System.out.println("What will you do today?");
            System.out.println("1. Add new Student.\n2. Manage the courses.\n3. View all students.\n4. Logout");
            subChoice = in.nextInt();
            in.nextLine();

            if (subChoice == 1) {
                System.out.print("Enter student's name: ");
                String n = in.nextLine();

                System.out.print("Enter student's username: ");
                String uN = in.nextLine();

                System.out.print("Enter student's password: ");
                String p = in.nextLine();

                System.out.print("Enter student's grade level (1 : 4) : ");
                int g = in.nextInt();
                in.nextLine();

                Student student = new Student(n, uN, p, g);
                AllStudents.addStudent(student);

                System.out.println("Student: " + n + " added successfully\n");
            } else if (subChoice == 2) {
                Courses.showAvailableCourses();
                System.out.println("1. Add new course.\n2. Remove course.");
                int choice1 = in.nextInt();
                in.nextLine();

                if (choice1 == 1) {
                    System.out.print("Enter course name: ");
                    String newCourse = in.nextLine();

                    newAdmin.addCourse(newCourse);
                } else if (choice1 == 2) {
                    System.out.print("Enter course name: ");
                    String newCourse = in.nextLine();

                    newAdmin.removeCourse(newCourse);
                } else System.out.println("Invalid choice...Try Again.\n");
            } else if (subChoice == 3) {
                AllStudents.viewEnrolledStudents();
            } else if (subChoice == 4) {
                break;
            } else {
                System.out.println("Invalid choice...Try Again.\n");
            }
        } while (true);
    }
    public static void performStudentTasks(Student newStudent) {
        Scanner in = new Scanner(System.in);

        System.out.println("Student logged in successful!");
        System.out.println("Welcome," + newStudent.getName());
        int subChoice;
        do {
            System.out.println("What will you do today?");
            System.out.println("1. View your information.\n2. Enroll in a new course.\n3. View your enrolled courses.\n4. Logout");
            subChoice = in.nextInt();
            in.nextLine();

            if (subChoice == 1) newStudent.showInformation();
            else if (subChoice == 2) {
                newStudent.showAvailableCourses();
                System.out.print("Enter new course to enroll: ");
                String newCourse = in.nextLine();

                newStudent.enrollCourse(newCourse);
            } else if (subChoice == 3) {
                newStudent.viewEnrolledCourses();
            } else if (subChoice == 4) {
                break;
            } else {
                System.out.println("Invalid choice...Try Again\n");
            }
        } while (true);
    }
}