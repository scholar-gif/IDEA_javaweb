package servlet;

import bean.ScoreDAO;
import bean.ScoreDTO;
import bean.StudentDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetScoreinfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.setCharacterEncoding("utf-8");
        //  response.setContentType("text/html;charset=utf=8") ;

        String studentId=request.getParameter("studentId");
        String courseId = request.getParameter("courseId");
        System.out.println(studentId);
        System.out.println(courseId);
        //创建模型对象
        ScoreDAO dao = new ScoreDAO();
        //调用业务逻辑方法
        ScoreDTO score=dao.queryScoreId(studentId,courseId);
        System.out.println(score.getCourseId());
        System.out.println(score.getCourseName());
        System.out.println(score.getStudentId());
        System.out.println(score.getStudentName());
        System.out.println(score.getScore());

        request.setAttribute("score",score);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("updatescore.jsp");
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
