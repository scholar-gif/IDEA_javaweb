package servlet;

import bean.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateScoreServlet extends HttpServlet {
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
        String studentId=request.getParameter("studentId");
        String studentName=request.getParameter("studentName");
        String scores=request.getParameter("score");

        //封装到DTO中
        ScoreDTO score= new ScoreDTO();
        score.setCourseId(courseId);
        score.setCourseName(courseName);
        score.setStudentId(studentId);
        score.setStudentName(studentName);
        score.setScore(scores);

        //创建模型对象
        ScoreDAO dao= new ScoreDAO();
        System.out.println(dao.updateScoreById(score));

        //调用业务逻辑方法并页面转发
        if(dao.updateScoreById(score)){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("scoreinfo");
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
