<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<body >
<%--头部--%>
    <div class="header">
        <div class="header1"><img src="TP/log.png"></div>
        <div class="header2">学生信息管理系统</div>
        <div class="header3">${sessionScope.userid}|<a onclick="window.location.href='logon.jsp'">登出</a></div>
    </div>

    <%--导航--%>
<center>
    <div class="nav" align="center">
        <a href="main.jsp">系统首页</a>
        <a href="userinfo">用户信息</a>
        <a href="studentinfo">学生信息</a>
        <a href="courseinfo">课程信息</a>
        <a href="scoreinfo">成绩信息</a>
    </div>
</center>
</body>
   
</html>
