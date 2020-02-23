package com.sacredminds.snookerbooking.boardservice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sacredminds.snookerbooking.boardservice.exceptionhandler.BoardServiceException;
import com.sacredminds.snookerbooking.boardservice.service.SlotsService;
import com.sacredminds.snookerbooking.boardservice.vo.BoardSlotsResponseVO;
import com.sacredminds.snookerbooking.boardservice.vo.SlotRequestVO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/slots")
public class SlotsController {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	SlotsService slotsService;

	@Autowired
	public SlotsController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}
	
	@ApiOperation(value = "/",notes = "Creates Interview slots for given date", produces = "application/json")
	@PostMapping(value = "/", consumes = { "application/json", "application/xml" })
	public ResponseEntity<BoardSlotsResponseVO> createSlots(
			@ApiParam(value = "Request payload to create Slots", required = true) @Valid @RequestBody SlotRequestVO slotRequestVO) throws BoardServiceException {
		BoardSlotsResponseVO slots = slotsService.createSlots(slotRequestVO);
		return new ResponseEntity<>(slots, HttpStatus.OK);
	}
}
