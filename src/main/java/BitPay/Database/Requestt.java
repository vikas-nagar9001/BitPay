package BitPay.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Requestt extends connection {
	Long senderAccountNo;

	public Requestt(Long senderAccountNo) {
		this.senderAccountNo = senderAccountNo;

	}

	public ArrayList<String[]> showRequestHistory() {

		ArrayList<String[]> requestHistory = new ArrayList<>();
		String query = "select * from transactionhistory where Receiver_Account_No =? AND action = 'Send Request';";

		try {
			PreparedStatement ps = mycon.prepareStatement(query);
			ps.setLong(1, senderAccountNo);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String requestId = rs.getString("TransactionID");
				String senderName = rs.getString("SenderName");
				String senderAcc = rs.getString("Sender_Account_No");
				String message = rs.getString("description");
				String time = rs.getString("time");
				String amount = rs.getString("amount");
				String status = rs.getString("status");

				requestHistory.add(new String[] { senderName, senderAcc, amount, message, time, status,requestId });

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e + " Exception in show request db");
			// e.printStackTrace();
		}

		return requestHistory;

	}

	public boolean acceptRequest(long transactionId) {
		boolean result = false;

		String query = "UPDATE TransactionHistory SET status = ? WHERE TransactionID = ?;";

		try {
			PreparedStatement ps = mycon.prepareStatement(query);
			ps.setString(1, "Accepted"); // Set the status to 'Accepted'

			ps.setLong(2, transactionId);

			int rowsAffect = ps.executeUpdate();
			if (rowsAffect > 0) {
				result = true;
				System.out.println("Request Accepted");
			} else {
				System.out.println("Request Accepted Failed");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Request Accept failed");
			System.out.println("exception in requestAccept db " + e);
		}

		return result;
	}
	
	public boolean declineRequest(long transactionId) {
		boolean result = false;

		String query = "UPDATE TransactionHistory SET status = ? WHERE TransactionID = ?;";

		try {
			PreparedStatement ps = mycon.prepareStatement(query);
			ps.setString(1, "Declined"); // Set the status to 'Accepted'

			ps.setLong(2, transactionId);

			int rowsAffect = ps.executeUpdate();
			if (rowsAffect > 0) {
				result = true;
				System.out.println("Request Declined");
			} else {
				System.out.println("Request Declined Failed");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Request Declined failed");
			System.out.println("exception in requestAccept db " + e);
		}

		return result;
	}

	// not in use
	public long sendRequest(String senderName, Long requestAccountNo, String requestName, String description,
			double amount) {
		String query = "insert into requesthistory (SenderName,ReceiverName ,Sender_Account_No,Receiver_Account_No,amount,Description) value(?,?,?,?,?,?);";
		long requestId = 0;
		try {
			PreparedStatement ps = mycon.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, senderName);
			ps.setString(2, requestName);
			ps.setLong(3, senderAccountNo);
			ps.setLong(4, requestAccountNo);
			ps.setDouble(5, amount);
			ps.setString(6, description);

			int rowsAffect = ps.executeUpdate();
			if (rowsAffect > 0) {
				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						long generatedId = generatedKeys.getLong(1); // Get the auto-incremented id
						requestId = generatedId;
						System.out.println("Generated ID: " + generatedId);
						System.out.println("Request added successfull");
					}
				}
			} else {
				System.out.println("Request added failed");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Request added failed");
			System.out.println("exception in request db " + e);
		}
		return requestId;
	}

}
