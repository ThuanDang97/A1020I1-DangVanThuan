package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                saveContract(request,response);
                break;
            case "update":
                updateContract(request,response);
                break;
            default:
                homeContract(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case"list":
                listContract(request,response);
                break;
            case "create":
                createContract(request,response);
                break;
            case "edit":
                editContract(request,response);
                break;
            case "update":
                showEditContract(request,response);
                break;
            case "delete":
                deleteContract(request, response);
                break;
            case "chooseDelete":
                chooseDeleteContract(request, response);
                break;
            default:
                homeContract(request,response);
        }
    }

    // ------------------------------ Home Contract ------------------------- //

    private void homeContract(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("contract/contract.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------ Show List Contract ------------------------- //

    private void listContract(HttpServletRequest request, HttpServletResponse response) {

    }

    // ------------------------------ Create & Save Contract ------------------------- //

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
    }

    private void saveContract(HttpServletRequest request, HttpServletResponse response) {
    }

    // ------------------------------ Edit & Update Contract ------------------------- //

    private void showEditContract(HttpServletRequest request, HttpServletResponse response) {
    }

    private void editContract(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateContract(HttpServletRequest request, HttpServletResponse response) {
    }

    // ------------------------------ Delete Contract ------------------------- //

    private void chooseDeleteContract(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
    }

}
