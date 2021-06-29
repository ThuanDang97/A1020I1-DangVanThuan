package controller;

import model.customer.Customer;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                saveCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            default:
                homeCustomer(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list":
                listCustomer(request, response);
                break;
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "update":
                showEditCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "chooseDelete":
                chooseDeleteCustomer(request, response);
                break;
            default:
                homeCustomer(request, response);
                break;
        }
    }

    // ------------------------------ Home Customer ------------------------- //

    private void homeCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("customer/customer.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------ Show List Customer ------------------------- //

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("customerList", this.customerService.findAll());
            request.getRequestDispatcher("customer/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------ Create & Save Customer ------------------------- //

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("customer/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) {
        int typeCustomer = Integer.parseInt(request.getParameter("customerType"));
        String nameCustomer = request.getParameter("name");
        Date dayOfBirth = Date.valueOf(request.getParameter("dayOfBirth"));
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        this.customerService.insertCustomer(new Customer(typeCustomer, nameCustomer, dayOfBirth, gender, idCard, phone, email, address));
        try {
            request.getRequestDispatcher("customer/customer.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------ Edit & Update Customer ------------------------- //


    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("customerList", this.customerService.findAll());
            request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Customer customer = this.customerService.findById(id);
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("customer/update.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int typeIdCustomer = Integer.parseInt(request.getParameter("customerType"));
        String nameCustomer = request.getParameter("name");
        Date dayOfBirth = Date.valueOf(request.getParameter("dayOfBirth"));
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(typeIdCustomer, nameCustomer, dayOfBirth, gender, idCard, phone, email, address);
        this.customerService.updateCustomer(id, customer);
        try {
            request.setAttribute("customerList", this.customerService.findAll());
            request.getRequestDispatcher("customer/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    // ------------------------------ Delete Customer ------------------------- //

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("customerList", this.customerService.findAll());
            request.getRequestDispatcher("customer/delete.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void chooseDeleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.customerService.deleteCustomer(id);
        request.setAttribute("customerList", this.customerService.findAll());
        try {
            request.getRequestDispatcher("customer/delete.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
