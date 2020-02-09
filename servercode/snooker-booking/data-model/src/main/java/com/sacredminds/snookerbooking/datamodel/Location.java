package com.sacredminds.snookerbooking.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Data
public class Location {

	@Id
	@GeneratedValue(generator = "location-sequence-generator")
    @GenericGenerator(
      name = "location-sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "location_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private long locationId;

	private String addressLine1;

	private String addressLine2;

	@ManyToOne
	@JoinColumn(name = "city")
	private City city;

	private String state;

	private int pincode;

}
