package BitPay.Servlet.Send_Request_Money;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import BitPay.Database.Transactions.*;

/**
 * Servlet implementation class SendMoneyEntry
 */
public class SendMoneyEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMoneyEntry() {
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
	
	try {
		
		System.out.println("come in send money entry servlet");
		HttpSession session1 = request.getSession();
		String accountNo = (String) session1.getAttribute("entryAccount");
	
			
		ShowTransactionHistory sh = new ShowTransactionHistory(accountNo);
		
		ArrayList<String[]> sendMoneyHistory = sh.showSendHistory();
		
		session1.setAttribute("sendMoneyHistory", sendMoneyHistory);
		
		// update the toast or entry point 
        RequestDispatcher Dispatcher = request.getRequestDispatcher("NotificationEntry");
        Dispatcher.include(request, response);
		   
        
		response.sendRedirect("send_money.jsp");
	
	
	}catch (Exception e) {
		System.out.println(e+" exception in send money entry");
		response.sendRedirect("send_money.jsp");
	}
	}

}
