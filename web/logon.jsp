<%@ page language="java" import="java.util.*,bean.UserBean" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'logon.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="CSS/style.css">

    <script language="javascript" type="text/javascript">
        var validUserName = false;//用户是否通过验证
        var validUserPwd = false;

        function showTipUserName() {//点击时状态
            document.getElementById("usertip").style.display = "block";//提示打开
            document.getElementById("usererr").style.display = "none";//错误提示关闭
            document.frmLogon.userName.style.borderColor = "azure";//边框颜色
        }

        function checkUserName() {//非点击时状态
            document.getElementById("usertip").style.display = "none";//提示关闭
            document.frmLogon.userName.style.borderColor = "azure";//边框颜色
            var username = document.frmLogon.userName.value;//文本框内容提取
            var reg = /^[\w_\u2e00-\u9fa5]{1,9}$/;//用户名格式要求

            if (!username) {
                document.getElementById("usererr").innerHTML = "用户名不能为空*";
                document.getElementById("usererr").style.display = "block";//错误提示打开
                validUserName = false;//用户名状态错误
            } else {
                if (!reg.test(username)) {
                    document.getElementById("usererr").innerHTML = "用户名不合法*";
                    document.getElementById("usererr").style.display = "block";//错误提示打开
                    validUserName = false;//用户名状态错误
                } else {
                    document.getElementById("usererr").style.display = "none";//错误提示关闭
                    document.frmLogon.userName.style.borderColor = "azure";//边框颜色
                    validUserName = true;//用户名状态正确
                }
            }
        }

        function showTipUserPwd() {//点击时状态
            document.getElementById("pwdtip").style.display = "block";//提示打开
            document.getElementById("pwderr").style.display = "none";//错误提示关闭
            document.frmLogon.userPwd.style.borderColor = "azure";//边框颜色
        }

        function checkUserPwd() {//非点击时状态
            document.getElementById("pwdtip").style.display = "none";//提示关闭
            document.frmLogon.userPwd.style.borderColor = "azure";//边框颜色
            var pwdvalue = document.frmLogon.userPwd.value;//文本框内容提取
            var reg = /^.{6,16}$/;//密码格式要求

            if (!pwdvalue) {
                document.getElementById("pwderr").innerHTML = "密码不能为空*";
                document.getElementById("pwderr").style.display = "block";//错误提示打开
                validUserPwd = false;//密码状态错误
            } else {
                if (!reg.test(pwdvalue)) {
                    document.getElementById("pwderr").innerHTML = "密码长度错误*";
                    document.getElementById("pwderr").style.display = "block";//错误提示打开
                    validUserPwd = false;//密码状态错误
                } else {
                    document.getElementById("pwderr").style.display = "none";//错误提示关闭
                    document.frmLogon.userPwd.style.borderColor = "azure";//边框颜色
                    validUserPwd = true;//密码状态正确
                }
            }
        }

        //对整个表单进行检查
        function checkFrom() {
            if (validUserName == true && validUserPwd == true)
                return true;
            else
                return false;
        }
    </script>

</head>

<body style="background-image:url(TP/cat.jpg); ">

<fieldset style="width:40%;height:60%;margin: 10% 50%;background:rgba(255,255,255,0.2);">

    <legend style="color:darkslateblue;font-size:30px"><b style="text-shadow: 1px 1px 1px gray;">学生信息管理系统</b><b><sup
            style="font-size:10px">软件1181 胡佳 10212818126</sup></b></legend>
    <h1>用户登录</h1>
    <form action="logon" name="frmLogon" method="post" onsubmit="return checkFrom();">
        <table align="center" cellspacing="10" width="90%">
            <tr>
                <th valign="top" width="35%" align="right"><label for="userName" class="mylable">用户名:</label></th>
                <td>
                    <input type="text" name="userName" id="userName" class="input" onfocus="showTipUserName();"
                           onblur="checkUserName()"/>
                    <span id="usertip" class="tip">字母数字下划线4-10位，第1位不能为数字</span>
                    <span id="usererr" class="err"></span>
                </td>
            </tr>

            <tr>
                <th valign="top" width="35%" align="right"><label for="userPwd" class="mylable">密码:</label></th>
                <td>
                    <input type="password" name="userPwd" id="userPwd" class="input" onfocus="showTipUserPwd();"
                           onblur="checkUserPwd();"/>
                    <span id="pwdtip" class="tip">请输入登录密码</span>
                    <span id="pwderr" class="err"></span>
                </td>
            </tr>
            <td></td>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="登录" class="mybutton"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="取消" class="mybutton"/>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="right"><a href="register.jsp" style="text-decoration: none">新用户注册</a></td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>

