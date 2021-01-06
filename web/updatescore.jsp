<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

    //防止未登陆就进入主页
    if(session.getAttribute("userid")==null)
        response.sendRedirect("logon.jsp");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'updatestudent.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="CSS/style.css">
    
	<script language="javascript">
		window.onload=init;
		function init(){
			var pop="${requestScope.msg}";
			if(pop !="")
				alert(pop);
		}
	</script>
</head>

<body>
<%--头部--%>
<jsp:include page="header.jsp"/><%--动态包含--%>

<%--左导航--%>
<div class="leftnav">成绩信息</a><br>
    <a href="studentmanage">成绩管理</a><br>
    <a href="addstudent.jsp">添加成绩</a>
</div>

<%--主内容--%>
<div class="content">
    <h1 id="title">更新成绩信息</h1><br>
    <form name="updatescore" action="updatescore" method="post">
        <table align="center">
            <tr>
                <td><label for="courseId">课程号:</label></td>
                <td><input type="text" id="courseId" name="courseId" class="myinput" value="${score.courseId}"/></td>
            </tr>

            <tr>
                <td><label for="courseName">课程名:</label></td>
                <td><input type="text" id="courseName" name="courseName" class="myinput" readonly value="${score.courseName}"/>*无需更改</td>
            </tr>

            <tr>
                <td><label for="studentId">学生学号:</label></td>
                <td><input type="text" id="studentId" name="studentId" class="myinput" value="${score.studentId}"/></td>
            </tr>

            <tr>
                <td><label for="studentName">学生名:</label></td>
                <td><input type="text" id="studentName" name="studentName" class="myinput" readonly value="${score.studentName}"/>*无需更改</td>
            </tr>

            <tr>
                <td><label for="score">成绩:</label></td>
                <td><input type="text" id="score" name="score" class="myinput" value="${score.score}"/></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td>
                    <input type="submit" id="btnSubmit" name="btnSubmit" value="更新" class="mybutton"/>&nbsp&nbsp&nbsp
                    <input type="button" id="btnCancel" name="btnCancel" value="取消" class="mybutton" onclick="window.location.href='scoreinfo'"/>
                </td>
            </tr>
        </table>
    </form>
</div>

    <%--底部--%>
    <jsp:include page="footer.jsp" /><%--动态包含--%>
</body>
</html>