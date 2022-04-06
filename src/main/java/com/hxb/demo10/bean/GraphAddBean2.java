package com.hxb.demo10.bean;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GraphAddBean2 {

    //日期
    private String date;
    //新增确诊人数
    private int addConfirm;
    //疑似确诊人数
    private int addSuspect;
    private int addHeal;
    private int addDead;

}
