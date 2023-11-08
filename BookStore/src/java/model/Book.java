/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 1112v
 */
//[id] int IDENTITY(1,1) NOT NULL,
//	[title] [nvarchar](100),
//	[author] [nvarchar](80),
//	[categoryid] int,
//	[quantity] smallint,
//	[price] decimal(10,2),
//	[is_sale] bit,
//	[discount] smallint,
//	[image] [varchar](500),
//	[description] nvarchar(2000),
public class Book {
    int id;
    String title,author;
    int categoryid;
    int quantity;
    Double price;
    Boolean is_sale;
    int discount;
    String image,description;

    public Book() {
    }

    public Book(String title, String author, int categoryid, int quantity, Double price, Boolean is_sale, int discount, String image, String description) {
        this.title = title;
        this.author = author;
        this.categoryid = categoryid;
        this.quantity = quantity;
        this.price = price;
        this.is_sale = is_sale;
        this.discount = discount;
        this.image = image;
        this.description = description;
    }

    public Book(int id, String title, String author, int quantity, Double price, String image) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }
      
    public Book(int id, String title, String author, int categoryid, int quantity, Double price, Boolean is_sale, int discount, String image, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.categoryid = categoryid;
        this.quantity = quantity;
        this.price = price;
        this.is_sale = is_sale;
        this.discount = discount;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIs_sale() {
        return is_sale;
    }

    public void setIs_sale(Boolean is_sale) {
        this.is_sale = is_sale;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
