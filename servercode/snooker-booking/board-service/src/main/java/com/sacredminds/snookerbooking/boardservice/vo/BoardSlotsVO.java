package com.sacredminds.snookerbooking.boardservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "slotId", "start", "end" })
@Data
public class BoardSlotsVO {

	@JsonProperty("slotId")
	private long slotId;
	@JsonProperty("start")
	private String start;
	@JsonProperty("end")
	private String end;

}