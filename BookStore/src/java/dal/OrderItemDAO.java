/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Book;
import model.OrderItem;

/**
 *
 * @author 1112v
 */
public class OrderItemDAO extends DBContext {

    public OrderItem getItem(int bookId, int quantity) {
        OrderItem item = new OrderItem();
        BookDAO bd = new BookDAO();
        Book b = bd.getDetailBook(bookId);
        item.setBookid(bookId);
        item.setItemname(b.getTitle());
        item.setQuantity(quantity);

        // Kiểm tra xem sách có đang được giảm giá không
        if (b.getIs_sale()) {
            // Nếu sách đang được giảm giá, tính giá sau khi giảm giá
            double discountedPrice = b.getPrice() * (1 - b.getDiscount() / 100.0);
            item.setPrice(discountedPrice);
        } else {
            // Nếu sách không được giảm giá, sử dụng giá gốc
            item.setPrice(b.getPrice());
        }

        return item;
    }

    public void save(OrderItem item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void saveOrderItem(OrderItem item) {
    try {
        String sql = "INSERT INTO [OrderItem] (orderid, bookid, itemname, quantity, price) VALUES (?, ?, ?, ?, ?)";

        // Create a PreparedStatement
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, item.getOrderid());
        stmt.setInt(2, item.getBookid());
        stmt.setString(3, item.getItemname());
        stmt.setInt(4, item.getQuantity());
        stmt.setDouble(5, item.getPrice());

        // Execute the statement
        stmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
