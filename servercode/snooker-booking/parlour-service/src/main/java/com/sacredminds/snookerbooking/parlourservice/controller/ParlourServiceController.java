package com.sacredminds.snookerbooking.parlourservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sacredminds.snookerbooking.parlourservice.service.ParlourService;
import com.sacredminds.snookerbooking.parlourservice.vo.ParlourRequestVO;
import com.sacredminds.snookerbooking.parlourservice.vo.ParlourResponseVO;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/parlour")
public class ParlourServiceController {

	private static final Logger log = LoggerFactory.getLogger(ParlourServiceController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	ParlourService parlourService;

	@Autowired
	public ParlourServiceController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<ParlourResponseVO> addParlour(
			@ApiParam(value = "Creation of Parlour", required = true) @Valid @RequestBody ParlourRequestVO body) {
		String accept = request.getHeader("Accept");
		ParlourResponseVO parlourResponseVO = parlourService.addParlour(body);
		return new ResponseEntity<ParlourResponseVO>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<ParlourResponseVO>> findParloursByCity(
			@NotNull @ApiParam(value = "Id of the city which users selects as their location", required = true) @Valid @RequestParam(value = "cityId", required = true) Long cityId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				List<ParlourResponseVO> parlourResponseVOs = new ArrayList<>();
				parlourResponseVOs = parlourService.findParlourByCity(cityId);
				return new ResponseEntity<List<ParlourResponseVO>>(parlourResponseVOs, HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<ParlourResponseVO>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<List<ParlourResponseVO>>(HttpStatus.NOT_IMPLEMENTED);

	}
}
