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
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求信息
        String courseId = request.getParameter("courseId");
        String studentId = request.getParameter("studentId");
        //创建模型对象
        ScoreDAO dao = new ScoreDAO();
        if (courseId == null && studentId == null) {
            String[] cbxscore = request.getParameterValues("cbxscore");
            for (String name :cbxscore) {
                System.out.println(name);
                String split1 = name.substring(0,4);
                String split2 = name.substring(4,8);
                System.out.println(split1+","+split2);
                dao.delScoreId(split2,split1);
            }
        } else
            dao.delScoreId(courseId,studentId);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("scoreinfo");
        requestDispatcher.forward(request, response);
    }
}
