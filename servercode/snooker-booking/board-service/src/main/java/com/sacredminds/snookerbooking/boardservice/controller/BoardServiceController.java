package com.sacredminds.snookerbooking.boardservice.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sacredminds.snookerbooking.boardservice.service.BoardService;
import com.sacredminds.snookerbooking.boardservice.vo.BoardRequestVO;
import com.sacredminds.snookerbooking.boardservice.vo.BoardResponseVO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/board")
public class BoardServiceController {

	private static final Logger log = LoggerFactory.getLogger(BoardServiceController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	BoardService boardService;

	@Autowired
	public BoardServiceController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@ApiOperation(value = "/parlour/{parlourId}")
	@GetMapping(value = "/parlour/{parlourId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<BoardResponseVO>> findBoardByParlourId(
			@NotNull @ApiParam(value = "unique id of the parlour", required = true) @Valid @PathVariable(value = "parlourId", required = true) Long parlourId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<>(boardService.findBoardsByParlourId(parlourId), HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "/board-type/{boardTypeId}")
	@GetMapping(value = "/board-type/{boardTypeId}", consumes = { "application/json" }, produces = { "application/json",
			"application/xml" })
	public ResponseEntity<List<BoardResponseVO>> findBoardByBoardTypeId(
			@NotNull @ApiParam(value = "unique id of the boardType", required = true) @Valid @PathVariable(value = "boardTypeId", required = true) Long boardTypeId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<>(boardService.findBoardsByBoardType(boardTypeId), HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "/")
	@PostMapping(value = "/", consumes = { "application/json", "application/xml" })
	public ResponseEntity<List<BoardResponseVO>> addParlour(
			@ApiParam(value = "Creation of Board", required = true) @Valid @RequestBody List<BoardRequestVO> boardRequests) {
		List<BoardResponseVO> parlourResponseVO = boardService.addBoard(boardRequests);
		return new ResponseEntity<>(parlourResponseVO, HttpStatus.OK);
	}

}
