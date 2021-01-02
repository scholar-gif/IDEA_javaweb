package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class StudentDAO {
    public LinkedList<StudentDTO> queryAllStudents(){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<StudentDTO> studentlist=new LinkedList<StudentDTO>();
        StudentDTO student =null;
        ResultSet rs=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="select * from Student_Table";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);

            //执行SQL语句
            rs=pstmt.executeQuery();

            while (rs.next()){
                student=new StudentDTO();
                student.setStudentId(rs.getString(1));
                student.setStudentName(rs.getString(2));
                student.setStudentSex(rs.getString(3));
                student.setStudentBirthday(rs.getString(4));
                student.setStudentDept(rs.getString(5));
                student.setStudentMajor(rs.getString(6));
                student.setStudentClassId(rs.getString(7));
                studentlist.add(student);
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
        return studentlist;
    }

    public StudentDTO queryStudent(String studentId) {
    	Connection con=null;
        PreparedStatement pstmt=null;
        StudentDTO student =null;
        ResultSet rs=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="select * from Student_Table where student_id = ?";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,studentId);
			rs=pstmt.executeQuery();
            //执行SQL语句
            while (rs.next()){
                student=new StudentDTO();
                student.setStudentId(rs.getString(1));
                student.setStudentName(rs.getString(2));
                student.setStudentSex(rs.getString(3));
                student.setStudentBirthday(rs.getString(4));
                student.setStudentDept(rs.getString(5));
                student.setStudentMajor(rs.getString(6));
                student.setStudentClassId(rs.getString(7));
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
        return student;
    }

	public boolean updateStudentById(StudentDTO student) {
		boolean b=false;
		
		//定义数据库驱动程序请求
		Connection con=null;
        PreparedStatement pstmt=null;
        try{
        	 //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
       //     String sql="update Student_Table set student_name = ?, student_sex = ?, sutdent_birthday = ?, student_dept = ?, student_major = ?, student_classid = ?"
           // 		+ "where student_id = ?"; 
            
            String sql="update Student_Table set student_name = ?, student_sex = ?, student_birthday = ?, student_dept = ?, student_major = ?, student_classid = ? "
           		 + " where student_id = ?";
            
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            //对SQL语句中的参数赋值
            pstmt.setString(1,student.getStudentName());
            pstmt.setString(2,student.getStudentSex());
            pstmt.setString(3,student.getStudentBirthday());
            pstmt.setString(4,student.getStudentDept());
            pstmt.setString(5,student.getStudentMajor());
            pstmt.setString(6,student.getStudentClassId());
            pstmt.setString(7,student.getStudentId());

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

    public boolean addStudentById(StudentDTO student) {
        boolean b=false;

        //定义数据库驱动程序请求
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql="insert into Student_Table values(?,?,?,?,?,?,?)";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            //对SQL语句中的参数赋值
            pstmt.setString(1,student.getStudentId());
            pstmt.setString(2,student.getStudentName());
            pstmt.setString(3,student.getStudentSex());
            pstmt.setString(4,student.getStudentBirthday());
            pstmt.setString(5,student.getStudentDept());
            pstmt.setString(6,student.getStudentMajor());
            pstmt.setString(7,student.getStudentClassId());
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

    public boolean delStudentById(String studentId) {
        boolean b=false;

        //定义数据库驱动程序请求
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql= "delete from Student_Table where student_id = ?";
            System.out.println(sql);
            //创建预编译语句
            pstmt=con.prepareStatement(sql);
            //对SQL语句中的参数赋值
            pstmt.setString(1,studentId);
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

    public LinkedList<StudentDTO> queryStudents(String select,String select_value){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<StudentDTO> studentlist=new LinkedList<StudentDTO>();
        StudentDTO student =null;
        ResultSet rs=null;
        try{
            //创建连接对象
            con=DBManager.getConnection();
            //编写参数化SQl语句
            String sql=null;
            if(select.equals("id")){
                sql = "select * from Student_Table where student_id=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("name")){
                sql = "select * from Student_Table where student_name=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("性别")){
                sql = "select * from Student_Table where student_sex=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("学院")){
                sql = "select * from Student_Table where student_dept=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("专业")){
                sql = "select * from Student_Table where student_major=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            while (rs.next()){
                student=new StudentDTO();
                student.setStudentId(rs.getString(1));
                student.setStudentName(rs.getString(2));
                student.setStudentSex(rs.getString(3));
                student.setStudentBirthday(rs.getString(4));
                student.setStudentDept(rs.getString(5));
                student.setStudentMajor(rs.getString(6));
                student.setStudentClassId(rs.getString(7));
                studentlist.add(student);
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
        return studentlist;
    }
}
