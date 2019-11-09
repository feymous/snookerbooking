package com.sacredminds.snookerbooking.parlourservice.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.Tag;

/**
 * Parlour
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-09T09:56:04.132Z[GMT]")
public class ParlourResponseVO   {
	
  @JsonProperty("parlour_id")
  private Long parlourId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("photoUrls")
  @Valid
  private List<String> photoUrls = new ArrayList<String>();

  @JsonProperty("locationId")
  private Long locationId = null;

  @JsonProperty("tags")
  @Valid
  private List<Tag> tags = null;

  /**
   * Parlour status
   */
  public enum StatusEnum {
    OPEN("open"),
    
    CLOSED("closed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  public ParlourResponseVO parlourId(Long parlourId) {
    this.parlourId = parlourId;
    return this;
  }

  /**
   * Get parlourId
   * @return parlourId
  **/
  @ApiModelProperty(value = "")
  
    public Long getParlourId() {
    return parlourId;
  }

  public void setParlourId(Long parlourId) {
    this.parlourId = parlourId;
  }

  public ParlourResponseVO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Frames Parlour,Snooker Den", required = true, value = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ParlourResponseVO photoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
    return this;
  }

  public ParlourResponseVO addPhotoUrlsItem(String photoUrlsItem) {
    this.photoUrls.add(photoUrlsItem);
    return this;
  }

  /**
   * Get photoUrls
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

  public ParlourResponseVO locationId(Long locationId) {
    this.locationId = locationId;
    return this;
  }

  /**
   * Get locationId
   * @return locationId
  **/
  @ApiModelProperty(value = "")
  
    public Long getLocationId() {
    return locationId;
  }

  public void setLocationId(Long locationId) {
    this.locationId = locationId;
  }

  public ParlourResponseVO tags(List<Tag> tags) {
    this.tags = tags;
    return this;
  }

  public ParlourResponseVO addTagsItem(Tag tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<Tag>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Get tags
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

  public ParlourResponseVO status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Parlour status
   * @return status
  **/
  @ApiModelProperty(value = "Parlour status")
  
    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParlourResponseVO parlour = (ParlourResponseVO) o;
    return Objects.equals(this.parlourId, parlour.parlourId) &&
        Objects.equals(this.name, parlour.name) &&
        Objects.equals(this.photoUrls, parlour.photoUrls) &&
        Objects.equals(this.locationId, parlour.locationId) &&
        Objects.equals(this.tags, parlour.tags) &&
        Objects.equals(this.status, parlour.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parlourId, name, photoUrls, locationId, tags, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Parlour {\n");
    
    sb.append("    parlourId: ").append(toIndentedString(parlourId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
