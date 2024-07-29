package bean;

import java.util.Date;

public class Test {

	private String student_num;
	private String subject_cd;
	private String school_cd;
	private int times;
	private Integer point;
	private Integer point2;
	private int no;
	private String class_num;
	private Date test_day;
	private boolean is_pass;
	private String subject;
	private int ent_year;
	private String name;


	public String getStudentNum() {
		return student_num;
	}
	public String getSubject_cd() {
		return subject_cd;
	}
	public String getSchool_cd() {
		return school_cd;
	}
	public int getTimes() {
		return times;
	}
	public Integer getPoint() {
		return point;
	}
	public Integer getPoint2() {
		return point2;
	}
	public int getNo() {
		return no;
	}
	public String getClassNum() {
		return class_num;
	}
	public Date getTest_day() {
		return test_day;
	}
	public boolean getIs_pass() {
		return is_pass;
	}
	public String getSubject() {
		return subject;
	}
	public int getEntYear() {
		return ent_year;
	}
	public String getName() {
		return name;
	}

	public void setStudentNum(String student_no){
		this.student_num=student_no;
	}
	public void setSubject_cd(String subject_cd){
		this.subject_cd=subject_cd;
	}
	public void setSchool_cd(String school_cd){
		this.school_cd=school_cd;
	}
	public void setTimes(int times){
		this.times=times;
	}
	public void setPoint(Integer point){
		this.point=point;
	}
	public void setPoint2(Integer point2){
		this.point2=point2;
	}
	public void setNo(int no){
		this.no=no;
	}
	public void setClassNum(String class_num){
		this.class_num=class_num;
	}
	public void setTest_day(Date test_day){
		this.test_day=test_day;
	}
	public void setIs_pass(boolean is_pass){
		this.is_pass=is_pass;
	}
	public void setSubject(String subject){
		this.subject=subject;
	}
	public void setEntYear(int ent_year){
		this.ent_year=ent_year;
	}
	public void setName(String name){
		this.name=name;
	}

}
