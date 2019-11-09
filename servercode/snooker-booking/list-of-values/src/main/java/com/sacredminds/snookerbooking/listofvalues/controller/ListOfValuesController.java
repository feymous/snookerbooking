package com.sacredminds.snookerbooking.listofvalues.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sacredminds.snookerbooking.listofvalues.vo.Cities;

@RestController
@RequestMapping("/api/parlour")
public class ListOfValuesController {

	private static final Logger log = LoggerFactory.getLogger(ListOfValuesController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public ListOfValuesController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<List<Cities>> findCities() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Cities>>(objectMapper.readValue(
						"[ [ {\n  \"name\" : \"name\",\n  \"cityId\" : 0\n}, {\n  \"name\" : \"name\",\n  \"cityId\" : 0\n} ], [ {\n  \"name\" : \"name\",\n  \"cityId\" : 0\n}, {\n  \"name\" : \"name\",\n  \"cityId\" : 0\n} ] ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Cities>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Cities>>(HttpStatus.NOT_IMPLEMENTED);
	}
}
