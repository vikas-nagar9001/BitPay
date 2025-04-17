package BitPay.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import BitPay.Database.Profile;


/**
 * Servlet implementation class EntryServlet
 */


public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryServlet() {
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
		HttpSession entrySession = request.getSession(false);
		String email = (String) entrySession.getAttribute("email");
		Profile p = new Profile();
		  
		
			String[] data =	p.showProfileDetails(email);
//			System.out.println(data.length);
			
			String entryEmail = data[0];
			String entryName = data[1];
			String entryPassword = data[2];
			String entryMobile = data[3];
			String entryAddress = data[4];
			String entryAccount = data[5];
			String entryFunds = data[6];
			String entryPin = data[7];
			 
		
			entrySession.setAttribute("entryEmail", entryEmail);
			entrySession.setAttribute("entryName", entryName);
			entrySession.setAttribute("entryPassword", entryPassword);
			entrySession.setAttribute("entryMobile", entryMobile);
			entrySession.setAttribute("entryAddress", entryAddress);
			entrySession.setAttribute("entryAccount", entryAccount);
			entrySession.setAttribute("entryFunds", entryFunds);
			entrySession.setAttribute("entryPin", entryPin);
			System.out.println("Come in entry servlet");
			
			// update the toast or entry point 
	        RequestDispatcher Dispatcher = request.getRequestDispatcher("NotificationEntry");
	        Dispatcher.include(request, response);
			
			
			
		response.sendRedirect("RefreshAllServletEntry");

	}

}
