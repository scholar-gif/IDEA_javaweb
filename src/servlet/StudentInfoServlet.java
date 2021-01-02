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

public class StudentInfoServlet extends HttpServlet{

    public StudentInfoServlet(){
        super();
    }
    public void destroy(){
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request.setCharacterEncoding("utf-8");
       // response.setContentType("text/html") ;
        //response.setCharacterEncoding("utf-8");
        //����ģ�Ͷ���
        StudentDAO dao = new StudentDAO();
        //����ҵ���߼�����
        LinkedList<StudentDTO> studentlist=dao.queryAllStudents();
        
        request.setAttribute("studentlist",studentlist);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("studentinfo.jsp");
        requestDispatcher.forward(request, response);

        //response.sendRedirect("studentinfo.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);

    }

    public void init() throws ServletException{

    }
}