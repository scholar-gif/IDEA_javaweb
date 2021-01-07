package bean;

import java.sql.*;
import java.util.LinkedList;


public class UserBean {
    private String userName;
    private String userPwd;
    private String userSex;
    private String userEmail;
    private String userType;
    private String userDept;

    public String getUserDept() {return userDept; }
    public void setUserDept(String userDept) { this.userDept = userDept; }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserSex() {
        return userSex;
    }
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }

    //��¼��֤
    public boolean isValidUser(String userName,String userPwd){
        boolean b=false;
        /*
        if(userName != null && userName.equals("zhangsan") && userPwd != null && userPwd.equals("123456"))
            b= true;
        else
            b= false;
        */
        final String driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        final String connStr="jdbc:sqlserver://localhost:1433;DatabaseName=StudentInfo";
        final String username="sa";
        final String pwd="123456";

        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        try{
            //�������ݿ���������
            Class.forName(driverClass);
            System.out.println("���ݿ��������سɹ���");
            con= DriverManager.getConnection(connStr,username,pwd);
            System.out.println("���ݿ����ӳɹ���");

            //��дSQl���
            String sql="select * from User_Table where user_name= '"+userName+"' and user_password='"+userPwd+"'";
            System.out.println(sql);
            //����������
            stmt=con.createStatement();
            //ִ��SQL���
            rs=stmt.executeQuery(sql);

            if (rs.next()){
                for (int i=0;i<rs.getMetaData().getColumnCount();i++)
                    System.out.print(rs.getString(i+1) + " ");
                rs.getString(5);
                b=true;
            }
        }
        catch(ClassNotFoundException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            //�ر�
            try {rs.close();}   catch (SQLException e) {}
            try {stmt.close();} catch (SQLException e1) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return b;
    }
    public UserBean isUser(String userName,String userPwd){
        /*
        if(userName != null && userName.equals("zhangsan") && userPwd != null && userPwd.equals("123456"))
            b= true;
        else
            b= false;
        */
        final String driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        final String connStr="jdbc:sqlserver://localhost:1433;DatabaseName=StudentInfo";
        final String username="sa";
        final String pwd="123456";

        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        UserBean user = null;

        try{
            //�������ݿ���������
            Class.forName(driverClass);
            System.out.println("���ݿ��������سɹ���");
            con= DriverManager.getConnection(connStr,username,pwd);
            System.out.println("���ݿ����ӳɹ���");

            //��дSQl���
            String sql="select * from User_Table where user_name= '"+userName+"' and user_password='"+userPwd+"'";
            System.out.println(sql);
            //����������
            stmt=con.createStatement();
            //ִ��SQL���
            rs=stmt.executeQuery(sql);

            while (rs.next()) {
                user = new UserBean();
                user.setUserName(rs.getString(1));
                user.setUserPwd(rs.getString(2));
                user.setUserSex(rs.getString(3));
                user.setUserEmail(rs.getString(4));
                user.setUserType(rs.getString(5));
                user.setUserDept(rs.getString(6));
            }
        }
        catch(ClassNotFoundException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            //�ر�
            try {rs.close();}   catch (SQLException e) {}
            try {stmt.close();} catch (SQLException e1) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return user;
    }

    //ע����֤
    public boolean addUser(String userName, String userPwd, String userSex, String userEmail, String userType,  String userDept) {
        boolean b=false;

        Connection con=null;
        PreparedStatement pstmt=null;

        try{
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="insert into User_Table values(?,?,?,?,?,?)";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            //System.out.println("ABC");
            pstmt.setString(1,userName);
            pstmt.setString(2,userPwd);
            pstmt.setString(3,userSex);
            pstmt.setString(4,userEmail);
            pstmt.setString(5,userType);
            pstmt.setString(6,userDept);

            //ִ��SQL���
            int n=pstmt.executeUpdate();

            if (n>0){
                b=true;
            }
        }

        catch (SQLException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            //�ر�
            try {pstmt.close();} catch (SQLException e1) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return b;
    }
    public LinkedList<UserBean> queryAllUser(){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<UserBean> userlist=new LinkedList<UserBean>();
        UserBean user =null;
        ResultSet rs=null;
        try{
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="select * from User_Table";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);

            //ִ��SQL���
            rs=pstmt.executeQuery();

            while (rs.next()){
                user=new UserBean();
                user.setUserName(rs.getString(1));
                user.setUserPwd(rs.getString(2));
                user.setUserSex(rs.getString(3));
                user.setUserEmail(rs.getString(4));
                user.setUserType(rs.getString(5));
                user.setUserDept(rs.getString(6));
                userlist.add(user);
            }
        }

        catch (SQLException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            //�ر�
            try {rs.close();} catch (SQLException e) {}
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return userlist;
    }
    public LinkedList<UserBean> queryAllUser(String select, String select_value){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<UserBean> userlist=new LinkedList<UserBean>();
        UserBean user =null;
        ResultSet rs=null;
        try{
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql=null;
            if(select.equals("�û���")){
                sql = "select * from User_Table where user_name=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("�Ա�")){
                sql = "select * from User_Table where user_sex=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("����")){
                sql = "select * from User_Table where user_email=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            while (rs.next()){
                user=new UserBean();
                user.setUserName(rs.getString(1));
                user.setUserPwd(rs.getString(2));
                user.setUserSex(rs.getString(3));
                user.setUserEmail(rs.getString(4));
                user.setUserType(rs.getString(5));
                userlist.add(user);
            }
        }

        catch (SQLException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            //�ر�
            try {rs.close();} catch (SQLException e) {}
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return userlist;
    }
    public boolean delusername(String username) {
        boolean b=false;

        //�������ݿ�������������
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql= "delete from User_Table where user_name = ?";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            //��SQL����еĲ�����ֵ
            pstmt.setString(1,username);
            //ִ��SQL���
            int n=pstmt.executeUpdate();

            if (n>0){
                b=true;
            }
        }
        catch (SQLException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            //�ر�
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return b;
    }
    public UserBean queryuser(String userName) {
        Connection con=null;
        PreparedStatement pstmt=null;
        UserBean user =null;
        ResultSet rs=null;
        try{
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="select * from User_Table where user_name = ?";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,userName);
            rs=pstmt.executeQuery();
            //ִ��SQL���
            while (rs.next()){
                user=new UserBean();
                user.setUserName(rs.getString(1));
                user.setUserPwd(rs.getString(2));
                user.setUserSex(rs.getString(3));
                user.setUserEmail(rs.getString(4));
                user.setUserType(rs.getString(5));
                user.setUserDept(rs.getString(6));
            }
        }

        catch (SQLException e){

        }
        finally{
            //�ر�
            try {rs.close();} catch (SQLException e) {}
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return user;
    }
    public boolean updateuser(UserBean user) {
        boolean b=false;

        //�������ݿ�������������
        Connection con=null;
        PreparedStatement pstmt=null;
        try{
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="update User_Table set user_password = ?, user_sex = ?, user_email = ?, user_type = ?, user_dept = ?"
                    +" where user_name = ?";

            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            //��SQL����еĲ�����ֵ
            pstmt.setString(1,user.getUserPwd());
            pstmt.setString(2,user.getUserSex());
            pstmt.setString(3,user.getUserEmail());
            pstmt.setString(4,user.getUserType());
            pstmt.setString(5,user.getUserDept());
            pstmt.setString(6,user.getUserName());
            //ִ��SQL���
            int n=pstmt.executeUpdate();

            if (n>0){
                b=true;
            }
        }

        catch (SQLException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            //�ر�
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return b;
    }
    public boolean addUsers(UserBean user) {
        boolean b=false;

        //�������ݿ�������������
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="insert into User_Table values(?,?,?,?,?,?)";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            //��SQL����еĲ�����ֵ
            pstmt.setString(1,user.getUserName());
            pstmt.setString(2,user.getUserPwd());
            pstmt.setString(3,user.getUserSex());
            pstmt.setString(4,user.getUserEmail());
            pstmt.setString(5,user.getUserType());
            pstmt.setString(6,user.getUserDept());
            //ִ��SQL���
            int n=pstmt.executeUpdate();

            if (n>0){
                b=true;
            }
        }
        catch (SQLException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            //�ر�
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return b;
    }
}

