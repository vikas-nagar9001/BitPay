package BitPay.Servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import BitPay.Database.LoginSignUp;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		// TODO Auto-generated method stub

		try {
			// connection class object
			LoginSignUp l1 = new LoginSignUp();

			// SIGN IN
			String email = request.getParameter("email");
			String pass = request.getParameter("password");

			String failed;
			int loginStatus = l1.checkLogin(email, pass);

			switch (loginStatus) {
			case 1:
				HttpSession session = request.getSession();
				System.out.println("session created " + session);

				session.setAttribute("email", email);
				session.setAttribute("password", pass);

				response.sendRedirect("EntryServlet");
				break;
			case 2:
				failed = "Incorrect Password";
				response.sendRedirect("login.jsp?error=" + failed);
				break;
			case 3:
				failed = "Email not found";
				response.sendRedirect("login.jsp?error=" + failed);
				break;
			default:
				failed = "Login failed invalid credentials";
				response.sendRedirect("login.jsp?error=" + failed);
				break;

			}

		} catch (Exception e) {
			System.out.println("Error " + e);
			response.sendRedirect("login.jsp?error=" + e);
		}

		
	}

}
