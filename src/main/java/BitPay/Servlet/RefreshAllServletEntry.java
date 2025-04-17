package BitPay.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import BitPay.Database.Notification;
import BitPay.Database.Profile;
import BitPay.Database.Requestt;
import BitPay.Database.Wallet;
import BitPay.Database.Transactions.ShowTransactionHistory;

/**
 * Servlet implementation class AllServletEntry
 */
public class RefreshAllServletEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RefreshAllServletEntry() {
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

		
		
		// this servlet refresh all the entry servlets

	
		try {
		
		// refresh toast and notification
		HttpSession notificationSession = request.getSession(false);
		String notificationaccountNo = (String) notificationSession.getAttribute("entryAccount");
		long notificationaccountNumber = Long.parseLong(notificationaccountNo);

		ArrayList<String[]> toast = new ArrayList<>();
		ArrayList<String[]> notification = new ArrayList<>();

		System.out.println("in notification servlet");
		Notification n = new Notification(notificationaccountNumber);
		toast = n.showToast();
		notification = n.showNotification();

		notificationSession.setAttribute("toastHistory", toast);
		notificationSession.setAttribute("notificationHistory", notification);

	
		
		
		
		// wallet entry servlet
		HttpSession walletSession = request.getSession(false);
		String walletemail = (String) walletSession.getAttribute("email");
		String walletaccountNo = (String) walletSession.getAttribute("entryAccount");

		Wallet w = new Wallet();
		double walletFunds = w.showFunds(walletemail);
		walletSession.setAttribute("walletFunds", walletFunds);

		ShowTransactionHistory sh = new ShowTransactionHistory(walletaccountNo);

		ArrayList<String[]> walletHistory = sh.showWalletHistory();

		walletSession.setAttribute("walletHistory", walletHistory);

	
		
		
		
		// send money servlet update
		System.out.println("come in send money entry servlet");
		HttpSession sendMoneySession = request.getSession();
		String sendMoneyaccountNo = (String) sendMoneySession.getAttribute("entryAccount");

		ShowTransactionHistory sth = new ShowTransactionHistory(sendMoneyaccountNo);

		ArrayList<String[]> sendMoneyHistory = sth.showSendHistory();

		sendMoneySession.setAttribute("sendMoneyHistory", sendMoneyHistory);

		
		
		
		
		
		// profile servlet
		HttpSession profileSession = request.getSession(false);
		String email = (String) profileSession.getAttribute("email");
		Profile p = new Profile();

		String[] data = p.showProfileDetails(email);
//			System.out.println(data.length);

		String profileEmail = data[0];
		String profileName = data[1];
		String profilePassword = data[2];
		String profileMobile = data[3];
		String profileAddress = data[4];
		String profileAccount = data[5];
		String profileFunds = data[6];
		String profilePin = data[7];

//			HttpSession session = request.getSession(false);
		profileSession.setAttribute("profileEmail", profileEmail);
		profileSession.setAttribute("profileName", profileName);
		profileSession.setAttribute("profilePassword", profilePassword);
		profileSession.setAttribute("profileMobile", profileMobile);
		profileSession.setAttribute("profileAddress", profileAddress);
		profileSession.setAttribute("profileAccount", profileAccount);
		profileSession.setAttribute("profileFunds", profileFunds);
//			session.setAttribute("profilePin", profilePin);
		
		
		
		
		
		//Transaction history
		HttpSession transactionSession = request.getSession();
		String transactionaccountNo = (String) transactionSession.getAttribute("entryAccount");
	
			
		ShowTransactionHistory sth2 = new ShowTransactionHistory(transactionaccountNo);
		
		ArrayList<String[]> showAllHistory = sth2.showAllHistory();
		
		transactionSession.setAttribute("showAllHistory", showAllHistory);
		
		
		
		
		
		//request entry
		HttpSession requestSession = request.getSession(false);
		String userName = (String) requestSession.getAttribute("entryName");
		String userAcc = (String) requestSession.getAttribute("entryAccount");

		long userAccount = Long.parseLong(userAcc);

		Requestt r = new Requestt(userAccount);

		// store the request history in arraylist
		ArrayList<String[]> requestHistory = new ArrayList<>();

		requestHistory = r.showRequestHistory();
		
   		requestSession.setAttribute("requestHistory", requestHistory);
   		
   		
   		response.sendRedirect("index.jsp");
   		
   		
		}catch(Exception e) {
			System.out.println(e+" exception in All servlet entry");
		}

	}

}
