package com.avsan.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Data
public class ProductDetail {
    private long productId;
    private String partNumber;
    private String dimension;
    private float weight;
    private String manufacturer;
    private String origin;
    private Product product;
 
 
    // other getters and setters
}