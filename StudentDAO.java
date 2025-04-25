import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Data Access Object: all DB operations are here
public class StudentDAO {
 
    // Add a new student record
    public void insertStudent(Student s) {
        final String SQL = "INSERT INTO students "
                         + "(prn, name, dob, mark1, mark2, mark3) "
                         + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {

            ps.setInt(1, s.getPrn());
            ps.setString(2, s.getName());
            ps.setDate(3, s.getDob());
            int[] m = s.getMarks();
            ps.setInt(4, m[0]);
            ps.setInt(5, m[1]);
            ps.setInt(6, m[2]);
            ps.executeUpdate();
            System.out.println("✔ Student added.");
        } catch (SQLException e) {
            System.err.println("❌ Insert failed: " + e.getMessage());
        }
    }

    // Fetch all students into a list
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        final String SQL = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                int prn         = rs.getInt("prn");
                String name     = rs.getString("name");
                Date dob        = rs.getDate("dob");
                int[] marks     = {
                    rs.getInt("mark1"),
                    rs.getInt("mark2"),
                    rs.getInt("mark3")
                };
                list.add(new Student(prn, name, dob, marks));
            }
        } catch (SQLException e) {
            System.err.println("❌ Fetch failed: " + e.getMessage());
        }
        return list;
    }

    // Search by PRN
    public Student searchByPrn(int prn) {
        final String SQL = "SELECT * FROM students WHERE prn = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {

            ps.setInt(1, prn);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int[] marks = {
                        rs.getInt("mark1"),
                        rs.getInt("mark2"),
                        rs.getInt("mark3")
                    };
                    return new Student(prn,
                                       rs.getString("name"),
                                       rs.getDate("dob"),
                                       marks);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Search by PRN failed: " + e.getMessage());
        }
        return null;
    }

    // Search by Name (exact match)
    public List<Student> searchByName(String nameQuery) {
        List<Student> results = new ArrayList<>();
        final String SQL = "SELECT * FROM students WHERE name = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {

            ps.setString(1, nameQuery);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int prn     = rs.getInt("prn");
                    Date dob    = rs.getDate("dob");
                    int[] marks = {
                        rs.getInt("mark1"),
                        rs.getInt("mark2"),
                        rs.getInt("mark3")
                    };
                    results.add(new Student(prn, nameQuery, dob, marks));
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Search by Name failed: " + e.getMessage());
        }
        return results;
    }

    // Update student marks (for simplicity)
    public void updateStudent(int prn, int[] newMarks) {
        final String SQL = "UPDATE students "
                         + "SET mark1 = ?, mark2 = ?, mark3 = ? "
                         + "WHERE prn = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {

            ps.setInt(1, newMarks[0]);
            ps.setInt(2, newMarks[1]);
            ps.setInt(3, newMarks[2]);
            ps.setInt(4, prn);
            int rows = ps.executeUpdate();
            System.out.println(rows + " record(s) updated.");
        } catch (SQLException e) {
            System.err.println("❌ Update failed: " + e.getMessage());
        }
    }
    // Delete a student record
    public void deleteStudent(int prn) {
        final String SQL = "DELETE FROM students WHERE prn = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL)) {

            ps.setInt(1, prn);
            int rows = ps.executeUpdate();
            System.out.println(rows + " record(s) deleted.");
        } catch (SQLException e) {
            System.err.println("❌ Delete failed: " + e.getMessage());
        }
    }
}
