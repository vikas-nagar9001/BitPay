package BitPay.Servlet.Notification;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import BitPay.Database.Notification;
/**
 * Servlet implementation class CloseToast
 */
public class CloseToast extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseToast() {
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
		  String id2 = request.getParameter("toastId");
		  String page = request.getParameter("currentPage");
		  long id = Long.parseLong(id2);
	      
		  Notification n = new Notification(0);
	      n.closeToast(id);
	      
	      // Include the toast
	        RequestDispatcher Dispatcher = request.getRequestDispatcher("NotificationEntry");
	        Dispatcher.include(request, response);
	        
	      response.sendRedirect(page);

	}

}
