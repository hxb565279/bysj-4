package com.hxb.demo10.test;

import org.python.util.PythonInterpreter;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class test1 {


    public static void main(String[] args)
            throws Exception {
        PythonInterpreter pythonInterpreter = new PythonInterpreter();
        pythonInterpreter.execfile("J:\\bysj\\src\\main\\java\\com\\hxb\\demo10\\python_01\\__init__.py");
    }
}



