package servlet;

import bean.StudentDAO;
import bean.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);

        //创建模型对象
        UserBean dao = new UserBean();


        if(dao.delusername(username)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("userinfo");
            requestDispatcher.forward(request,response);
        }
    }
}
