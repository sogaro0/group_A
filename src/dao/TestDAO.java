package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.Test;

public class TestDAO extends DAO {

	public List<Test> all() throws Exception {
		List<Test> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
		"select  * from Test");
		ResultSet rs=st.executeQuery();

		while (rs.next()){
			Test p=new Test();
			p.setStudentNum(rs.getString("student_no"));
			p.setSubject_cd(rs.getString("subject_cd"));
			p.setSchool_cd(rs.getString("school_cd"));
			p.setTimes(rs.getInt("no"));
			p.setPoint(rs.getInt("point"));
			p.setClassNum(rs.getString("class_num"));
			p.setTest_day(rs.getDate("test_day"));
			p.setIs_pass(rs.getBoolean("Is_pass"));

			list.add(p);
		}
		st.close();
		con.close();

		return list;
	}


	//TestRegistAction.javaから取り寄せたデータでh2コンソールを検索
	public List<Test> search(Student test, Test test1) throws Exception {
		List<Test> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(

//		testテーブルとstudentテーブルを生徒番号で結合して、testテーブルとsubjectテーブルを教科コードで結合して、
//		生徒番号と生徒氏名と入学年度とクラス番号とテストの得点とテストの回数と教科を取り出す
				"select student.ent_year,point, student.class_num, student.no, "
				+ "student.name, new_test.point, new_test.is_pass, new_test.no,new_test.subject_cd "
				 + "from student "
				+ "left join ( "
				+ "select test.point as point, test.is_pass as is_pass, test.student_no as student_no, test.subject_cd, test.no from test "
				+ "where no=? and subject_cd=? "
				+ ") as new_test "
				+ "on student.no = new_test.student_no "
				+"where student.ent_year = ? and student.class_num = ?; ");

			st.setInt(1, test1.getTimes());
			st.setString(2, test1.getSubject());
			st.setInt(3, test.getEntYear());
			st.setString(4, test.getClassNum());

		ResultSet rs=st.executeQuery();

			while (rs.next()){
				Test p=new Test();
				p.setEntYear(rs.getInt("ent_year"));
				p.setClassNum(rs.getString("class_num"));
				p.setStudentNum(rs.getString("student.no"));
				p.setName(rs.getString("student.name"));
				p.setPoint(rs.getInt("point"));
				p.setIs_pass(rs.getBoolean("is_pass"));
				list.add(p);
			}
		st.close();
		con.close();

		return list;
		}

//テスト回数を重複しないように取り出す
public List<Test> dup() throws Exception {
	List<Test> list=new ArrayList<>();

	Connection con=getConnection();

	PreparedStatement st=con.prepareStatement(
		"select distinct no from test ");

			ResultSet rs=st.executeQuery();

			while (rs.next()){
				Test p=new Test();
				p.setTimes(rs.getInt("no"));
				list.add(p);
			}
			st.close();
			con.close();

			return list;
		}

//成績登録のDAO1(赤点の場合)
public int update1(Test test) throws Exception {

	Connection con=getConnection();
	PreparedStatement st=con.prepareStatement(
			 "update test set point = ?, is_pass = false "
			+ "where student_no = ? and subject_cd = ? and no = ?");

	st.setInt(1, test.getPoint());
	st.setString(2, test.getStudentNum());
	st.setString(3, test.getSubject_cd());
	st.setInt(4, test.getTimes());
	int line= st.executeUpdate();

	st.close();
	con.close();
	return line;
		}

//成績登録のDAO2(黒点の場合)
public int update2(Test test) throws Exception {

	Connection con=getConnection();
	PreparedStatement st=con.prepareStatement(
			 "update test set point = ?, is_pass = true "
			+ "where student_no = ?  and subject_cd = ? and no = ?");

	st.setInt(1, test.getPoint());
	st.setString(2, test.getStudentNum());
	st.setString(3, test.getSubject_cd());
	st.setInt(4, test.getTimes());
	int line= st.executeUpdate();

	st.close();
	con.close();
	return line;
		}

public List<Test> search1(Test test ) throws Exception {
	List<Test> list3=new ArrayList<>();

	Connection con=getConnection();

	PreparedStatement st=con.prepareStatement(
	"SELECT DISTINCT student.ent_year, student.class_num, student.no, student.name, scores.POINT_1, scores.POINT_2 FROM student JOIN (SELECT STUDENT_NO, SUBJECT_CD, MAX (CASE WHEN NO = 1 THEN POINT ELSE NULL END) AS POINT_1, MAX (CASE WHEN NO = 2 THEN POINT ELSE NULL END) AS POINT_2 FROM test GROUP BY STUDENT_NO, SUBJECT_CD) AS scores ON student.no = scores.STUDENT_NO JOIN subject ON subject.cd = scores.SUBJECT_CD join test on student.no = test.student_no"
	+ " where test.ent_year = ? and test.class_num = ? and subject.name= ?");

	st.setInt(1, test.getEntYear());
	st.setString(2, test.getClassNum());
	st.setString(3, test.getName());

	ResultSet rs=st.executeQuery();

	while (rs.next()){
			Test p=new Test();
			p.setEntYear(rs.getInt("ent_year"));
			p.setClassNum(rs.getString("class_num"));
			p.setNo(rs.getInt("no"));
			p.setName(rs.getString("name"));
			p.setPoint(rs.getInt("point_1"));
			p.setPoint2(rs.getInt("point_2"));


			list3.add(p);
		}
	st.close();
	con.close();

	return list3;
}

//学生番号で検索
	public List<Test> searchstudentcd(Test Test) throws Exception {
		List<Test> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
		"select * from test "
		+ " join student on test.student_no = student.no "
		+ " join subject on test.subject_cd = subject.cd "
		+ " where student_no = ?");

			st.setString(1, Test.getStudentNum());

		ResultSet rs=st.executeQuery();

		while (rs.next()){
			Test p=new Test();
			p.setSubject(rs.getString("subject.name"));
			p.setSubject_cd(rs.getString("subject_cd"));
			p.setNo(rs.getInt("no"));
			p.setName(rs.getString("name"));
			p.setStudentNum(rs.getString("student_no"));
			p.setPoint(rs.getInt("point"));
			p.setIs_pass(rs.getBoolean("is_pass"));



			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

	public int insert(Test test) throws Exception {

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
				"insert into test (student_no, subject_cd, school_cd, no, point, class_num, ent_year, name)"
				+ " values(?, ?, 'oom', ?, ?, ?, ?, ?)");

		st.setString(1, test.getStudentNum());
		st.setString(2, test.getSubject_cd());
		st.setInt(3, test.getTimes());
		st.setInt(4, test.getPoint());
		st.setString(5, test.getClassNum());
		st.setInt(6, test.getEntYear());
		st.setString(7, test.getName());

		int line= st.executeUpdate();
		st.close();
		con.close();

		return line;
	}

	public Test search3(String student_no, String subject_cd,Integer times) throws Exception {

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
				"select * from test "
				+ "where student_no = ? and subject_cd = ? and no = ?");

		st.setString(1, student_no);
		st.setString(2, subject_cd);
		st.setInt(3, times);

		ResultSet rs=st.executeQuery();

		Test test_check = new Test();
		while (rs.next()) {
			test_check.setSubject_cd(rs.getString("subject_cd"));

		}

		st.close();
		con.close();

		return test_check;

	}
}
