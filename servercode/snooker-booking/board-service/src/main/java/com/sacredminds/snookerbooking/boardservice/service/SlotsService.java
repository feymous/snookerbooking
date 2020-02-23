package com.sacredminds.snookerbooking.boardservice.service;

import javax.validation.Valid;

import com.sacredminds.snookerbooking.boardservice.exceptionhandler.BoardServiceException;
import com.sacredminds.snookerbooking.boardservice.vo.BoardSlotsResponseVO;
import com.sacredminds.snookerbooking.boardservice.vo.SlotRequestVO;

public interface SlotsService {

	BoardSlotsResponseVO createSlots(@Valid SlotRequestVO slotRequestVO) throws BoardServiceException;
	
}
