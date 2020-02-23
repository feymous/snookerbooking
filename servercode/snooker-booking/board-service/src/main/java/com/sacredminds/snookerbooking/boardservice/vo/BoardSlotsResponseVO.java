package com.sacredminds.snookerbooking.boardservice.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@JsonRootName(value = "")
@Data
public class BoardSlotsResponseVO {

	private long boardId;
	private String name;
	private String description;
	private long parlourId;
	private BoardTypeVO boardType;
	private long pricePerHour;
	private List<BoardSlotsVO> boardSlots;

}
