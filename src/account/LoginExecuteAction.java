package account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDAO;
import tool.Action;

public class LoginExecuteAction extends Action {

	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{

		HttpSession session=request.getSession();

		String id=request.getParameter("id");
		String password=request.getParameter("password");

		TeacherDAO dao=new TeacherDAO();
		Teacher teacher=dao.login(id, password);
		System.out.println(teacher);
		//	ユーザーデータをセッションに格納
		session.setAttribute("teacher", teacher);
		return "menu.jsp";

	}
}
