package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentSearchDAO extends DAO {


/**
 * Student表のデータを検索する。
 * @param student
 * @param student
 * @return
 * @throws Exception
 */

//入学年度:指定 クラス番号:指定(分類番号:なし)
public List<Student> search(Student student) throws Exception {
	List<Student> list=new ArrayList<>();

	Connection con=getConnection();

	PreparedStatement st=con.prepareStatement(
	"select * from student "
	+ "where ent_year = ? and class_num = ? and is_attend = ?");

		st.setInt(1, student.getEntYear());
		st.setString(2, student.getClassNum());
		st.setBoolean(3, student.getIsAttend());

	ResultSet rs=st.executeQuery();

		while (rs.next()){
			Student p=new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEntYear(rs.getInt("ent_year"));
			p.setClassNum(rs.getString("class_num"));
			p.setIsAttend(rs.getBoolean("is_attend"));
			p.setSchoolCd(rs.getString("school_cd"));
			p.setBirthDay(rs.getDate("birth_day"));

			list.add(p);
		}
	st.close();
	con.close();

	return list;

	}

//入学年度:なし クラス番号:なし(分類番号:1)
public List<Student> search1(Student student) throws Exception {
	List<Student> list=new ArrayList<>();

	Connection con=getConnection();

	PreparedStatement st=con.prepareStatement(
	"select * from student "
	+ "where is_attend = ?");

		st.setBoolean(1, student.getIsAttend());

	ResultSet rs=st.executeQuery();

		while (rs.next()){
			Student p=new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEntYear(rs.getInt("ent_year"));
			p.setClassNum(rs.getString("class_num"));
			p.setIsAttend(rs.getBoolean("is_attend"));
			p.setSchoolCd(rs.getString("school_cd"));
			p.setBirthDay(rs.getDate("birth_day"));

			list.add(p);
		}
	st.close();
	con.close();

	return list;
}

//入学年度:指定 クラス番号:なし(分類番号:2)
public List<Student> search2(Student student) throws Exception {
		List<Student> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"select * from student "
				+ "where ent_year = ? and is_attend = ?");

		st.setInt(1, student.getEntYear());
		st.setBoolean(2, student.getIsAttend());

		ResultSet rs=st.executeQuery();

		while (rs.next()){
			Student p=new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEntYear(rs.getInt("ent_year"));
			p.setClassNum(rs.getString("class_num"));
			p.setIsAttend(rs.getBoolean("is_attend"));
			p.setSchoolCd(rs.getString("school_cd"));
			p.setBirthDay(rs.getDate("birth_day"));

			list.add(p);
		}
	st.close();
	con.close();

	return list;

	}

//入学年度:なし クラス番号:指定(分類番号:3)
public List<Student> search3(Student student) throws Exception {
	List<Student> list=new ArrayList<>();

	Connection con=getConnection();

	PreparedStatement st=con.prepareStatement(
	"select * from student "
	+ "where class_num = ? and is_attend = ?");

		st.setString(1, student.getClassNum());
		st.setBoolean(2, student.getIsAttend());

	ResultSet rs=st.executeQuery();

		while (rs.next()){
			Student p=new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEntYear(rs.getInt("ent_year"));
			p.setClassNum(rs.getString("class_num"));
			p.setIsAttend(rs.getBoolean("is_attend"));
			p.setSchoolCd(rs.getString("school_cd"));
			p.setBirthDay(rs.getDate("birth_day"));

			list.add(p);
		}
	st.close();
	con.close();

	return list;

	}




}


