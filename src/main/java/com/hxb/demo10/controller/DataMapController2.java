package com.hxb.demo10.controller;


import com.google.gson.Gson;
import com.hxb.demo10.bean.DataBean;
import com.hxb.demo10.bean.GraphColumnarBean;
import com.hxb.demo10.handller.GraphHandler;
import com.hxb.demo10.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class DataMapController2 {
    @Autowired
    private DataService dataService;

    @GetMapping("/ToGWYQ")
    public String list(Model model) {
        List<DataBean> dataList = this.dataService.list2();
        List<DataBean> dataList2 = this.dataService.list2();
        List<DataBean> dataList3 = dataService.list5();
        model.addAttribute("data", dataList.get(0));
        model.addAttribute("china", dataList3.get(0).getConfirm());
        model.addAttribute("datalist", dataList);
        dataList2.sort((x, y) -> Double.compare(y.getNowConfirm(), x.getNowConfirm()));
        model.addAttribute("datalist2", dataList2);


        //境外排序

        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> nameList2 = new ArrayList<>();
        ArrayList<Integer> AbroadList = new ArrayList<>();
        ArrayList<Integer> ConfirmAddList = new ArrayList<>();
        ArrayList<Integer> DeadList = new ArrayList<>();
        for (int i = 2; i < 16; i++) {
            DataBean dataBean = dataList2.get(i);
            GraphColumnarBean bean = new GraphColumnarBean();
            bean.setArea(dataBean.getArea());
            bean.setFromAbroad((int) dataBean.getNowConfirm());
            nameList.add(bean.getArea());
            AbroadList.add(bean.getFromAbroad());
            ConfirmAddList.add(dataBean.getConfirm());
            DeadList.add(dataBean.getDead());
        }

        model.addAttribute("nameList", new Gson().toJson(nameList));
        model.addAttribute("fromAbroadList", new Gson().toJson(AbroadList));

        model.addAttribute("nameList1", nameList);
        model.addAttribute("ConfirmList", ConfirmAddList);



       model.addAttribute("deadList",new Gson().toJson(DeadList));
        return "GWYQTU";

    }


}
