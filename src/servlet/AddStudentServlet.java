package servlet;

import bean.StudentDAO;
import bean.StudentDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  request.setCharacterEncoding("utf-8")

        //获取请求信息
        String studentId=request.getParameter("studentId");
        String studentName=request.getParameter("studentName");
        String studentSex=request.getParameter("studentSex");
        String studentBirthday=request.getParameter("studentBirthday");
        String studentDept=request.getParameter("studentDept");
        String studentMajor=request.getParameter("studentMajor");
        String studentClassId=request.getParameter("studentClassId");
        //封装到DTO中
        StudentDTO student=new StudentDTO();
        student.setStudentId(studentId);
        student.setStudentName(studentName);
        student.setStudentSex(studentSex);
        student.setStudentBirthday(studentBirthday);
        student.setStudentDept(studentDept);
        student.setStudentMajor(studentMajor);
        student.setStudentClassId(studentClassId);
        //创建模型对象
        StudentDAO dao=new StudentDAO();

        //调用业务逻辑方法并页面转发
        if(dao.addStudentById(student)){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("studentinfo");
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
