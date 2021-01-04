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
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="select * from Course_Table";
            System.out.println(sql);

            //����Ԥ�������
            pstmt=con.prepareStatement(sql);

            //ִ��SQL���
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
            //�ر�
            try {rs.close();} catch (SQLException e) {}
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return courselist;
    }

    public LinkedList<CourseDTO> queryCourseId(String courseId){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<CourseDTO> courselist=new LinkedList<CourseDTO>();
        CourseDTO course =null;
        ResultSet rs=null;
        try{
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="select * from Course_Table where course_id = ?";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,courseId);
            rs=pstmt.executeQuery();
            //ִ��SQL���
            while (rs.next()){
                course=new CourseDTO();
                course.setCourseName(rs.getString(1));
                course.setStudentId(rs.getString(2));
                course.setStudentName(rs.getString(3));
                course.setCourseXf(rs.getString(4));
                course.setScore(rs.getString(5));
                courselist.add(course);
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
        return scorelist;
    }

    public boolean updateScoreById(CourseDTO score) {
        boolean b=false;

        //�������ݿ�������������
        Connection con=null;
        PreparedStatement pstmt=null;
        try{
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="update Score_Table set coure_id = ?, score = ?"
                    + " where student_id = ?";

            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            //��SQL����еĲ�����ֵ
            pstmt.setString(1,score.getCourseId());
            pstmt.setString(2,score.getScore());
            pstmt.setString(3,score.getStudentId());

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

    public boolean addScoreById(CourseDTO score) {
        boolean b=false;

        //�������ݿ�������������
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="insert into Score_Table values(?,?,?)";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            //��SQL����еĲ�����ֵ
            pstmt.setString(1,score.getCourseId());
            pstmt.setString(2,score.getScore());
            pstmt.setString(3,score.getStudentId());
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

    public boolean delScoreId(CourseDTO score) {
        boolean b=false;

        //�������ݿ�������������
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql= "delete from Score_Table where course_id = ?,student_id = ?";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            //��SQL����еĲ�����ֵ
            pstmt.setString(1,score.getCourseId());
            pstmt.setString(2,score.getStudentId());
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

    public LinkedList<CourseDTO> queryscores(String select,String select_value){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<CourseDTO> scoreslist=new LinkedList<CourseDTO>();
        CourseDTO score =null;
        ResultSet rs=null;
        try{
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql=null;
            if(select.equals("����")){
                sql = "select Course_Table.course_name,Student_Table.student_id,student_name,(case when Score_Table.score>=80 then course_xf when Score_Table.score>=60 then course_xf-1 else 0 end),Score_Table.score,(case when Score_Table.score>=80 then '����' when Score_Table.score>=60 then '����' else '������' end)" +
                        "from Student_Table,Score_Table,Course_Table" +
                        "where Score_Table.student_id = Student_Table.student_id  and Score_Table.course_id=Course_Table.course_id and student_name = ?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("ѧ��")){
                sql = "select Course_Table.course_name,Student_Table.student_id,student_name,(case when Score_Table.score>=80 then course_xf when Score_Table.score>=60 then course_xf-1 else 0 end),Score_Table.score,(case when Score_Table.score>=80 then '����' when Score_Table.score>=60 then '����' else '������' end) from Student_Table,Score_Table,Course_Table where Score_Table.student_id = Student_Table.student_id and Student_Table.student_id = ? and Score_Table.course_id=Course_Table.course_id";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("�γ�")){
                sql = "select Course_Table.course_name,Student_Table.student_id,student_name,(case when Score_Table.score>=80 then course_xf when Score_Table.score>=60 then course_xf-1 else 0 end),Score_Table.score,(case when Score_Table.score>=80 then '����' when Score_Table.score>=60 then '����' else '������' end)" +
                        "from Student_Table,Score_Table,Course_Table" +
                        "where Score_Table.student_id = Student_Table.student_id and Score_Table.course_id = ? and Score_Table.course_id=Course_Table.course_id";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            while (rs.next()){
                score=new CourseDTO();
                score.setCourseName(rs.getString(1));
                score.setStudentId(rs.getString(2));
                score.setStudentName(rs.getString(3));
                score.setCourseXf(rs.getString(4));
                score.setScore(rs.getString(5));
                scoreslist.add(score);
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
        return scoreslist;
    }
}
