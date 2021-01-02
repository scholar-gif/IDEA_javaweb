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


	public UpdateStudentServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//request.setCharacterEncoding("utf-8");
		
		//��ȡ������Ϣ
		String studentId=request.getParameter("studentId");
		String studentName=request.getParameter("studentName");
		String studentSex=request.getParameter("studentSex");
		String studentBirthday=request.getParameter("studentBirthday");
		String studentDept=request.getParameter("studentDept");
		String studentMajor=request.getParameter("studentMajor");
		String studentClassId=request.getParameter("studentClassId");
		
		//��װ��DTO��
		StudentDTO student=new StudentDTO();
		student.setStudentId(studentId);
		student.setStudentName(studentName);
		student.setStudentSex(studentSex);
		student.setStudentBirthday(studentBirthday);
		student.setStudentDept(studentDept);
		student.setStudentMajor(studentMajor);
		student.setStudentClassId(studentClassId);
		
		//����ģ�Ͷ���
		StudentDAO dao=new StudentDAO();
		System.out.println(dao.updateStudentById(student));
		
		//����ҵ���߼�������ҳ��ת��
		if(dao.updateStudentById(student)){
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("studentinfo");
		     requestDispatcher.forward(request, response);
		}
		else{
			request.setAttribute("msg", "����ʧ��");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("getstudentinfo?studentid="+studentId);
			requestDispatcher.forward(request,response);
		}
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
