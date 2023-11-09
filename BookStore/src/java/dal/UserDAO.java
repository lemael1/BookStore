/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author 1112v
 */
//int id;
//    String fullname;
//    Boolean gender;
//    Date dob;
//    String email;
//    String phone;
//    String address, username, password;
//    Boolean is_super;
public class UserDAO extends DBContext {

    public List<User> GetAllUser() {
        String sql = "select * from User";
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setFullname(rs.getString("fullname"));
                u.setGender(rs.getBoolean("gender"));
                u.setDob(rs.getDate("dob"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setAddress(rs.getString("address"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setIs_super(rs.getBoolean("is_super"));
                list.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public User getUser(String username, String password) {
        String sql = "Select * from [User] where username=? AND password=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs;
            rs = st.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setFullname(rs.getString("fullname"));
                u.setGender(rs.getBoolean("gender"));
                u.setDob(rs.getDate("dob"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setAddress(rs.getString("address"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setIs_super(rs.getBoolean("is_super"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println("getUser Error:" + e.getMessage());
        }
        return null;
    }

    public String getUsername(int userid) {
        String sql = "select [username] from [User] where [id] = " + userid;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs;
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("getNumberUser Error");
        }
        return null;
    }

    public boolean isAdmin(User user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            return true;
        } else {
            return false;
        }

    }

    public void addUser(User user) {
        try {
            // Tạo một đối tượng PreparedStatement
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO User (fullname, gender, dob, email, phone, address, username, password, is_super) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // Đặt giá trị cho các tham số
            stmt.setString(1, user.getFullname());
            stmt.setBoolean(2, user.getGender());
            stmt.setDate(3, user.getDob());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getAddress());
            stmt.setString(7, user.getUsername());
            stmt.setString(8, user.getPassword());
            stmt.setBoolean(9, user.getIs_super());

            // Thực hiện truy vấn
            stmt.executeUpdate();

            // Đảm bảo rằng PreparedStatement được đóng lại
            stmt.close();
        } catch (SQLException e) {
            // Xử lý lỗi
            e.printStackTrace();
        }
    }

    public boolean isUsernameTaken(String username) {
        Boolean result = false;
        UserDAO ud = new UserDAO();
        List<User> list = ud.GetAllUser();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                result = true;
                break;
            }
        }
        return result;
    }

}
