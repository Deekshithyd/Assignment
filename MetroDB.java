import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MetroDB {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "1OX22IS023";

        try {

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            st.executeUpdate("DROP DATABASE IF EXISTS MetroDB");
            st.executeUpdate("CREATE DATABASE MetroDB");
            st.executeUpdate("USE MetroDB");

            st.executeUpdate("CREATE TABLE Stations (" +
                    "station_id INT PRIMARY KEY," +
                    "station_name VARCHAR(50)," +
                    "location VARCHAR(50)," +
                    "platforms INT)");

            st.executeUpdate("CREATE TABLE Metro_Trains (" +
                    "train_id INT PRIMARY KEY," +
                    "train_name VARCHAR(50)," +
                    "capacity INT," +
                    "station_id INT," +
                    "FOREIGN KEY (station_id) REFERENCES Stations(station_id))");

            st.executeUpdate("ALTER TABLE Stations ADD opening_year INT");

            st.executeUpdate("RENAME TABLE Metro_Trains TO Trains");

            st.executeUpdate("INSERT INTO Stations VALUES " +
                    "(1,'Central Station','Downtown',4,2005)," +
                    "(2,'City Park','North Zone',3,2010)," +
                    "(3,'Tech Park','IT Corridor',5,2018)," +
                    "(4,'Airport Station','Airport Road',2,2020)," +
                    "(5,'Market Square','City Center',4,2012)");

            st.executeUpdate("INSERT INTO Trains VALUES " +
                    "(101,'Metro Express',1000,1)," +
                    "(102,'City Rider',900,2)," +
                    "(103,'Airport Link',800,4)");

            st.executeUpdate("UPDATE Trains SET capacity = 1100 WHERE train_id = 101");

            st.executeUpdate("DELETE FROM Stations WHERE station_id = 5");

            st.executeUpdate("CREATE USER IF NOT EXISTS 'metro_staff'@'localhost' IDENTIFIED BY 'password123'");

            st.executeUpdate("GRANT SELECT ON MetroDB.Stations TO 'metro_staff'@'localhost'");
            st.executeUpdate("GRANT INSERT ON MetroDB.Trains TO 'metro_staff'@'localhost'");

            st.executeUpdate("REVOKE INSERT ON MetroDB.Trains FROM 'metro_staff'@'localhost'");

            System.out.println("MetroDB created successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
