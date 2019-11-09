package com.sacredminds.snookerbooking.listofvalues.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sacredminds.snookerbooking.listofvalues.service.ListOfValuesService;
import com.sacredminds.snookerbooking.listofvalues.vo.Cities;

@RestController
@RequestMapping("/api/lovs/")
public class ListOfValuesController {

	private static final Logger log = LoggerFactory.getLogger(ListOfValuesController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	ListOfValuesService listOfValuesService;

	@org.springframework.beans.factory.annotation.Autowired
	public ListOfValuesController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@RequestMapping(value = "/city", produces = { "application/json", "application/xml" }, method = RequestMethod.GET)
	ResponseEntity<Cities> getCities() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {

				Cities cities = listOfValuesService.getCities();
				return new ResponseEntity<Cities>(objectMapper.readValue(
						"[ {\n  \"name\" : \"name\",\n  \"cityId\" : 0\n}, {\n  \"name\" : \"name\",\n  \"cityId\" : 0\n} ]",
						Cities.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Cities>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Cities>(HttpStatus.NOT_IMPLEMENTED);
	}
}
