package BitPay.Servlet.Request;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import BitPay.Database.Requestt;


/**
 * Servlet implementation class RequestEntry
 */
public class RequestEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestEntry() {
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
		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("entryName");
		String userAcc = (String) session.getAttribute("entryAccount");

		long userAccount = Long.parseLong(userAcc);

		Requestt r = new Requestt(userAccount);

		// store the request history in arraylist
		ArrayList<String[]> requestHistory = new ArrayList<>();

		requestHistory = r.showRequestHistory();
		
        
		
		session.setAttribute("requestHistory", requestHistory);
		
		
		// update the toast or entry point 
        RequestDispatcher Dispatcher = request.getRequestDispatcher("NotificationEntry");
        Dispatcher.include(request, response);
			
		response.sendRedirect("Requests.jsp");
	}

}
