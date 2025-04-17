package BitPay.Servlet.Verify;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import BitPay.Database.Verify;
/**
 * Servlet implementation class GetReceiverName
 */
public class GetReceiverName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReceiverName() {
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
	    String receiverAccountNo = request.getParameter("receiverAccountNo");

	    // Parse the account number to long
	    long account = Long.parseLong(receiverAccountNo);

	    // Perform verification using the Verify class
	    Verify v = new Verify();
	    String verifiedName = v.getReceiverName(account);

	    // Prepare the response
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");

	    // Send the response back to the client
	    if (verifiedName != null && !verifiedName.isEmpty()) {
	        response.getWriter().write("Account holder: " + verifiedName);
	    } else {
	        response.getWriter().write("Invalid account number. Please try again.");
	    }
	}


}
