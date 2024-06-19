package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDAO extends DAO {

	/**
	 * Product表からキーワードを検索し、該当する商品のListを返却する。
	 * @param keyword
	 * @return list<Product>
	 * @throws Exception
	 */
	public List<Subject> all() throws Exception {
		// ここから
		List<Subject> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
		"select * from Subject");
		ResultSet rs=st.executeQuery();

		while (rs.next()){
			Subject p=new Subject();
			p.setCd(rs.getString("cd"));
			p.setName(rs.getString("name"));

			list.add(p);
		}
		st.close();
		con.close();

		return list;
		// ここまで
	}
}

