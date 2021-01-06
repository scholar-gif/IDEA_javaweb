<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    //LinkedList<StudentDTO> studentlist=(LinkedList<StudentDTO>)request.getAttribute("studentlist");

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
    <a href="studentinfo">学生信息</a><br>
    <a href="studentmanage">学生管理</a><br>
    <a href="addstudent.jsp">添加学生</a>

</div>

<%--主内容--%>
<div class="content">
    <c:if test="${5<4}" var="hello" scope="session">
        hello

    </c:if>

    <form action="delstudent">
        <table border="1" align="center" class="infolist">
            <tr class="tableheader">
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>学院</th>
                <th>专业</th>
                <th>班级号</th>
            </tr>

            <c:forEach items="${requestScope.studentlist}" var="student">
                <tr align="center">
                    <td>${student.studentId}</td>
                    <td>${student.studentName}</td>
                    <td>${student.studentSex}</td>
                    <td>${student.studentBirthday}</td>
                    <td>${student.studentDept}</td>
                    <td>${student.studentMajor}</td>
                    <td>${student.studentClassId}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
    </form>

    <%--<%for(StudentDTO student :studentlist){ %>
    <tr>
        <td><%=student.getStudentId() %></td>
        <td><%=student.getStudentName() %></td>
        <td><%=student.getStudentSex() %></td>
        <td><%=student.getStudentBirthday() %></td>
        <td><%=student.getStudentDept() %></td>
        <td><%=student.getStudentMajor() %></td>
        <td><%=student.getStudentClassId() %></td>
        <td><a href="">更新</a></td>
        <td><a href="">删除</a></td>
    </tr>
    <%} %>--%>


</div>

<jsp:include page="footer.jsp"/>
<%--动态包含--%>
</body>
</html>
