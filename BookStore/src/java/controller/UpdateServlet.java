/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookDAO;
import dal.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import model.Book;
import model.Category;

/**
 *
 * @author 1112v
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
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
        CategoryDAO c = new CategoryDAO();
        List<Category> list_cate = c.getAllCategory();
        request.setAttribute("list_cate", list_cate);
        String id_raw = request.getParameter("id");
        int id = Integer.parseInt(id_raw);
        request.setAttribute("id", id);
        request.getRequestDispatcher("admin/update.jsp").forward(request, response);
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
    try {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int cateid = Integer.parseInt(request.getParameter("cateid"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Double price = Double.parseDouble(request.getParameter("price"));
        Boolean is_sale = "1".equals(request.getParameter("is_sale"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        String image = request.getParameter("image");
        String description = request.getParameter("description");

        Book book = new Book(id, title, author, cateid, quantity, price, is_sale, discount, image, description);
        BookDAO bookDAO = new BookDAO();
        bookDAO.updateBook(book);
        request.setAttribute("message", "Book updated successfully");
    } catch (NumberFormatException e) {
        request.setAttribute("message", "Invalid input");
    } catch (NullPointerException e) {
        request.setAttribute("message", "Missing input");
    } catch (SQLException e) {
        request.setAttribute("message", "Failed to update book");
    }

    request.getRequestDispatcher("admin").forward(request, response);
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
