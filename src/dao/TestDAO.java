package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
		"select * from Test");
		ResultSet rs=st.executeQuery();

		while (rs.next()){
			Test p=new Test();
			p.setStudent_no(rs.getString("student_no"));
			p.setSubject_cd(rs.getString("subject_cd"));
			p.setSchool_cd(rs.getString("school_cd"));
			p.setNo(rs.getInt("no"));
			p.setPoint(rs.getInt("point"));
			p.setClass_num(rs.getString("class_num"));
			p.setTest_day(rs.getDate("test_day"));
			p.setIs_pass(rs.getBoolean("Is_pass"));

			list.add(p);
		}
		st.close();
		con.close();

		return list;
		// ここまで
	}
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
