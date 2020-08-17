package com.poles.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/3 9:19 上午
*
*********************************************************************
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
