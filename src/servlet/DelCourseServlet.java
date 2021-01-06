package servlet;

import bean.CourseDAO;
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
public class DelCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求信息
        String courseId=request.getParameter("courseId");
        System.out.println(courseId);
        //创建模型对象
        CourseDAO dao = new CourseDAO();

        if(dao.delCourseId(courseId)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("courseinfo");
            requestDispatcher.forward(request,response);
        }
    }
}
