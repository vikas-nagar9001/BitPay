package BitPay.Servlet.Send_Request_Money;

import jakarta.servlet.ServletException;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import BitPay.Database.Transactions.AddTransactionHistory;
import BitPay.Database.Verify;

/**
 * Servlet implementation class SendRequestServlet
 */
public class SendRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendRequestServlet() {
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

		String error = null, requestMoneyStatus = null;
		
		// TODO Auto-generated method stub
		String requestAccountNo2 = request.getParameter("requestAccountNo");
		String requestName = request.getParameter("requestName");
		String requestDescription = request.getParameter("requestDescription");
		String requestAmount2 = request.getParameter("requestAmount");
		long requestAccountNo = Long.parseLong(requestAccountNo2);
		double requestAmount = Double.parseDouble(requestAmount2);

		HttpSession session = request.getSession(false);
		String senderAccount = (String) session.getAttribute("entryAccount");
		String senderName = (String) session.getAttribute("entryName");
		long senderAccountNo = Long.parseLong(senderAccount);

		String status = "pending";
		String action = "Send Request";

		AddTransactionHistory t = new AddTransactionHistory();
		

		
		//verify receiver account no
		Verify v = new Verify();
        boolean checkAcc =v.verifyReceiverAcc(requestAccountNo);
		if(checkAcc==true)
		{		
			
			error = "Request send successfully to "+requestName+" Thank You";
			requestMoneyStatus = "success";
			Long requestId = t.addHistory(senderName, requestName, requestAccountNo, senderAccountNo, requestAmount, status,
					action, requestDescription,error);
			response.sendRedirect("send_money.jsp?error=" + error + "&transactionId=" + requestId+"&requestMoneyStatus="+requestMoneyStatus);
	
		}else {
			
			status="failed";
		
			error = "Incorrect Account Number "+requestAccountNo+" Please Try Again";
			requestMoneyStatus = "failed";
			Long requestId = t.addHistory(senderName, requestName, requestAccountNo, senderAccountNo, requestAmount, status,
					action, requestDescription,error);
			response.sendRedirect("send_money.jsp?error=" + error + "&transactionId=" + requestId+"&requestMoneyStatus="+requestMoneyStatus);
		}
	}

}
