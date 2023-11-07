/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
public class UserDAO extends DBContext{
    public User getUser(String username, String password) {
        String sql = "Select * from [User] where username=? AND password=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,username);
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
         String sql = "select [username] from [User] where [id] = "+userid;
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs;
            rs = st.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch(SQLException e){
            System.out.println("getNumberUser Error");
        }
        return null;
    }
}
