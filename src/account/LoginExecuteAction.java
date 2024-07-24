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
		System.out.println("a");
		HttpSession session=request.getSession();
		String message = "";
		String id=request.getParameter("id");
		String password=request.getParameter("password");

		TeacherDAO dao=new TeacherDAO();
		Teacher teacher=dao.login(id, password);
		System.out.println(teacher);
		System.out.println(teacher.getId());
		System.out.println(teacher.getName());

		// ユーザーデータが格納されている場合
		if (teacher.getId()!=null){
			System.out.println("ユーザーデータが格納されています");
			// ユーザーデータをセッションに格納
			session.setAttribute("teacher_id", teacher.getId());
			session.setAttribute("teacher_name", teacher.getName());
			return "../menu/menu.jsp";
		}
		// ユーザーデータが格納されていない場合
		else {
			// ユーザーデータが格納されていない場合
			System.out.println("ユーザーデータが格納されていません");
			message = "IDまたはパスワードが間違っています";
			return "login.jsp";
		}

	}
}
