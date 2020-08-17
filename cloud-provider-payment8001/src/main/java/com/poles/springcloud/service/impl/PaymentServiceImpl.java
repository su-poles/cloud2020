package com.poles.springcloud.service.impl;

import com.poles.springcloud.dao.PaymentDao;
import com.poles.springcloud.entities.Payment;
import com.poles.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/3 9:27 上午
*
*********************************************************************
*/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;

    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
