package com.hxb.demo10.controller;


import com.hxb.demo10.bean.Patient;
import com.hxb.demo10.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/toMainPatientMap")
    public String listPat(Model model){
      List<Patient> listPatient =     this.patientService.findAllToMain();
        model.addAttribute("listPatientData",listPatient);
        return "main";
    }



}
