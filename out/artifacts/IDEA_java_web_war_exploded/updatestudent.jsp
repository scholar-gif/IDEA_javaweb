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
    <h1 id="title">更新学生信息</h1><br>
    <form name="updatestudent" action="updatestudent" method="post">
        <table align="center">
            <tr>
                <td><label for="studentId">学号:</label></td>
                <td style="font-size: 12px;color: darkgray;">
                    <input type="text" id="studentId" name="studentId" class="myinput" readonly value="${student.studentId}"/>*学号不可更改
                </td>
            </tr>
            <tr>
                <td><label for="studentName">姓名:</label></td>
                <td><input type="text" id="studentName" name="studentName" class="myinput" value="${student.studentName}"/></td>
            </tr>
            <tr>
                <td><label for="studentBirthday">出生日期:</label></td>
                <td><input type="date" min="1996-01-01" max="2006-01-01" id="studentBirthday" name="studentBirthday" class="myinput" value="${student.studentBirthday}"/></td>
            </tr>
            <tr>
                <td><label>性别:</label></td>
                    <td>
                        <input type="radio" name="studentSex" value="男"${student.studentSex=='男'? 'checked':''}>男
                        <input type="radio" name="studentSex" value="女"${student.studentSex=='女'? 'checked':''}>女
                    </td>
            </tr>
            <tr>
                <td><label>学院:</label></td>
                <td> <select  name="studentDept">
                	<option value="艺术学院 " ${student.studentDept == '艺术学院' ? 'selected': '' }>艺术学院</option>
                	<option value="商学院 " ${student.studentDept == '商学院' ? 'selected': '' }>商学院</option>
                	<option value="土建学院 " ${student.studentDept == '土建学院' ? 'selected': '' }>土建学院</option>
                	<option value="智能制造学院 " ${student.studentDept == '智能制造学院' ? 'selected': '' }>智能制造学院</option>
                	<option value="制药学院 " ${student.studentDept == '制药学院' ? 'selected': '' }>制药学院</option>
       				<option value="信息学院" ${student.studentDept == '信息学院' ? 'selected': '' }>信息学院</option>
                    <option value="体育学院" ${student.studentDept == '体育学院' ? 'selected': '' }>体育学院</option>
       			</select></td>
            </tr>
            <tr>
                <td><label>专业:</label></td>
                <td><input type="text" id="studentMajor" name="studentMajor" class="myinput" value="${student.studentMajor}"/></td>
            </tr>
            <tr>
                <td><label>班级号:</label></td>
                <td><input type="text" id="studentClassId" name="studentClassId" class="myinput" value="${student.studentClassId}"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td>
                    <input type="submit" id="btnSubmit" name="btnSubmit" value="更新" class="mybutton"/>&nbsp&nbsp&nbsp
                    <input type="button" id="btnCancel" name="btnCancel" value="取消" class="mybutton" onclick="window.location.href='studentinfo'"/>
                </td>
            </tr>
        </table>
    </form>
</div>

    <%--底部--%>
    <jsp:include page="footer.jsp" /><%--动态包含--%>
</body>
</html>