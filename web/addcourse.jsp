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
    <a href="courseinfo">课程信息</a><br>
    <a href="coursemanage">课程管理</a><br>
    <a href="addcourse.jsp">添加课程</a>
</div>

<%--主内容--%>
<div class="content">
    <h1 id="title">添加成绩信息</h1><br>
    <form id="add" name="addcourse" action="addcourse" method="post">
        <table align="center">
            <tr>
                <td><label for="courseId">课程号:</label></td>
                <td><input type="text" id="courseId" name="courseId" class="myinput"/></td>
            </tr>

            <tr>
                <td><label for="courseName">课程名:</label></td>
                <td><input type="text" id="courseName" name="courseName" class="myinput"/></td>
            </tr>

            <tr>
                <td><label>课程类型:</label></td>
                <td><select name="courseType">
                    <option>--请选择--</option>
                    <option value="选修 ">选修</option>
                    <option value="必修 ">必修</option>
                </select></td>
            </tr>

            <tr>
                <td><label for="courseXf">课程学分:</label></td>
                <td><input type="text" id="courseXf" name="courseXf" class="myinput" /></td>
            </tr>

            <tr>
                <td><label>上课学院:</label></td>
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
                <td><label></label></td>
                <td>
                    <input type="submit" id="btnSubmit" name="btnSubmit" value="添加" class="mybutton" onclick="add()"/>&nbsp&nbsp&nbsp
                    <input type="button" id="btnCancel" name="btnCancel" value="取消" class="mybutton" onclick="window.location.href='courseinfo'"/>
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
