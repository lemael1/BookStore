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
public class UserDAO extends DBContext{
    public User getUser(String key, String pass) {
        String sql = "Select * from [User] where (username='" + key + "' OR email='" + key + "') AND password='" + pass + "'";
        try {
           PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs;
            rs = st.executeQuery();
            while (rs.next()) {
                int userid = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getBoolean(3) ? "Male" : "Female";
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                String dob = f.format(rs.getDate(4));
                String email = rs.getString(5);
                String phone = rs.getString(6);
                String address = rs.getString(7);
                String username = rs.getString(8);
                boolean is_super = rs.getBoolean(10);
                User u = new User(userid, name, gender, dob, email, phone, address, username, pass, is_super);
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
