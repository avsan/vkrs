package com.avsan.spring.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="driver_details",uniqueConstraints={@UniqueConstraint(columnNames={"drivery_licance_number","voter_id_number","adhar_number"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
@Data
public class DriverDetailsPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)//, generator = "driver_detailse_sequence")
	@Column(name = "driver_id")
	private int driverId;

	@Column(name = "drivery_licance_number")// uk
	@NotNull
	private String driveryLicanceNumber;
	
	@Column(name = "driver_name")
	private String driverName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "alternate_contact_number")
	private String alternateContactNumber;
		
	@Column(name = "voter_id_number")// uk
	@NotNull
	private String voterIdNumber;
	
	@Column(name = "adhar_number")// uk
	@NotNull
	private String adharNumber;
	
	@Column(name = "dl_scaned_copy")
	private String dlScanedCopy;
	
	@Column(name = "voter_scaned_copy")
	private String voterScanedCopy;
	
	@Column(name = "adhar_scaned_copy")
	private String adharScanedCopy;
	
	@Column(name = "driver_photo_Copy")
	private String driverPhotoCopy;
	
	@Column(name = "years_of_experience")
	private String yearsOfExperience;
	
	@Column(name = "previously_worked_at")
	private String previouslyWorkedAt;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "driverId")
	private Set<DailyTripDetailsPojo> dailyTripDetails;

	@OneToMany(mappedBy = "driver_id")
	private Set<FuelDetailsPojo> fuelDetailsBean;
		
}
