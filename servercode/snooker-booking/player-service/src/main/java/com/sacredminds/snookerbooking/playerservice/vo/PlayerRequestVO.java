package com.sacredminds.snookerbooking.playerservice.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * PlayerRequestVO
 */
@Validated
@Data
public class PlayerRequestVO {

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

	
}
