package controller;

import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/", "/customer"})
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                deleteForm(request, response);
                break;
            case "view":
                viewCustomer(request,response);
                break;
            default:
                listCustomers(request, response);
                break;
        }
    }
    // --------------------- show list customer ---------------------------- //

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.customerService.findAll();
        request.setAttribute("customers", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --------------------- create customer ---------------------------- //
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = (int) (Math.random() * 10000);

        Customer customer = new Customer(id, name, email, address);
        this.customerService.save(customer);
        request.setAttribute("message", "New customer was created");
        request.getRequestDispatcher("customer/create.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("customer/create.jsp").forward(request, response);
    }

    // --------------------- edit & update customer ---------------------------- //

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findByID(id);
        if (customer == null) {
            request.getRequestDispatcher("error-404.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = this.customerService.findByID(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        this.customerService.update(id, customer);
        request.setAttribute("customer", customer);
        request.setAttribute("msg", "Customer information was updated");
        request.getRequestDispatcher("customer/edit.jsp").forward(request,response);
    }

    // --------------------- delete customer ---------------------------- //

    private void deleteForm (HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        this.customerService.remove(id);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --------------------- view info customer ---------------------------- //

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findByID(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}


