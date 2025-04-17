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
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {     
			// connection class object 
				LoginSignUp l1 = new LoginSignUp();
					String failed;
			     
					
					//SIGN UP
			
					String user = request.getParameter("name");
					String email = request.getParameter("email");
					String pass = request.getParameter("password");
			  
					if(l1.passwordValidate(pass)) {
					
					int signUpStatus = l1.signUp(user, email, pass);
					
					
//					 System.out.println(signUpStatus);
					
					 switch (signUpStatus) {
				       case 1:
				    	   String success ="Sign Up success Please Login";
						   
						   HttpSession session = request.getSession();
						   System.out.println("session created "+ session);
						  
						   session.setAttribute("email", email);
						   session.setAttribute("password", pass);
						   
						   response.sendRedirect("EntryServlet");
						  // response.sendRedirect("index.jsp?error="+success);
						   break;
				       case 2:
						   failed ="Email already exists";
					    	
					    	response.sendRedirect("register.jsp?error="+failed);
					    	break;
			
				       default:
						   failed ="Sign Up failed ";
	   			        	response.sendRedirect("register.jsp?error="+failed);
					    	break;
			
					 }
					}else {
						 failed ="Password must be combination of uppercase letters, lowercase letters, numbers, and symbols";
						response.sendRedirect("register.jsp?error="+failed);
					}
					 } catch(Exception e) {
				   System.out.println("Error "+e);
//				   response.sendRedirect("login.jsp");
			}
			
			
			
		}


}
