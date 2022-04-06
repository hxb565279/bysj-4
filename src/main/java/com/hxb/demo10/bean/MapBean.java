package com.hxb.demo10.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MapBean {

    //各省名称
    private String name;
    //确诊人数
    private int value;
}