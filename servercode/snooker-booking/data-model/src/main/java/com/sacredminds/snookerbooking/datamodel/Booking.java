package com.sacredminds.snookerbooking.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Booking extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long bookingId;

	// bi-directional many-to-one association to Requisition
	@ManyToOne
	@JoinColumn
	private Player player;

	// bi-directional many-to-one association to Requisition
	@OneToOne
	@JoinColumn
	private Slot slot;

}
