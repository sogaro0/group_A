package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;

public class SchoolDAO extends DAO {

	/**
	 * Product表からキーワードを検索し、該当する商品のListを返却する。
	 * @param keyword
	 * @return list<Product>
	 * @throws Exception
	 */
	public List<School> all() throws Exception {
		// ここから
		List<School> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
		"select * from school");
		ResultSet rs=st.executeQuery();

		while (rs.next()){
			School p=new School();
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
