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
        function add(){
            if(!confirm("添加成功")){
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
    <span><a href="addstudent.jsp">添加学生</a></span>
</div>

<%--主内容--%>
<div class="content">
    <h1 id="title">添加学生信息</h1><br>
    <form id="add" name="addstudent" action="addstudent" method="post">
        <table align="center">
            <tr>
                <td><label for="studentId">学号:</label></td>
                <td><input type="text" id="studentId" name="studentId" class="myinput"/></td>
            </tr>
            <tr>
                <td><label for="studentName">姓名:</label></td>
                <td><input type="text" id="studentName" name="studentName" class="myinput"/></td>
            </tr>
            <tr>
                <td><label for="studentBirthday">出生日期:</label></td>
                <td><input type="date" min="1996-01-01" max="2006-01-01" defaultValue="2000-01-01" id="studentBirthday"
                           name="studentBirthday" class="myinput"/></td>
            </tr>
            <tr>
                <td><label>性别:</label></td>
                <td>
                    <input type="radio" name="studentSex" value="男" }>男
                    <input type="radio" name="studentSex" value="女" }>女
                </td>
            </tr>
            <tr>
                <td><label>学院:</label></td>
                <td><select name="studentDept">
                    <option>--请选择--</option>
                    <option value="艺术学院 ">艺术学院</option>
                    <option value="商学院 ">商学院</option>
                    <option value="土建学院 ">土建学院</option>
                    <option value="智能制造学院 ">智能制造学院</option>
                    <option value="制药学院 ">制药学院</option>
                    <option value="信息学院">信息学院</option>
                    <option value="体育学院">体育学院</option>
                </select></td>
            </tr>
            <tr>
                <td><label>专业:</label></td>
                <td><input type="text" id="studentMajor" name="studentMajor" class="myinput"/></td>
            </tr>
            <tr>
                <td><label>班级号:</label></td>
                <td><input type="text" id="studentClassId" name="studentClassId" class="myinput"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td>
                    <input type="button" id="btnSubmit" name="btnSubmit" value="添加" class="mybutton" onclick="add()"/>&nbsp&nbsp&nbsp
                    <input type="button" id="btnCancel" name="btnCancel" value="取消" class="mybutton" onclick="window.location.href='studentinfo'"/>
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
