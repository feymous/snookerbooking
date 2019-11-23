package com.sacredminds.snookerbooking.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Location {

	@Id
	@Column
	@GeneratedValue(generator = "LOCATION_ID_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "LOCATION_ID_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "seq_Partner") })
	private long locationId;

	private String addressLine1;

	private String addressLine2;

	@ManyToOne
	@JoinColumn(name = "city")
	private City city;

	private String state;

	private int pincode;

}
