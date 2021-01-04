package servlet;

import bean.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


    public class RegisterServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          //  request.setCharacterEncoding("utf-8");
            //��ȡ������Ϣ
            String userName = request.getParameter("userName");
            String userPwd = request.getParameter("userPwd");
            String userSex = request.getParameter("userSex");
            String userEmail = request.getParameter("userEmail");
            String userBasic = request.getParameter("userBasic");
            //����ģ�Ͷ���
            UserBean user = new UserBean();
            //����ҵ���߼�����
            if (user.addUser(userName, userPwd, userSex, userEmail, userBasic))
                response.sendRedirect("logon.jsp");//ע��ɹ���ת����¼����
            else
                response.sendRedirect("register.jsp");//ע��ʧ�����½���ע��ҳ��
        }

        public void init() throws ServletException{

        }
    }

