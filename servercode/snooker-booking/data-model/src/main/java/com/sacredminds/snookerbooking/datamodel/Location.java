package com.sacredminds.snookerbooking.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long locationId;

	private String addressLine1;

	private String addressLine2;

	@OneToOne
	@JoinColumn
	private City city;

	private int pincode;

}
