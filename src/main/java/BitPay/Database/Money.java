package BitPay.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Money extends connection {

  public boolean sendMoney(long receiverAccountNo, long senderAccountNo, double amount) {

		boolean status = false;

		String credit = "update accounts set funds = funds+ ? where account_no =?;";
		String deposit = "update accounts set funds= funds - ? where account_no=?;";
		try {
			mycon.setAutoCommit(false);

			PreparedStatement creditStatement = mycon.prepareStatement(credit);
			PreparedStatement depositStatement = mycon.prepareStatement(deposit);

			creditStatement.setDouble(1, amount);
			creditStatement.setLong(2, receiverAccountNo);
			depositStatement.setDouble(1, amount);
			depositStatement.setLong(2, senderAccountNo);

			int row_affect = depositStatement.executeUpdate();
			int row_affect2 = creditStatement.executeUpdate();

			if ((row_affect > 0) && (row_affect2 > 0)) {
				mycon.commit();
				status = true;
				System.out.println("Transaction successfull");
			} else {
				mycon.rollback();
				System.out.println("Transaction Failed");
			}

		} catch (SQLException e) {
			System.out.println(e +"exception in db sendmoney");
		}
		return status;

	}
	
	
	
}