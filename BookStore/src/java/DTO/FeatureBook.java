/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author 1112v
 */
//        [id] int IDENTITY(1,1) NOT NULL,
//	[title] [nvarchar](100),
//	[author] [nvarchar](80),
//	[categoryid] int,
//	[quantity] smallint,
//	[price] decimal(10,2),
//	[is_sale] bit,
//	[discount] smallint,
//	[image] [varchar](500),
//	[description] nvarchar(2000),
//	[views] int
public class FeatureBook {
    int id;
    String title;
    String author;
    Double price;
    Boolean is_sale;
    int discount;
    String image;

    public FeatureBook() {
    }

    public FeatureBook(int id, String title, String author, Double price, Boolean is_sale, int discount, String image) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.is_sale = is_sale;
        this.discount = discount;
        this.image = image;
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

    
}
