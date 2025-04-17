package BitPay.Servlet.Wallet;

import com.razorpay.RazorpayClient;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@WebServlet("/VerifyPaymentServlet")
public class VerifyPaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get payment details from the request body
        String paymentDetails = request.getReader().readLine(); // Read payment details
        JSONObject paymentJson = new JSONObject(paymentDetails);

        // Razorpay Payment ID, Order ID, and Signature
        String razorpayPaymentId = paymentJson.getString("razorpay_payment_id");
        String razorpayOrderId = paymentJson.getString("razorpay_order_id");
        String razorpaySignature = paymentJson.getString("razorpay_signature");

        try {
            // Initialize Razorpay client with API keys
            RazorpayClient razorpayClient = new RazorpayClient("rzp_test_qpUAs39kazCw0o", "RK0uMB6UjY4soSmIwexa7eXt");

            // Generate the signature using the Razorpay order id and payment id
            String generatedSignature = generateSignature(razorpayOrderId, razorpayPaymentId);

            // Compare the generated signature with the provided signature
            if (generatedSignature.equals(razorpaySignature)) {
                // Payment is successful, mark the payment as verified in your database
                JSONObject result = new JSONObject();
                result.put("success", true);
                result.put("message", "Payment verified successfully!");
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.print(result.toString());
                out.flush();
            } else {
                // Payment verification failed
                JSONObject result = new JSONObject();
                result.put("success", false);
                result.put("message", "Payment verification failed!");
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.print(result.toString());
                out.flush();
            }
        } catch (Exception e) {
            // Handle any exceptions
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
            response.getWriter().write("Error while verifying payment: " + e.getMessage());
        }
    }

    // Generate the signature manually for comparison using HMAC-SHA256
    private String generateSignature(String razorpayOrderId, String razorpayPaymentId) throws Exception {
        String RAZORPAY_SECRET_KEY = "RK0uMB6UjY4soSmIwexa7eXt";  // Replace with your actual secret key
        String data = razorpayOrderId + "|" + razorpayPaymentId;

        // Create HMAC-SHA256 signature
        SecretKeySpec secretKeySpec = new SecretKeySpec(RAZORPAY_SECRET_KEY.getBytes(), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);

        // Generate the signature
        byte[] rawHmac = mac.doFinal(data.getBytes());
        String generatedSignature = Base64.getEncoder().encodeToString(rawHmac);

        return generatedSignature;
    }
}
