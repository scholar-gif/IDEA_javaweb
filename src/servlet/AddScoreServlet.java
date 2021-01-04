package servlet;

import bean.ScoreDAO;
import bean.ScoreDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddScoreServlet extends HttpServlet {

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
        String studentId=request.getParameter("studentId");
        String score=request.getParameter("score");
        //封装到DTO中
        ScoreDTO scores=new ScoreDTO();
        scores.setCourseId(courseId);
        scores.setStudentId(studentId);
        scores.setScore(score);
        //创建模型对象
        ScoreDAO dao=new ScoreDAO();

        //调用业务逻辑方法并页面转发
        if(dao.addScoreById(scores)){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("scoreinfo");
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
