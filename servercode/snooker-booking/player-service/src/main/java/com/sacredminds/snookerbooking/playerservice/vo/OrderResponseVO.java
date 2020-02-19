package com.sacredminds.snookerbooking.playerservice.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * OrderResponseVO
 */
@Validated
@Data
public class OrderResponseVO {
	
	
	@JsonProperty("orderId")
	private Long orderId = null;

	@JsonProperty("boardId")
	private Long boardId = null;

	@JsonProperty("quantity")
	private Long quantity = null;

	@JsonProperty("shipDate")
	private Date shipDate = null;

	@NotNull(message = "Status of the order has not been provided")
	@JsonProperty("status")
	private String status = null;
	
	@NotNull(message = "Complete or not has not been provided")
	@JsonProperty("password")
	private Boolean complete = false;

}
