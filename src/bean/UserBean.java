package bean;

import java.sql.*;



public class UserBean {
    private String userName;
    private String userPwd;
    private char userSex;
    private String userEmail;
    private String userBasic;


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

    public char getUserSex() {
        return userSex;
    }
    public void setUserSex(char userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserBasic() {
        return userBasic;
    }
    public void setUserBasic(String userBasic) {
        this.userBasic = userBasic;
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

    //ע����֤
    public boolean addUser(String userName, String userPwd, String userSex, String userEmail, String userBasic) {
        boolean b=false;

        Connection con=null;
        PreparedStatement pstmt=null;

        try{
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="insert into User_Table values(?,?,?,?,?)";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            //System.out.println("ABC");
            pstmt.setString(1,userName);
            pstmt.setString(2,userPwd);
            pstmt.setString(3,userSex);
            pstmt.setString(4,userEmail);
            pstmt.setString(5,userBasic);

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
}

