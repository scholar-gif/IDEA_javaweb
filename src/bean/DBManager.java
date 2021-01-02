package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String DRIVER_CLASS="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String CONN_STR="jdbc:sqlserver://localhost:1433;DatabaseName=StudentInfo";
    private static final String USER_NAME="sa";
    private static final String USER_PWD="123456";

    public static Connection getConnection(){
        Connection con=null;
        try{
            //加载数据库驱动程序
            Class.forName(DRIVER_CLASS);
            System.out.println("数据库驱动加载成功！");
            con= DriverManager.getConnection(CONN_STR,USER_NAME,USER_PWD);
            System.out.println("数据库连接成功！");
        }
        catch(ClassNotFoundException e){
            //T0D0 Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}
