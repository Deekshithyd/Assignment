import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;

public class HospitalProcedure {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/HospitalDB";
        String user = "root";
        String password = "1OX22IS023";

        try {

            Connection con = DriverManager.getConnection(url, user, password);

            CallableStatement cs = con.prepareCall("{CALL book_appointment(?,?,?)}");

            cs.setInt(1, 3);
            cs.setInt(2, 1);
            cs.setDate(3, java.sql.Date.valueOf("2026-03-15"));

            cs.execute();

            System.out.println("Stored procedure executed successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}