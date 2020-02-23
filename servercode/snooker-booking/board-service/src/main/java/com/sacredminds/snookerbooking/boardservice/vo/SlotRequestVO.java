package com.sacredminds.snookerbooking.boardservice.vo;

import java.util.Date;

import lombok.Data;

@Data
public class SlotRequestVO {

	private Date startDate;

	private Date endDate;

	private long boardId;
	
}
