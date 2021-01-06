package servlet;

import bean.CourseDAO;
import bean.CourseDTO;
import bean.ScoreDAO;
import bean.ScoreDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

public class GetCourseinfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.setCharacterEncoding("utf-8");
        //  response.setContentType("text/html;charset=utf=8") ;

        String courseId = request.getParameter("courseId");
        System.out.println(courseId);
        //创建模型对象
        CourseDAO dao = new CourseDAO();
        //调用业务逻辑方法
        CourseDTO course=dao.queryCourseId(courseId);
        System.out.println(course.getCourseId());
        System.out.println(course.getCourseName());
        System.out.println(course.getCourseType());
        System.out.println(course.getCourseXf());
        System.out.println(course.getStudentDept());

        request.setAttribute("course",course);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("updatecourse.jsp");
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
