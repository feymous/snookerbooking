package com.sacredminds.snookerbooking.parlourservice.vo;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * LocationResponseVO
 */
@Validated
@Data
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-09T09:56:04.132Z[GMT]")
public class LocationResponseVO {
	@JsonProperty("locationId")
	private Long locationId = null;

	@JsonProperty("addressLine1")
	private String addressLine1 = null;

	@JsonProperty("addressLine2")
	private String addressLine2 = null;

	@JsonProperty("city")
	private String cityName = null;

	@JsonProperty("state")
	private String state = null;

	@JsonProperty("gps")
	private GPS gps = null;

}
