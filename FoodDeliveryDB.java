import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FoodDeliveryDB {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "1OX22IS023";

        try {

            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            st.executeUpdate("DROP DATABASE IF EXISTS FoodDeliveryDB");
            st.executeUpdate("CREATE DATABASE FoodDeliveryDB");
            st.executeUpdate("USE FoodDeliveryDB");

            st.executeUpdate("CREATE TABLE Customers (" +
                    "customer_id INT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "city VARCHAR(50)," +
                    "phone VARCHAR(15))");

            st.executeUpdate("CREATE TABLE Restaurants (" +
                    "restaurant_id INT PRIMARY KEY," +
                    "restaurant_name VARCHAR(50)," +
                    "city VARCHAR(50)," +
                    "rating DECIMAL(2,1))");

            st.executeUpdate("CREATE TABLE Food_Items (" +
                    "food_id INT PRIMARY KEY," +
                    "food_name VARCHAR(50)," +
                    "price INT," +
                    "restaurant_id INT," +
                    "FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id))");

            st.executeUpdate("CREATE TABLE Orders (" +
                    "order_id INT PRIMARY KEY," +
                    "customer_id INT," +
                    "food_id INT," +
                    "quantity INT," +
                    "order_date DATE," +
                    "FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)," +
                    "FOREIGN KEY (food_id) REFERENCES Food_Items(food_id))");

            st.executeUpdate("INSERT INTO Customers VALUES" +
                    "(1,'Arjun','Chennai','9876543210')," +
                    "(2,'Ananya','Bangalore','9876543211')," +
                    "(3,'Rahul','Hyderabad','9876543212')," +
                    "(4,'Amit','Delhi','9876543213')," +
                    "(5,'Sneha','Chennai','9876543214')");

            st.executeUpdate("INSERT INTO Restaurants VALUES" +
                    "(1,'Pizza Hub','Chennai',4.5)," +
                    "(2,'Burger Point','Bangalore',4.2)," +
                    "(3,'Spicy Kitchen','Hyderabad',4.0)");

            st.executeUpdate("INSERT INTO Food_Items VALUES" +
                    "(101,'Veg Pizza',250,1)," +
                    "(102,'Chicken Pizza',300,1)," +
                    "(103,'Veg Burger',150,2)," +
                    "(104,'Chicken Burger',220,2)," +
                    "(105,'Biryani',280,3)");

            st.executeUpdate("INSERT INTO Orders VALUES" +
                    "(1,1,101,2,'2026-03-09')," +
                    "(2,2,103,1,'2026-03-09')," +
                    "(3,3,105,3,'2026-03-08')");

            System.out.println("Database Created Successfully!");

            ResultSet rs = st.executeQuery("SELECT * FROM Food_Items");

            System.out.println("\nFood Items:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("food_id") + " " +
                                rs.getString("food_name") + " " +
                                rs.getInt("price")
                );
            }

            rs = st.executeQuery("SELECT * FROM Food_Items WHERE price > 200");

            System.out.println("\nFood Items Price > 200:");
            while (rs.next()) {
                System.out.println(rs.getString("food_name") + " - " + rs.getInt("price"));
            }

            rs = st.executeQuery("SELECT * FROM Food_Items ORDER BY price DESC");

            System.out.println("\nFood Items Sorted by Price:");
            while (rs.next()) {
                System.out.println(rs.getString("food_name") + " - " + rs.getInt("price"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
