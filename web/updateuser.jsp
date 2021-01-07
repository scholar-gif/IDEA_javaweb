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

    <script language="javascript" type="text/javascript">
        var validUserName = false;//用户是否通过验证
        var validUserPwd = false;
        var validUserEmail = false;

        //用户名
        function showTipUserName() {//点击时状态
            document.getElementById("usertip").style.display = "block";//提示打开
            document.getElementById("usererr").style.display = "none";//错误提示关闭
            document.frmRegister.userName.style.borderColor ="azure";//边框颜色
        }

        function checkUserName() {//非点击时状态
            document.getElementById("usertip").style.display = "none";//提示关闭
            document.frmRegister.userName.style.borderColor ="azure";//边框颜色
            var uservalue = document.frmRegister.userName.value;//文本框内容提取
            var reg = /^[a-zA-Z_\u2e00-\u9fa5][\w_\u2e00-\u9fa5]{1,9}$/;//用户名格式要求

            if (!uservalue) {
                document.getElementById("usererr").innerHTML ="用户名不能为空*";
                document.getElementById("usererr").style.display = "block";//错误提示打开
                validUserName = false;//用户名状态错误
            } else{
                if (!reg.test(uservalue)) {
                    document.getElementById("usererr").innerHTML ="用户名不合法*";
                    document.getElementById("usererr").style.display = "block";//错误提示打开
                    validUserName = false;//用户名状态错误
                } else {
                    document.getElementById("usererr").style.display = "none";//错误提示关闭
                    document.frmRegister.userName.style.borderColor = "azure";//边框颜色
                    validUserName = true;//用户名状态正确
                }
            }
        }

        //密码
        function showTipUserPwd() {
            document.getElementById("pwdtip").style.display = "block";//提示打开
            document.getElementById("pwderr").style.display = "none";//错误提示关闭
            document.frmRegister.userPwd.style.borderColor = "azure";//边框颜色
        }

        function checkUserPwd() {
            document.getElementById("pwdtip").style.display = "none";//提示关闭
            document.frmRegister.userPwd.style.borderColor = "azure";//边框颜色
            var pwdvalue = document.frmRegister.userPwd.value;//文本框内容提取
            var reg = /^.{6,16}$/;//密码格式要求

            if (!pwdvalue) {
                document.getElementById("pwderr").innerHTML = "密码不能为空*";
                document.getElementById("pwderr").style.display = "block";//错误提示打开
                validUserPwd = false;//密码状态错误
            } else {
                if (!reg.test(pwdvalue)) {
                    document.getElementById("pwderr").innerHTML = "密码长度不符*";
                    document.getElementById("pwderr").style.display = "block";//错误提示打开
                    validUserPwd = false;//密码状态错误
                } else {
                    document.getElementById("pwderr").style.display = "none";//错误提示关闭
                    document.frmRegister.userPwd.style.borderColor = "azure";//边框颜色
                    validUserPwd = true;//密码状态正确
                }
            }
        }

        //邮箱
        function showTipUserEmail() {
            document.getElementById("emailtip").style.display = "block";//提示打开
            document.getElementById("emailerr").style.display = "none";//错误提示关闭
            document.frmRegister.userEmail.style.borderColor ="azure";//边框颜色
        }

        function checkUserEmail() {
            document.getElementById("emailtip").style.display = "none";//提示关闭
            document.frmRegister.userEmail.style.borderColor ="azure";//边框颜色
            var emailvalue = document.frmRegister.userEmail.value;//文本框内容提取
            var reg = /\w+([-+.']\w+)*@\w+([-.]\w+)*.\w+([-.]\w+)*/;//邮箱格式要求
            if (!emailvalue) {
                document.getElementById("emailerr").innerHTML = "邮箱不能为空*";
                document.getElementById("emailerr").style.display = "block";//错误提示打开
                validUserEmail = false;
            } else {
                if (!reg.test(emailvalue)) {
                    document.getElementById("emailerr").innerHTML = "邮箱格式不合法*";
                    document.getElementById("emailerr").style.display = "block";//错误提示打开
                    validUserEmail = false;
                } else {
                    document.getElementById("emailerr").style.display = "none";//错误提示关闭
                    document.frmRegister.userEmail.style.borderColor ="azure";//边框颜色
                    validUserEmail = true;
                }
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
    <%if("admin".equals(session.getAttribute("users"))){%>
    <a href="userinfo">用户信息</a><br>
    <a href="usermanage">用户管理</a><br>
    <a href="adduser.jsp">添加用户</a>
    <%}
    else {%>
    <a>个人信息</a><br>
    <%}%>
</div>

<%--主内容--%>
<div class="content">
        <h1 id="title">更新用户信息</h1>
        <form  name="updateuser" action="updateuser" method="post" >
            <table align="center" ><!--表格行间距和对齐方式-->
                <tr>
                    <td><label for="userName">用户名:</label></td>
                    <td style="font-size: 12px;color: darkgray;">
                        <input type="text" id="userName" name="userName" class="myinput" readonly value="${user.userName}"/>*用户名不可更改
                    </td>
                </tr>

                <tr>
                    <td><label for="userPwd">密码:</label></td>
                    <td>
                        <input type="text" id="userPwd" name="userPwd" class="myinput" value="${user.userPwd}" onfocus="showTipUserName();" onblur="checkUserName();"/>
                        <span id="pwdtip" class="tip">密码长度为6-16</span>
                        <span id="pwderr" class="err"></span>
                    </td>
                </tr>

                <tr>
                    <td><label>性别:</label></td>
                    <td>
                        <input type="radio" name="userSex" value="男"${user.userSex=='男'? 'checked':''}>男
                        <input type="radio" name="userSex" value="女"${user.userSex=='女'? 'checked':''}>女
                    </td>
                </tr>

                <tr>
                    <td><label for="userEmail">邮箱:</label></td>
                    <td>
                        <input type="text" name="userEmail" id="userEmail" class="myinput" value="${user.userEmail}" onfocus="showTipUserEmail();" onblur="checkUserEmail();"/>
                        <span id="emailtip" class="tip">请输入邮箱名</span>
                        <span id="emailerr" class="err"></span>
                    </td>
                </tr>
                <tr>
                    <td><label>用户类型:</label></td>
                    <td>
                        <input type="radio" name="userType" value="admin" ${user.userType=='admin'? 'checked':''}>管理员
                        <input type="radio" name="userType" value="users" ${user.userType=='users'? 'checked':''}>学生
                    </td>
                </tr>
                <tr>
                    <td><label>学院:</label></td>
                    <td><select name="userDept">
                        <option>--请选择--</option>
                        <option value="无"${user.userDept=='无'? 'selected = "selected"':''}>管理员</option>
                        <option value="艺术学院"${user.userDept=='艺术学院'? 'selected = "selected"':''}>艺术学院</option>
                        <option value="商学院"${user.userDept=='商学院'? 'selected = "selected"':''}>商学院</option>
                        <option value="土建学院"${user.userDept=='土建学院'? 'selected = "selected"':''}>土建学院</option>
                        <option value="智能制造学院"${user.userDept=='智能制造学院'? 'selected = "selected"':''}>智能制造学院</option>
                        <option value="制药学院"${user.userDept=='制药学院'? 'selected = "selected"':''}>制药学院</option>
                        <option value="信息学院"${user.userDept=='信息学院'? 'selected = "selected"':''}>信息学院</option>
                        <option value="体育学院"${user.userDept=='体育学院'? 'selected = "selected"':''}>体育学院</option>
                    </select></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td>
                        <input type="submit" id="btnSubmit" name="btnSubmit" value="更新" class="mybutton"/>&nbsp&nbsp&nbsp
                        <input type="button" id="btnCancel" name="btnCancel" value="取消" class="mybutton" onclick="window.location.href='userinfo'"/>
                    </td>
                </tr>
            </table>
        </form>
</div>

<%--底部--%>
<jsp:include page="footer.jsp" /><%--动态包含--%>
</body>
</html>