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


/**
 * Subject表のデータを更新する。
 * @param subject
 * @return
 * @throws Exception
 */
public int update(Subject subject) throws Exception {

	Connection con=getConnection();
	PreparedStatement st=con.prepareStatement(
			 "update subject set "
			+ "name = ?"
			+ "where cd = ?");

	st.setString(1, subject.getName());
	st.setString(2, subject.getCd());
	int line= st.executeUpdate();

	st.close();
	con.close();
	return line;
}
/**
 * Subject表のデータを削除する。
 * @param subject
 * @return
 * @throws Exception
 */
public int delete(Subject subject) throws Exception {

Connection con=getConnection();
PreparedStatement st=con.prepareStatement(
		"delete from subject where cd=?");

st.setString(1, subject.getCd());
int line= st.executeUpdate();
st.close();
con.close();
return line;
}

/**
 * Subject表のデータを作成する。
 * @param subject
 * @return
 * @throws Exception
 */
public int insert(Subject subject) throws Exception {

	Connection con=getConnection();
	PreparedStatement st=con.prepareStatement(
			"insert into subject (school_cd,CD,NAME)"
			+ " values('oom', ?,?)");

	st.setString(1, subject.getCd());
	st.setString(2, subject.getName());
	int line= st.executeUpdate();
	st.close();
	con.close();
	return line;
}

}