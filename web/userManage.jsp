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
            var checklist = document.getElementsByName("cbxUser");
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
        function dels(hef1){
            var b =confirm("确定是否删除此信息");
            if (b){
                window.location.href="deluser?username="+hef1;
            }
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
    <a href="userinfo">用户信息</a><br>
    <a href="usermanage">用户管理</a><br>
    <a href="adduser.jsp">添加用户</a>
</div>

<%--主内容--%>
<div class="content">
    <c:if test="${5<4}" var="hello" scope="session">
        hello
    </c:if>
    <form action="queryuser">
        <div><label>查询条件:</label>
            <select name="select" style="height:27px">
                <option>请选择</option>
                <option value="用户名">用户名</option>
                <option value="性别">性别</option>
                <option value="邮箱">邮箱</option>
            </select>
            <input type="text" name="selectvalue" size="20"/>
            <input type="submit" name="btnSearch" class="mybutton" value="查询"/>
        </div>
    </form>
    <form action="deluser" id="del">
        <table border="1" align="center" class="infolist" cellpadding="5">
            <COL WIDTH=10><COL WIDTH=100><COL WIDTH=100><COL WIDTH=80><COL WIDTH="200"><COL WIDTH=80><COL WIDTH=80><COL WIDTH=80>
            <tr class="tableheader">
                <th><input type="checkbox" name="cbxAll" id="cbxAll" onclick="selectAll()"/></th>
                <th>用户名</th>
                <th>密码</th>
                <th>性别</th>
                <th>邮箱</th>
                <th>用户类型</th>
                <th>所属学院</th>
                <th>更新</th>
                <th>删除</th>
            </tr>
            <c:forEach items="${requestScope.userlist}" var="user">

                <tr align="center">
                    <td><input type="checkbox" name="cbxUser" value="${user.userName}"></td>
                    <td>${user.userName}</td>
                    <td>${user.userPwd}</td>
                    <td>${user.userSex}</td>
                    <td>${user.userEmail}</td>
                    <td>${user.userType}</td>
                    <td>${user.userDept}</td>
                    <td><a href="getuserinfo?username=${user.userName}"style="text-decoration: none;">更新</a></td>
                    <td><input type="button" onclick="dels(${user.userName})" value="删除"></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <input type="button" name="btnDelete" class="mybutton" value="删除" onclick="del()"/>&nbsp&nbsp&nbsp
        <input type="button" name="btnAdd" class="mybutton" value="添加" onclick="window.location.href='adduser.jsp'"/>
    </form>
</div>

<jsp:include page="footer.jsp"/>
<%--动态包含--%>
</body>
</html>
