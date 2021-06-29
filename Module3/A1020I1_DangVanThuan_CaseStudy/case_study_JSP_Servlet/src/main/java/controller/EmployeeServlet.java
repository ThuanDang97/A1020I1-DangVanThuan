package controller;

import model.employee.Employee;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                saveEmployee(request,response);
                break;
            case "update":
                updateEmployee(request,response);
                break;
            default:
                homeEmployee(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case"list":
                listEmployee(request,response);
                break;
            case "create":
                createEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
            case "update":
                showEditEmployee(request,response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "chooseDelete":
                chooseDeleteEmployee(request, response);
                break;
            default:
                homeEmployee(request,response);
                break;
        }
    }

    // ------------------------------ Home Employee ------------------------- //

    private void homeEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("employee/employee.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------ Show List Employee ------------------------- //

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("employeeList", this.employeeService.findAll());
        try {
            request.getRequestDispatcher("employee/list.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------ Create & Save Employee ------------------------- //

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("employee/create.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void saveEmployee(HttpServletRequest request, HttpServletResponse response) {
        String nameEmployee = request.getParameter("name");
        Date dayOfBirth = Date.valueOf(request.getParameter("dayOfBirth"));
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));

        this.employeeService.insertEmployee(new Employee(nameEmployee, dayOfBirth, idCard, salary, phone, email, address, position, education, division));
        try {
            request.getRequestDispatcher("employee/employee.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------ Edit & Update Employee ------------------------- //

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("employeeList", this.employeeService.findAll());
            request.getRequestDispatcher("employee/edit.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeService.findById(id);
        request.setAttribute("employee", employee);
        try {
            request.getRequestDispatcher("employee/update.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameEmployee = request.getParameter("name");
        Date dayOfBirth = Date.valueOf(request.getParameter("dayOfBirth"));
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));
        System.out.println(position);
        System.out.println(education);
        System.out.println(division);
        Employee employee = new Employee(nameEmployee, dayOfBirth, idCard, salary, phone, email, address, position, education, division);
        this.employeeService.updateEmployee(id, employee);
        try {
            request.setAttribute("employeeList", this.employeeService.findAll());
            request.getRequestDispatcher("employee/edit.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------ Delete Employee ------------------------- //

    private void chooseDeleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.employeeService.deleteEmployee(id);
        try {
            request.setAttribute("employeeList", this.employeeService.findAll());
            request.getRequestDispatcher("employee/delete.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("employeeList", this.employeeService.findAll());
            request.getRequestDispatcher("employee/delete.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
