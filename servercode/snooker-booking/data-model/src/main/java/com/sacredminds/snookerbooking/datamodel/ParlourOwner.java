package com.sacredminds.snookerbooking.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class ParlourOwner {

	@Id
	@GeneratedValue(generator = "parlour-owner-sequence-generator")
    @GenericGenerator(
      name = "parlour-owner-sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "parlour_owner_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private long ownerId;

	private String firstName;

	private String lastName;

	private String phoneNo;

	private String email;

	@OneToOne(mappedBy = "owner")
	@JsonIgnore
	private Parlour parlour;

}
