import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculatorServlet")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double fistNumber = Double.parseDouble(request.getParameter("first_operand"));
        double secondNumber = Double.parseDouble(request.getParameter("second_operand"));
        char operator = request.getParameter("operator").charAt(0);

        double result = Calculator.calculator(fistNumber, secondNumber, operator);

        request.setAttribute("result",result);
        request.getRequestDispatcher("Calculator.jsp").forward(request,response);

    }
}
