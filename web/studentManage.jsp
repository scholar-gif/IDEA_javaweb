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

        function selectAll() {
            var checklist = document.getElementsByName("cbxStudent");
            if (document.getElementById("cbxAll").checked)//document.getElementById(" ")获取指定id值的对象，.checked若被选中则返回true
                for (var i = 0; i < checklist.length; i++)
                    checklist[i].checked = 1;
            else
                for (var j = 0; j < checklist.length; j++)
                    checklist[j].checked = 0;
        }
        function del(){
            if(!confirm("确定删除这些信息吗？")){
                return;
            }
            var delElt = document.getElementById("del");
            delElt.submit();
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
    <form action="querystudents">
        <div><label>查询条件:</label>
            <select name="select" style="height:27px">
                <option>请选择</option>
                <option value="学号">学号</option>
                <option value="姓名">姓名</option>
                <option value="性别">性别</option>
                <option value="学院">学院</option>
                <option value="专业">专业</option>
            </select>
            <input type="text" name="selectvalue" size="20"/>
            <input type="submit" name="btnSearch" class="mybutton" value="查询"/>
        </div>
    </form>
    <form action="delstudent" id="del">
        <table border="1" align="center" class="infolist">
            <tr class="tableheader">
                <th><input type="checkbox" name="cbxAll" id="cbxAll" onclick="selectAll()"/></th>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>学院</th>
                <th>专业</th>
                <th>班级号</th>
                <th>更新</th>
                <th>删除</th>
            </tr>

            <c:forEach items="${requestScope.studentlist}" var="student">
                <tr align="center">
                    <td><input type="checkbox" name="cbxStudent" value="${student.studentId}"></td>
                    <td>${student.studentId}</td>
                    <td>${student.studentName}</td>
                    <td>${student.studentSex}</td>
                    <td>${student.studentBirthday}</td>
                    <td>${student.studentDept}</td>
                    <td>${student.studentMajor}</td>
                    <td>${student.studentClassId}</td>
                    <td><a href="getstudentinfo?studentid=${student.studentId}" style="text-decoration: none;">更新</a></td>
                    <td><a href="delstudent?studentid=${student.studentId}" style="text-decoration: none;">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <input type="button" name="btnDelete" class="mybutton" value="删除" onclick="del()"/>&nbsp&nbsp&nbsp
        <input type="button" name="btnAdd" class="mybutton" value="添加" onclick="window.location.href='addstudent.jsp'"/>
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
