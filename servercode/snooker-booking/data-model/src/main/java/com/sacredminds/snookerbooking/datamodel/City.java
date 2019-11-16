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
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long cityId;

	private String cityName;

	@OneToMany(mappedBy = "city")
	@JsonIgnore
	private List<Location> locations;

}
