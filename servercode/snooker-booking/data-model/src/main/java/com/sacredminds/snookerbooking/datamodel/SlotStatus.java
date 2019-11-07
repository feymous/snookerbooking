package com.sacredminds.snookerbooking.datamodel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class SlotStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long slotStatusId;

	private String statuscode;
	
	@OneToMany(mappedBy="slotStatus")
	private List<Slot> slots;
}
