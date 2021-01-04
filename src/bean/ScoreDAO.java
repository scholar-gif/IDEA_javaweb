package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ScoreDAO {
    public LinkedList<ScoreDTO> queryAllScores(){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<ScoreDTO> Scorelist=new LinkedList<ScoreDTO>();
        ScoreDTO Score =null;
        ResultSet rs=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="select Course_Table.course_name,Student_Table.student_id,student_name,(case when Score_Table.score>=80 then course_xf when Score_Table.score>=60 then course_xf-1 else 0 end),Score_Table.score,(case when Score_Table.score>=80 then '优秀' when Score_Table.score>=60 then '及格' else '不及格' end) from Student_Table,Score_Table,Course_Table where Score_Table.student_id = Student_Table.student_id  and Score_Table.course_id=Course_Table.course_id";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);

            //执行SQL语句
            rs=pstmt.executeQuery();

            while (rs.next()){
                Score=new ScoreDTO();
                Score.setCourseName(rs.getString(1));
                Score.setStudentId(rs.getString(2));
                Score.setStudentName(rs.getString(3));
                Score.setCourseXf(rs.getString(4));
                Score.setScore(rs.getString(5));
                Score.setJige(rs.getString(6));
                Scorelist.add(Score);
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
        return Scorelist;
    }

    public LinkedList<ScoreDTO> queryScoreId(String ScoreId){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<ScoreDTO> scorelist=new LinkedList<ScoreDTO>();
        ScoreDTO score =null;
        ResultSet rs=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="select Course_Table.course_name,Student_Table.student_id,student_name,(case when Score_Table.score>=80 then course_xf when Score_Table.score>=60 then course_xf-1 else 0 end),Score_Table.score,(case when Score_Table.score>=80 then '优秀' when Score_Table.score>=60 then '及格' else '不及格' end)" +
                    "from Student_Table,Score_Table,Course_Table" +
                    "where Score_Table.student_id = Student_Table.student_id and Student_Table.student_id = ? and Score_Table.course_id=Course_Table.course_id";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,ScoreId);
            rs=pstmt.executeQuery();
            //执行SQL语句
            while (rs.next()){
                score=new ScoreDTO();
                score.setCourseName(rs.getString(1));
                score.setStudentId(rs.getString(2));
                score.setStudentName(rs.getString(3));
                score.setCourseXf(rs.getString(4));
                score.setScore(rs.getString(5));
                score.setJige(rs.getString(6));
                scorelist.add(score);
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
        return scorelist;
    }

    public boolean updateScoreById(ScoreDTO Score) {
        boolean b=false;

        //定义数据库驱动程序请求
        Connection con=null;
        PreparedStatement pstmt=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="update Score_Table set coure_id = ?, score = ?"
                    + " where student_id = ?";

            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            //对SQL语句中的参数赋值
            pstmt.setString(1,Score.getCourseId());
            pstmt.setString(2,Score.getScore());
            pstmt.setString(3,Score.getStudentId());

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

    public boolean addScoreById(ScoreDTO Score) {
        boolean b=false;

        //定义数据库驱动程序请求
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="insert into Score_Table values(?,?,?)";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            //对SQL语句中的参数赋值
            pstmt.setString(1,Score.getStudentId());
            pstmt.setString(2,Score.getScore());
            pstmt.setString(3,Score.getCourseId());
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

    public boolean delScoreId(ScoreDTO Score) {
        boolean b=false;

        //定义数据库驱动程序请求
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql= "delete from Score_Table where course_id = ?,student_id = ?";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            //对SQL语句中的参数赋值
            pstmt.setString(1,Score.getCourseId());
            pstmt.setString(2,Score.getStudentId());
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

    public LinkedList<ScoreDTO> queryscores(String select,String select_value){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<ScoreDTO> scorelist=new LinkedList<ScoreDTO>();
        ScoreDTO score =null;
        ResultSet rs=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql=null;
            if(select.equals("姓名")){
                sql = "select Course_Table.course_name,Student_Table.student_id,student_name,(case when Score_Table.score>=80 then course_xf when Score_Table.score>=60 then course_xf-1 else 0 end),Score_Table.score,(case when Score_Table.score>=80 then '优秀' when Score_Table.score>=60 then '及格' else '不及格' end)" +
                        "from Student_Table,Score_Table,Course_Table" +
                        "where Score_Table.student_id = Student_Table.student_id  and Score_Table.course_id=Course_Table.course_id and student_name = ?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("学号")){
                sql = "select Course_Table.course_name,Student_Table.student_id,student_name,(case when Score_Table.score>=80 then course_xf when Score_Table.score>=60 then course_xf-1 else 0 end),Score_Table.score,(case when Score_Table.score>=80 then '优秀' when Score_Table.score>=60 then '及格' else '不及格' end)" +
                        "from Student_Table,Score_Table,Course_Table \n" +
                        "where Score_Table.student_id = Student_Table.student_id and Student_Table.student_id = ? and Score_Table.course_id=Course_Table.course_id";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("课程")){
                sql = "select Course_Table.course_name,Student_Table.student_id,student_name,(case when Score_Table.score>=80 then course_xf when Score_Table.score>=60 then course_xf-1 else 0 end),Score_Table.score,(case when Score_Table.score>=80 then '优秀' when Score_Table.score>=60 then '及格' else '不及格' end)" +
                        "from Student_Table,Score_Table,Course_Table" +
                        "where Score_Table.student_id = Student_Table.student_id and Score_Table.course_id = ? and Score_Table.course_id=Course_Table.course_id";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            while (rs.next()){
                score=new ScoreDTO();
                score.setCourseName(rs.getString(1));
                score.setStudentId(rs.getString(2));
                score.setStudentName(rs.getString(3));
                score.setCourseXf(rs.getString(4));
                score.setScore(rs.getString(5));
                score.setJige(rs.getString(6));
                scorelist.add(score);
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
        return scorelist;
    }

}
