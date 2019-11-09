package com.sacredminds.snookerbooking.parlourservice.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.Tag;

/**
 * ParlourRequestVO
 */
@Validated
public class ParlourRequestVO {
	@JsonProperty("parlourName")
	private String parlourName = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("mailId")
	private String mailId = null;

	@JsonProperty("phoneNo")
	private String phoneNo = null;

	@JsonProperty("location")
	private LocationVO location = null;

	@JsonProperty("owner")
	private OwnerVO owner = null;

	@JsonProperty("boards")
	@Valid
	private List<BoardVO> boards = null;

	@JsonProperty("tags")
	@Valid
	private List<Tag> tags = null;

	public ParlourRequestVO parlourName(String parlourName) {
		this.parlourName = parlourName;
		return this;
	}

	/**
	 * Get parlourName
	 * 
	 * @return parlourName
	 **/
	@ApiModelProperty(example = "Frames Parlour,Snooker Den", value = "")

	public String getParlourName() {
		return parlourName;
	}

	public void setParlourName(String parlourName) {
		this.parlourName = parlourName;
	}

	public ParlourRequestVO description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 **/
	@ApiModelProperty(example = "Parlour description", value = "")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ParlourRequestVO mailId(String mailId) {
		this.mailId = mailId;
		return this;
	}

	/**
	 * Get mailId
	 * 
	 * @return mailId
	 **/
	@ApiModelProperty(value = "")

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public ParlourRequestVO phoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
		return this;
	}

	/**
	 * Get phoneNo
	 * 
	 * @return phoneNo
	 **/
	@ApiModelProperty(value = "")

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public ParlourRequestVO location(LocationVO location) {
		this.location = location;
		return this;
	}

	/**
	 * Get location
	 * 
	 * @return location
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public LocationVO getLocation() {
		return location;
	}

	public void setLocation(LocationVO location) {
		this.location = location;
	}

	public ParlourRequestVO owner(OwnerVO owner) {
		this.owner = owner;
		return this;
	}

	/**
	 * Get owner
	 * 
	 * @return owner
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public OwnerVO getOwner() {
		return owner;
	}

	public void setOwner(OwnerVO owner) {
		this.owner = owner;
	}

	public ParlourRequestVO boards(List<BoardVO> boards) {
		this.boards = boards;
		return this;
	}

	public ParlourRequestVO addBoardsItem(BoardVO boardsItem) {
		if (this.boards == null) {
			this.boards = new ArrayList<BoardVO>();
		}
		this.boards.add(boardsItem);
		return this;
	}

	/**
	 * Get boards
	 * 
	 * @return boards
	 **/
	@ApiModelProperty(value = "")
	@Valid
	public List<BoardVO> getBoards() {
		return boards;
	}

	public void setBoards(List<BoardVO> boards) {
		this.boards = boards;
	}

	public ParlourRequestVO tags(List<Tag> tags) {
		this.tags = tags;
		return this;
	}

	public ParlourRequestVO addTagsItem(Tag tagsItem) {
		if (this.tags == null) {
			this.tags = new ArrayList<Tag>();
		}
		this.tags.add(tagsItem);
		return this;
	}

	/**
	 * Get tags
	 * 
	 * @return tags
	 **/
	@ApiModelProperty(value = "")
	@Valid
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ParlourRequestVO parlourVO = (ParlourRequestVO) o;
		return Objects.equals(this.parlourName, parlourVO.parlourName)
				&& Objects.equals(this.description, parlourVO.description)
				&& Objects.equals(this.mailId, parlourVO.mailId) && Objects.equals(this.phoneNo, parlourVO.phoneNo)
				&& Objects.equals(this.location, parlourVO.location) && Objects.equals(this.owner, parlourVO.owner)
				&& Objects.equals(this.boards, parlourVO.boards) && Objects.equals(this.tags, parlourVO.tags);
	}

	@Override
	public int hashCode() {
		return Objects.hash(parlourName, description, mailId, phoneNo, location, owner, boards, tags);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ParlourVO {\n");

		sb.append("    parlourName: ").append(toIndentedString(parlourName)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    mailId: ").append(toIndentedString(mailId)).append("\n");
		sb.append("    phoneNo: ").append(toIndentedString(phoneNo)).append("\n");
		sb.append("    location: ").append(toIndentedString(location)).append("\n");
		sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
		sb.append("    boards: ").append(toIndentedString(boards)).append("\n");
		sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
