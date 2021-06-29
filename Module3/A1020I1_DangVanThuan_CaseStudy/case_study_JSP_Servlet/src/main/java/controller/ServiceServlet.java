package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                saveService(request,response);
                break;
            case "update":
                updateService(request,response);
                break;
            default:
                homeService(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case"list":
                listService(request,response);
                break;
            case "create":
                createService(request,response);
                break;
            case "edit":
                editService(request,response);
                break;
            case "update":
                showEditService(request,response);
                break;
            case "delete":
                deleteService(request, response);
                break;
            case "chooseDelete":
                chooseDeleteService(request, response);
                break;
            default:
                homeService(request,response);
        }
    }

    // ------------------------------ Home Service ------------------------- //

    private void homeService(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("service/service.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------ Show List Service ------------------------- //

    private void listService(HttpServletRequest request, HttpServletResponse response) {

    }

    // ------------------------------ Create & Save Service ------------------------- //

    private void createService(HttpServletRequest request, HttpServletResponse response) {
    }

    private void saveService(HttpServletRequest request, HttpServletResponse response) {
    }

    // ------------------------------ Edit & Update Service ------------------------- //

    private void showEditService(HttpServletRequest request, HttpServletResponse response) {
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) {
    }

    // ------------------------------ Delete Service ------------------------- //

    private void chooseDeleteService(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
    }

}
