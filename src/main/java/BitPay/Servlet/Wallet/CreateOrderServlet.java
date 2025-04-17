package BitPay.Servlet.Wallet;


import com.razorpay.Order;

import com.razorpay.RazorpayClient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;
/**
 * Servlet implementation class CreateOrderServlet
 */
public class CreateOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the amount from the request (in paise, i.e., multiply by 100)
        String amountStr = request.getReader().readLine(); // Get amount as JSON from the request body
        JSONObject amountJson = new JSONObject(amountStr);
        int amount = amountJson.getInt("amount");

        try {
            // Initialize Razorpay client with your API keys
            RazorpayClient razorpayClient = new RazorpayClient("rzp_test_qpUAs39kazCw0o", "RK0uMB6UjY4soSmIwexa7eXt");

            // Prepare the order parameters
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount); // Amount in paise
            orderRequest.put("currency", "INR");
            orderRequest.put("payment_capture", 1); // 1 means automatic payment capture

            // Create the order
            Order order = razorpayClient.orders.create(orderRequest);

            // Prepare response with the order details
            JSONObject responseJson = new JSONObject();
            responseJson.put("id",(int) order.get("id"));
            responseJson.put("amount", (int) order.get("amount"));


            // Set response content type and write the response
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(responseJson.toString());
            out.flush();
        } catch (Exception e) {
            // Handle exceptions and send error response
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
            response.getWriter().write("Error while creating order: " + e.getMessage());
        }
    }
}