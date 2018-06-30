package com.avsan.spring.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

public class Product {
    private long productId;
    private String name;
    private String description;
    private float price;
    private ProductDetail productDetail;
 
}