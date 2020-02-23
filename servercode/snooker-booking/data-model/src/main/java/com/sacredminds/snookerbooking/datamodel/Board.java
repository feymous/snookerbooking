package com.sacredminds.snookerbooking.datamodel;

import javax.persistence.Column;
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
public class Board {

	@Id
	@GeneratedValue(generator = "board-sequence-generator")
    @GenericGenerator(
      name = "board-sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "board_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	@Column
	private long boardId;

	private String name;

	private String description;
	
	private long pricePerHour;

	// bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name = "board_type")
	private BoardType boardType;

	// bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name = "parlour")
	private Parlour parlour;

}
