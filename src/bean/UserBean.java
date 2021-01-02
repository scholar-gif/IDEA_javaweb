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

    //登录验证
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
            //加载数据库驱动程序
            Class.forName(driverClass);
            System.out.println("数据库驱动加载成功！");
            con= DriverManager.getConnection(connStr,username,pwd);
            System.out.println("数据库连接成功！");

            //编写SQl语句
            String sql="select * from User_Table where user_name= '"+userName+"' and user_password='"+userPwd+"'";
            System.out.println(sql);
            //创建语句对象
            stmt=con.createStatement();
            //执行SQL语句
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
            //关闭
            try {rs.close();}   catch (SQLException e) {}
            try {stmt.close();} catch (SQLException e1) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return b;
    }

    //注册验证
    public boolean addUser(String userName, String userPwd, String userSex, String userEmail, String userBasic) {
        boolean b=false;

        Connection con=null;
        PreparedStatement pstmt=null;

        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="insert into User_Table values(?,?,?,?,?)";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            //System.out.println("ABC");
            pstmt.setString(1,userName);
            pstmt.setString(2,userPwd);
            pstmt.setString(3,userSex);
            pstmt.setString(4,userEmail);
            pstmt.setString(5,userBasic);

            //执行SQL语句
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
            //关闭
            try {pstmt.close();} catch (SQLException e1) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return b;
    }
}

