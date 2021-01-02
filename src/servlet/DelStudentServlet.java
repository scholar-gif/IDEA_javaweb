package servlet;

import bean.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelStudentServlet")
public class DelStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentid");
        System.out.println(studentId);

        //创建模型对象
        StudentDAO dao = new StudentDAO();


        if(dao.delStudentById(studentId)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("studentinfo");
            requestDispatcher.forward(request,response);
        }
    }
}
