package controller;

import model.bean.MatBang;
import model.service.MatBangService;
import model.service.MatBangServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "MatBangServlet", urlPatterns = "/matbang")
public class MatBangServlet extends HttpServlet {
    private MatBangService matBangService = new MatBangServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                luuMatbang(request,response);
                break;
            case "edit":
                break;
            default:
                listMatBang(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action){
            case "create":
                taoMatBang(request,response);
                break;
            case "edit":
                break;
            case "delete":
                xoaMatBang(request,response);
                break;
            case "search":
                break;
            default:
                listMatBang(request,response);
                break;
        }
    }

    private void listMatBang(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("matBangList", this.matBangService.findAll());
            request.getRequestDispatcher("matbang/list.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void taoMatBang(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("matbang/create.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void luuMatbang(HttpServletRequest request, HttpServletResponse response) {
        String maMatBang = request.getParameter("mamb");
        int trangThai = Integer.parseInt(request.getParameter("trangthai"));
        double dienTich = Double.parseDouble(request.getParameter("dientich"));
        int tang = Integer.parseInt(request.getParameter("tang"));
        int loaiMatBang = Integer.parseInt(request.getParameter("loaimb"));
        double giaTien = Double.parseDouble(request.getParameter("giatien"));
        Date ngayBatDau = Date.valueOf(request.getParameter("ngaybd"));
        Date ngayKetThuc = Date.valueOf(request.getParameter("ngaykt"));

        this.matBangService.chonMatBang(new MatBang(maMatBang,trangThai,dienTich,tang,loaiMatBang,giaTien,ngayBatDau,ngayKetThuc));
        try {
            request.setAttribute("matBangList", this.matBangService.findAll());
            request.getRequestDispatcher("matbang/list.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void xoaMatBang(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.matBangService.xoaMatBang(id);
        try {
            request.setAttribute("matBangList", this.matBangService.findAll());
            request.getRequestDispatcher("matbang/list.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
