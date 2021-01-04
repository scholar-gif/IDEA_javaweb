package servlet;

import bean.ScoreDAO;
import bean.ScoreDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelScoreServlet")
public class DelScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求信息
        String courseId=request.getParameter("courseId");
        String studentId=request.getParameter("studentId");
        //封装到DTO中
        ScoreDTO scores=new ScoreDTO();
        scores.setCourseId(courseId);
        scores.setStudentId(studentId);
        //创建模型对象
        ScoreDAO dao = new ScoreDAO();

        if(dao.delScoreId(scores)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("scoreinfo");
            requestDispatcher.forward(request,response);
        }
    }
}
