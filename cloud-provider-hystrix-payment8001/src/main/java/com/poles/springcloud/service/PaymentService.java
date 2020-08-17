package com.poles.springcloud.service;

/**
 * @ClassName PaymentService
 * @version: 1.0.0
 * @author: liyanlong
 * @date: 2020/8/10 3:20 下午
 */
public interface PaymentService {

    /**
     * 定义一个能正常执行的方法
     */
    String paymentInfoOk(Integer id);

    /**
     * 定义一个执行超时的方法
     */
    String paymentInfoTimeOut(Integer id);

    /**
     * 定义一个抛出异常的方法
     */
    String paymentInfoExpcetion(Integer id);

    String paymentCircuitBreaker(Integer id);
}
