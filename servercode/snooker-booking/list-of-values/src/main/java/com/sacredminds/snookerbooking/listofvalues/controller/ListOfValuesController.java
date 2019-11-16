package com.sacredminds.snookerbooking.listofvalues.controller;

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

	private final HttpServletRequest request;

	@Autowired
	ListOfValuesService listOfValuesService;

	@org.springframework.beans.factory.annotation.Autowired
	public ListOfValuesController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.request = request;
	}

	@RequestMapping(value = "/city", produces = { "application/json", "application/xml" }, method = RequestMethod.GET)
	ResponseEntity<Cities> getCities() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			Cities cities = listOfValuesService.getCities();
			return new ResponseEntity<Cities>(cities, HttpStatus.OK);
		}
		return new ResponseEntity<Cities>(HttpStatus.NOT_IMPLEMENTED);
	}
}
