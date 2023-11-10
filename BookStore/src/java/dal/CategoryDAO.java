/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author 1112v
 */
public class CategoryDAO extends DBContext {

    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM Category";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException e) {
            System.out.println("getAllCategory Error:" + e.getMessage());
        }
        return categories;
    }

    public static void main(String[] args) {
        CategoryDAO d = new CategoryDAO();
        System.out.println(d.getAllCategory().get(0).getName());
    }

}
