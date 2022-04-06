package com.hxb.demo10.serviceimpl;

import com.github.pagehelper.PageHelper;

import com.hxb.demo10.bean.Patient;
import com.hxb.demo10.mapper.PatientDao;
import com.hxb.demo10.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Service
public class PatientServiceImp implements PatientService {
    @Autowired
    PatientDao dao;
    @Override
    public List<Patient> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }


    @Override
    public void add(Patient patient) {
        dao.add(patient);
    }

    @Override
    public int update(Patient patient) {
     return    dao.update(patient);
    }

    @Override
    public int delete(int id) {
       return   dao.delete(id);
    }

    @Override
    public Patient updatePaintById(int baseId) {
     return    dao.updatePatientById(baseId);
    }

    @Override
    public List<Patient> findAllToMain() {
        return this.findAllToMain();
    }


}
