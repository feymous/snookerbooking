package com.sacredminds.snookerbooking.parlourservice.vo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.models.Tag;
import lombok.Data;

/**
 * Parlour
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-09T09:56:04.132Z[GMT]")
@Data
public class ParlourResponseVO {

	@JsonProperty("parlour_id")
	private Long parlourId = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("photoUrls")
	@Valid
	private List<String> photoUrls = new ArrayList<String>();

	@JsonProperty("location")
	private LocationVO location = null;

	@JsonProperty("tags")
	@Valid
	private List<Tag> tags = null;

}
