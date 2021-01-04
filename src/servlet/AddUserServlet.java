package servlet;

import bean.StudentDAO;
import bean.StudentDTO;
import bean.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  request.setCharacterEncoding("utf-8")

        //获取请求信息
        String userName      =request.getParameter("userName");
        String userPwd    =request.getParameter("userPwd");
        String userSex     =request.getParameter("userSex");
        String userEmail=request.getParameter("userEmail");
        String userBasic    =request.getParameter("userBasic");
        //封装到DTO中
        UserBean user= new UserBean();
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        user.setUserSex(userSex);
        user.setUserEmail(userEmail);
        user.setUserBasic(userBasic);
        //创建模型对象
        UserBean dao= new UserBean();

        //调用业务逻辑方法并页面转发
        if(dao.addUsers(user)){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("userinfo");
            requestDispatcher.forward(request, response);
        }
        else{
            request.setAttribute("mng","添加失败");
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("main");
            requestDispatcher.forward(request,response);
        }
    }

    public void init() throws ServletException {
        // Put your code here
    }
}
