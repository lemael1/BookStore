/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import DTO.FeatureBook;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1112v
 */
public class BookDAO extends DBContext {

    public List<FeatureBook> Get3FeatureBook() {
        String sql = "SELECT TOP 3 id,title,author,price,is_sale,discount,image\n"
                + "FROM [dbo].[Book]\n"
                + "WHERE is_sale = 1\n"
                + "ORDER BY price * (1 - discount / 100.0)";
        List<FeatureBook> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                FeatureBook f = new FeatureBook();
                f.setId(rs.getInt(1));
                f.setTitle(rs.getString(2));
                f.setAuthor(rs.getString(3));
                f.setPrice(rs.getDouble(4));
                f.setIs_sale(rs.getBoolean(5));
                f.setDiscount(rs.getInt(6));
                f.setImage(rs.getString(7));
                list.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        BookDAO b = new BookDAO();
        System.out.println(b.Get3FeatureBook().get(0).getImage());
    }

}
