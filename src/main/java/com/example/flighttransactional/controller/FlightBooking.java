package com.example.flighttransactional.controller;

import com.example.flighttransactional.dto.FlightBookingAcknowledgement;
import com.example.flighttransactional.dto.FlightBookingRequest;
import com.example.flighttransactional.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableTransactionManagement
public class FlightBooking {
    @Autowired private FlightBookingService flightBookingService;

    @RequestMapping(method = RequestMethod.POST, value = "/bookFlightTicket")
    public FlightBookingAcknowledgement boolFlightTicket(@RequestBody FlightBookingRequest flightBookingRequest){
        return flightBookingService.bookFlightTicket(flightBookingRequest);
    }

}
