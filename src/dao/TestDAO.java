package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.Test;

public class TestDAO extends DAO {

	/**
	 * Product表からキーワードを検索し、該当する商品のListを返却する。
	 * @param keyword
	 * @return list<Product>
	 * @throws Exception
	 */
	public List<Test> all() throws Exception {
		// ここから
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
		// ここまで
	}

//	/**
//	 * Product表へデータを挿入する。
//	 * @param product
//	 * @return
//	 * @throws Exception
//	 */
//	public int insert(Product product) throws Exception {
//		// ここから
//		Connection con=getConnection();
//		PreparedStatement st=con.prepareStatement(
//				"insert into product values(null, ?, ?)");
//		st.setString(1, product.getName());
//		st.setInt(1, product.getPrice());
//		int line=st.executeUpdate();
//
//		st.close();
//		con.close();
//		// ここまで
//		return line;
//	}
//}

//入学年度:指定 クラス番号:指定(分類番号:なし)
public List<Test> search(Student test, Test test1) throws Exception {
	List<Test> list=new ArrayList<>();

	Connection con=getConnection();

	PreparedStatement st=con.prepareStatement(
	"select distinct student_no, point, student.name, ent_year, test.class_num, subject.name, test.no from test "
	+ "join student "
	+ "on test.student_no = student.no "
	+ "join subject "
	+ "on test.subject_cd = subject.cd "
	+ "where ent_year = ? and test.class_num = ? and subject_cd = ? and test.no = ? ");

		st.setInt(1, test.getEntYear());
		st.setString(2, test.getClassNum());
		st.setString(3, test1.getSubject());
		st.setInt(4, test1.getTimes());

	ResultSet rs=st.executeQuery();


		while (rs.next()){
			Test p=new Test();
			p.setSubject(rs.getString("subject.name"));
			p.setTimes(rs.getInt("test.no"));
			p.setEntYear(rs.getInt("ent_year"));
			p.setClassNum(rs.getString("class_num"));
			p.setStudentNum(rs.getString("student_no"));
			p.setName(rs.getString("student.name"));
			p.setPoint(rs.getInt("point"));
			list.add(p);
		}
		System.out.println(rs);
	st.close();
	con.close();

	System.out.println(list);
	return list;
	}




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
}
