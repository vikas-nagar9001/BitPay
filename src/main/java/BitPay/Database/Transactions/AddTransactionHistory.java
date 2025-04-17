package BitPay.Database.Transactions;

import java.sql.PreparedStatement;

import BitPay.Database.connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class AddTransactionHistory extends connection {
	
	public long addHistory(String senderName,String receiverName,long receiverAccountNo, long senderAccountNo, double amount, String status, String action,String description,String note) {
	    long transactionId = 0;
	   
	    String query = "INSERT INTO TransactionHistory (SenderName, ReceiverName, Sender_Account_No, Receiver_Account_No, amount,status, action,description,note) VALUES (?,?, ?, ?, ?,?,?,?, ?)";
	    
	    try {
	    	PreparedStatement ps = mycon.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		        ps.setString(1,senderName);                     // SenderName
		        ps.setString(2,receiverName );              // ReceiverName
		        ps.setLong(3, senderAccountNo);             // Sender_Account_No
		        ps.setLong(4, receiverAccountNo);           // Receiver_Account_No
		        ps.setDouble(5, amount);                   // amount
		        ps.setString(6, status);              
		        ps.setString(7, action);
		        ps.setString(8, description);
		        ps.setString(9, note);

	
		        int rowAffected = ps.executeUpdate();

		        if (rowAffected > 0) {
		            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
		                if (generatedKeys.next()) {
		                    long generatedId = generatedKeys.getLong(1); // Get the auto-incremented id
		                    transactionId = generatedId;
		                    System.out.println("Generated ID: " + generatedId);
		                }
		            }
		        } else {
		            System.out.println("Insert failed, no ID obtained.");
		            System.out.println("Added Transaction History Failed");
		        }
    } catch (SQLException e) {
	        System.out.println(e +" Exception in Add transaction history db");
	    }
	    
	    return transactionId;
	}


}