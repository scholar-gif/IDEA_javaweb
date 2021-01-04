package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentDAO;
import bean.StudentDTO;

public class GetStudentinfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //request.setCharacterEncoding("utf-8");
	      //  response.setContentType("text/html;charset=utf=8") ;

	        String studentId=request.getParameter("studentid");
	        System.out.println(studentId);
	        //创建模型对象
	        StudentDAO dao = new StudentDAO();
	        //调用业务逻辑方法
	        StudentDTO student=dao.queryStudent(studentId);
	        System.out.println(student.getStudentId());
	        System.out.println(student.getStudentName());
	        System.out.println(student.getStudentSex());
	        System.out.println(student.getStudentBirthday());
	        System.out.println(student.getStudentDept());
	        System.out.println(student.getStudentMajor());
	        System.out.println(student.getStudentClassId());

	        request.setAttribute("student",student);
	        RequestDispatcher requestDispatcher=request.getRequestDispatcher("updatestudent.jsp");
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
