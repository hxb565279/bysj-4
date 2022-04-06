package com.hxb.demo10.controller;

import com.google.gson.Gson;
import com.hxb.demo10.bean.*;
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
public class DataMapController {
    @Autowired
    private DataService dataService;

    @GetMapping("/ToGNYQ")
    public String list(Model model) {
        //国内全部
        List<DataBean> dataList = dataService.list5();
        List<DataBean> dataList2 = dataService.list5();
       model.addAttribute("datalist",dataList);
        model.addAttribute("data", dataList.get(0));
        dataList2.sort((x,y)->Double.compare(y.getConfirm(),x.getConfirm()));
       model.addAttribute("datalist2",dataList2);
        List<MapBean> result = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            DataBean dataBean = dataList.get(i);
            MapBean mapBean = new MapBean(dataBean.getArea(), dataBean.getNowConfirm());
            result.add(mapBean);

        }
        model.addAttribute("mapData", new Gson().toJson(result));






        String str = GraphHandler.getData();
        List<GrapMapBean> list  = GraphHandler.getGraphData2(str);
        //  进一步改造数据格式
        //  因为前端需要的数据是  x轴所有数据的数组和y轴所有数据的数组

        ArrayList<String> dateList = new ArrayList<>();
        ArrayList<Integer> nowConfirmList = new ArrayList<>();
        ArrayList<Integer> ConfirmList = new ArrayList<>();
        ArrayList<Integer> deadList = new ArrayList<>();
        ArrayList<Integer> healList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            GrapMapBean graphBean = list.get(i);
            dateList.add(graphBean.getDate());
            nowConfirmList.add(graphBean.getNowConfirm());
            ConfirmList.add(graphBean.getConfirm());
            deadList.add(graphBean.getDead());
            healList.add(graphBean.getHeal());
        }

        model.addAttribute("dateList", new Gson().toJson(dateList));
        model.addAttribute("nowConfirmList", new Gson().toJson(nowConfirmList));
        model.addAttribute("ConfirmList", new Gson().toJson(ConfirmList));
        model.addAttribute("deadList", new Gson().toJson(deadList));
        model.addAttribute("healList", new Gson().toJson(healList));





        List<GraphAddBean2> addList = GraphHandler.getGraphAddData2(str);

        ArrayList<String> addDateList = new ArrayList<>();
        ArrayList<Integer> addConfirmList = new ArrayList<>();
        ArrayList<Integer> addSuspectList = new ArrayList<>();
        ArrayList<Integer> addHealList = new ArrayList<>();
        ArrayList<Integer> addDeadList = new ArrayList<>();
        for (int i = 0; i < addList.size(); i++) {
            GraphAddBean2 graphAddBean = addList.get(i);
            addDateList.add(graphAddBean.getDate());
            addConfirmList.add(graphAddBean.getAddConfirm());
            addSuspectList.add(graphAddBean.getAddSuspect());
            addHealList.add(graphAddBean.getAddHeal());
            addDeadList.add(graphAddBean.getAddDead());
        }

        model.addAttribute("addDateList", new Gson().toJson(addDateList));
        model.addAttribute("addConfirmList", new Gson().toJson(addConfirmList));
        model.addAttribute("addSuspectList", new Gson().toJson(addSuspectList));
        model.addAttribute("addHealList", new Gson().toJson(addHealList));
        model.addAttribute("addDeadList", new Gson().toJson(addDeadList));





        List<GraphPieBean> pieList = GraphHandler.getGraphPieData(str);
        Collections.sort(pieList);
        model.addAttribute("pieList", new Gson().toJson(pieList));





        List<GraphColumnarBean> columnarList = GraphHandler.getGraphColumnarData();
        Collections.sort(columnarList);

        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<Integer> fromAbroadList = new ArrayList<>();

        for (int i = 0; i < 27; i++) {
            GraphColumnarBean bean = columnarList.get(i);
            nameList.add(bean.getArea());
            fromAbroadList.add(bean.getFromAbroad());
        }

        model.addAttribute("nameList", new Gson().toJson(nameList));
        model.addAttribute("fromAbroadList", new Gson().toJson(fromAbroadList));
        return "GNYQTU";
    }



}
