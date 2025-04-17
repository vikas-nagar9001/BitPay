package BitPay.Servlet.Notification;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import BitPay.Database.Notification;

/**
 * Servlet implementation class Toast
 */
public class NotificationEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotificationEntry() {
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
		HttpSession Session = request.getSession(false);
		String accountNo = (String) Session.getAttribute("entryAccount");
		long accountNumber = Long.parseLong(accountNo);
		
		ArrayList<String[]> toast = new ArrayList<>();
		ArrayList<String[]> notification = new ArrayList<>();
		
		System.out.println("in notification servlet");
		Notification n = new Notification(accountNumber);
		toast =	n.showToast();
		notification = n.showNotification();
		
     	Session.setAttribute("toastHistory", toast);
     	Session.setAttribute("notificationHistory", notification);
  
	}

}
