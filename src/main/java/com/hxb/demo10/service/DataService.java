package com.hxb.demo10.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hxb.demo10.bean.DataBean;
import com.hxb.demo10.bean.IDBean;
import com.hxb.demo10.bean.USABean;

import java.util.List;

public interface DataService extends IService<DataBean> {
    List<DataBean> list();

    List<DataBean> list2();
    List<DataBean> list3();
    List<DataBean> list4();
    List<DataBean>  list5();
    List<USABean> list6();
}
