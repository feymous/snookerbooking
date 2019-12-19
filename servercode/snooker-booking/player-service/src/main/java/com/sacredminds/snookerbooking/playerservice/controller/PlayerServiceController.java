package com.sacredminds.snookerbooking.playerservice.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sacredminds.snookerbooking.playerservice.service.PlayerService;
import com.sacredminds.snookerbooking.playerservice.vo.ParlourRequestVO;
import com.sacredminds.snookerbooking.playerservice.vo.ParlourResponseVO;
import com.sacredminds.snookerbooking.playerservice.vo.PlayerRequestVO;
import com.sacredminds.snookerbooking.playerservice.vo.PlayerResponseVO;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/player")
public class PlayerServiceController {

	private static final Logger log = LoggerFactory.getLogger(PlayerServiceController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	PlayerService playerService;

	@Autowired
	public PlayerServiceController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@PostMapping(value = "/", consumes = { "application/json", "application/xml" })
	public ResponseEntity<PlayerResponseVO> addPlayer(
			@ApiParam(value = "Creation of Parlour", required = true) @Valid @RequestBody PlayerRequestVO body) {
		PlayerResponseVO playerResponseVO = playerService.addPlayer(body);
		return new ResponseEntity<PlayerResponseVO>(playerResponseVO, HttpStatus.OK);
	}

	@GetMapping(value = "/player/{playerName}/{password}", produces = { "application/json", "application/xml" })
	public ResponseEntity<PlayerResponseVO> findPlayerByLogin(
			@NotNull @ApiParam(value = "Name of the user", required = true) @Valid @RequestParam(value = "playerName", required = true) String playerName,
			@NotNull @ApiParam(value = "Password for the user", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				parlourResponseVOs = playerService.findByUsrAndPwd(playerName,password);
				return new ResponseEntity<PlayerResponseVO>(playerResponseVO, HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<PlayerResponseVO>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<PlayerResponseVO>(HttpStatus.NOT_IMPLEMENTED);
	}

	
	@GetMapping(value = "/store/order/{orderId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<PlayerResponseVO> findPlayerByLogin(
			@NotNull @ApiParam(value = "Id for the order", required = true) @Valid @RequestParam(value = "orderId", required = true) Long orderId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				parlourResponseVOs = playerService.findByUsrAndPwd(playerName,password);
				return new ResponseEntity<PlayerResponseVO>(playerResponseVO, HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<PlayerResponseVO>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<PlayerResponseVO>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	
	
	
}
