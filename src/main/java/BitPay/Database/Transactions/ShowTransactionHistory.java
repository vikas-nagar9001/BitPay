package BitPay.Database.Transactions;
import java.sql.PreparedStatement;
import BitPay.Database.connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ShowTransactionHistory extends connection {
	long accountNo;

	
	public ShowTransactionHistory(String accountNo2){
	    accountNo = Long.parseLong(accountNo2);

	}
	
	  
	  public ArrayList<String[]> showSendHistory() {
		 
		String action="Send Money";
		String action2="Send Request";

		
		 ArrayList<String[]> sendHistory = new ArrayList<>();
		
		String query = "select * from transactionhistory where  Sender_Account_No=? && (action=? || action=?);";
		
		try {
			PreparedStatement ps = mycon.prepareStatement(query);
			ps.setLong(1, accountNo);	
			ps.setString(2, action);
			ps.setString(3, action2);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				long transactionId = rs.getLong("TransactionID");
				String senderName =rs.getString("SenderName") ;
				String receiverName =rs.getString("ReceiverName") ;
				long senderAcc = rs.getLong("Sender_Account_No");
				long receiverAcc = rs.getLong("Receiver_Account_No");
				double amount = rs.getDouble("amount");
				String status = rs.getString("status");
				String action3 = rs.getString("action");
				String time = rs.getString("time");
				String description = rs.getString("description");
				String note = rs.getString("note");
			
			
				
				//type cast all non string variable to string
				String transactionId2 = Long.toString(transactionId);
				String senderAcc2 = Long.toString(senderAcc);
				String receiverAcc2 = Long.toString(receiverAcc);
				String amount2 = Double.toString(amount);
			
				
				sendHistory.add(new String[] {transactionId2,receiverName,receiverAcc2,amount2,status,time,note,action3,description});
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e+ "Exception in show transaction db send history method");
			//e.printStackTrace();
		}
		
		return sendHistory;
	}
	  
	  public ArrayList<String[]> showWalletHistory() {
			String action="Add Funds";
			
			 ArrayList<String[]> sendWalletHistory = new ArrayList<>();
			
			String query = "select * from transactionhistory where  Sender_Account_No=? && action=?";
			
			try {
				PreparedStatement ps = mycon.prepareStatement(query);
				ps.setLong(1, accountNo);
				ps.setString(2, action);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					long transactionId = rs.getLong("TransactionID");
					String senderName =rs.getString("SenderName") ;
					String receiverName =rs.getString("ReceiverName") ;
					long senderAcc = rs.getLong("Sender_Account_No");
					long receiverAcc = rs.getLong("Receiver_Account_No");
					double amount = rs.getDouble("amount");
					String status = rs.getString("status");
					String time = rs.getString("time");
					String note = rs.getString("note");
					
					
					//type cast all non string variable to string
					String transactionId2 = Long.toString(transactionId);
					String senderAcc2 = Long.toString(senderAcc);
					String receiverAcc2 = Long.toString(receiverAcc);
					String amount2 = Double.toString(amount);
					
					
					sendWalletHistory.add(new String[] {transactionId2,senderName,amount2,status,time,note});
				}
				
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e+ "Exception in show transaction db");
				//e.printStackTrace();
			}
			
			return sendWalletHistory;
		}
	  public ArrayList<String[]> showAllHistory() {
			 
		
			
			 ArrayList<String[]> allHistory = new ArrayList<>();
			
			String query = "select * from transactionhistory where  Sender_Account_No=? || Receiver_Account_No=?";
			
			try {
				PreparedStatement ps = mycon.prepareStatement(query);
				ps.setLong(1, accountNo);
				ps.setLong(2, accountNo);
				

				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					
					long transactionId = rs.getLong("TransactionID");
					String senderName =rs.getString("SenderName") ;
					String receiverName =rs.getString("ReceiverName") ;
					long senderAcc = rs.getLong("Sender_Account_No");
					long receiverAcc = rs.getLong("Receiver_Account_No");
					double amount = rs.getDouble("amount");
					String status = rs.getString("status");
					String time = rs.getString("time");
					String description = rs.getString("description");
					String note = rs.getString("note");
					String action = rs.getString("action");
					
					 
					String Name=null; String accountNumber=null;
					// filter data according to condition 
					
					//makin action to received bcoz this payment received so we show receiver name jiisee payment received hua
					if(senderAcc!=accountNo&&action.equals("Send Money")) {
						action="Received";
						Name=senderName;
						accountNumber = Long.toString(senderAcc); 
						
					}
				
					//when payment send by user then we show receiver name whose he send payment 
					else if(action.equals("Send Money")) {
						Name = receiverName;
						accountNumber = Long.toString(receiverAcc); 
					}
					//add fund bcoz in table so self name show
					else if(action.equalsIgnoreCase("Add Funds")) {
						Name = senderName+(" (You)");
						accountNumber = Long.toString(senderAcc)+" (You)";
					}
					else if(action.equals("Send Request")&&senderAcc==accountNo) {
						Name = receiverName;
						accountNumber = Long.toString(receiverAcc); 
					}
					else {
						Name = "Unknown Entry Check Db";
						
						//this show the send request also the receiver trans..history so we use continue here to skip this entry 
						
						continue;
					}
					
					
					
					//type cast all non string variable to string
					String transactionId2 = Long.toString(transactionId);
					String amount2 = Double.toString(amount);
				
					
					allHistory.add(new String[] {transactionId2,Name,accountNumber,amount2,status,time,note,action,description});
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e+ " Exception in show transaction history db");
				//e.printStackTrace();
			}
			
			return allHistory;
		}
	
	
}
