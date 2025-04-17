package BitPay.Database;


import java.sql.Connection;


import java.sql.DriverManager;

 public class connection {
    String url = "jdbc:mysql://localhost:3306/BitPay";
    String username = "root";
    String password = "Qwerty123@";
   public Connection mycon =null ;

   public connection(){
    	
    	
    	  
        try {
        	  Class.forName("com.mysql.cj.jdbc.Driver");
            mycon = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Succesfull");

        } catch (Exception e) {

            System.out.println("JDBC Connection Failed in database = "+e);
        }
    }
}
