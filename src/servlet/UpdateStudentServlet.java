package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentDAO;
import bean.StudentDTO;

public class UpdateStudentServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		System.out.println(dao.updateStudentById(student));
		
		//调用业务逻辑方法并页面转发
		if(dao.updateStudentById(student)){
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("studentinfo");
		     requestDispatcher.forward(request, response);
		}
		else{
			request.setAttribute("msg", "更新失败");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("getstudentinfo?studentid="+studentId);
			requestDispatcher.forward(request,response);
		}
	}

	
	public void init() throws ServletException {

	}

}
