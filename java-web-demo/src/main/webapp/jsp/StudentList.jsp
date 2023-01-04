<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.yang.pojo.StudentEntity"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>学生列表页面</title>
</head>
<body>
<%
    ArrayList list = (ArrayList) request.getAttribute("data");
%>
<!-- 声明一个表格,这是表头 -->
<h2 align = "center">学生列表</h2>
<table border = 1px align = "center">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>所在院系</th>
    </tr>
    <!-- 继续使用jsp语句 循环放入存放于list中的Book实体类中的数据 -->
    <%
        for(int i = 0;i<list.size();i++){
            StudentEntity Student =(StudentEntity) list.get(i);%>
    <tr>
        <th><%=Student.getSno() %></th>
        <th><%=Student.getsName()%></th>
        <th><%=Student.getsSex()%></th>
        <th><%=Student.getsDept()%></th><br>
    </tr>
    <% }%>
</table>
</body>
</html>
