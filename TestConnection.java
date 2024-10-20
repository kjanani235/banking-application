package projectbanking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
   public static void main(String[] args) {
	
	   
	   {
	        String url = "jdbc:mysql://localhost:3306/BankDB";
	        String user = "root";
	        String password = "Janani2223@";

	        try (Connection connection = DriverManager.getConnection(url, user, password)) {
	            if (connection != null) {
	                System.out.println("Connected to the database!");
	            } else {
	                System.out.println("Failed to make connection!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
}
}
}
