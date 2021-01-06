package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class CourseDAO {
    public LinkedList<CourseDTO> queryAllCourse(){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<CourseDTO> courselist=new LinkedList<CourseDTO>();
        CourseDTO course =null;
        ResultSet rs=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="select * from Course_Table";
            System.out.println(sql);

            //创建预编译语句
            pstmt=con.prepareStatement(sql);

            //执行SQL语句
            rs=pstmt.executeQuery();

            while (rs.next()){
                course=new CourseDTO();
                course.setCourseId(rs.getString(1));
                course.setCourseName(rs.getString(2));
                course.setCourseType(rs.getString(3));
                course.setCourseXf(rs.getString(4));
                course.setStudentDept(rs.getString(5));
                courselist.add(course);
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
        return courselist;
    }

    public CourseDTO queryCourseId(String courseId){
        Connection con=null;
        PreparedStatement pstmt=null;
        CourseDTO course =null;
        ResultSet rs=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="select * from Course_Table where course_id = ?";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,courseId);
            rs=pstmt.executeQuery();
            //执行SQL语句
            while (rs.next()){
                course=new CourseDTO();
                course.setCourseId(rs.getString(1));
                course.setCourseName(rs.getString(2));
                course.setCourseType(rs.getString(3));
                course.setCourseXf(rs.getString(4));
                course.setStudentDept(rs.getString(5));
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
        return course;
    }

    public boolean updateCourseById(CourseDTO course) {
        boolean b=false;

        //定义数据库驱动程序请求
        Connection con=null;
        PreparedStatement pstmt=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="update Course_Table set course_id =?, course_name =?, course_type =?, course_xf =?,course_Dept =? where course_id =?";

            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            //对SQL语句中的参数赋值
            pstmt.setString(1,course.getCourseId());
            pstmt.setString(2,course.getCourseName());
            pstmt.setString(3,course.getCourseType());
            pstmt.setString(4,course.getCourseXf());
            pstmt.setString(5,course.getStudentDept());
            pstmt.setString(6,course.getCourseId());

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

    public boolean addCourseById(CourseDTO course) {
        boolean b=false;

        //定义数据库驱动程序请求
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="insert into Course_Table values(?,?,?,?,?)";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            //对SQL语句中的参数赋值
            pstmt.setString(1,course.getCourseId());
            pstmt.setString(2,course.getCourseName());
            pstmt.setString(3,course.getCourseType());
            pstmt.setString(4,course.getCourseXf());
            pstmt.setString(5,course.getStudentDept());
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

    public boolean delCourseId(String course) {
        boolean b=false;

        //定义数据库驱动程序请求
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql= "delete from Course_Table where course_id = ?";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            //对SQL语句中的参数赋值
            pstmt.setString(1,course);
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

    public LinkedList<CourseDTO> queryscores(String select,String select_value){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<CourseDTO> courselist=new LinkedList<CourseDTO>();
        CourseDTO course =null;
        ResultSet rs=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql=null;
            if(select.equals("课程号")){
                sql = "select * from Course_Table where course_id = ?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("课程名")){
                sql = "select * from Course_Table where course_name = ?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("所属学院")){
                sql = "select * from Course_Table where course_Dept = ?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("课程类型")){
                sql = "select * from Course_Table where course_type = ?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            while (rs.next()){
                course=new CourseDTO();
                course.setCourseId(rs.getString(1));
                course.setCourseName(rs.getString(1));
                course.setCourseType(rs.getString(1));
                course.setCourseXf(rs.getString(1));
                course.setStudentDept(rs.getString(1));
                courselist.add(course);
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
        return courselist;
    }
}
