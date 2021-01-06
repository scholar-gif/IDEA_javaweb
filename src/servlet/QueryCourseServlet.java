package servlet;

import bean.CourseDAO;
import bean.CourseDTO;
import bean.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

public class QueryCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String select_value = request.getParameter("selectvalue");
        String select = request.getParameter("select");
        System.out.println(select);
        System.out.println(select_value);

        //创建模型对象
        CourseDAO dao = new CourseDAO();

        //调用业务逻辑方法
        LinkedList<CourseDTO> courselist = dao.queryscores(select,select_value);

        request.setAttribute("courselist",courselist);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("courseinfo.jsp");
        requestDispatcher.forward(request,response);

    }
}
