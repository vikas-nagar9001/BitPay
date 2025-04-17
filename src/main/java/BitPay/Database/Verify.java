package BitPay.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Verify extends connection {

	public boolean checkPin(double accountNo, int pin) {

		boolean status = false;
		String pinQuery = "select pin from accounts where account_no =?;";
		PreparedStatement ps;
		try {
			ps = mycon.prepareStatement(pinQuery);

			ps.setDouble(1, accountNo);
			ResultSet rs = ps.executeQuery();
			rs.next();

			int securityPin = rs.getInt("pin");
			if (pin == securityPin) {
				System.out.println("security pin checked successfully");
				status = true;

			} else {
				System.out.println("incorrect pin");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

		return status;
	}

	public boolean verifyReceiverAcc(long accountNo) {

		boolean status = false;
		String query = "select account_no from accounts where account_no =?;";
		PreparedStatement ps;
		try {
			ps = mycon.prepareStatement(query);

			ps.setLong(1, accountNo);
			ResultSet rs = ps.executeQuery();
			rs.next();

			long dbAcc = rs.getLong("account_no");
			if (dbAcc == accountNo) {
				System.out.println("Receiver account verified success");
				status = true;

			} else {
				System.out.println("Receiver account verified failed");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e + " exception in verify db");
		}

		return status;
	}

	public String getReceiverName(long accountNo) {

		String resultName = null;
		String query = "select name from accounts where account_no =?;";
		PreparedStatement ps;
		try {
			ps = mycon.prepareStatement(query);

			ps.setLong(1, accountNo);
			ResultSet rs = ps.executeQuery();
			rs.next();

			String name = rs.getString("name");
			if (name != null) {
				resultName = name;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e + " exception in verify db");
		}

		return resultName;
	}
}