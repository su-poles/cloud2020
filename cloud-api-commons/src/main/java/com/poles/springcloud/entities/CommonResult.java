package com.poles.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/3 9:33 上午
*
*********************************************************************
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String  msg;
    private T       data;

    public CommonResult(int code, String msg){
        this(code, msg, null);
    }
}
