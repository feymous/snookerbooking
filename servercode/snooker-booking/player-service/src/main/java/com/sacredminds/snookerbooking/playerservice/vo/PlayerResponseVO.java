package com.sacredminds.snookerbooking.playerservice.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * PlayerRequestVO
 */
@Validated
public class PlayerResponseVO {
	
	
	@JsonProperty("parlour_id")
	private Long parlourId = null;

	@JsonProperty("firstName")
	private String firstName = null;

	@JsonProperty("lastName")
	private String lastName = null;

	@JsonProperty("email")
	private String email = null;

	@NotNull(message = "Player Phone number has not been provided")
	@JsonProperty("phoneNo")
	private String phoneNo = null;
	
	@NotNull(message = "Player Password has not been provided")
	@JsonProperty("password")
	private String password	 = null;

	public Long getParlourId() {
		return parlourId;
	}

	public void setParlourId(Long parlourId) {
		this.parlourId = parlourId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
