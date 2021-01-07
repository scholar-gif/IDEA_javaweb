package servlet;

import bean.CourseDAO;
import bean.CourseDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

public class CourseManageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDAO dao = new CourseDAO();
        //调用业务逻辑方法
        LinkedList<CourseDTO> courselist = dao.queryAllCourse();

        request.setAttribute("courselist", courselist);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("coursemanage.jsp");
        requestDispatcher.forward(request, response);
    }
}
