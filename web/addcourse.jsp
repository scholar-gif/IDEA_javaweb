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

    <title>My JSP 'addscore.jsp' starting page</title>

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
    <a href="courseinfo">课程信息</a><br>
    <a href="studentManage">课程管理</a><br>
    <a href="addcourse.jsp">添加课程</a>
</div>

<%--主内容--%>
<div class="content">
    <h1 id="title">添加成绩信息</h1><br>
    <form name="addcourse" action="addcourse" method="post">
        <table align="center">
            <tr>
                <td><label for="courseId">课程号:</label></td>
                <td><input type="text" id="courseId" name="courseId" class="myinput" value="${course.courseId}"/></td>
            </tr>

            <tr>
                <td><label for="courseName">课程名:</label></td>
                <td><input type="text" id="courseName" name="courseName" class="myinput" value="${course.courseName}"/></td>
            </tr>

            <tr>
                <td><label for="courseType">课程类型:</label></td>
                <td><input type="text" id="courseType" name="courseType" class="myinput" value="${course.courseType}"/></td>
            </tr>

            <tr>
                <td><label for="courseXf">课程学分:</label></td>
                <td><input type="text" id="courseXf" name="courseXf" class="myinput" value="${course.courseXf}"/></td>
            </tr>

            <tr>
                <td><label for="studentDept">上课学院:</label></td>
                <td><input type="text" id="studentDept" name="studentDept" class="myinput" value="${course.studentDept}"/></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td>
                    <input type="submit" id="btnSubmit" name="btnSubmit" value="添加" class="mybutton"/>&nbsp&nbsp&nbsp
                    <input type="button" id="btnCancel" name="btnCancel" value="取消" class="mybutton"
                           onclick="window.location.href='courseinfo'"/>
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
