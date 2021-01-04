package bean;

import java.sql.*;
import java.util.LinkedList;


public class UserBean {
    private String userName;
    private String userPwd;
    private String userSex;
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
    public LinkedList<UserBean> queryAllUser(){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<UserBean> userlist=new LinkedList<UserBean>();
        UserBean user =null;
        ResultSet rs=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="select * from User_Table";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);

            //执行SQL语句
            rs=pstmt.executeQuery();

            while (rs.next()){
                user=new UserBean();
                user.setUserName(rs.getString(1));
                user.setUserPwd(rs.getString(2));
                user.setUserSex(rs.getString(3));
                user.setUserEmail(rs.getString(4));
                user.setUserBasic(rs.getString(5));
                userlist.add(user);
            }
        }

        catch (SQLException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            //关闭
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
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql=null;
            if(select.equals("用户名")){
                sql = "select * from User_Table where user_name=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("性别")){
                sql = "select * from User_Table where user_sex=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("邮箱")){
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
                user.setUserBasic(rs.getString(5));
                userlist.add(user);
            }
        }

        catch (SQLException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            //关闭
            try {rs.close();} catch (SQLException e) {}
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return userlist;
    }
    public boolean delusername(String username) {
        boolean b=false;

        //定义数据库驱动程序请求
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql= "delete from User_Table where user_name = ?";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            //对SQL语句中的参数赋值
            pstmt.setString(1,username);
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
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="select * from User_Table where user_name = ?";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,userName);
            rs=pstmt.executeQuery();
            //执行SQL语句
            while (rs.next()){
                user=new UserBean();
                user.setUserName(rs.getString(1));
                user.setUserPwd(rs.getString(2));
                user.setUserSex(rs.getString(3));
                user.setUserEmail(rs.getString(4));
                user.setUserBasic(rs.getString(5));
            }
        }

        catch (SQLException e){

        }
        finally{
            //关闭
            try {rs.close();} catch (SQLException e) {}
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return user;
    }
    public boolean updateuser(UserBean user) {
        boolean b=false;

        //定义数据库驱动程序请求
        Connection con=null;
        PreparedStatement pstmt=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="update User_Table set user_password = ?, user_sex = ?, user_email = ?, user_basic = ?"
                    +" where user_name = ?";

            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            //对SQL语句中的参数赋值
            pstmt.setString(1,user.getUserPwd());
            pstmt.setString(2,user.getUserSex());
            pstmt.setString(3,user.getUserEmail());
            pstmt.setString(4,user.getUserBasic());
            pstmt.setString(5,user.getUserName());
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
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return b;
    }
    public boolean addUsers(UserBean user) {
        boolean b=false;

        //定义数据库驱动程序请求
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
            //对SQL语句中的参数赋值
            pstmt.setString(1,user.getUserName());
            pstmt.setString(2,user.getUserPwd());
            pstmt.setString(3,user.getUserSex());
            pstmt.setString(4,user.getUserEmail());
            pstmt.setString(5,user.getUserBasic());
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
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return b;
    }
}

