package BitPay.Servlet.Wallet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import BitPay.Database.Transactions.*;
import BitPay.Database.Wallet;

/**
 * Servlet implementation class WalletServlet
 */
public class WalletEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WalletEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	try {	
		HttpSession walletSession = request.getSession(false);
		String email = (String) walletSession.getAttribute("email");
		String accountNo = (String) walletSession.getAttribute("entryAccount");
		
		
		Wallet w = new Wallet();
		double walletFunds = w.showFunds(email);
        walletSession.setAttribute("walletFunds", walletFunds);

		ShowTransactionHistory sh = new ShowTransactionHistory(accountNo);

		ArrayList<String[]> walletHistory = sh.showWalletHistory();

		walletSession.setAttribute("walletHistory", walletHistory);
		
		
		// update the toast or entry point 
        RequestDispatcher Dispatcher = request.getRequestDispatcher("NotificationEntry");
        Dispatcher.include(request, response);

		response.sendRedirect("wallet.jsp");
	}catch (Exception e) {
		System.out.println(e+" exception in wallet entry");
		response.sendRedirect("wallet.jsp");
	}
	}

}
