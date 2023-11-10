/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import DTO.FeatureBook;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;

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

    public List<FeatureBook> GetAllBooks(String msg) {
        String sql = null;
        if (msg.equals("all")) {
            sql = "SELECT id,title,author,price,is_sale,discount,image FROM [dbo].[Book]";
        } else if (msg.equals("asc")) {
            sql = "SELECT id,title,author,price,is_sale,discount,image FROM [dbo].[Book] ORDER BY price * (1 - discount / 100.0) ASC";
        } else if (msg.equals("desc")) {
            sql = "SELECT id,title,author,price,is_sale,discount,image FROM [dbo].[Book] ORDER BY price * (1 - discount / 100.0) DESC";
        }
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

    public List<Book> GetBookforAdmin() {
        List<Book> books = new ArrayList<>();
        String sql = "Select id,title,author,quantity,price,image from [Book]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                Double price = rs.getDouble("price");
                String image = rs.getString("image");
                Book book = new Book(id, title, author, quantity, price, image);
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println("GetBookforAdmin Error:" + e.getMessage());
        }
        return books;
    }

    public void updateBook(Book book) throws SQLException {
        String sql = "UPDATE Book SET title = ?, author = ?, categoryid = ?, quantity = ?, price = ?, is_sale = ?, discount = ?, image = ?, description = ? WHERE id = ?";
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, book.getTitle());
            st.setString(2, book.getAuthor());
            st.setInt(3, book.getCategoryid());
            st.setInt(4, book.getQuantity());
            st.setDouble(5, book.getPrice());
            st.setBoolean(6, book.getIs_sale());
            st.setInt(7, book.getDiscount());
            st.setString(8, book.getImage());
            st.setString(9, book.getDescription());
            st.setInt(10, book.getId());
            st.executeUpdate();
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public void deleteBook(String id) {
        String sql = "DELETE FROM Book WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(id));
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("deleteBook Error:" + e.getMessage());
        }
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO Book (title, author, categoryid, quantity, price, is_sale, discount, image, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, book.getTitle());
            st.setString(2, book.getAuthor());
            st.setInt(3, book.getCategoryid());
            st.setInt(4, book.getQuantity());
            st.setDouble(5, book.getPrice());
            st.setBoolean(6, book.getIs_sale());
            st.setInt(7, book.getDiscount());
            st.setString(8, book.getImage());
            st.setString(9, book.getDescription());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("addBook Error:" + e.getMessage());
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    /* ignored */ }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    /* ignored */ }
            }
        }
    }

    public Book getDetailBook(int id) {
        String sql = "SELECT * FROM Book WHERE id = ?";
        Book book = null;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                int categoryid = rs.getInt("categoryid");
                int quantity = rs.getInt("quantity");
                Double price = rs.getDouble("price");
                Boolean is_sale = rs.getBoolean("is_sale");
                int discount = rs.getInt("discount");
                String image = rs.getString("image");
                String description = rs.getString("description");

                book = new Book(id, title, author, categoryid, quantity, price, is_sale, discount, image, description);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // close resources
        }

        return book;
    }

    public static void main(String[] args) {
        BookDAO d = new BookDAO();
        System.out.println(d.GetBookforAdmin());
    }
}
