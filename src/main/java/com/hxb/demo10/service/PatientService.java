package com.hxb.demo10.service;



import com.hxb.demo10.bean.Patient;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

public interface PatientService {
    //查找所有病患
    public List<Patient> findAll(int size, int page);

    //添加病患
    public void add(Patient patient);
    //更新病患信息
    public int update(Patient patient) ;


    //死亡
    public int delete(int id);

    public Patient updatePaintById(int baseId);

    public List<Patient> findAllToMain();
}
