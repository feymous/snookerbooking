package com.sacredminds.snookerbooking.datamodel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Parlour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "parlour_id")
	private long parlourId;

	private String parlourName;

	private String description;

	@OneToOne
	@JoinColumn
	private Location locationId;

	// bi-directional many-to-one association to Application
	@OneToMany(mappedBy = "parlour")
	@JsonIgnore
	private List<Board> boards;

	// bi-directional many-to-one association to Application
	@OneToOne
	@JoinColumn
	private ParlourOwner owner;

}
