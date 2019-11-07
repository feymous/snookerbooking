package com.sacredminds.snookerbooking.datamodel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long playerId;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String phone;

	// bi-directional many-to-one association to Application
	@OneToMany(mappedBy = "player")
	@JsonIgnore
	private List<Booking> bookings;

}
