package com.sacredminds.snookerbooking.parlourservice.vo;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * LocationRequestVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-09T09:56:04.132Z[GMT]")
public class LocationRequestVO {
	@JsonProperty("locationId")
	private Long locationId = null;

	@JsonProperty("addressLine1")
	private String addressLine1 = null;

	@JsonProperty("addressLine2")
	private String addressLine2 = null;

	@JsonProperty("city")
	private long city = 0;

	@JsonProperty("state")
	private String state = null;

	@JsonProperty("gps")
	private GPS gps = null;

	public LocationRequestVO locationId(Long locationId) {
		this.locationId = locationId;
		return this;
	}

	/**
	 * Get locationId
	 * 
	 * @return locationId
	 **/
	@ApiModelProperty(required = true, value = "")
	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public LocationRequestVO addressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	/**
	 * Get addressLine1
	 * 
	 * @return addressLine1
	 **/
	@ApiModelProperty(value = "")

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public LocationRequestVO addressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	/**
	 * Get addressLine2
	 * 
	 * @return addressLine2
	 **/
	@ApiModelProperty(value = "")

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public LocationRequestVO city(long city) {
		this.city = city;
		return this;
	}

	/**
	 * Get city
	 * 
	 * @return city
	 **/
	@ApiModelProperty(value = "")

	public long getCity() {
		return city;
	}

	public void setCityName(long city) {
		this.city = city;
	}

	public LocationRequestVO state(String state) {
		this.state = state;
		return this;
	}

	/**
	 * Get state
	 * 
	 * @return state
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LocationRequestVO gps(GPS gps) {
		this.gps = gps;
		return this;
	}

	/**
	 * Get gps
	 * 
	 * @return gps
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid
	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LocationRequestVO LocationRequestVO = (LocationRequestVO) o;
		return Objects.equals(this.locationId, LocationRequestVO.locationId)
				&& Objects.equals(this.addressLine1, LocationRequestVO.addressLine1)
				&& Objects.equals(this.addressLine2, LocationRequestVO.addressLine2)
				&& Objects.equals(this.city, LocationRequestVO.city) && Objects.equals(this.state, LocationRequestVO.state)
				&& Objects.equals(this.gps, LocationRequestVO.gps);
	}

	@Override
	public int hashCode() {
		return Objects.hash(locationId, addressLine1, addressLine2, city, state, gps);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class LocationRequestVO {\n");

		sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
		sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
		sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
		sb.append("    city: ").append(toIndentedString(city)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
		sb.append("    gps: ").append(toIndentedString(gps)).append("\n");
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
