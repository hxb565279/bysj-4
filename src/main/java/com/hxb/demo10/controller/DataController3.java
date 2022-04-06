package com.hxb.demo10.controller;

import com.google.gson.Gson;
import com.hxb.demo10.bean.DataBean;
import com.hxb.demo10.bean.MapBean;
import com.hxb.demo10.service.DataService;
import org.python.modules._sre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class DataController3 {
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/PQMAP")
    public String listPQMAP(Model model){
        List<DataBean> dataList = dataService.list4();
        model.addAttribute("dataList", dataList);
        List<MapBean> result = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            DataBean dataBean = dataList.get(i);
            MapBean mapBean = new MapBean(dataBean.getArea(), dataBean.getNowConfirm());
            result.add(mapBean);

        }


        model.addAttribute("mapData",  new Gson().toJson(result).replace("（金）",""));
        return "test";
    }


    @RequestMapping(value = "/ToGNYQ")
    public String GNYQ(){
        return "GNYQTU";
    }

    @RequestMapping(value = "/ToGWYQ")
    public String GYYQ(){
        return "GWYQTU";
    }




}
