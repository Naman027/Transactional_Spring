package com.example.flighttransactional.util;

import com.example.flighttransactional.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private static Map<String,Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1", 12000.0);
        paymentMap.put("acc2",30000.0);
        paymentMap.put("acc3",500.0);
        paymentMap.put("acc4",700.0);
    }

    public static boolean validateCreditLimit(String accNo, double paidAmount){
        if(paidAmount>paymentMap.get(accNo)){
            throw new InsufficientAmountException("Amount is less in your account");
        }
        return true;
    }

}
