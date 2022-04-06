package com.hxb.demo10.controller;

import com.github.pagehelper.PageInfo;

import com.hxb.demo10.bean.*;
import com.hxb.demo10.service.PatientService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PatientService service;

    //查看现存确诊病人
    @RequestMapping(value = "/MessageManager", method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "25") int size) {

        List<Patient> patients = service.findAll(page, size);
        PageInfo<Patient> pageInfo = new PageInfo(patients);

        model.addAttribute("pageInfo", pageInfo);
        return "MessageManager";

    }

    //添加患者列表
    @RequestMapping(value = "/patient/add", method = RequestMethod.POST)
    public String addPatient(    @RequestParam("username") String username, @RequestParam("id") String id,  @RequestParam("onsetDate") Date onsetDate,
                              @RequestParam("sex") String sex, @RequestParam("elephone") String elephone, @RequestParam("address") String address,
                              @RequestParam("hospital") String hospital, @RequestParam("symptoms")String symptoms) {
        Patient patient = new Patient();
        patient.setUsername(username);
        patient.setId(id);
        patient.setSex(sex);
        patient.setElephone(elephone);
        patient.setOnsetDate(onsetDate);
        patient.setAddress(address);
        patient.setHospital(hospital);
        patient.setSymptoms(symptoms);
        System.out.println(patient.toString());
       service.add(patient);
        return "redirect:/MessageManager";
    }
    @RequestMapping(value = "/toDead",method = RequestMethod.POST)
    @ResponseBody
    public String deleteMessage(int baseId){
         int num= this.service.delete(baseId);
        if (num>0){
            return "OK";
        }else{
            return "FAIL";
        }
    }


    //根据id查询数据
    @RequestMapping(value = "updatePatientById",method = RequestMethod.GET)
    @ResponseBody
    public Patient updatePatientById(int baseId){
        return this.service.updatePaintById(baseId);
    }
//更新数据
    @RequestMapping(value = "/updatePatient",method = RequestMethod.POST)
    @ResponseBody
    public String updatePatient( @RequestParam("baseId") int baseId,   @RequestParam("username") String username, @RequestParam("id") String id,
                                 @RequestParam("sex") String sex, @RequestParam("elephone") String elephone, @RequestParam("address") String address,
                                 @RequestParam("hospital") String hospital, @RequestParam("symptoms")String symptoms )  {
        Patient patient = new Patient();
        patient.setBaseId(baseId);
        patient.setUsername(username);
        patient.setId(id);
        patient.setSex(sex);
        patient.setElephone(elephone);
        patient.setAddress(address);
        patient.setHospital(hospital);
        patient.setSymptoms(symptoms);
        int num= this.service.update(patient);
        if (num>0){
            return "OK";
        }else {
            return "FAIL";
        }
    }
    //跳转添加页面
    @RequestMapping(value = "/patient/toAdd")
    public String toAdd() {
        return "patientAdd";
    }
}
