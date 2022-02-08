package com.test.ates.service.implement;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.test.ates.DTO.FlightDTO;
import com.test.ates.entity.Flight;
import com.test.ates.repository.FlightRepository;
import com.test.ates.service.FlightService;

@Service
public class FlightServiceImplement implements FlightService {

	@Autowired
	FlightRepository flightRepository;
	
	@Override
	public FlightDTO newFlight(FlightDTO flightDTO) {
		
		if (Objects.nonNull(flightDTO.getFlightNumber()) && Objects.nonNull(flightDTO.getArrivalAirportIATACode()) && 
				Objects.nonNull(flightDTO.getDepartureAirportIATACode())) {
			
			Flight flight = new Flight();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			
			flight.setFlightNumber(flightDTO.getFlightNumber());
			flight.setArrivalAirportIATACode(flightDTO.getArrivalAirportIATACode());
			flight.setDepartureAirportIATACode(flightDTO.getDepartureAirportIATACode());
			flight.setDepartureDate(timestamp);
			
			
			flightRepository.save(flight);
			
			flightDTO.setFlightId(flight.getId());
			flightDTO.setDepartureDate(timestamp);
			
			return flightDTO;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Please insert flightNumber, departureAirportIATACode and arrivalAirportIATACode");
		}
	}
}
