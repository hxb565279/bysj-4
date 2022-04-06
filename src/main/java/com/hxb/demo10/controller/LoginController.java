package com.hxb.demo10.controller;

import com.hxb.demo10.bean.DataBean;
import com.hxb.demo10.bean.UserBean;
import com.hxb.demo10.service.DataService;
import com.hxb.demo10.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import javax.swing.*;
import java.util.List;

@Controller
public class LoginController {
    //将Service注入Web层
    @Autowired(required = false)
    UserService userService;
    @Autowired
    private DataService  dataService;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }
    @RequestMapping("/toMain")
    public  String toMain(Model model){
        List<DataBean> dataList = this.dataService.list2();
        List<DataBean> dataList2 = this.dataService.list2();
        List<DataBean> dataList3 = dataService.list5();
        model.addAttribute("data", dataList.get(0));
        model.addAttribute("china", dataList3.get(0).getConfirm());
        model.addAttribute("datalist", dataList);
        dataList2.sort((x, y) -> Double.compare(y.getNowConfirm(), x.getNowConfirm()));
        model.addAttribute("datalist2", dataList2);

        return "main";
    }

    @RequestMapping(value = "/ToRegister")
    public String toResiter(){
        return "register";
    }

    @RequestMapping(value = "/ToYM")
    public String toYQ(){
        return "YMTU";
    }
    @RequestMapping(value = "/Register")
    public void Register(String username,String password){
        this.userService.register(username,password);
    }


    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String username,String password,Model model){
        UserBean userBean = userService.loginIn(username,password);
        System.out.println(username);
        System.out.println(password);
        System.out.println(userBean);
        if(userBean!=null){
            List<DataBean> dataList = this.dataService.list2();
            List<DataBean> dataList2 = this.dataService.list2();
            List<DataBean> dataList3 = dataService.list5();
            model.addAttribute("data", dataList.get(0));
            model.addAttribute("china", dataList3.get(0).getConfirm());
            model.addAttribute("datalist", dataList);
            dataList2.sort((x, y) -> Double.compare(y.getNowConfirm(), x.getNowConfirm()));
            model.addAttribute("datalist2", dataList2);
            return "main";
        }else {
            return "login";
        }
    }

    // 检查用户名存在
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    @ResponseBody
    public UserBean checkUser(   @RequestBody UserBean user) {
        System.out.println(user.getName());
        String username = user.getName();
        UserBean user1 = this.userService.getUsername(username);
        if (user1 != null) {
            return user1;
        }
        return null;
    }


    @RequestMapping(value = "/logoSystem")
    public String logoSystem(){
        return "logoSystem";
    }

//    @RequestMapping(value = "/MessageManager")
//    public String MessageManager(){
//        return "MessageManager";
//    }
    @RequestMapping(value = "/MessagePQ")
    public String MessagePQ(){
        return "MessagePQ";
    }

    @RequestMapping(value = "/MessagePQ2")
    public String MessagePQ2(){
        return "MessagePQ2";
    }
    @RequestMapping(value = "/userManager")
    public String userManager(){
        return "userManager";
    }


    @RequestMapping(value = "user/list",method = RequestMethod.GET)
    public String list(Model model){
        List<UserBean> deads = userService.selectAllUser();
        model.addAttribute("pageInfo",deads);
        return "userManager";
    }

//根据ID获取数据
    @RequestMapping(value = "getUserById",method = RequestMethod.GET)
    @ResponseBody
  public UserBean getUserById(int id){
       return      this.userService.getUserById(id);
    }



    //根据ID修改用户数据
    @RequestMapping(value = "/updateCustomer1" ,method = RequestMethod.POST)
    @ResponseBody
    public String updateCustomer1(UserBean userBean){
        int num = this.userService.updateCustomer1(userBean);
        if (num>0){
            return "OK";
        }else {
            return "FAIL";
        }
    }


    //根据ID删除数据
    @RequestMapping(value = "/deleteUserById",method = RequestMethod.POST)
    @ResponseBody
    public String deleteUserById(int id){
        int num  =this.userService.deleteUser(id);
       if (num>0){
            return "OK";
        }else {
            return "FAIL";
        }
    }
}
