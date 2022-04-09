package com.hxb.demo10.test;

import org.python.util.PythonInterpreter;

import java.net.*;
import java.util.Enumeration;

public class test1 {


    public static void main(String[] args){
        try {
            InetAddress ip4 = Inet4Address.getLocalHost();
            System.out.println(ip4.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}



