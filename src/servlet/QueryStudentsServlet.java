package servlet;

import bean.StudentDAO;
import bean.StudentDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "QuerytStudentServlet")
public class QueryStudentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String select_value = request.getParameter("selectvalue");
        select_value=new String (select_value.getBytes("iso-8859-1"),"utf-8");
        String select = request.getParameter("select");
        System.out.println(select);
        System.out.println(select_value);

        //创建模型对象
        StudentDAO dao = new StudentDAO();

        //调用业务逻辑方法
        LinkedList<StudentDTO> studentlist = dao.queryStudents(select,select_value);

        request.setAttribute("studentlist",studentlist);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("studentinfo.jsp");
        requestDispatcher.forward(request,response);

    }
}
