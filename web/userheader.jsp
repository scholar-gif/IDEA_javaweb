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
    <div class="nav">
        <a href="main.jsp">系统首页</a>
        <a href="getuserinfo?username=${sessionScope.userid}">个人中心</a>
        <a href="querycourse?selectvalue=${sessionScope.username.userDept}&select=所属学院">课程信息</a>
        <a href="queryscore?selectvalue=${sessionScope.username.userName}&select=xh">成绩信息</a>
    </div>
</body>
   
</html>
