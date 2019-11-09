package com.sacredminds.snookerbooking.parlourservice.vo;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BoardVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-09T09:56:04.132Z[GMT]")
public class BoardVO   {
  @JsonProperty("category")
  private Long category = null;

  @JsonProperty("pricePerHour")
  private Integer pricePerHour = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("photoUrls")
  @Valid
  private List<String> photoUrls = new ArrayList<String>();

  public BoardVO category(Long category) {
    this.category = category;
    return this;
  }

  /**
   * Type of the board
   * @return category
  **/
  @ApiModelProperty(value = "Type of the board")
  
    public Long getCategory() {
    return category;
  }

  public void setCategory(Long category) {
    this.category = category;
  }

  public BoardVO pricePerHour(Integer pricePerHour) {
    this.pricePerHour = pricePerHour;
    return this;
  }

  /**
   * Get pricePerHour
   * @return pricePerHour
  **/
  @ApiModelProperty(value = "")
  
    public Integer getPricePerHour() {
    return pricePerHour;
  }

  public void setPricePerHour(Integer pricePerHour) {
    this.pricePerHour = pricePerHour;
  }

  public BoardVO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
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

  public BoardVO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "Description about the board", value = "")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BoardVO photoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
    return this;
  }

  public BoardVO addPhotoUrlsItem(String photoUrlsItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BoardVO boardVO = (BoardVO) o;
    return Objects.equals(this.category, boardVO.category) &&
        Objects.equals(this.pricePerHour, boardVO.pricePerHour) &&
        Objects.equals(this.name, boardVO.name) &&
        Objects.equals(this.description, boardVO.description) &&
        Objects.equals(this.photoUrls, boardVO.photoUrls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, pricePerHour, name, description, photoUrls);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BoardVO {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    pricePerHour: ").append(toIndentedString(pricePerHour)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
