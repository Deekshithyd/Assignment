import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JoinExampleDB {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "1OX22IS023";

        try {

            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("DROP DATABASE IF EXISTS JoinDB");
            st.executeUpdate("CREATE DATABASE JoinDB");
            st.executeUpdate("USE JoinDB");

            st.executeUpdate("CREATE TABLE University_Students (student_id INT PRIMARY KEY, name VARCHAR(50))");
            st.executeUpdate("CREATE TABLE Clubs (club_id INT PRIMARY KEY, club_name VARCHAR(50))");
            st.executeUpdate("CREATE TABLE Student_Club (student_id INT, club_id INT)");

            st.executeUpdate("INSERT INTO University_Students VALUES (1,'Rahul'),(2,'Priya'),(3,'Amit'),(4,'Neha')");
            st.executeUpdate("INSERT INTO Clubs VALUES (101,'Robotics'),(102,'Photography')");
            st.executeUpdate("INSERT INTO Student_Club VALUES (1,101),(2,102),(3,101)");

            ResultSet rs = st.executeQuery(
                    "SELECT s.name, c.club_name " +
                            "FROM University_Students s " +
                            "INNER JOIN Student_Club sc ON s.student_id = sc.student_id " +
                            "INNER JOIN Clubs c ON sc.club_id = c.club_id"
            );

            while (rs.next()) {
                System.out.println(rs.getString("name") + " - " + rs.getString("club_name"));
            }

            st.executeUpdate("CREATE TABLE App_Users (user_id INT PRIMARY KEY, name VARCHAR(50))");
            st.executeUpdate("CREATE TABLE Subscriptions (sub_id INT PRIMARY KEY, user_id INT, plan VARCHAR(50))");

            st.executeUpdate("INSERT INTO App_Users VALUES (1,'Arjun'),(2,'Sneha'),(3,'Karan'),(4,'Meera')");
            st.executeUpdate("INSERT INTO Subscriptions VALUES (201,1,'Premium'),(202,2,'Basic')");

            rs = st.executeQuery(
                    "SELECT u.name, s.plan " +
                            "FROM App_Users u " +
                            "LEFT JOIN Subscriptions s ON u.user_id = s.user_id"
            );

            while (rs.next()) {
                System.out.println(rs.getString("name") + " - " + rs.getString("plan"));
            }

            st.executeUpdate("CREATE TABLE Authors (author_id INT PRIMARY KEY, author_name VARCHAR(50))");
            st.executeUpdate("CREATE TABLE Books (book_id INT PRIMARY KEY, title VARCHAR(100), author_id INT)");

            st.executeUpdate("INSERT INTO Authors VALUES (1,'R.K. Narayan'),(2,'Chetan Bhagat')");
            st.executeUpdate("INSERT INTO Books VALUES (301,'Malgudi Days',1),(302,'Five Point Someone',2),(303,'Unknown Mystery',NULL)");

            rs = st.executeQuery(
                    "SELECT b.title, a.author_name " +
                            "FROM Authors a " +
                            "RIGHT JOIN Books b ON a.author_id = b.author_id"
            );

            while (rs.next()) {
                System.out.println(rs.getString("title") + " - " + rs.getString("author_name"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}