package com.sacredminds.snookerbooking.boardservice.vo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BoardVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-09T09:56:04.132Z[GMT]")
public class BoardRequestVO {
	@JsonProperty("boardTypeId")
	private Long boardTypeId = null;
	
	@JsonProperty("parlourId")
	private Long parlourId = null;

	@JsonProperty("pricePerHour")
	private Integer pricePerHour = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("photoUrls")
	@Valid
	private List<String> photoUrls = new ArrayList<String>();

	public BoardRequestVO boardTypeId(Long boardTypeId) {
		this.boardTypeId = boardTypeId;
		return this;
	}

	/**
	 * Type of the board
	 * 
	 * @return category
	 **/
	@ApiModelProperty(value = "Type of the board")

	public Long getBoardTypeId() {
		return boardTypeId;
	}

	public void setBoardTypeId(Long boardTypeId) {
		this.boardTypeId = boardTypeId;
	}

	public BoardRequestVO pricePerHour(Integer pricePerHour) {
		this.pricePerHour = pricePerHour;
		return this;
	}

	/**
	 * Get pricePerHour
	 * 
	 * @return pricePerHour
	 **/
	@ApiModelProperty(value = "")

	public Integer getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Integer pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public BoardRequestVO name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(example = "Board1,Board2", required = true, value = "")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BoardRequestVO description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 **/
	@ApiModelProperty(example = "Description about the board", value = "")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BoardRequestVO photoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
		return this;
	}

	public BoardRequestVO addPhotoUrlsItem(String photoUrlsItem) {
		this.photoUrls.add(photoUrlsItem);
		return this;
	}

	/**
	 * Get photoUrls
	 * 
	 * @return photoUrls
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	
	/**
	 * Get ParlourId
	 * 
	 * @return parlourId
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public Long getParlourId() {
		return parlourId;
	}

	public void setParlourId(Long parlourId) {
		this.parlourId = parlourId;
	}

	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BoardVO {\n");

		sb.append("    category: ").append(toIndentedString(boardTypeId)).append("\n");
		sb.append("    pricePerHour: ").append(toIndentedString(pricePerHour)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    parlourId: ").append(toIndentedString(parlourId)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
