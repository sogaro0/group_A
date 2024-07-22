package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;

public class TeacherDAO extends DAO {

	/**
	 * Teacher表からidを検索し、id,passwordが一致したデータを取得する。
	 * @param String id, String password
	 * @return Teacher
	 * @throws Exception
	 */
	public Teacher login(String id, String password) throws Exception {

		System.out.println("111");

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
		"select * from teacher where id = ? and password = ?");
		st.setString(1, id);
		st.setString(2, password);

		ResultSet rs=st.executeQuery();
		System.out.println("222");

		Teacher teacher = new Teacher();
		while (rs.next()) {
			teacher.setId(rs.getString("id"));
			teacher.setPassword(rs.getString("password"));
			teacher.setName(rs.getString("name"));
			teacher.setSchoolCd(rs.getString("school_cd"));
			teacher.setIsWork(rs.getBoolean("is_work"));
		}

		System.out.println("333");
		st.close();
		con.close();

		return teacher;

	}
}
