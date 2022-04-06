package com.hxb.demo10.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.hxb.demo10.bean.DataBean;
import com.hxb.demo10.mapper.DataMapper;
import com.hxb.demo10.handller.DataHandler;

import com.hxb.demo10.service.DataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl extends ServiceImpl<DataMapper, DataBean>
        implements DataService {

    @Override
    public List<DataBean> list() {
        List<DataBean> result = null;
        try {
            result = DataHandler.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<DataBean> list2() {
        List<DataBean> result = null;
        try {
            result = DataHandler.getData3();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<DataBean> list3() {
        List<DataBean> result = null;
        try {
            result = DataHandler.getData4();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<DataBean> list4() {
        List<DataBean> result = null;
        try {
            result = DataHandler.getData5();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public List<DataBean> list5() {
        List<DataBean> result = null;
        try {
            result = DataHandler.getData6();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
