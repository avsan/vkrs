package com.avsan.spring.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="vehicle_audit")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
@Data
public class VehicleAuditPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)//, generator = "vehicle_details_sequence")
	@Column(name = "vehicle_id")
	private int vehicleId;
	
	@Column(name = "vechicle_pr_number",unique=true)// uk
	private String vehiclePrNumber;
	
	@Column(name = "name_of_owner")
	private String nameOfOwner;
	

	@Column(name = "registratio_no")
	private String registratioNo;
	
	@Column(name = "date_of_purchase")
	private String dateOfPurchase;
	@Column(name = "total_cost_of_vehicle")
	private int totalCostOfVehicle;
	@Column(name = "down_payment")
	private int downPayment;
	@Column(name = "total_loan")
	private int totalLoan;
	@Column(name = "emi_amount")
	private int emiAmount;
	@Column(name = "loan_financed_by")
	private String loanFinancedBy;
	@Column(name = "contact_person_name")
	private String contactPersonName;
	@Column(name = "contact_no")
	private String contactNo;
	@Column(name = "no_of_emi")
	private int noOfEmi;
	@Column(name = "emi_date")
	private String emiDate ;
}
