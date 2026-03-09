import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SubqueryExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "1OX22IS023";

        try {

            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("DROP DATABASE IF EXISTS CompanyDB");
            st.executeUpdate("CREATE DATABASE CompanyDB");
            st.executeUpdate("USE CompanyDB");

            st.executeUpdate("CREATE TABLE Employees (emp_id INT PRIMARY KEY, name VARCHAR(50), salary INT, dept_id INT)");
            st.executeUpdate("CREATE TABLE Departments (dept_id INT PRIMARY KEY, dept_name VARCHAR(50))");
            st.executeUpdate("CREATE TABLE Projects (project_id INT PRIMARY KEY, emp_id INT, project_name VARCHAR(50))");

            st.executeUpdate("INSERT INTO Employees VALUES (1,'Ravi',50000,1),(2,'Meena',70000,2),(3,'Arun',60000,1),(4,'Kiran',45000,2),(5,'Pooja',80000,3)");
            st.executeUpdate("INSERT INTO Departments VALUES (1,'IT'),(2,'HR'),(3,'Finance')");
            st.executeUpdate("INSERT INTO Projects VALUES (101,1,'AI System'),(102,2,'Payroll App'),(103,3,'Database Tool'),(104,5,'Finance Tracker')");

            ResultSet rs;

            rs = st.executeQuery("SELECT name, salary FROM Employees WHERE salary > (SELECT AVG(salary) FROM Employees)");

            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getInt("salary"));
            }

            rs = st.executeQuery("SELECT name FROM Employees WHERE dept_id IN (SELECT dept_id FROM Departments WHERE dept_name IN ('IT','Finance'))");

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            rs = st.executeQuery("SELECT name, salary, dept_id FROM Employees e WHERE salary > (SELECT AVG(salary) FROM Employees WHERE dept_id = e.dept_id)");

            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getInt("salary") + " " + rs.getInt("dept_id"));
            }

            rs = st.executeQuery("SELECT name FROM Employees WHERE emp_id IN (SELECT emp_id FROM Projects WHERE emp_id IN (SELECT emp_id FROM Employees WHERE dept_id = (SELECT dept_id FROM Departments WHERE dept_name = 'IT')))");

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}