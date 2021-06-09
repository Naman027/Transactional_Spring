package com.example.flighttransactional.repository;

import com.example.flighttransactional.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {

}
