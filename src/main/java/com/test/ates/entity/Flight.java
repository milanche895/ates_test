package com.test.ates.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "flight_number")
	private Integer flightNumber;
	
	@Column(name = "departure_airport")
	private String departureAirportIATACode;
	
	@Column(name = "arrival_airport")
	private String arrivalAirportIATACode;
	
	@Column(name = "departure_date")
	private Timestamp departureDate;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureAirportIATACode() {
		return departureAirportIATACode;
	}

	public void setDepartureAirportIATACode(String departureAirportIATACode) {
		this.departureAirportIATACode = departureAirportIATACode;
	}

	public String getArrivalAirportIATACode() {
		return arrivalAirportIATACode;
	}

	public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
		this.arrivalAirportIATACode = arrivalAirportIATACode;
	}

	public Timestamp getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}
	
}
