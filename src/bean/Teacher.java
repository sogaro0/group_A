package bean;

public class Teacher {

	private String id;
	private String password;
	private String name;
	private String school_cd;
	private boolean is_work;


	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getSchoolCd() {
		return school_cd;
	}
	public boolean getIsWork() {
		return is_work;
	}


	public void setId(String id){
		this.id=id;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setSchoolCd(String school_cd){
		this.school_cd=school_cd;
	}
	public void setIsWork(boolean is_work){
		this.is_work=is_work;
	}


}
