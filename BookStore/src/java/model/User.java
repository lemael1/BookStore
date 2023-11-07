/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
//[id] int IDENTITY(1,1) NOT NULL,
//	[fullname] [nvarchar](50),

import java.sql.Date;

//	[gender] [bit],
//	[dob] [date],
//	[email] [varchar](50) NULL,
//	[phone] [varchar](11) NULL,
//	[address] [nvarchar](200) NULL,
//	[username] [varchar](50) NOT NULL,
//	[password] [varchar](50) NOT NULL,
//	[is_super] [bit] NOT NULL
public class User {

    int id;
    String fullname;
    Boolean gender;
    Date dob;
    String email;
    String phone;
    String address, username, password;
    Boolean is_super;

    public User() {
    }

    public User(int id, String fullname, Boolean gender, Date dob, String email, String phone, String address, String username, String password, Boolean is_super) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
        this.is_super = is_super;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIs_super() {
        return is_super;
    }

    public void setIs_super(Boolean is_super) {
        this.is_super = is_super;
    }

}
