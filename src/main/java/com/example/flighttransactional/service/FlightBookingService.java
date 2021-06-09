package com.example.flighttransactional.service;

import com.example.flighttransactional.dto.FlightBookingAcknowledgement;
import com.example.flighttransactional.dto.FlightBookingRequest;
import com.example.flighttransactional.entity.PassengerInfo;
import com.example.flighttransactional.entity.PaymentInfo;
import com.example.flighttransactional.exception.InsufficientAmountException;
import com.example.flighttransactional.repository.PassengerInfoRepository;
import com.example.flighttransactional.repository.PaymentInfoRepository;
import com.example.flighttransactional.util.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired private PassengerInfoRepository passengerInfoRepository;
    @Autowired private PaymentInfoRepository paymentInfoRepository;

    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = InsufficientAmountException.class)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest flightBookingRequest){
        FlightBookingAcknowledgement flightBookingAcknowledgement = new FlightBookingAcknowledgement();
        PassengerInfo passengerInfo = flightBookingRequest.getPassengerInfo();
        passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);
    }

}
