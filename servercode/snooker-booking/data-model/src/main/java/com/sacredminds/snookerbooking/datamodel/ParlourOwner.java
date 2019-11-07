package com.sacredminds.snookerbooking.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class ParlourOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long ownerId;

	private String firstName;

	private String lastName;

	private String phoneNo;

	private String email;

	@OneToOne(mappedBy = "owner")
	@JsonIgnore
	private Parlour parlour;

}
