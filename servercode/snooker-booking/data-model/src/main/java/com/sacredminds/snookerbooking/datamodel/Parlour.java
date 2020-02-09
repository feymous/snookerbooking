package com.sacredminds.snookerbooking.datamodel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Parlour {

	@Id
	@GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "parlour_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	@Column(name = "parlour_id")
	private long parlourId;

	private String parlourName;
	
	private String email;
	
	private String phoneNo;

	private String description;

	@OneToOne
	@JoinColumn(name = "location")
	private Location location;

	// bi-directional many-to-one association to Parlour
	@OneToMany(mappedBy = "parlour")
	@JsonIgnore
	private List<Board> boards;

	// bi-directional many-to-one association to Parlour
	@OneToOne
	@JoinColumn(name = "owner")
	private ParlourOwner owner;
	
	private String tags;

}
