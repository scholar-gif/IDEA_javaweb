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
            var checklist = document.getElementsByName("cbxscore");
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
    <a href="scoreinfo">成绩信息</a><br>
    <%if("admin".equals(session.getAttribute("users"))){%>
    <a href="scoremanage">成绩管理</a><br>
    <a href="addscore.jsp">添加成绩</a>
    <%}%>
</div>

<%--主内容--%>
<div class="content">
    <c:if test="${5<4}" var="hello" scope="session">
        hello
    </c:if>
    <form action="delscore">
        <table border="1" align="center" class="infolist">
            <tr class="tableheader">
                <th>课程名称</th>
                <th>学号</th>
                <th>学生姓名</th>
                <th>课程学分</th>
                <th>成绩</th>
            </tr>

            <c:forEach items="${requestScope.scoreslist}" var="score">
                <tr align="center">
                    <td>${score.courseName}</td>
                    <td>${score.studentId}</td>
                    <td>${score.studentName}</td>
                    <td>${score.courseXf}</td>
                    <td>${score.score}</td>
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
