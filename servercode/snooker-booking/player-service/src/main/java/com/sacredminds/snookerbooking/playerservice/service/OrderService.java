package com.sacredminds.snookerbooking.playerservice.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;

import com.sacredminds.snookerbooking.playerservice.vo.OrderResponseVO;
import com.sacredminds.snookerbooking.playerservice.vo.ParlourRequestVO;
import com.sacredminds.snookerbooking.playerservice.vo.ParlourResponseVO;
import com.sacredminds.snookerbooking.playerservice.vo.PlayerRequestVO;
import com.sacredminds.snookerbooking.playerservice.vo.PlayerResponseVO;

public interface OrderService {

	protected OrderResponseVO findByOrderId(@NotNull @Valid Long orderId);
	
	
}
