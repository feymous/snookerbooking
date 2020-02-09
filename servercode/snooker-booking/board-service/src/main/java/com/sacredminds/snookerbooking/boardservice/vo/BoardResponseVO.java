package com.sacredminds.snookerbooking.boardservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "boardId", "name", "description", "pricePerHour", "parlourId", "boardType" })
public class BoardResponseVO {

	@JsonProperty("boardId")
	private Integer boardId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("pricePerHour")
	private Integer pricePerHour;
	@JsonProperty("boardType")
	private BoardTypeVO boardType;
	@JsonProperty("parlourId")
	private long parlourId;

	@JsonProperty("boardId")
	public Integer getBoardId() {
		return boardId;
	}

	@JsonProperty("boardId")
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("pricePerHour")
	public Integer getPricePerHour() {
		return pricePerHour;
	}

	@JsonProperty("pricePerHour")
	public void setPricePerHour(Integer pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public BoardTypeVO getBoardType() {
		return boardType;
	}

	public void setBoardType(BoardTypeVO boardType) {
		this.boardType = boardType;
	}

	public long getParlourId() {
		return parlourId;
	}

	public void setParlourId(long parlourId) {
		this.parlourId = parlourId;
	}

}