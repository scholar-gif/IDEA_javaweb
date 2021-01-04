package servlet;

import bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


    public class RegisterServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          //  request.setCharacterEncoding("utf-8");
            //获取请求信息
            String userName = request.getParameter("userName");
            String userPwd = request.getParameter("userPwd");
            String userSex = request.getParameter("userSex");
            String userEmail = request.getParameter("userEmail");
            String userBasic = request.getParameter("userBasic");
            //创建模型对象
            UserBean user = new UserBean();
            //调用业务逻辑方法
            if (user.addUser(userName, userPwd, userSex, userEmail, userBasic))
                response.sendRedirect("logon.jsp");//注册成功跳转到登录界面
            else
                response.sendRedirect("register.jsp");//注册失败重新进入注册页面
        }

        public void init() throws ServletException{

        }
    }

