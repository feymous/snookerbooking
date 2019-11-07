package com.sacredminds.snookerbooking.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class BoardType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long boardTypeId;

	private String boardTypeName;

	private String description;
}
