<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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

    <title>My JSP 'studentinfo.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="CSS/style.css">


    <script language="javascript" type="text/javascript">

        window.onload = init;

        function init() {
            var pop = "${requestScope.msg}";
            if (pop != "")
                alert(pop);
        }
        function selectAll() {
            var checklist = document.getElementsByName("cbxcourse");
            if (document.getElementById("cbxAll").checked)//document.getElementById(" ")获取指定id值的对象，.checked若被选中则返回true
                for (var i = 0; i < checklist.length; i++)
                    checklist[i].checked = 1;
            else
                for (var j = 0; j < checklist.length; j++)
                    checklist[j].checked = 0;
        }

    </script>

</head>

<body>
<%--头部--%>
<%
    if("admin".equals(session.getAttribute("users"))){
%>
<jsp:include page="header.jsp"/><%--动态包含--%>
<%}
else {
%>
<jsp:include page="userheader.jsp"/><%--动态包含--%>
<%
    }
%>
<%--左导航--%>
<div class="leftnav">
    <%if("admin".equals(session.getAttribute("users"))){%>
    <a href="courseinfo">课程信息</a><br>
    <a href="coursemanage">课程管理</a><br>
    <a href="addcourse.jsp">添加课程</a>
    <%}
    else {%>
    <a>课程信息</a><br>
    <%}%>
</div>

<%--主内容--%>
<div class="content">
    <c:if test="${5<4}" var="hello" scope="session">
        hello
    </c:if>
    <form action="delstudent">
        <table border="1" align="center" class="infolist" cellpadding="5">
            <COL WIDTH=100><COL WIDTH=150><COL WIDTH=80><COL WIDTH=80><COL WIDTH=110>
            <tr class="tableheader">
                <th>课程号</th>
                <th>课程名称</th>
                <th>课程类型</th>
                <th>课程学分</th>
                <th>上课的学院</th>
            </tr>

            <c:forEach items="${requestScope.courselist}" var="course">
                <tr align="center">
                    <td>${course.courseId}</td>
                    <td>${course.courseName}</td>
                    <td>${course.courseType}</td>
                    <td>${course.courseXf}</td>
                    <td>${course.studentDept}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
    </form>
</div>

<jsp:include page="footer.jsp"/>
<%--动态包含--%>
</body>
</html>
