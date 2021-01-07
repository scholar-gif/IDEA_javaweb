package servlet;

import bean.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetUserinfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName=request.getParameter("username");
        System.out.println(userName);
        //创建模型对象
        UserBean dao = new UserBean();
        //调用业务逻辑方法
        UserBean user=dao.queryuser(userName);
        System.out.println(user.getUserName());
        System.out.println(user.getUserPwd());
        System.out.println(user.getUserSex());
        System.out.println(user.getUserEmail());
        System.out.println(user.getUserType());
        System.out.println(user.getUserDept());

        request.setAttribute("user",user);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("updateuser.jsp");
        requestDispatcher.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request,response);
    }


    public void init() throws ServletException {
        // Put your code here
    }
}
