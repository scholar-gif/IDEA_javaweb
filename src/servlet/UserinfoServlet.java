package servlet;

import bean.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

public class UserinfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean dao = new UserBean();
        //调用业务逻辑方法
        LinkedList<UserBean> userlist=dao.queryAllUser();

        request.setAttribute("userlist",userlist);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("userinfo.jsp");
        requestDispatcher.forward(request, response);

    }
}
