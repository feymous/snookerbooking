package com.sacredminds.snookerbooking.playerservice.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.sacredminds.snookerbooking.playerservice.vo.OrderResponseVO;

public interface OrderService {

	public OrderResponseVO findByOrderId(@NotNull @Valid long orderId);
	
	
}
