/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/* @author ACER */
public class OrderItem {
    int orderid;
     int bookid;
     String itemname;
     int quantity;
     double price;

    public OrderItem() {
    }

    public OrderItem(int orderid, int bookid, String itemname, int quantity, double price) {
        this.orderid = orderid;
        this.bookid = bookid;
        this.itemname = itemname;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem(int bookid, String itemname, int quantity, double price) {
        this.bookid = bookid;
        this.itemname = itemname;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   
    
}
