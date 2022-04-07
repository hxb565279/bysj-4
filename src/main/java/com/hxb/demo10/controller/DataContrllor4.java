package com.hxb.demo10.controller;


import com.hxb.demo10.bean.IDBean;
import com.hxb.demo10.bean.USABean;
import com.hxb.demo10.handller.DataHandler2;
import com.hxb.demo10.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DataContrllor4 {
    @Autowired
    private DataHandler2 dataHandler2;
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/toTest")
    public String totest() {
        List<USABean> idBeans = this.dataService.list6();
        System.out.println(idBeans);

        return "main";
    }


}
