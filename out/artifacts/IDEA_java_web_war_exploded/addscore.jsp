<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

    //防止未登陆就进入主页
    if (session.getAttribute("userid") == null)
        response.sendRedirect("logon.jsp");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'addstudent.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="CSS/style.css">

    <script language="javascript">
        window.onload = init;
        function init() {
            var pop = "${requestScope.mng}";
            if (pop != "")
                alert(pop);
        }
    </script>

</head>


<body>
<%--头部--%>
<jsp:include page="header.jsp"/>
<%--动态包含--%>

<%--左导航--%>
<div class="leftnav">
    <a href="studentinfo">成绩信息</a><br>
    <a href="studentmanage">成绩管理</a><br>
    <span><a href="addstudent.jsp">成绩录入</a></span>
</div>

<%--主内容--%>
<div class="content">
    <h1 id="title">添加学生信息</h1><br>
    <form name="addscore" action="addscore" method="post">
        <table align="center">
            <tr>
                <td><label for="scoreId">课程名称:</label></td>
                <td><input type="text" id="scoreId" name="scoreId" class="myinput"/></td>
            </tr>
            <tr>
                <td><label for="studentId">学号:</label></td>
                <td><input type="text" id="studentId" name="studentId" class="myinput"/></td>
            </tr>
            <tr>
                <td><label for="studentName">学生姓名:</label></td>
                <td><input type="text" id="studentName" name="studentName" class="myinput"/></td>
            </tr>
            <tr>
                <td><label>成绩:</label></td>
                <td><input type="text" id="score" name="score" class="myinput"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td>
                    <input type="submit" id="btnSubmit" name="btnSubmit" value="添加" class="mybutton"/>&nbsp&nbsp&nbsp
                    <input type="button" id="btnCancel" name="btnCancel" value="取消" class="mybutton" onclick="window.location.href='scoreinfo'"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<%--底部--%>
<jsp:include page="footer.jsp"/>
<%--动态包含--%>
</body>
</html>
