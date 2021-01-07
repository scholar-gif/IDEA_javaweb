package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;

public class LogonServlet extends HttpServlet {
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

  
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //request.setCharacterEncoding("utf-8");
        //获取请求信息
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        UserBean users = null;

        //创建模型对象
        UserBean user = new UserBean();
        //调用业务逻辑方法
        if (user.isValidUser(userName, userPwd)) {
            HttpSession s = request.getSession();
            s.setAttribute("userid",userName);
            users = user.isUser(userName, userPwd);
            s.setAttribute("users",users.getUserType());
            s.setAttribute("username",users);
            response.sendRedirect("main.jsp");//验证成功
        }
        else
        	 response.sendRedirect("logon.jsp");
    }
}

