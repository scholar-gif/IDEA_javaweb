package bean;

public class CourseDTO {
    private String courseId;
    private String courseName;
    private String courseType;
    private String courseXf;
    private String studentDept;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseXf() {
        return courseXf;
    }

    public void setCourseXf(String courseXf) {
        this.courseXf = courseXf;
    }

    public String getStudentDept() {
        return studentDept;
    }

    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }
}
