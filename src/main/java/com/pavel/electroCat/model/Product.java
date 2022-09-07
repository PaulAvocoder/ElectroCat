package com.pavel.electroCat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
    @Column(name = "productId")
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long productId;

    @Column(name = "name")
    private String name = null;

    @Column(name = "description")
    private String description = null;

    @Column(name = "price")
    private Integer price = null;

    @Column(name = "img")
    private String img=null;

    @Column(name = "category")
    private String category=null;

    @Column(name = "entry_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date entryDate;

    @Column(name = "status")
    private Boolean status;



    public Product() {
    }

    public Product(Long productId, String name, String description, Integer price, String img, String category, Date entryDate, Boolean status) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
        this.category = category;
        this.entryDate = entryDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                ", category='" + category + '\'' +
                ", entryDate=" + entryDate +
                ", status=" + status +
                '}';
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
