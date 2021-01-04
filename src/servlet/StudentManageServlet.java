package servlet;

import bean.StudentDAO;
import bean.StudentDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

public class StudentManageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //创建模型对象
        StudentDAO dao = new StudentDAO();
        //调用业务逻辑方法
        LinkedList<StudentDTO> studentlist=dao.queryAllStudents();

        request.setAttribute("studentlist",studentlist);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("studentManage.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);

    }

    public void init() throws ServletException{

    }
}
