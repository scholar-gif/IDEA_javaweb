package servlet;

import bean.ScoreDAO;
import bean.ScoreDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

public class ScoreinfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScoreDAO dao = new ScoreDAO();
        //调用业务逻辑方法
        LinkedList<ScoreDTO> scoreslist=dao.queryAllScores();

        request.setAttribute("scoreslist",scoreslist);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("scoreinfo.jsp");
        requestDispatcher.forward(request, response);

    }
}
