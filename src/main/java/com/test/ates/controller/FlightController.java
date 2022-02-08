package com.test.ates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ates.DTO.FlightDTO;
import com.test.ates.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	FlightService flightService;
	
	@PostMapping("/new")
	public ResponseEntity<FlightDTO> newFlight(@RequestBody FlightDTO flightDTO){
		return new ResponseEntity<FlightDTO>(flightService.newFlight(flightDTO),HttpStatus.OK);
	}
}
