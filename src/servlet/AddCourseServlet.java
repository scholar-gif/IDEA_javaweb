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
import java.io.PrintWriter;

public class AddCourseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  request.setCharacterEncoding("utf-8")

        //获取请求信息
        String courseId=request.getParameter("courseId");
        String courseName=request.getParameter("courseName");
        String courseType=request.getParameter("courseType");
        String courseXf=request.getParameter("courseXf");
        String studentDept=request.getParameter("studentDept");
        //封装到DTO中
        CourseDTO course= new CourseDTO();
        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setCourseType(courseType);
        course.setCourseXf(courseXf);
        course.setStudentDept(studentDept);
        //创建模型对象
        CourseDAO dao= new CourseDAO();

        //调用业务逻辑方法并页面转发
        if(dao.addCourseById(course)){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("courseinfo");
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
