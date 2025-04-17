package BitPay.Servlet.Profile;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;



import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import BitPay.Database.Profile;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try {
		
		HttpSession session1 = request.getSession(false);
		String email = (String) session1.getAttribute("email");
		Profile p = new Profile();
		
			String[] data =	p.showProfileDetails(email);
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
			session1.setAttribute("profileEmail", profileEmail);
			session1.setAttribute("profileName", profileName);
			session1.setAttribute("profilePassword", profilePassword);
			session1.setAttribute("profileMobile", profileMobile);
			session1.setAttribute("profileAddress", profileAddress);
			session1.setAttribute("profileAccount", profileAccount);
			session1.setAttribute("profileFunds", profileFunds);
//			session.setAttribute("profilePin", profilePin);
			
			
			// update the toast or entry point 
	        RequestDispatcher Dispatcher = request.getRequestDispatcher("NotificationEntry");
	        Dispatcher.include(request, response);
			
		response.sendRedirect("Profile.jsp");
	
	}catch (Exception e) {
		System.out.println(e +" exception in profile entry");
		response.sendRedirect("Profile.jsp");
	}

}
	}
