import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScholarshipView {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "1OX22IS023";

        try {

            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("DROP DATABASE IF EXISTS UniversityDB");
            st.executeUpdate("CREATE DATABASE UniversityDB");
            st.executeUpdate("USE UniversityDB");

            st.executeUpdate("CREATE TABLE Students (student_id INT PRIMARY KEY, name VARCHAR(50), department VARCHAR(50), marks INT, attendance INT)");

            st.executeUpdate("INSERT INTO Students VALUES" +
                    "(1,'Rahul','CSE',85,90)," +
                    "(2,'Priya','ECE',78,88)," +
                    "(3,'Amit','CSE',92,95)," +
                    "(4,'Neha','EEE',70,80)," +
                    "(5,'Kiran','CSE',88,87)," +
                    "(6,'Sneha','ECE',82,84)," +
                    "(7,'Arjun','IT',91,92)," +
                    "(8,'Meena','IT',75,89)," +
                    "(9,'Ravi','EEE',83,90)," +
                    "(10,'Pooja','CSE',79,86)");

            st.executeUpdate(
                    "CREATE VIEW eligible_scholarship_students AS " +
                            "SELECT * FROM Students WHERE marks > 80 AND attendance > 85"
            );

            ResultSet rs = st.executeQuery("SELECT * FROM eligible_scholarship_students");

            System.out.println("Eligible Students:");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("student_id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("department") + " " +
                                rs.getInt("marks") + " " +
                                rs.getInt("attendance")
                );
            }

            st.executeUpdate("INSERT INTO eligible_scholarship_students VALUES (11,'Anil','CSE',70,90)");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}