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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Slot {

	@Id
	@GeneratedValue(generator = "slot-sequence-generator")
    @GenericGenerator(
      name = "slot-sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "slot_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	@Column
	private long slotId;

	private int slotTime;

	private Date slotDate;

	@ManyToOne
	@JoinColumn
	private Board board;

	@ManyToOne
	@JoinColumn(name = "slot_status")
	private SlotStatus slotStatus;

	@OneToOne(mappedBy = "slot")
	@JsonIgnore
	private Booking booking;

}
