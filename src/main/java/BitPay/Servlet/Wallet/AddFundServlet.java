package BitPay.Servlet.Wallet;

import jakarta.servlet.ServletException;


import BitPay.Database.Transactions.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import BitPay.Database.Wallet;

/**
 * Servlet implementation class AddFundServlet
 */
public class AddFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long transactionId=0,userAccount=0;
		double addAmount =0;
		String action ="Add Funds";
		String receiverName=null,description=null;int receiverAccountNumber=0; 
		String error =null,addFundStatus="failed";
		AddTransactionHistory t = new AddTransactionHistory();
		
		
		HttpSession session1 = request.getSession();
		String userName= (String) session1.getAttribute("entryName");
		String userAcc= (String) session1.getAttribute("entryAccount");
		String email = (String) session1.getAttribute("email");
		
	try {	
		
		String Amount = request.getParameter("addFundAmount");
		
	    userAccount= Long.parseLong(userAcc);
		
		//we dont need receiver name and acc so null
		
		
		
		
		 addAmount = Double.parseDouble(Amount);
		
		
		if(addAmount>0 && addAmount<=50000) {
		
		Wallet w = new Wallet();
		boolean walletFunds =w.addFunds(addAmount,email);
		
		if(walletFunds==true) {
			addFundStatus="success";
			
			error = "Funds Added Successfully ";
			transactionId = t.addHistory(userName, receiverName, receiverAccountNumber, userAccount, addAmount, addFundStatus, action,description,error);
			
			response.sendRedirect("wallet.jsp?error=" + error + "&addFundStatus=" + addFundStatus+"&transactionId="+transactionId);

		}else {
			error = "Funds Added Failed ";
			transactionId = t.addHistory(userName, receiverName, receiverAccountNumber, userAccount, addAmount, addFundStatus, action,description,error);
			response.sendRedirect("wallet.jsp?error=" + error + "&addFundStatus=" + addFundStatus+"&transactionId="+transactionId);

			
		}
	
		}else {
			error = "Invalid Amount (Min =1,Max =50,000)";
			transactionId = t.addHistory(userName, receiverName, receiverAccountNumber, userAccount, addAmount, addFundStatus, action,description,error);
			response.sendRedirect("wallet.jsp?error=" + error + "&addFundStatus=" + addFundStatus+"&transactionId="+transactionId);

			
		}
		
		
	}catch(Exception e) {
		System.out.println(e +" Exception in add fund servlet");
	    error = "Invalid inputs please give proper input";
		transactionId = t.addHistory(userName, receiverName, receiverAccountNumber, userAccount, addAmount, addFundStatus, action,description,error);
		response.sendRedirect("wallet.jsp?error=" + error + "&addFundStatus=" + addFundStatus+"&transactionId="+transactionId);
		
	}
	
	}

}
