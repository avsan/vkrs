package com.candidjava.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Table(name = "PRODUCT_DETAIL")
@Data
public class ProductDetail {
    private long productId;
    private String partNumber;
    private String dimension;
    private float weight;
    private String manufacturer;
    private String origin;
    private Product product;
 
    public ProductDetail() {
    }
 
    @Id
    @GeneratedValue(generator = "foreigngen")
    @GenericGenerator(strategy = "foreign", name="foreigngen",
            parameters = @Parameter(name = "property", value="product"))
    @Column(name = "PRODUCT_ID")
    public long getProductId() {
        return productId;
    }
 
 
    @Column(name = "PART_NUMBER")
    public String getPartNumber() {
        return partNumber;
    }
 
    @OneToOne(mappedBy = "productDetail")
    public Product getProduct() {
        return product;
    }
 
    // other getters and setters
}