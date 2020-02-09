package com.sacredminds.snookerbooking.boardservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "boardTypeId", "boardTypeName", "description" })
public class BoardTypeVO {

	@JsonProperty("boardTypeId")
	private Integer boardTypeId;
	@JsonProperty("boardTypeName")
	private String boardTypeName;
	@JsonProperty("description")
	private Object description;

	@JsonProperty("boardTypeId")
	public Integer getBoardTypeId() {
		return boardTypeId;
	}

	@JsonProperty("boardTypeId")
	public void setBoardTypeId(Integer boardTypeId) {
		this.boardTypeId = boardTypeId;
	}

	@JsonProperty("boardTypeName")
	public String getBoardTypeName() {
		return boardTypeName;
	}

	@JsonProperty("boardTypeName")
	public void setBoardTypeName(String boardTypeName) {
		this.boardTypeName = boardTypeName;
	}

	@JsonProperty("description")
	public Object getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(Object description) {
		this.description = description;
	}

}