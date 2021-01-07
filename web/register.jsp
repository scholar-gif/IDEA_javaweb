<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'register.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="CSS/style.css">
    <script language="javascript" type="text/javascript">
        var validUserName = false;//用户是否通过验证
        var validUserPwd = false;
        var validUserPwd1 = false;
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


        //确认密码
        function showTipUserPwd1() {
            document.getElementById("pwdtip1").style.display = "block";//提示打开
            document.getElementById("pwderr1").style.display = "none";//错误提示关闭
            document.frmRegister.userPwd1.style.borderColor ="azure";//边框颜色
        }

        function checkUserPwd1() {
            document.getElementById("pwdtip1").style.display = "none";//提示关闭
            document.frmRegister.userPwd1.style.borderColor ="azure";//边框颜色
            var pwdvalue = document.frmRegister.userPwd.value;//文本框内容提取
            var pwdvalue1 = document.frmRegister.userPwd1.value;//文本框内容提取
            if (!pwdvalue) {
                document.getElementById("pwderr1").innerHTML = "确认密码不能为空*";
                document.getElementById("pwderr1").style.display = "block";//错误提示打开
                validUserPwd = false;//密码状态错误
            } else {
                if (pwdvalue != pwdvalue1) {
                    document.getElementById("pwderr1").innerHTML = "确认密码与密码不一致*";
                    document.getElementById("pwderr1").style.display = "block";//错误提示打开
                    validUserPwd1 = false;
                } else {
                    document.getElementById("pwderr").style.display = "none";//错误提示关闭
                    document.frmRegister.userPwd1.style.borderColor ="azure";//边框颜色
                    validUserPwd1 = true;
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


        //对整个表单进行检查
        function checkFrom() {
            if (validUserName == true && validUserPwd == true && validUserPwd1 == true && validUserEmail == true)
                return true;
            else
                return false;
        }

    </script>

</head>


<body style="background-image:url(TP/cat.jpg);">
<fieldset style="width:40%;height:92%;margin: 2% 50%;background:rgba(255,255,255,0.2);">
    <br>
    <legend style="color:darkslateblue;font-size:30px"> <b style="text-shadow: 1px 1px 1px gray;" >学生信息管理系统</b><b><sup style="font-size:10px">软件1181 胡佳10212818126</sup></b></legend>
    <h1 id="title">注册新用户</h1>
    <form  action="register" name="frmRegister" method="post" onsubmit="return checkFrom();"><!--action 注册成功后的跳转-->
        <table align="center" ><!--表格行间距和对齐方式-->
            <tr>
                <td valign="top" class="mylable"><label for="userName" >用  户  名:</label></td>
                <td width="75%">
                    <input type="text" name="userName" id="userName" class="input" onfocus="showTipUserName();" onblur="checkUserName();"/>
                    <span id="usertip" class="tip">字母数字下划线2-10位，第1位不能为数字</span>
                    <span id="usererr" class="err"></span>
                </td>
            </tr>

            <tr>
                <td valign="top" class="mylable"><label for="userPwd">密码:</label></td>
                <td>
                    <input type="password" name="userPwd" id="userPwd" class="input" onfocus="showTipUserPwd();" onblur="checkUserPwd();"/>
                    <span id="pwdtip" class="tip">密码长度为6-16</span>
                    <span id="pwderr" class="err"></span>
                </td>
            </tr>

            <tr>
                <td valign="top" class="mylable"><label for="userPwd1" >确认密码:</label></td>
                <td>
                    <!--2.密码输入框控件-->
                    <input type="password" name="userPwd1" id="userPwd1" class="input" onfocus="showTipUserPwd1();" onblur="checkUserPwd1();"/>
                    <span id="pwdtip1" class="tip">确认密码必须与密码一致</span>
                    <span id="pwderr1" class="err"></span>
                </td>
            </tr>

            <tr>
                <td class="mylable">性   别:</td>
                <td>
                    <!--radio单选输入框控件，由于无法输入value，所以预先定义好-->
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="userSex" value="男" id="m"/>
                    <label for="m" >男</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="userSex" value="女" id="n"/>
                    <label for="n" >女</label>
                </td>
            </tr>

            <tr>
                <td valign="top" class="mylable"><label for="userEmail" >电子邮箱:</label></td>
                <td>
                    <!--text文本输入框控件-->
                    <input type="text" name="userEmail" id="userEmail" class="input" onfocus="showTipUserEmail();" onblur="checkUserEmail();"/>
                    <span id="emailtip" class="tip">请输入邮箱名</span>
                    <span id="emailerr" class="err"></span>
                </td>
            </tr>

            <tr>
                <td><label>用户类型:</label></td>
                <td>
                    <input type="radio" name="userType" value="admin">管理员
                    <input type="radio" name="userType" value="users">学生
                </td>

            </tr>

            <tr>
                <td><label>学院:</label></td>
                <td><select name="userDept">
                    <option>--请选择--</option>
                    <option value="无">管理员</option>
                    <option value="艺术学院">艺术学院</option>
                    <option value="商学院">商学院</option>
                    <option value="土建学院">土建学院</option>
                    <option value="智能制造学院">智能制造学院</option>
                    <option value="制药学院">制药学院</option>
                    <option value="信息学院">信息学院</option>
                    <option value="体育学院">体育学院</option>
                </select></td>
            </tr>
            <tr>

                <td colspan="2" align="center">
                    <input type="submit" value="注册" class="mybutton"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="重填" class="mybutton"/>
                </td>
            </tr>

        </table>
    </form>
</fieldset>
</body>
</html>

