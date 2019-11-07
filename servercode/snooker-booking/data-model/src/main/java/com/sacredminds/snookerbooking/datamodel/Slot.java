package com.sacredminds.snookerbooking.datamodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Slot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long slotId;

	private int slotTime;

	private Date slotDate;

	@ManyToOne
	@JoinColumn
	private Board board;

	@ManyToOne
	@JoinColumn
	private SlotStatus slotStatus;

	@OneToOne(mappedBy = "slot")
	@JsonIgnore
	private Booking booking;

}
