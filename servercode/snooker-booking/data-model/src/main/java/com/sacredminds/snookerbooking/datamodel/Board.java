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
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long boardId;

	private String boardName;

	// bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name= "board_type")
	private BoardType boardType;

	// bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name = "parlour")
	private Parlour parlour;

	private int pricePerHour;

}
