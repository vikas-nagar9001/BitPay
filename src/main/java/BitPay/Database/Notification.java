package BitPay.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Notification extends connection {
	long accountNo;

	public Notification(long accountNo) {
		this.accountNo = accountNo;
	}

	public ArrayList<String[]> showNotification() {
		ArrayList<String[]> showNotification = new ArrayList<>();
		String query = "select * from transactionhistory where Receiver_Account_No =? AND notification = 'show';";

		try {
			PreparedStatement ps = mycon.prepareStatement(query);
			ps.setLong(1, accountNo);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String senderName = rs.getString("SenderName");

				String message = rs.getString("description");
				String time = rs.getString("time");
				String amount = rs.getString("amount");
				String action = rs.getString("action");
				String id = rs.getString("TransactionID");

				String heading = null;
				if (action.equals("Send Request")) {
					heading = "Request Received!";
				} else if (action.equals("Send Money")) {
					heading = "Money Received!";
				}

				showNotification.add(new String[] { senderName, amount,message, heading, action, id });

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e + " Exception in show showNotification db");
			// e.printStackTrace();
		}

		return showNotification;
	}

	
	
	public ArrayList<String[]> showToast() {
		ArrayList<String[]> showToast = new ArrayList<>();
		String query = "select * from transactionhistory where Receiver_Account_No =? AND toast = 'unseen';";

		try {
			PreparedStatement ps = mycon.prepareStatement(query);
			ps.setLong(1, accountNo);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String senderName = rs.getString("SenderName");

				String message = rs.getString("description");
				String time = rs.getString("time");
				String amount = rs.getString("amount");
				String action = rs.getString("action");
				String id = rs.getString("TransactionID");

				
				
				String heading = null;
				if (action.equals("Send Request")) {
					heading = "Request Received!";
				} else if (action.equals("Send Money")) {
					heading = "Money Received!";
				}

				showToast.add(new String[] { senderName, amount, heading, action, id });

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e + " Exception in show showNotification db");
			// e.printStackTrace();
		}

		return showToast;
	}


	public void closeToast(long id) {
		String query = "UPDATE transactionhistory SET toast = 'seen' WHERE TransactionId = ?;";

		try {
			PreparedStatement ps = mycon.prepareStatement(query);
			ps.setLong(1, id);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				System.out.println("toast seen");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e + " Exception in show showNotification close db");
			// e.printStackTrace();
		}
	}

}
