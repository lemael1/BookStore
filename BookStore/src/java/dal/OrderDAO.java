/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Order;
import model.OrderItem;

/**
 *
 * @author 1112v
 */
public class OrderDAO extends DBContext{

   
    public void addItem(OrderItem item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void save(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   public void saveOrder(Order order) {
    try {
        

       
        String sql = "INSERT INTO [Order] (userid, orderdate, total, status) VALUES (?, ?, ?, ?)";

        // Create a PreparedStatement
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, order.getUserid());
        stmt.setString(2, order.getOrderdate());
        stmt.setFloat(3, order.getTotal());
        stmt.setString(4, order.getStatus());

        // Execute the statement
        stmt.executeUpdate();

        // Close the connection
       
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    
}
