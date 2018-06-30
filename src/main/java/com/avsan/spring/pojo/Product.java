package com.avsan.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PRODUCT")
@Data
public class Product {
    private long productId;
    private String name;
    private String description;
    private float price;
    private ProductDetail productDetail;
 
    public Product() {
    }
 
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    public long getProductId() {
        return productId;
    }
 
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public ProductDetail getProductDetail() {
        return productDetail;
    }
 
    // other getters and setters
}