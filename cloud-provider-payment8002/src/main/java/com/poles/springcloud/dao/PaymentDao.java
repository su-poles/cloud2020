package com.poles.springcloud.dao;

import com.poles.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/3 9:28 上午
*
*********************************************************************
*/
@Mapper
public interface PaymentDao {
    public int insert(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
