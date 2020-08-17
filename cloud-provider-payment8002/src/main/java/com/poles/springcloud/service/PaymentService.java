package com.poles.springcloud.service;

import com.poles.springcloud.entities.Payment;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/3 9:27 上午
*
*********************************************************************
*/
public interface PaymentService {
    public int insert(Payment payment);
    public Payment getPaymentById(Long id);
}
