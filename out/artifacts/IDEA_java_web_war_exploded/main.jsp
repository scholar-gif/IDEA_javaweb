<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    int iCount=0;
    //默认值
    Object o=application.getAttribute("count");
    if(o!=null)
    {
        iCount=((Integer)o).intValue();
    }
    iCount++;
    //修改访问量
    application.setAttribute("count",iCount);
    out.println("您是第"+iCount+"位访客");

    //防止未登陆就进入主页
    if(session.getAttribute("userid")==null)
        response.sendRedirect("logon.jsp");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'main.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="CSS/style.css">

</head>

<body>

	<%--头部--%>
    <%
        if("admin".equals(session.getAttribute("users"))){
    %>
    <%@ include file="header.jsp" %><%--静态包含--%>
    <%}
        else {
    %>
    <%@ include file="userheader.jsp" %>
    <%
        }
    %>
   <%--左导航--%>
    <div class="leftnav">
        <span>系统首页</span><br>
        <a>教务通知</a><br>
        <a>规章制度</a>
    </div>
    
    <%--主内容--%>
    <div class="content"> 主内容content</div>
    <%@ include file="footer.jsp" %><%--静态包含--%>
</body>
</html>
