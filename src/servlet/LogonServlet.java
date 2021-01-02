package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;

public class LogonServlet extends HttpServlet {


    public LogonServlet() {
        super();
    }

    
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

  
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

  
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //request.setCharacterEncoding("utf-8");
        //��ȡ������Ϣ
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        //����ģ�Ͷ���
        UserBean user = new UserBean();
        //����ҵ���߼�����
        if (user.isValidUser(userName, userPwd)) {
            HttpSession s = request.getSession();
            s.setAttribute("userid",userName);
            response.sendRedirect("main.jsp");//��֤�ɹ�
        }
        else
        	 response.sendRedirect("logon.jsp");
    }
}

