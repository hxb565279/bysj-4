package com.hxb.demo10.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class USABean {

    private int id;
    private double confirm;
    private double dead;
    private double heal;
    private Date date;
}
