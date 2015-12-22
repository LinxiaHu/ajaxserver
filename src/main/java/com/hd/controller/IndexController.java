package com.hd.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hd.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chunyun on 2015/12/20.
 */
public class IndexController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        StringBuffer url = req.getRequestURL();
        System.out.println("url:" + url.toString());
        PrintWriter writer = resp.getWriter();
//        writer.println("from server!");
        String username = req.getParameter("username");
        System.out.println("接收到的用户名是：" + username);
        if (username.equals("antao")) {
            writer.println("用户名：" + username + "可以使用！");
        } else {
            writer.println("用户名:" + username + "已经被注册！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {

    }
}
