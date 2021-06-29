package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/", "/product"})
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                saveProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "find":
                break;
            default:
                productHome(request, response);
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
                createProduct(request, response);
                break;
            case "update":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "info":
                infoProduct(request, response);
                break;
            case "find":
                findProduct(request, response);
                break;
            default:
                productHome(request, response);
                break;
        }
    }

    // ----------------------------- View Home Product ----------------------------- //

    private void productHome(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("products", this.productService.findAll());
        try {
            request.getRequestDispatcher("product/view.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ----------------------------- Create & Save Product ----------------------------- //
    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("product/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void saveProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nameProduct");
        int price = Integer.parseInt(request.getParameter("priceProduct"));
        String description = request.getParameter("descriptionProduct");
        String producer = request.getParameter("producer");
        this.productService.saveProduct(new Product(id, name, price, description, producer));
        try {
            request.getRequestDispatcher("product/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ----------------------------- Edit & Update Product ----------------------------- //

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findByID(id);
        request.setAttribute("product", product);
        try {
            request.getRequestDispatcher("product/update.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nameProduct");
        int price = Integer.parseInt(request.getParameter("priceProduct"));
        String descriptionProduct = request.getParameter("descriptionProduct");
        String producer = request.getParameter("producer");

        Product product = new Product();
        this.productService.findByID(id);
        product.setNameProduct(name);
        product.setPriceProduct(price);
        product.setDescriptionProduct(descriptionProduct);
        product.setProducer(producer);

        this.productService.updateProduct(id, product);
        try {
            request.getRequestDispatcher("product/update.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ----------------------------- Delete Product ----------------------------- //

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.productService.deleteProduct(id);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ----------------------------- View Info Product ----------------------------- //

    private void infoProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findByID(id);
        request.setAttribute("product", product);
        try {
            request.getRequestDispatcher("product/info.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    // ----------------------------- Find By Name Product ----------------------------- //

    private void findProduct(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("keyword");
        List<Product> productList = this.productService.searchByKeyword(keyword);
        request.setAttribute("products", productList);
        try {
            request.getRequestDispatcher("product/view.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
