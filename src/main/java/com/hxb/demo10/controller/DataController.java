package com.hxb.demo10.controller;

import com.google.gson.Gson;
import com.hxb.demo10.bean.*;
import com.hxb.demo10.handller.GraphHandler;
import com.hxb.demo10.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.hxb.demo10.bean.GraphAddBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class DataController {
    @Autowired
    private DataService dataService;

    @RequestMapping("/SelectMPQ")
    @ResponseBody
    public String list_select(Model model,String name){
        List<DataBean> dataList = dataService.list3();
        List<DataBean> dataList2 = new ArrayList<>();
        int count=0;
        for ( int i=0;i<dataList.size();i++){
           if(name  ==    dataList.get(i).getArea()){
               dataList2.get(count).setArea(name);
               dataList2.get(count).setConfirm(dataList.get(i).getConfirm());
               dataList2.get(count).setNowConfirm(dataList.get(i).getNowConfirm());
               dataList2.get(count).setDead(dataList.get(i).getDead());
               dataList2.get(count).setHeal(dataList.get(i).getHeal());
               count++;
           }

        }
        model.addAttribute("selectlist",dataList2);

        return "MessagePQ";
    }



    @GetMapping("/MessagePQ")
    public String list(Model model) {
        List<DataBean> dataList = dataService.list3();
        model.addAttribute("dataList", dataList);

        List<MapBean> result = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            DataBean dataBean = dataList.get(i);
            MapBean mapBean = new MapBean(dataBean.getArea(), dataBean.getNowConfirm());
            result.add(mapBean);

        }
        model.addAttribute("mapData", new Gson().toJson(result));

        String str = GraphHandler.getData();
        List<GraphBean> list  = GraphHandler.getGraphData(str);
        //  ???????????????????????????
        //  ??????????????????????????????  x???????????????????????????y????????????????????????

        ArrayList<String> dateList = new ArrayList<>();
        ArrayList<Integer> nowConfirmList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            GraphBean graphBean = list.get(i);
            dateList.add(graphBean.getDate());
            nowConfirmList.add(graphBean.getNowConfirm());
        }

        model.addAttribute("dateList", new Gson().toJson(dateList));
        model.addAttribute("nowConfirmList", new Gson().toJson(nowConfirmList));


        List<GraphAddBean> addList = GraphHandler.getGraphAddData(str);

        ArrayList<String> addDateList = new ArrayList<>();
        ArrayList<Integer> addConfirmList = new ArrayList<>();
        ArrayList<Integer> addSuspectList = new ArrayList<>();

        for (int i = 0; i < addList.size(); i++) {
            GraphAddBean graphAddBean = addList.get(i);
            addDateList.add(graphAddBean.getDate());
            addConfirmList.add(graphAddBean.getAddConfirm());
            addSuspectList.add(graphAddBean.getAddSuspect());
        }

        model.addAttribute("addDateList", new Gson().toJson(addDateList));
        model.addAttribute("addConfirmList", new Gson().toJson(addConfirmList));
        model.addAttribute("addSuspectList", new Gson().toJson(addSuspectList));


        List<GraphPieBean> pieList = GraphHandler.getGraphPieData(str);
        Collections.sort(pieList);
        model.addAttribute("pieList", new Gson().toJson(pieList));

        List<GraphColumnarBean> columnarList = GraphHandler.getGraphColumnarData();
        Collections.sort(columnarList);

        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<Integer> fromAbroadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            GraphColumnarBean bean = columnarList.get(i);
            nameList.add(bean.getArea());
            fromAbroadList.add(bean.getFromAbroad());
        }

        model.addAttribute("nameList", new Gson().toJson(nameList));
        model.addAttribute("fromAbroadList", new Gson().toJson(fromAbroadList));

        return "MessagePQ";
    }


    @GetMapping("/MessagePQ2")
    public String list2(Model model2) {
        List<DataBean> dataList = dataService.list2();
        model2.addAttribute("dataList", dataList);

//        List<MapBean> result = new ArrayList<>();
//        for (int i = 0; i < dataList.size(); i++) {
//            DataBean dataBean = dataList.get(i);
//            MapBean mapBean = new MapBean(dataBean.getArea(), dataBean.getNowConfirm());
//            result.add(mapBean);
//
//        }
//        model.addAttribute("mapData", new Gson().toJson(result));
//
//        String str = GraphHandler.getData();
//        List<GraphBean> list  = GraphHandler.getGraphData(str);
//        //  ???????????????????????????
//        //  ??????????????????????????????  x???????????????????????????y????????????????????????
//
//        ArrayList<String> dateList = new ArrayList<>();
//        ArrayList<Integer> nowConfirmList = new ArrayList<>();
//
//        for (int i = 0; i < list.size(); i++) {
//            GraphBean graphBean = list.get(i);
//            dateList.add(graphBean.getDate());
//            nowConfirmList.add(graphBean.getNowConfirm());
//        }
//
//        model.addAttribute("dateList", new Gson().toJson(dateList));
//        model.addAttribute("nowConfirmList", new Gson().toJson(nowConfirmList));
//
//
//        List<GraphAddBean> addList = GraphHandler.getGraphAddData(str);
//
//        ArrayList<String> addDateList = new ArrayList<>();
//        ArrayList<Integer> addConfirmList = new ArrayList<>();
//        ArrayList<Integer> addSuspectList = new ArrayList<>();
//
//        for (int i = 0; i < addList.size(); i++) {
//            GraphAddBean graphAddBean = addList.get(i);
//            addDateList.add(graphAddBean.getDate());
//            addConfirmList.add(graphAddBean.getAddConfirm());
//            addSuspectList.add(graphAddBean.getAddSuspect());
//        }
//
//        model.addAttribute("addDateList", new Gson().toJson(addDateList));
//        model.addAttribute("addConfirmList", new Gson().toJson(addConfirmList));
//        model.addAttribute("addSuspectList", new Gson().toJson(addSuspectList));
//
//
//        List<GraphPieBean> pieList = GraphHandler.getGraphPieData(str);
//        Collections.sort(pieList);
//        model.addAttribute("pieList", new Gson().toJson(pieList));
//
//        List<GraphColumnarBean> columnarList = GraphHandler.getGraphColumnarData();
//        Collections.sort(columnarList);
//
//        ArrayList<String> nameList = new ArrayList<>();
//        ArrayList<Integer> fromAbroadList = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            GraphColumnarBean bean = columnarList.get(i);
//            nameList.add(bean.getArea());
//            fromAbroadList.add(bean.getFromAbroad());
//        }
//
//        model.addAttribute("nameList", new Gson().toJson(nameList));
//        model.addAttribute("fromAbroadList", new Gson().toJson(fromAbroadList));

        return "MessagePQ2";
    }
}
