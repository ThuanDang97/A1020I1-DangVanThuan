package controller;

import model.Product;
import model.service.ProducServiceImpl;
import model.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "")
public class ProductServlet extends javax.servlet.http.HttpServlet {
    private ProductService productService = new ProducServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                //Lưu thông tin product vào db
                saveProduct(request, response);
                break;
            default:
                getProductHome(request, response);
        }
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                getCreateProduct(request, response); //trả về trang create
                break;
            case "edit":
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                getProductHome(request, response);
        }
    }


    private void getCreateProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void getProductHome(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("products", productService.findAll());
        try {
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void saveProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        productService.save(new Product(id, name, price));
        String message = "Created";
        request.setAttribute("message", message);
        try {
            request.getRequestDispatcher("create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteById(id);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
