import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double list_price = Double.parseDouble(request.getParameter("list_price"));
        double discount = Double.parseDouble(request.getParameter("discount"));

        double discount_amount = list_price * discount * 0.01;
        double price = list_price - discount_amount;

        request.setAttribute("amount",discount_amount);
        request.setAttribute("price", price);
        request.getRequestDispatcher("total.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
