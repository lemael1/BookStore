/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import model.Order;
import model.OrderItem;
import model.User;

/**
 *
 * @author 1112v
 */
@WebServlet(name = "MuaServlet", urlPatterns = {"/mua"})
public class MuaServlet extends HttpServlet {

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
            out.println("<title>Servlet MuaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MuaServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
    // Get the user from the session
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");

    // Check if the user is logged in
    if (user == null) {
        // If the user is not logged in, redirect to the login page
        response.sendRedirect("login");
    }

    // Get the cart from the session
    List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");
    if (cart == null || cart.isEmpty()) {
        // If the cart is empty, redirect to the mua.jsp page
        request.getRequestDispatcher("mua.jsp").forward(request, response);
    }

    // Create a new order
    Order order = new Order();
    order.setUserid(user.getId());

    // Set the order date to the current date and convert it to a string
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate localDate = LocalDate.now();
    order.setOrderdate(dtf.format(localDate));

    order.setStatus("Processing");

    // Calculate the total price of the order
    float total = 0;
    for (OrderItem item : cart) {
        total += item.getPrice() * item.getQuantity();
    }
    order.setTotal(total);

    // Save the order to the database and get the generated ID
    OrderDAO od= new OrderDAO();
   od.saveOrder(order);

    // Add the items to the OrderItem table with the generated order ID
    OrderItemDAO orderItemDao = new OrderItemDAO();
    for (OrderItem item : cart) {
        item.setOrderid(order.getId());
        orderItemDao.saveOrderItem(item);
    }

    // Clear the cart
    cart.clear();

    // Redirect to a success page
    response.sendRedirect("home");
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
