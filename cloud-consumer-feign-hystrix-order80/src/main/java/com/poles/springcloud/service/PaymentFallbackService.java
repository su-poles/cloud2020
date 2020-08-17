package com.poles.springcloud.service;

import org.springframework.stereotype.Component;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/11 3:50 下午
 * 1. 最开始时，Controller调用PaymentHystrixService接口，通过Feign直接调用8001的接口来实现业务调用
 * 2. 我们加入Hystrix，为80服务的Controller增加了降级方法，由最开始的每个方法指定降级方法到后来指定一个默认的全局降级方法
 * 3. 由于PaymentHystrixService接口包含了所有的业务处理方法，不妨直接对PaymentHystrixService下来来做降级操作
 * 4. 降级的方式为：
 *      4.1 创建PaymentFallbackService类，实现PaymentHystrixService接口
 *      4.2 然后实现PaymentHystrixService接口里所有的方法，这里的方法将作为接口里定义的业务方法的的降级方法
 *          即，PaymentHystrixService接口如果正常请求，则正常返回，如果超时或者异常则执行本类中的降级方法，
 *          这一切是由PaymentHystrixServic接口类中的@Feign注解来控制，请查看@Feign之类
 *      4.3 给PaymentHystrixService类的注解@FeignClient增加一个属性，改为下面的：
 *          @FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE", fallback = PaymentFallbackService.class)
 *      4.4 以上就是给service做降级，至于controller降级跟service降级是两回事，根据需要各自搞。
*********************************************************************
*/
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentOk(Integer id) {
        return "8001服务应该是挂了或者没起起来，PaymentFallbackService#paymentOk#fallback, id = " + id + ", ThreadName:" + Thread.currentThread().getName();
    }

    @Override
    public String paymentTiemout(Integer id) {
        return "8001服务挂了？异常？超时？反正不能服务了！PaymentFallbackService#paymentTiemout#fallback, id = " + id + ", ThreadName:" + Thread.currentThread().getName();
    }
}
