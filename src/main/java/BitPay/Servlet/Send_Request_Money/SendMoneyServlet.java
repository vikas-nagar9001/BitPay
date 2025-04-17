package BitPay.Servlet.Send_Request_Money;

import jakarta.servlet.ServletException;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import BitPay.Database.Verify;
import BitPay.Database.Wallet;
import BitPay.Database.Money;
import BitPay.Database.Requestt;
import BitPay.Database.Transactions.*;

/**
 * Servlet implementation class SendMoney
 */
public class SendMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendMoneyServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = null, sendMoneyStatus = "failed", action = "Send Money", senderDescription = null;
		String receiverName = null, senderName = null;
		String email = null;
		
		
		long receiverAccountNumber = 0, senderAccountNo = 0;
		double sendAmount = 0;
		long transactionId = 0;
		
		
		HttpSession session = request.getSession(false);
		String account = (String) session.getAttribute("entryAccount");
		String entryEmail = (String) session.getAttribute("entryEmail");
		senderName = (String) session.getAttribute("entryName");
		senderAccountNo = Long.parseLong(account);


		// check current funds in user wallet
		Wallet w = new Wallet();
		double currentWalletFunds = w.showFunds(entryEmail);
		System.out.println(currentWalletFunds+" =wallet");
		// ......................

		

		AddTransactionHistory t = new AddTransactionHistory();
		Requestt r = new Requestt(0l);

		
		
		//for request page when we accept request
		long requestId;
		try {
		String requestId2 = request.getParameter("requestId");
	    requestId = Long.parseLong(requestId2);
		}catch(Exception e) {
			requestId=0l;
		}
		//for request page when we accept request
		
		
		try {

			// TODO Auto-generated method stub
			receiverName = request.getParameter("receiverName");
			senderDescription = request.getParameter("senderDescription");
			String senderPin1 = request.getParameter("senderPin1");
			String senderPin2 = request.getParameter("senderPin2");
			String senderPin3 = request.getParameter("senderPin3");
			String senderPin4 = request.getParameter("senderPin4");
			String sendingAmount = request.getParameter("sendingAmount");
			String receiverAccountNo = request.getParameter("receiverAccountNo");
			
			
			String senderPin =senderPin1+senderPin2+senderPin3+senderPin4;
			int pin = Integer.parseInt(senderPin);
			receiverAccountNumber = Long.parseLong(receiverAccountNo);
			sendAmount = Double.parseDouble(sendingAmount);

			Verify v = new Verify();
			boolean pinStatus = v.checkPin(senderAccountNo, pin);

			if (sendAmount > 0 && sendAmount <= 100000) {

				if (sendAmount<=currentWalletFunds) {

					if (pinStatus) {

						Money s = new Money();
						boolean sendingStatus = s.sendMoney(receiverAccountNumber, senderAccountNo, sendAmount);

						if (sendingStatus) {
							sendMoneyStatus = "success";

							// add this transaction in history
							error = "Your payment for " + sendAmount + " in Rs has been received and sent to "
									+ receiverName + ".";
							transactionId = t.addHistory(senderName, receiverName, receiverAccountNumber,
									senderAccountNo, sendAmount, sendMoneyStatus, action, senderDescription, error);
							
							
							//there we change the status of request id to accepted
							if(requestId!=0) {
							r.acceptRequest(requestId);
							}
							response.sendRedirect("send_money.jsp?error=" + error + "&sendMoneyStatus="
									+ sendMoneyStatus + "&transactionId=" + transactionId);
						} else {
							error = "You entered Incorrect Account Number. Please try again.";

							transactionId = t.addHistory(senderName, receiverName, receiverAccountNumber,
									senderAccountNo, sendAmount, sendMoneyStatus, action, senderDescription, error);

							response.sendRedirect("send_money.jsp?error=" + error + "&sendMoneyStatus="
									+ sendMoneyStatus + "&transactionId=" + transactionId);
						}

					} else {
						error = "You entered Incorrect Pin. Please try again";
						transactionId = t.addHistory(senderName, receiverName, receiverAccountNumber, senderAccountNo,
								sendAmount, sendMoneyStatus, action, senderDescription, error);

						response.sendRedirect("send_money.jsp?error=" + error + "&sendMoneyStatus=" + sendMoneyStatus
								+ "&transactionId=" + transactionId);
					}

				} else {
					error = "Insufficient funds! in your wallet Thank You";
					transactionId = t.addHistory(senderName, receiverName, receiverAccountNumber, senderAccountNo,
							sendAmount, sendMoneyStatus, action, senderDescription, error);

					response.sendRedirect("send_money.jsp?error=" + error + "&sendMoneyStatus=" + sendMoneyStatus
							+ "&transactionId=" + transactionId);
				}

			} else {
				error = "Invalid Amount (Min=1 ,Max =1,00,000";
				transactionId = t.addHistory(senderName, receiverName, receiverAccountNumber, senderAccountNo,
						sendAmount, sendMoneyStatus, action, senderDescription, error);

				response.sendRedirect("send_money.jsp?error=" + error + "&sendMoneyStatus=" + sendMoneyStatus
						+ "&transactionId=" + transactionId);

			}
		} catch (Exception e) {
			System.out.println(e + " in send money servlet");
			error = "There was an issue with your payment or Invalid input. Please try again.";
			transactionId = t.addHistory(senderName, receiverName, receiverAccountNumber, senderAccountNo, sendAmount,
					sendMoneyStatus, action, senderDescription, error);

			response.sendRedirect("send_money.jsp?error=" + error + "&sendMoneyStatus=" + sendMoneyStatus
					+ "&transactionId=" + transactionId);
		}

	}

}
