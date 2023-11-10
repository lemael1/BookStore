/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookDAO;
import dal.OrderDAO;
import dal.OrderItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.Book;
import model.Order;
import model.OrderItem;
import model.User;

/**
 *
 * @author 1112v
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/order"})
public class OrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin người dùng từ session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // Kiểm tra xem người dùng đã đăng nhập hay chưa
        if (user == null) {
            // Nếu người dùng chưa đăng nhập, chuyển hướng họ đến trang đăng nhập
            response.sendRedirect("login");
        } else {
            // Nếu người dùng đã đăng nhập, chuyển hướng họ đến trang mua.jsp
            response.sendRedirect("mua.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin sách và số lượng từ yêu cầu
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Lấy thông tin người dùng từ session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // Kiểm tra xem người dùng đã đăng nhập hay chưa
        if (user == null) {
            // Nếu người dùng chưa đăng nhập, hiển thị thông báo yêu cầu đăng nhập
            response.getWriter().println("Làm ơn đăng nhập để mua hàng");
            return;
        }

        // Tạo một OrderItem mới
        OrderItem item = new OrderItem();
        item.setBookid(bookId);
        item.setQuantity(quantity);
        BookDAO bd = new BookDAO();
        Book b = bd.getDetailBook(bookId);
        item.setItemname(b.getTitle());
        if (b.getIs_sale()) {
            // Nếu sách đang được giảm giá, tính giá sau khi giảm giá
            double discountedPrice = Math.floor(b.getPrice() * (1 - b.getDiscount() / 100.0) * 100) / 100;
            item.setPrice(discountedPrice);
        } else {
            // Nếu sách không được giảm giá, sử dụng giá gốc
            item.setPrice(Math.floor(b.getPrice() * 100) / 100);
        }

        List<OrderItem> list_item = (List<OrderItem>) session.getAttribute("cart");
        if (list_item == null) {
            list_item = new ArrayList<>();

        }
        boolean check = true;
        for (int i = 0; i < list_item.size(); i++) {
            if (list_item.get(i).getBookid() == item.getBookid()) {
                list_item.get(i).setQuantity(list_item.get(i).getQuantity() + item.getQuantity());
                check = false;
                break;
            }
        }
        if (check == true) {
            list_item.add(item);
        }
        session.setAttribute("cart", list_item);
        response.sendRedirect("mua.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
