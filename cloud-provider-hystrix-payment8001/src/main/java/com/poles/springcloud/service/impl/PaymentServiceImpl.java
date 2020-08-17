package com.poles.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.poles.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/10 3:20 下午
*
*********************************************************************
*/
@Service
public class PaymentServiceImpl implements PaymentService {

    //=======================================服务降级start===========================
    @Override
    public String paymentInfoOk(Integer id) {
        return "paymentInfoOk::线程名：" + Thread.currentThread().getName() + ", ID：" + id ;
    }

    @Override
    //当方法异常或者xxx时，要做降级处理
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallBack", commandProperties = {
            //表示3秒以内属于正常，超过3秒直接抛异常
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="5000")
    })
    public String paymentInfoTimeOut(Integer id) {
        //异常或者超时，都会进入降级
//        return paymentInfoExpcetion(id);
        long timeout = 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "paymentInfoTimeOut::线程名：" + Thread.currentThread().getName() + ", ID：" + id + ", 耗时：" + timeout + "秒";
    }

    public String paymentInfoTimeOutFallBack(Integer id){
        return "paymentInfoTimeOutFallBack::" + Thread.currentThread().getName() + "，ID：" + id + ", 系统忙，请稍后再试！";
    }

    @Override
    public String paymentInfoExpcetion(Integer id) {
       int  c = 1/0;
        return "";
    }
    //=======================================服务降级end===========================

    //=======================================服务熔断start===========================
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            //这些属性可以在类HystrixCommandProperties里查看默认值或者复制到这里设置值
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),   //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),   //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),   //失败率
            //上面的意思是，先启动熔断器，当10000毫秒内的10次请求中有6次或6次以上失败（达到60%）时，触发熔断器
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("*******id不能为负数");
        }

        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t调用成功，流水号：" + uuid;
    }

    /**
     * 本方法是一个降级方法。
     *
     * 当请求URL1：http://localhost:8001/payment/circuit/1 时，正常响应
     * 当请求URL2：http://localhost:8001/payment/circuit/-1 时，进入降级方法
     * 当段时间多次URL2（符合熔断器的条件，即10秒内有10次请求中6此时失败的）时，触发熔断器，此时访问URL1也不能正常响应，此时熔断器处于半开状态（half-open）
     * 当过了一会儿（默认5秒）有不满熔断器的条件时，熔断器会尝试恢复调用链路，即释放部分请求，如果还是满足熔断器的条件，则重新回归第前一步，如果不满足熔断条件，则恢复正常的调用链路。
     *
     *
     * 测试效果：狂点：http://localhost:8001/payment/circuit/-1
     * 然后多次访问：http://localhost:8001/payment/circuit/1时发现也是进入降级服务的，继续点击，等一会儿之后又会恢复正常
     */
    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试~！~~~~~";
    }
    //=======================================服务熔断start===========================

}
