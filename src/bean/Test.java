package bean;

import java.util.Date;

public class Test {

	private String student_no;
	private String subject_cd;
	private String school_cd;
	private int times;
	private int point;
	private String class_num;
	private Date test_day;
	private boolean is_pass;
	private String subject;


	public String getStudent_no() {
		return student_no;
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
	public int getPoint() {
		return point;
	}
	public String getClass_num() {
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


	public void setStudent_no(String student_no){
		this.student_no=student_no;
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
	public void setPoint(int point){
		this.point=point;
	}
	public void setClass_num(String class_num){
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


}
