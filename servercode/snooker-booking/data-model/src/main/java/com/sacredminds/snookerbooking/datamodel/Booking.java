package com.sacredminds.snookerbooking.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Booking extends DateAudit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6632281216267666289L;

	@Id
	@GeneratedValue(generator = "booking-sequence-generator")
    @GenericGenerator(
      name = "booking-sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "booking_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	private long bookingId;

	// bi-directional many-to-one association to Requisition
	@ManyToOne
	@JoinColumn(name = "player")
	private Player player;

	// bi-directional many-to-one association to Requisition
	@OneToOne
	@JoinColumn(name = "slot")
	private Slot slot;

}
