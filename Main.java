import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db"; 
    private static final String USER = "root"; // your MySQL username
    String password = "yourpassword"; // your MySQL password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\n1. Add Student\n2. View Students\n3. Update Student\n4. Delete Student\n5. Exit");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> addStudent(conn, sc);
                    case 2 -> viewStudents(conn);
                    case 3 -> updateStudent(conn, sc);
                    case 4 -> deleteStudent(conn, sc);
                    case 5 -> { System.out.println("Goodbye!"); return; }
                    default -> System.out.println("Invalid choice!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter grade: ");
        String grade = sc.nextLine();

        String sql = "INSERT INTO students(name, age, grade) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, grade);
            ps.executeUpdate();
            System.out.println("Student added!");
        }
    }

    private static void viewStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("%d | %s | %d | %s%n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("grade"));
            }
        }
    }

    private static void updateStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new grade: ");
        String grade = sc.nextLine();

        String sql = "UPDATE students SET grade=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, grade);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Updated!" : "Student not found.");
        }
    }

    private static void deleteStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM students WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Deleted!" : "Student not found.");
        }
    }
}
