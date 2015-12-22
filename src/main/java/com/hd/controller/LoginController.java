package com.hd.controller;

import com.hd.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chunyun on 2015/12/22.
 */
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Person p1 = new Person("1", "zhangsan", 9);
        Person p2 = new Person("2", "lisi", 19);
        String password = req.getParameter("password");
        if (password.equals("123")) {
            List<Person> list = new ArrayList<Person>();
            list.add(p1);
            list.add(p2);
            req.setAttribute("p", list);
            req.getRequestDispatcher("/WEB-INF/jsp/ajaxAuh.jsp").forward(req, resp);
            System.out.println("密码输入正确！");
        }else {
            System.out.println("密码输入不正确！");
            req.getRequestDispatcher("/WEB-INF/jsp/ajaxAuh.jsp").forward(req, resp);
            resp.getWriter().println("密码输入不正确！");
        }
    }
}
