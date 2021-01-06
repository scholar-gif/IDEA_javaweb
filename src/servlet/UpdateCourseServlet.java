package servlet;

import bean.CourseDAO;
import bean.CourseDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateCourseServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.flush();
        out.close();
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取请求信息
        String courseId=request.getParameter("courseId");
        String courseName=request.getParameter("courseName");
        String courseType=request.getParameter("courseType");
        String courseXf=request.getParameter("courseXf");
        String studentDept=request.getParameter("studentDept");

        //封装到DTO中
        CourseDTO score= new CourseDTO();
        score.setCourseId(courseId);
        score.setCourseName(courseName);
        score.setCourseType(courseType);
        score.setCourseXf(courseXf);
        score.setStudentDept(studentDept);

        //创建模型对象
        CourseDAO dao= new CourseDAO();
        System.out.println(dao.updateCourseById(score));

        //调用业务逻辑方法并页面转发
        if(dao.updateCourseById(score)){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("courseinfo");
            requestDispatcher.forward(request, response);
        }
        else{
            request.setAttribute("msg", "更新失败");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("getscoreinfo?CourseId="+courseId+"& CourseName="+courseName);
            requestDispatcher.forward(request,response);
        }
    }


    public void init() throws ServletException {

    }
}
