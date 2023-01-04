package com.yang.controller;

import com.yang.pojo.StudentEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StudentEntity> list = new ArrayList<StudentEntity>();
        StudentEntity student = new StudentEntity();
        student.setSno("1");
        student.setsAge(18);
        student.setsSex("男");
        student.setsDept("计算机学院");
        student.setsName("张三");
        list.add(student);

        StudentEntity student2 = new StudentEntity();
        student2.setSno("2");
        student2.setsAge(18);
        student2.setsSex("女");
        student2.setsDept("计算机学院");
        student2.setsName("李四");
        list.add(student2);

        request.setAttribute("data",list);
    request.getRequestDispatcher("./jsp/StudentList.jsp").forward(request,response);
    }
}
