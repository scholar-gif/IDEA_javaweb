package servlet;

import bean.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateUserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.flush();
        out.close();
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取请求信息
        String userName=request.getParameter("userName");
        String userPwd=request.getParameter("userPwd");
        String userSex=request.getParameter("userSex");
        String userEmail=request.getParameter("userEmail");
        String userType=request.getParameter("userType");
        String userdept=request.getParameter("userDept");

        //封装到DTO中
        UserBean user=new UserBean();
        user.setUserPwd(userPwd);
        user.setUserName(userName);
        user.setUserSex(userSex);
        user.setUserEmail(userEmail);
        user.setUserType(userType);
        user.setUserDept(userdept);

        //创建模型对象
        UserBean dao=new UserBean();
        System.out.println(dao.updateuser(user));

        //调用业务逻辑方法并页面转发
        if(dao.updateuser(user)){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("userinfo");
            requestDispatcher.forward(request, response);
        }
        else{
            request.setAttribute("msg", "更新失败");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("getuserinfo?username="+userName);
            requestDispatcher.forward(request,response);
        }
    }


    public void init() throws ServletException {

    }
}
