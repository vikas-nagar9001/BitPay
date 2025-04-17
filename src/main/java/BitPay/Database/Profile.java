package BitPay.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Profile extends connection {

	public String[] showProfileDetails(String email) {
		String[] result = new String[8];
		int a = 0;
		String query1 = "Select * from users where email =?;";
		String query2 = "Select * from accounts where email =?;";
		 
		try {
			PreparedStatement ps = mycon.prepareStatement(query1);
			PreparedStatement ps2=mycon.prepareStatement(query2);

			ps.setString(1, email);
			ps2.setString(1, email);

			ResultSet rs = ps.executeQuery();
			
			
           
			while (rs.next()) {
				 System.out.println("in loop");
				String name = rs.getString("name");
				String email2 = rs.getString("email");

				String password = rs.getString("password");
				String mobile = rs.getString("mobile");
				String address = rs.getString("address");
				
//				 System.out.println(email+"\n"+username+"\n"+password+"\n"+mobile+"\n"+address);
				result[0] = email2;
				result[1] = name;
				result[2] = password;
				result[3] = mobile;
				result[4] = address;
				
			}
			
			rs = ps2.executeQuery();
			while (rs.next()) {
				String account_no = rs.getString("account_no");
				String funds = rs.getString("funds");
				String pin = rs.getString("pin");
//				System.out.println(account_no+"\n"+funds+"\n"+pin);

				result[5] = account_no;
				result[6] = funds;
				result[7] = pin;
				

			}
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

		return result;
	}

	public boolean editProfileDetails(String name, String email, String password, String mobile, String address) {
		String query = "update users set name =? ,email=?,password=?,mobile=?,address=? where email =?;";
		boolean result = false;

		try {
			PreparedStatement ps = mycon.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, mobile);
			ps.setString(5, address);
			ps.setString(6, email);

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Profile updated " + email);
				result = true;

			} else {
				System.out.println("Profile updation Failed in profiledetails database " + email);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return result;

	}
	

}
