package com.avsan.spring.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="bunk_details_tbl")
@TableGenerator(name="bunk_details_gen", initialValue=0)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class BunkDetailsPojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="bunk_details_gen")//, generator = "bunk_details_sequence")
	@Column(name = "bunk_id")
	private int bunkId;
	
	@Column(name = "bunk_name")
	private String bunkName;
	
	@Column(name = "bunk_address")
	private String bunkAddress;
	
	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "alternate_contact_number")
	private String alternateContactNumber;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "active")
	private String active;
	
	@OneToMany(mappedBy = "bunkId")
	private Set<FuelDetailsPojo> fuelDetailsBean;
	
	
}
