package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentDAO extends DAO {

	/**
	 * Student表から全ての情報をデータを表示する。
	 * @param keyword
	 * @return list<Product>
	 * @throws Exception
	 */
	public List<Student> all() throws Exception {
		// ここから
		List<Student> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
		"select * from student");
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
		// ここまで
	}

	/**
	 * Student表へデータを挿入する。
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int insert(Student student) throws Exception {

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
				"insert into student (no, name, ent_year, class_num, is_attend, school_cd, birth_day)"
				+ " values(?, ?, ?, ?, True, 'oom', '2004-12-15')");

		st.setString(1, student.getNo());
		st.setString(2, student.getName());
		st.setInt(3, student.getEntYear());
		st.setString(4, student.getClassNum());
		int line= st.executeUpdate();
		st.close();
		con.close();
		return line;
	}

	/**
	 * Student表のデータを削除する。
	 * @param student
	 * @return
	 * @throws Exception
	 */
public int delete(Student student) throws Exception {

	Connection con=getConnection();
	PreparedStatement st=con.prepareStatement(
			"delete from student where no=?");

	st.setString(1, student.getNo());
	int line= st.executeUpdate();
	st.close();
	con.close();
	return line;
}

	/**
	 * Student表のデータを更新する。
	 * @param student
	 * @return
	 * @throws Exception
	 */
public int update(Student student) throws Exception {

	Connection con=getConnection();
	PreparedStatement st=con.prepareStatement(
			 "update student set name = ?,"
			+ "class_num = ?, is_attend = ?"
			+ "where no = ?");

	st.setString(1, student.getName());
	st.setString(2, student.getClassNum());
	st.setBoolean(3, student.getIsAttend());
	st.setString(4, student.getNo());
	int line= st.executeUpdate();

	st.close();
	con.close();
	return line;
}

	/**
	 * Student表から学生番号を検索する。(バリデーション用)
	 * @param student
	 * @return list<Student>
	 * @throws Exception
	 */
public List<Student> validete(String no) throws Exception {
	List<Student> list=new ArrayList<>();

	Connection con=getConnection();

	PreparedStatement st=con.prepareStatement(
	"select no from student "
	+ "where no = ?");

	st.setString(1, no);

	ResultSet rs=st.executeQuery();

		while (rs.next()){
			Student p=new Student();
			p.setNo(rs.getString("no"));

			list.add(p);
		}
	st.close();
	con.close();

	return list;

	}


}
