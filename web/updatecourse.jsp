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
<div class="leftnav">课程信息</a><br>
    <a href="coursemanage">课程管理</a><br>
    <a href="addstudent.jsp">添加管理</a>
</div>

<%--主内容--%>
<div class="content">
    <h1 id="title">更新课程信息</h1><br>
    <form name="updatecourse" action="updatecourse" method="post">
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
                <td><label>课程类型:</label></td>
                <td><select name="courseType">
                    <option>--请选择--</option>
                    <option value="选修 " ${course.courseType=='选修'?'selected':''}>选修</option>
                    <option value="必修 " ${course.courseType=='必修'?'selected':''}>必修</option>
                </select></td>
            </tr>

            <tr>
                <td><label for="courseXf">课程学分:</label></td>
                <td><input type="text" id="courseXf" name="courseXf" class="myinput" value="${course.courseXf}"/></td>
            </tr>

            <tr>
                <td><label>学院:</label></td>
                <td> <select  name="studentDept">
                    <option value="艺术学院 " ${course.studentDept == '艺术学院' ? 'selected': '' }>艺术学院</option>
                    <option value="商学院 " ${course.studentDept == '商学院' ? 'selected': '' }>商学院</option>
                    <option value="土建学院 " ${course.studentDept == '土建学院' ? 'selected': '' }>土建学院</option>
                    <option value="智能制造学院 " ${course.studentDept == '智能制造学院' ? 'selected': '' }>智能制造学院</option>
                    <option value="制药学院 " ${course.studentDept == '制药学院' ? 'selected': '' }>制药学院</option>
                    <option value="信息学院" ${course.studentDept == '信息学院' ? 'selected': '' }>信息学院</option>
                    <option value="体育学院" ${course.studentDept == '体育学院' ? 'selected': '' }>体育学院</option>
                </select></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td>
                    <input type="submit" id="btnSubmit" name="btnSubmit" value="更新" class="mybutton"/>&nbsp&nbsp&nbsp
                    <input type="button" id="btnCancel" name="btnCancel" value="取消" class="mybutton" onclick="window.location.href='courseinfo'"/>
                </td>
            </tr>
        </table>
    </form>
</div>

    <%--底部--%>
    <jsp:include page="footer.jsp" /><%--动态包含--%>
</body>
</html>