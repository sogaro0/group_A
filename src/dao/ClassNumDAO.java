package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;

public class ClassNumDAO extends DAO {

	/**
	 * Product表からキーワードを検索し、該当する商品のListを返却する。
	 * @param keyword
	 * @return list<Product>
	 * @throws Exception
	 */
	public List<ClassNum> all() throws Exception {
		// ここから
		List<ClassNum> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
		"select * from class_num");
		ResultSet rs=st.executeQuery();

		while (rs.next()){
			ClassNum p=new ClassNum();
			p.setSchoolCd(rs.getString("school_cd"));
			p.setClassNum(rs.getString("class_num"));

			list.add(p);
		}
		st.close();
		con.close();

		return list;
		// ここまで
	}
}
