package BitPay.Database;

import java.sql.*;
import java.util.regex.*;


public class LoginSignUp extends connection{

    public int signUp(String username ,String email ,String password) {
        String query = "insert into users (name,email,password) values(?,?,?);";
        String accountsQuery = "insert into accounts (name,email) values(?,?);";
        int signupStatus = 0;

        try {
            PreparedStatement ps = mycon.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            
          
            PreparedStatement ps2 = mycon.prepareStatement(accountsQuery);
            ps2.setString(1, username);
            ps2.setString(2, email);

            int rowsaffect = ps.executeUpdate();
            int rowsaffect2 = ps2.executeUpdate();
            if(rowsaffect>0&&rowsaffect2>0){
                System.out.println("Sign up successfull "+email);
                signupStatus = 1;
            }else {
                System.out.println("Signup failed "+email);
                signupStatus = 0;
            }

        }
        catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Email already exists "+email);
            signupStatus = 2;
        }
        catch (Exception e){
            System.out.println("Sign up failed "+e);
            signupStatus = 0;
        }
        return signupStatus;
    }

    public int checkLogin(String email, String password) {
        String query = "SELECT email, password FROM users WHERE email = ?";
        int signinStatus=0;
        
        try {
            PreparedStatement ps = mycon.prepareStatement(query);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String dbEmail = rs.getString("email");
                String dbPassword = rs.getString("password");

                if (dbPassword.equals(password)) {
                    System.out.println("Login successful for email: " + dbEmail);
                    signinStatus = 1;
                } else {
                    System.out.println("Incorrect password for email: " + dbEmail);
                    signinStatus = 2;

                }
            } else {
                System.out.println("Email not found.");
                signinStatus = 3;

            }

        } catch (Exception e) {
            System.out.println("Login failed: " + e);
            signinStatus = 0;

        }
        
        return signinStatus ;
          }
    
   public boolean passwordValidate(String password) {

        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        System.out.println("password alphanumeric = "+m.matches());
        return m.matches();


    }
   
   

}