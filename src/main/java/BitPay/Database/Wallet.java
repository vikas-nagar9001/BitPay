package BitPay.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Wallet extends connection {

	public double showFunds(String email) {
		String funds = null;
		double result = 0;
		String query = "select funds from accounts where email=?";

		try {

			PreparedStatement ps = mycon.prepareStatement(query);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				funds = rs.getString("funds");
			}

			result = Double.parseDouble(funds);

		} catch (Exception e) {
			System.out.println("Exception in wallet db " + e);
		}
//	System.out.println(result);
		return result;

	}

	public boolean addFunds(double fundAmount,String email)  {
         
		boolean returnResult = false;
		String add = "update accounts set funds = funds+ ? where email =?;";
		
		try {

		PreparedStatement depositStatement = mycon.prepareStatement(add);

		
		depositStatement.setDouble(1, fundAmount);
		depositStatement.setString(2, email);
		int row = depositStatement.executeUpdate();
		if (row > 0) {
			System.out.println("Money added successfull = "+fundAmount);
			returnResult = true;
			
		} else {
			System.out.println("Failed");
		}
		} catch (Exception e) {
			System.out.println("Exception in wallet db " + e);
		}
		
		return returnResult;
	}

}