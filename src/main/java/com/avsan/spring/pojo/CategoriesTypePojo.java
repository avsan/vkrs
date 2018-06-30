package com.avsan.spring.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="categories_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class CategoriesTypePojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)//, generator = "categories_type_sequence")
	@Column(name = "ssno")
	private int ssno;
	@Column(name = "value")
	private String value;
	
	@Column(name = "categories")
	private String categories;
	
	@OneToMany(mappedBy = "fuelType")
	private Set<FuelDetailsPojo> fuelDetailsBean;
}
