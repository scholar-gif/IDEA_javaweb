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
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="select * from Student_Table";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);

            //ִ��SQL���
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
            //�ر�
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
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="select * from Student_Table where student_id = ?";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,studentId);
			rs=pstmt.executeQuery();
            //ִ��SQL���
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
            //�ر�
            try {rs.close();} catch (SQLException e) {}
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return student;
    }

	public boolean updateStudentById(StudentDTO student) {
		boolean b=false;
		
		//�������ݿ�������������
		Connection con=null;
        PreparedStatement pstmt=null;
        try{
        	 //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
       //     String sql="update Student_Table set student_name = ?, student_sex = ?, sutdent_birthday = ?, student_dept = ?, student_major = ?, student_classid = ?"
           // 		+ "where student_id = ?"; 
            
            String sql="update Student_Table set student_name = ?, student_sex = ?, student_birthday = ?, student_dept = ?, student_major = ?, student_classid = ? "
           		 + " where student_id = ?";
            
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            //��SQL����еĲ�����ֵ
            pstmt.setString(1,student.getStudentName());
            pstmt.setString(2,student.getStudentSex());
            pstmt.setString(3,student.getStudentBirthday());
            pstmt.setString(4,student.getStudentDept());
            pstmt.setString(5,student.getStudentMajor());
            pstmt.setString(6,student.getStudentClassId());
            pstmt.setString(7,student.getStudentId());

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

    public boolean addStudentById(StudentDTO student) {
        boolean b=false;

        //�������ݿ�������������
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql="insert into Student_Table values(?,?,?,?,?,?,?)";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            //��SQL����еĲ�����ֵ
            pstmt.setString(1,student.getStudentId());
            pstmt.setString(2,student.getStudentName());
            pstmt.setString(3,student.getStudentSex());
            pstmt.setString(4,student.getStudentBirthday());
            pstmt.setString(5,student.getStudentDept());
            pstmt.setString(6,student.getStudentMajor());
            pstmt.setString(7,student.getStudentClassId());
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

    public boolean delStudentById(String studentId) {
        boolean b=false;

        //�������ݿ�������������
        Connection con=null;
        PreparedStatement pstmt=null;
        try{

            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
            String sql= "delete from Student_Table where student_id = ?";
            System.out.println(sql);
            //����Ԥ�������
            pstmt=con.prepareStatement(sql);
            //��SQL����еĲ�����ֵ
            pstmt.setString(1,studentId);
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

    public LinkedList<StudentDTO> queryStudents(String select,String select_value){
        Connection con=null;
        PreparedStatement pstmt=null;
        LinkedList<StudentDTO> studentlist=new LinkedList<StudentDTO>();
        StudentDTO student =null;
        ResultSet rs=null;
        try{
            //�������Ӷ���
            con=DBManager.getConnection();
            //��д������SQl���
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
            else if(select.equals("�Ա�")){
                sql = "select * from Student_Table where student_sex=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("ѧԺ")){
                sql = "select * from Student_Table where student_dept=?";
                System.out.println(sql);

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,select_value);
                rs = pstmt.executeQuery();
            }
            else if(select.equals("רҵ")){
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
            //�ر�
            try {rs.close();} catch (SQLException e) {}
            try {pstmt.close();} catch (SQLException e) {}
            try {con.close();}  catch (SQLException e) {}
        }
        return studentlist;
    }
}
