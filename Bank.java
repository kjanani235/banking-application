package projectbanking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Bank {

    	
    public void addAccount(Account account) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Accounts (AccountNumber, AccountHolderName, balance) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, account.getAccountNumber());
            statement.setString(2, account.getAccountHolderName());
            statement.setDouble(3, account.getBalance());
            statement.executeUpdate();
            System.out.println("Account created: " + account.getAccountNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to find an account in the database
    public Account findAccount(String AccountNumber) {
        Account account = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Accounts WHERE accountNumber = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, AccountNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String accountHolderName = resultSet.getString("accountHolderName");
                double balance = resultSet.getDouble("balance");
                account = new Account(AccountNumber, accountHolderName, balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    // Method to deposit money into an account
    public void deposit(String AccountNumber, double amount) {
        Account account = findAccount(AccountNumber);
        if (account != null) {
            account.deposit(amount);
            updateBalance(account);
            System.out.println("Deposited " + amount + " to " + account.getAccountNumber());
        }
    }

    // Method to withdraw money from an account
    public void withdraw(String AccountNumber, double amount) {
        Account account = findAccount(AccountNumber);
        if (account != null) {
            account.withdraw(amount);
            updateBalance(account);
            System.out.println("Withdrew " + amount + " from " + account.getAccountNumber());
        }
    }

    // Method to update the balance of an account in the database
    public void updateBalance(Account account) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Accounts SET balance = ? WHERE AccountNumber = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, account.getBalance());
            statement.setString(2, account.getAccountNumber());
            statement.executeUpdate();
            System.out.println("Updated balance for " + account.getAccountNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
           
    }

    public double getBalance(String AccountNumber) {
        double balance = 0.0;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT balance FROM Accounts WHERE accountNumber = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, AccountNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                balance = resultSet.getDouble("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }
	
	
	
	
	
	
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
